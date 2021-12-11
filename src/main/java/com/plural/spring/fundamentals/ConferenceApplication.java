package com.plural.spring.fundamentals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConferenceApplication {

    private static final Logger logger = LogManager.getLogger(ConferenceApplication.class.getName());

    public static void main(String[] args) {
        logger.info("Trying to execute the code remotely...");
        logger.info("Input arguments: {}", args[0]);
    }
}