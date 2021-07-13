package com.remoteide.Online.Ide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeExecutorService {
    @Autowired
    private FileOperationsService fileOperationsService;
    @Autowired
    private CppSolverService cppSolverService;

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

    public String executeCode(String language, String code) {

        String path = generatePath(language);

        if (fileOperationsService.createFile(path)) {
            boolean response = fileOperationsService.writeToFile(path, code);
            if (response == false) {
                return "Not Success";
            }
        } else {
            return "Not Success";
        }

        return cppSolverService.execute(path);
    }

}
