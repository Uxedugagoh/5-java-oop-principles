package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        String fst = "KTO NAHUY";
        int lalka = 23;
        Logger logger = new Logger("name", "", Logger.levels.ERROR);
        logger.error("pisya popa suka nah %s %d", fst, lalka);
    }
}
