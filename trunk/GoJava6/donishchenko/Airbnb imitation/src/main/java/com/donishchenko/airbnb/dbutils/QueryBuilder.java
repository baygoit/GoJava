package com.donishchenko.airbnb.dbutils;

import java.util.ArrayList;
import java.util.Arrays;
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
        parse(params, true);
    }

    public void parse(Object[] params, boolean modifyQuery) {
        if (modifyQuery) {
            if (params.length % 2 != 0) {
                throw new IllegalArgumentException("An odd number of arguments");
            }

            buildQuery(params);
        } else {
            values.add(Arrays.asList(params));
        }
    }

    public List<Object> values() {
        return values;
    }

    public String getQuery() {
        return query;
    }

    private void buildQuery(Object[] params) {
        if (params.length != 0) {

            StringBuilder builder = new StringBuilder(initialQuery);

            builder.append(" WHERE ");
            for (int i = 0; i < params.length; ) {
                builder.append(params[i]).append(" = ?");
                values.add(params[i + 1]);

                i += 2;
                if (i < params.length) {
                    builder.append(" AND ");
                }
            }

            query = builder.toString();
        }
    }
}
