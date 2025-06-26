package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String user = "Argha";
        int points = 150;

        logger.info("User {} has earned {} arcade points!", user, points);
        logger.warn("User {} is approaching the daily limit.", user);
        logger.error("Could not save points for user: {}", user);
    }
}
