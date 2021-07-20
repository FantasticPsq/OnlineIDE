package com.remoteide.Online.Ide.ProblemSolverFactoryUtility;

import com.remoteide.Online.Ide.CodeExecutorUtility.ICommandRun;
import com.remoteide.Online.Ide.CodeExecutorUtility.TerminalResponse;
import org.springframework.stereotype.Service;

@Service
public class CppProblemSolver implements ProblemSolver {

    private ICommandRun commandRun;

    public CppProblemSolver(ICommandRun commandRun) {
        this.commandRun = commandRun;
    }

    @Override
    public String execute(String path, String input) {
        String command = "g++ " + path + " -o " + "Solution";
        TerminalResponse terminalResponse = commandRun.compilerCommandRun(command, null);
        if (!terminalResponse.getStatus()) {
            return "Code not executed";
        }
        if (terminalResponse.getTerminaloutput().length() > 0) {
            System.out.println(terminalResponse.getTerminaloutput());

        }

        if (terminalResponse.getTerminalError().length() > 0) {
            return terminalResponse.getTerminalError();
        }

        terminalResponse = commandRun.compilerCommandRun("./Solution", input);
        if (!terminalResponse.getStatus()) {
            return "Code not executed";
        }

        if (terminalResponse.getTerminalError().length() > 0) {
            return terminalResponse.getTerminalError();
        }
        return terminalResponse.getTerminaloutput();

    }
}
