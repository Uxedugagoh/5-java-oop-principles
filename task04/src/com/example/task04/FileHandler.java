package com.example.task04;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.io.FileWriter;

public class FileHandler extends AbstractHandler  {

    public FileHandler(String name) {
        super(name);
    }

    protected void handleMessage(String message, LogLevel level) {
        java.time.LocalTime currentTime = java.time.LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        String currentDate = java.time.LocalDate.now().toString().replaceAll("-", ".");
        String answer = "[" + level + "] " + currentDate + ' ' + currentTime + ' ' + name + " - " + message;

        try(FileWriter writer = new FileWriter("outline.txt", false))
        {
            writer.write(answer);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

