package com.remoteide.Online.Ide;

import org.springframework.stereotype.Service;

@Service
public class ProblemSolverFactory {
        public String getSolver(String language,String path, String input){
            if (language.equalsIgnoreCase("C++")) {
                ProblemSolver problemSolver = new CppProblemSolver();
                return problemSolver.execute(path, input);
            } else if (language.equalsIgnoreCase("Java")) {
                ProblemSolver problemSolver = new JavaProblemSolver();
                return problemSolver.execute(path, input);
            }
            return "";
        }

}
