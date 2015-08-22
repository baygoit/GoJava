package ua.com.goit.kyrychok.dao.database.sql_provider;

public class H2FaqSqlProvider implements FaqSqlProvider {
    @Override
    public String get4Add() {
        return "INSERT INTO faq (question, answer, project_id) " +
                "VALUES (?, ?, ?)";
    }

    @Override
    public String get4Fetch() {
        return "SELECT f.faq_id AS id, f.question AS question, f.answer AS answer " +
                "FROM faq f WHERE f.project_id = ? ORDER BY f.faq_id";
    }
}
