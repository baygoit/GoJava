package com.sandarovich.kickstarter.io;

import java.util.Map;

/**
 * @author Olexander Kolodiazhny 2016
 */

class ConsoleTable {

    private final String[] columnNames;
    private final Object[][] data;

    public ConsoleTable(Tableable object) {
        columnNames = generateColumnNames(object);
        data = generateData(object);
    }

    private String[] generateColumnNames(Tableable object) {
        return object.getColumns();
    }

    private Object[][] generateData(Tableable object) {
        Object[][] result = new Object[object.count()][columnNames.length];
        for (int rowIndex = 0; rowIndex < object.count(); rowIndex++) {
            Map<String, Object> row = object.getRowData(rowIndex);
            int columnIndex = 0;
            for (Map.Entry<String, Object> pair : row.entrySet()) {
                result[rowIndex][columnIndex++] = pair.getValue();
            }
        }
        return result;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public Object[][] getData() {
        return data;
    }
}
