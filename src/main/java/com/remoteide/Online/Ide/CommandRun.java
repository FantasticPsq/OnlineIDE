package com.remoteide.Online.Ide;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class CommandRun {

    private String readInputStream(InputStream input) {
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(input));
        String outputString = "";
        String line = null;
        try {
            while ((line = stdInput.readLine()) != null) {
                outputString += line;
            }
        } catch (IOException e) {
            System.out.println("Exception in readInputStream method");
            e.printStackTrace();
            outputString = "";
        }
        return outputString;
    }

    public TerminalResponse compilerCommandRun(String command) {
        TerminalResponse terminalResponse = new TerminalResponse(false, "", "");
        try {
            //boolean status = true;
            Process p = Runtime.getRuntime().exec(command);
            terminalResponse.setTerminaloutput(readInputStream(p.getInputStream()));
            terminalResponse.setTerminalError(readInputStream(p.getErrorStream()));
            terminalResponse.setStatus(true);
        } catch (IOException e) {
            boolean status = false;
            System.out.println("Exception in compilerCommandRun method");
            e.printStackTrace();
        }
        return terminalResponse;
    }

}
