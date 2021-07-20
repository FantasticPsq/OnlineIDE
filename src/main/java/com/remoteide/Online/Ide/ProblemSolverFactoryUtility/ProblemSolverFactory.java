package com.remoteide.Online.Ide.ProblemSolverFactoryUtility;

import com.remoteide.Online.Ide.CodeExecutorUtility.ICommandRun;

public class ProblemSolverFactory {
    public ProblemSolver getSolver(String language, ICommandRun commandRun){
        if (language == null) {
            return null;
        }
        if (language.equalsIgnoreCase("C++")) {
            return new CppProblemSolver(commandRun);
        } else if (language.equalsIgnoreCase("Java")) {
            return new JavaProblemSolver(commandRun);
        }
        return null;
    }
}

