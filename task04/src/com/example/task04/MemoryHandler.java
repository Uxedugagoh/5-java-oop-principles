package com.example.task04;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class MemoryHandler extends AbstractHandler {
    private final AbstractHandler target;
    private final int bufferSize;
    private final List<String> buffer;
    private final LogLevel level;

    public MemoryHandler(String name, AbstractHandler target, int bufferSize, List<String> buffer, LogLevel level) {
        super(name);
        this.target = target;
        this.bufferSize = bufferSize;
        this.buffer = new ArrayList<>(bufferSize);
        this.level = level;
    }

    @Override
    protected void handleMessage(String message, LogLevel level) {
        java.time.LocalTime currentTime = java.time.LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        String currentDate = java.time.LocalDate.now().toString().replaceAll("-", ".");
        String answer = "[" + level + "] " + currentDate + ' ' + currentTime + ' ' + name + " - " + message;

        buffer.add(answer);
        if (buffer.size() >= bufferSize) {
            flush();
        }
    }


    public synchronized void flush() {
        for (String message : buffer) {
            target.handleMessage(message, level);
        }
        buffer.clear();
    }

}
