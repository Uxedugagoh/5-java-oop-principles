package com.example.task04;

public interface MessageHandler {

    void error(String recivedMessage);

    void info(String recivedMessage);

    void warning(String recivedMessage);

    void debug(String recivedMessage);

}
