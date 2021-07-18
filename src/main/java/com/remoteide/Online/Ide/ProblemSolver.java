package com.remoteide.Online.Ide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface ProblemSolver {
    @Autowired
    CommandRun commandRun = new CommandRun();
    String execute(String path, String input);
}
