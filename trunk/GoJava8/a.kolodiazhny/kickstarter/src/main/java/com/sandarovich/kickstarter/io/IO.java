package com.sandarovich.kickstarter.io;

import com.sandarovich.kickstarter.project.ProjectSerializable;

/**
 * @author Olexander Kolodiazhny 2016 
 * Describe common text output
 */

public interface IO {
    void write(String message);
    String read();

    void writeTable(ProjectSerializable object);
}
