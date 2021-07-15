package com.remoteide.Online.Ide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CppSolverService {

    @Autowired
    private CommandRun commandRun;

    public String execute(String path)  {
        String command = "g++ " + path + " -o " + "Solution";
        TerminalResponse terminalResponse = commandRun.compilerCommandRun(command);
        if (!terminalResponse.getStatus()) {
            return "Code not executed";
        }
        if (terminalResponse.getTerminaloutput().length() > 0) {
            System.out.println(terminalResponse.getTerminaloutput());

        }

        if (terminalResponse.getTerminalError().length() > 0) {
            return terminalResponse.getTerminalError();
        }

        terminalResponse = commandRun.compilerCommandRun("./Solution");
        if (!terminalResponse.getStatus()) {
            return "Code not executed";
        }

        if (terminalResponse.getTerminalError().length() > 0) {
            return terminalResponse.getTerminalError();
        }
        return terminalResponse.getTerminaloutput();
    }
}
