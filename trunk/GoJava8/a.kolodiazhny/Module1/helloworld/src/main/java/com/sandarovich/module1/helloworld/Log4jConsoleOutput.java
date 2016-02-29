package com.sandarovich.module1.helloworld;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Olexander Kolodiazhny 2016
 * 
 * Outputs to console using log4j functionality
 *
 */

public class Log4jConsoleOutput implements OutputFormatter {
    
    private static final Logger log = Logger.getLogger(Log4jConsoleOutput.class);
    
    @Override
    public void processMessage(String message) {
	PropertyConfigurator.configure("src/main/resources/log4j.properties");
	log.info(message);
    }
    
}
