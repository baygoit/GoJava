package com.sandarovich.kickstarter.io;

import java.util.Map;

/**
 * @author Olexander Kolodiazhny
 *         <p/>
 *         Interface marker
 */
public interface Tableable {
    Map<String, Object> getRowData(int index);

    String[] getColumns();

    int count();
}
