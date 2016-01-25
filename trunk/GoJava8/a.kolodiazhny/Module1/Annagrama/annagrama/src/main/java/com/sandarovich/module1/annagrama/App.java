package com.sandarovich.module1.annagrama;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 * @author Olexander Kolodiazhny
 * 
 *  Module#1 Task #3
 *
 */


public class App {
    
    private static final Logger LOGGER = Logger.getLogger(App.class);
    
    private App() {
        
    }     
    
    public static void main(String[] args) {
        String inputMessage = "мама мыла раму";
        Annagrama annagrama = new Annagrama();
        
        BasicConfigurator.configure();
        LOGGER.getRootLogger().setLevel(Level.INFO);
        
        LOGGER.info(annagrama.reversed(inputMessage));
    }
}
