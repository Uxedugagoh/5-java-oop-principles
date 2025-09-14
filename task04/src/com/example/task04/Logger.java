package com.example.task04;

import java.util.List;

public class Logger {
    private final String name;
    private String message;
    private LogLevel level;
    private final List<AbstractHandler> handlerList;

    public Logger(String name, String message, LogLevel level, List<AbstractHandler> handlerList) {
        this.name = name;
        this.message = message;
        this.level = level;
        this.handlerList = handlerList;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public List<AbstractHandler> getHandlerList() {
        return handlerList;
    }

}
