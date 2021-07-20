package com.remoteide.Online.Ide.CodeExecutorUtility;


import com.remoteide.Online.Ide.FileOperationsUtility.FileOperationsService;
import com.remoteide.Online.Ide.ProblemSolverFactoryUtility.ProblemSolver;
import com.remoteide.Online.Ide.ProblemSolverFactoryUtility.ProblemSolverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeExecutorService {
    @Autowired
    private FileOperationsService fileOperationsService;

    private String getExtension(String language) {
        if (language.equalsIgnoreCase("C++")) {
            return "cpp";
        } else if (language.equalsIgnoreCase("Java")) {
            return "java";
        } else if (language.equalsIgnoreCase("Python")) {
            return "py";
        } else {
            return "js";
        }
    }

    private String generatePath(String language) {
        String path = "Solution." + getExtension(language);
        return path;
    }

    public String executeCode(String language, String code, String input) {
        String path = generatePath(language);
        //Why Not Success in both condition
        if (fileOperationsService.createFile(path)) {
            boolean response = fileOperationsService.writeToFile(path, code);
            if (response == false) {
                return "Not Success";
            }
        } else {
            return "Not Success";
        }
        ProblemSolverFactory problemSolverFactory = new ProblemSolverFactory();
        ProblemSolver problemSolver = problemSolverFactory.getSolver(language, new CommandRun());
        return problemSolver.execute(path, input);
    }
}
