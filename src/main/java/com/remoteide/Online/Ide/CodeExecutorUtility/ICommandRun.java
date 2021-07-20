package com.remoteide.Online.Ide.CodeExecutorUtility;

public interface ICommandRun {
    TerminalResponse compilerCommandRun(String command, String input);
}
