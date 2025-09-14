package com.example.task04;

import java.time.temporal.ChronoUnit;

public class ConsoleHandler extends AbstractHandler {
    public ConsoleHandler(String name) {
        super(name);
    }

    @Override
    protected void handleMessage(String message, LogLevel level) {
        java.time.LocalTime currentTime = java.time.LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        String currentDate = java.time.LocalDate.now().toString().replaceAll("-", ".");
        System.out.println("[" + level + "] " + currentDate + ' ' + currentTime + ' ' + name + " - " + message);
    }
}
