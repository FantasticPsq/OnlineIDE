package com.remoteide.Online.Ide.ProblemSolverFactoryUtility;

import com.remoteide.Online.Ide.CodeExecutorUtility.ICommandRun;
import com.remoteide.Online.Ide.CodeExecutorUtility.TerminalResponse;
import org.springframework.stereotype.Service;

@Service
public class JavaProblemSolver implements ProblemSolver {

    private ICommandRun commandRun;
    JavaProblemSolver(ICommandRun commandRun) {
        this.commandRun = commandRun;
    }

    public String execute(String path, String input) {
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