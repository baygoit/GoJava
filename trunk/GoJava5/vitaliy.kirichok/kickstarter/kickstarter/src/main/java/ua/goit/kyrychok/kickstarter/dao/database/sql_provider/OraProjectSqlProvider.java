package ua.goit.kyrychok.kickstarter.dao.database.sql_provider;

import ua.goit.kyrychok.kickstarter.dao.database.ProjectSqlProvider;

public class OraProjectSqlProvider implements ProjectSqlProvider {
    @Override
    public String get4Load() {
        return "SELECT p.NAME AS name, " +
                "p.description AS description, " +
                "p.goal AS goal, " +
                "p.balance AS balance, " +
                "p.deadline_date AS deadline_date, " +
                "p.demo_link AS demo_link, " +
                "p.create_date AS create_date " +
                "FROM project p " +
                "WHERE p.project_id = ?";
    }

    @Override
    public String get4SetBalance() {
        return "UPDATE project SET balance = ? WHERE project_id = ?";
    }

    @Override
    public String get4GetBalance() {
        return "SELECT p.balance AS balance FROM project p WHERE p.project_id = ?";
    }

    @Override
    public String get4Fetch() {
        return "SELECT p.project_id AS id, " +
                "p.name AS project_name, " +
                "p.description AS short_description, " +
                "p.goal AS goal, " +
                "p.balance AS balance, " +
                "p.deadline_date AS deadline_date " +
                "FROM project p " +
                "WHERE p.category_id = ? " +
                "ORDER BY p.name";
    }

    @Override
    public String get4Add() {
        return "insert into project(project_id, NAME, description, goal, balance, deadline_date, demo_link, create_date, category_id) " +
                "values(project_id_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
    }
}
