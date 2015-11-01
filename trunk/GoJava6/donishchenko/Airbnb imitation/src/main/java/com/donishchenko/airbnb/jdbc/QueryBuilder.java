package com.donishchenko.airbnb.jdbc;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {
    private String initialQuery;
    private String query;
    private List<Object> values = new ArrayList<>();

    public QueryBuilder(String initialQuery) {
        this.initialQuery = initialQuery;
        this.query = initialQuery;
    }

    public void parse(Object[] params) {
        if (params.length != 0) {
            StringBuilder builder = new StringBuilder(initialQuery);

            builder.append(" WHERE ");
            for (int i = 0; i < params.length; i += 2) {
                builder.append(params[i]).append(" = ?");
                values.add(params[i+1]);
            }

            query = builder.toString();
        }
    }

    public List<Object> values() {
        return values;
    }

    public String getQuery() {
        return query;
    }
}
