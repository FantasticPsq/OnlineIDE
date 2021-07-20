package com.remoteide.Online.Ide.CodeExecutorUtility;

public class TerminalResponse {
    private boolean status;
    private String terminaloutput;
    private String terminalError;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTerminaloutput() {
        return terminaloutput;
    }

    public void setTerminaloutput(String terminaloutput) {
        this.terminaloutput = terminaloutput;
    }

    public String getTerminalError() {
        return terminalError;
    }

    public void setTerminalError(String terminalError) {
        this.terminalError = terminalError;
    }

    public TerminalResponse(boolean status, String terminaloutput, String terminalError) {
        this.status = status;
        this.terminaloutput = terminaloutput;
        this.terminalError = terminalError;
    }

    @Override
    public String toString() {
        return "TerminalResponse{" +
                "status=" + status +
                ", terminaloutput='" + terminaloutput + '\'' +
                ", eroor='" + terminalError + '\'' +
                '}';
    }
}

