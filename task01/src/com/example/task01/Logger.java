package com.example.task01;

import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Logger {
    private final String name;
    private String message;
    private levels level;

    public Logger(String name, String message, levels level) {
        this.name = name;
        this.message = message;
        this.level = level;
    }

    public Logger(String name) {
        this.name = name;
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

    public levels getLevel() {
        return level;
    }

    public void setLevel(levels level) {
        this.level = level;
    }

    public static Logger getLogger(String name) {
        return new Logger(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Logger logger = (Logger) o;
        return Objects.equals(name, logger.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public enum levels {
        DEBUG,
        INFO,
        WARNING,
        ERROR;
    }

    public void error(String recivedMessage) {
        message = recivedMessage;
        level = levels.ERROR;
        System.out.println(this);
    }

    public void error(String format, Object... args) {
        message = String.format(format, args);
        level = levels.ERROR;
        System.out.println(this);
    }
    public void info(String recivedMessage) {
        message = recivedMessage;
        level = levels.INFO;
        System.out.println(this);
    }

    public void info(String format, Object... args) {
        message = String.format(format, args);
        level = levels.INFO;
        System.out.println(this);
    }
    public void warning(String recivedMessage) {
        message = recivedMessage;
        level = levels.WARNING;
        System.out.println(this);
    }

    public void warning(String format, Object... args) {
        message = String.format(format, args);
        level = levels.WARNING;
        System.out.println(this);
    }
    public void debug(String recivedMessage) {
        message = recivedMessage;
        level = levels.DEBUG;
        System.out.println(this);
    }

    public void debug(String format, Object... args) {
        message = String.format(format, args);
        level = levels.DEBUG;
        System.out.println(this);
    }


    @Override
    public String toString() {
        java.time.LocalTime currentTime = java.time.LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        String currentDate = java.time.LocalDate.now().toString().replaceAll("-", ".");
        return "[" + level + "] " +
                currentDate + ' ' +
                currentTime + ' ' +
                name + " - " +
                message;
    }
}
