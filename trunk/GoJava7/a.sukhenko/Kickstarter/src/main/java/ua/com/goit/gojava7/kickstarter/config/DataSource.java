package ua.com.goit.gojava7.kickstarter.config;

public enum DataSource {
    MEMORY("m"), MYSQL("db");

    DataSource() {
    }

    DataSource(String s) {
    }

    public static DataSource getDataSource() {
        String param = System.getenv("SOURCE");
        if (param != null) {
            switch (param) {
                case "m" :
                    return DataSource.MEMORY;
                case "db" :
                    return DataSource.MYSQL;

                default :
                    return DataSource.MEMORY;
            }
        }
        return DataSource.MEMORY;
    }

}
