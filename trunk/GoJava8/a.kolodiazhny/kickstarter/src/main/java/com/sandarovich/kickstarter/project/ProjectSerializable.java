package com.sandarovich.kickstarter.project;

import java.util.Map;

/**
 * @author Olexander Kolodiazhny
 *         <p/>
 *         Interface marker
 */
public interface ProjectSerializable {
    Map<String, Object> getRowData(int index);

    String[] getColumns();

    int count();
}
