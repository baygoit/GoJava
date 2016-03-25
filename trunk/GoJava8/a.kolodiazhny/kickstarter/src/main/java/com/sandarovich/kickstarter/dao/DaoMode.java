package com.sandarovich.kickstarter.dao;

/**
 * Application mode enum
 */

public enum DaoMode {
    MEMORY,
    FILE,
    DB;

    public static DaoMode fromName(String daoMode) {
        if (daoMode == null || daoMode.isEmpty()) {
            //-Dmode=memory
            throw new IllegalStateException("Environment variable mode was not found" +
                    " --> To Fix use: -Dmode=memory)");
        }
        String daoModeFormatted = daoMode.toUpperCase().trim();
        if (FILE.name().equals(daoModeFormatted)) {
            return FILE;
        }
        if (DB.name().equals(daoModeFormatted)) {
            return DB;
        }
        return MEMORY;
    }

}
