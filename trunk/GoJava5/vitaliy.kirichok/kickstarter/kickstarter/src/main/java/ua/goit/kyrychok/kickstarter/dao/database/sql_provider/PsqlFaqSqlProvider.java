package ua.goit.kyrychok.kickstarter.dao.database.sql_provider;

import ua.goit.kyrychok.kickstarter.dao.database.FaqSqlProvider;

public class PsqlFaqSqlProvider implements FaqSqlProvider {
    @Override
    public String get4Add() {
        return "INSERT INTO faq (faq_id, question, answer, project_id) " +
                "VALUES (nextval('faq_id_seq'), ?, ?, ?)";
    }

    @Override
    public String get4Fetch() {
        return "SELECT f.faq_id AS id, f.question AS question, f.answer AS answer " +
                "FROM faq f WHERE f.project_id = ? ORDER BY f.faq_id";
    }
}
