package com.example.task04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RotationFileHandler extends AbstractHandler {
    private BufferedWriter writer;
    private LocalDateTime currentRotationTime;
    private final ChronoUnit rotationUnit;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    public RotationFileHandler(String name, ChronoUnit rotationUnit) {
        super(name);
        this.rotationUnit = rotationUnit;
    }

    @Override
    protected void handleMessage(String message, LogLevel level) {
        try {
            if (needRotate()) {
                rotateFile();
            }

            java.time.LocalTime currentTime = java.time.LocalTime.now().truncatedTo(rotationUnit);
            String currentDate = java.time.LocalDate.now().toString().replaceAll("-", ".");
            String answer = "[" + level + "] " + currentDate + ' ' + currentTime + ' ' + name + " - " + message;

            writer.write(answer);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("ioe exception", e);
        }
    }

    private boolean needRotate() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextRotation = currentRotationTime.plus(1, rotationUnit);
        return now.isAfter(nextRotation);
    }

    private void rotateFile() {
        try {
            if (writer != null) {
                writer.close();
            }

            currentRotationTime = LocalDateTime.now().truncatedTo(rotationUnit);
            String fileName = currentRotationTime.format(formatter) + ".log";
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            throw new RuntimeException("runtime", e);
        }
    }
}
