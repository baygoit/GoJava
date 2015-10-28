package ua.goit.kyrychok.kickstarter.dao.database.sql_provider;

import ua.goit.kyrychok.kickstarter.dao.database.CategorySqlProvider;

public class OraCategorySqlProvider implements CategorySqlProvider {

    @Override
    public String get4GetWelcomeMessage() {
        return "SELECT m.text AS message FROM message m WHERE rownum = 1";
    }

    @Override
    public String get4AddWelcomeMessage() {
        return "insert into message(message_id, text) values(message_id_seq.nextval, ?)";
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
        return "insert into category(category_id, name) values (category_id_seq.nextval, ?)";
    }
}
