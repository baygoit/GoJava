package ua.goit.kyrychok.kickstarter.dao.database.sql_provider;

import ua.goit.kyrychok.kickstarter.dao.database.ProjectEventSqlProvider;

public class PsqlProjectEventSqlProvider implements ProjectEventSqlProvider {
    @Override
    public String get4Fetch() {
        return "SELECT pe.project_event_id AS id, " +
                "pe.event_date AS event_date, " +
                "pe.message AS message " +
                "FROM project_event pe " +
                "WHERE pe.project_id = ? " +
                "ORDER BY pe.event_date DESC";
    }

    @Override
    public String get4Add() {
        return "insert into project_event(project_event_id, event_date, message, project_id) " +
                "values (nextval('project_event_id_seq'), ?, ?, ?)";
    }

}
