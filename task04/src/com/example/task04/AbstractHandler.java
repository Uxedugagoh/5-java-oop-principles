package com.example.task04;

public abstract class AbstractHandler implements MessageHandler {
    protected final String name;
    protected boolean debugEnabled;
    protected boolean infoEnabled;

    public AbstractHandler(String name) {
        this.name = name;
    }

    public void error(String recivedMessage) {
        handleMessage(recivedMessage, LogLevel.ERROR);
    }

    public void info(String recivedMessage) {
        handleMessage(recivedMessage, LogLevel.INFO);
    }

    public void warning(String recivedMessage) {
        handleMessage(recivedMessage, LogLevel.WARNING);
    }

    public void debug(String recivedMessage) {
        handleMessage(recivedMessage, LogLevel.DEBUG);
    }

    protected abstract void handleMessage(String message, LogLevel level);
}
