package com.remoteide.Online.Ide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JavaSolverService {

    @Autowired
    private CommandRun commandRun;

    public String execute( String path, String input) {
        String command = "javac " + path;
        TerminalResponse terminalResponse = commandRun.compilerCommandRun(command, null);
        if (!terminalResponse.getStatus()) {
            return "Code not executed";
        }

        if (terminalResponse.getTerminalError().length() > 0) {
            return terminalResponse.getTerminalError();
        }

        terminalResponse = commandRun.compilerCommandRun("java Solution", input);
        if (!terminalResponse.getStatus()) {
            return "Code not executed";
        }

        if (terminalResponse.getTerminalError().length() > 0) {
            return terminalResponse.getTerminalError();
        }
        return terminalResponse.getTerminaloutput();

    }
}
