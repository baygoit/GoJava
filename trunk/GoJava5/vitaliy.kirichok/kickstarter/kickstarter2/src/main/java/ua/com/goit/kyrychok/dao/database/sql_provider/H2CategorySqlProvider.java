package ua.com.goit.kyrychok.dao.database.sql_provider;

import ua.com.goit.kyrychok.dao.database.CategorySqlProvider;

public class H2CategorySqlProvider implements CategorySqlProvider {

    @Override
    public String get4GetWelcomeMessage() {
        return "SELECT m.text AS message FROM message m LIMIT 1";
    }

    @Override
    public String get4AddWelcomeMessage() {
        return "insert into message(text) values(?)";
    }

    @Override
    public String get4Fetch() {
        return "SELECT c.category_id AS id, c.name AS NAME FROM category c ORDER BY c.name";
    }

    @Override
    public String get4Get() {
        return "SELECT c.name AS category_name FROM category c WHERE c.category_id = ?";
    }

    @Override
    public String get4Add() {
        return "insert into category(name) values (?)";
    }

}
