package com.remoteide.Online.Ide;

import org.springframework.stereotype.Service;

import java.io.*;

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
            if (command.equalsIgnoreCase("./Solution")) {
                OutputStream outputStream = p.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
                writer.write("20");
                writer.flush();
                writer.close();
            }
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
