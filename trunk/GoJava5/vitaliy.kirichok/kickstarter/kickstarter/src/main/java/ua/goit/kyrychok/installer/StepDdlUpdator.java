package ua.goit.kyrychok.installer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StepDdlUpdator extends AbstractStep {
    public static final String CURRENT_VERSION = "1.0";
    public static final int COMPONENT_ID = 2;
    private static final List<String> createQueries;

    static {
        createQueries = new ArrayList<>();
        createQueries.add("create table version (id integer not null, version_number varchar(50) not null)");
        createQueries.add("alter table VERSION add constraint VERSION_ID_UK unique (ID)");
        createQueries.add("create table CATEGORY (category_id integer not null, name varchar(240) not null)");
        createQueries.add("alter table CATEGORY add constraint CATEGORY_PK primary key (CATEGORY_ID)");
        createQueries.add("create table PROJECT (project_id integer not null, name VARCHAR(240) not null, description VARCHAR(500), " +
                "goal integer not null, balance integer, create_date date not null, deadline_date date not null, " +
                "demo_link VARCHAR(500), category_id integer not null)");
        createQueries.add("alter table PROJECT add constraint PROJECT_PK primary key (PROJECT_ID)");
        createQueries.add("alter table PROJECT add constraint PROJECT_CATEGORY_ID_FK foreign key (CATEGORY_ID) " +
                "references CATEGORY (CATEGORY_ID)");
        createQueries.add("create table FAQ (faq_id integer not null, question VARCHAR(500) not null, " +
                "answer VARCHAR(500), project_id integer not null)");
        createQueries.add("alter table FAQ add constraint FAQ_PK primary key (FAQ_ID)");
        createQueries.add("alter table FAQ add constraint FAQ_PROJECT_ID_FK foreign key (PROJECT_ID) " +
                "references PROJECT (PROJECT_ID)");
        createQueries.add("create table MESSAGE (message_id integer not null, text VARCHAR(500) not null)");
        createQueries.add("alter table MESSAGE add constraint MESSAGE_PK primary key (message_id)");
        createQueries.add("create table PROJECT_EVENT (project_event_id integer not null, event_date date not null, " +
                "message VARCHAR(500) not null, project_id integer not null)");
        createQueries.add("alter table PROJECT_EVENT add constraint PROJECT_EVENT_PK primary key (PROJECT_EVENT_ID)");
        createQueries.add("alter table PROJECT_EVENT add constraint PROJECT_EVENT_PROJECT_ID_FK foreign key (PROJECT_ID) " +
                "references PROJECT (PROJECT_ID)");
        createQueries.add("create table REWARD (reward_id integer not null, amount integer not null, " +
                "description VARCHAR(500) not null, project_id integer not null)");
        createQueries.add("alter table REWARD add constraint REWARD_PK primary key (REWARD_ID)");
        createQueries.add("alter table REWARD add constraint REWARD_PROJECT_ID_FK foreign key (PROJECT_ID) " +
                "references PROJECT (PROJECT_ID)");
        createQueries.add("create sequence MESSAGE_ID_SEQ minvalue 1 start with 1 increment by 1 cache 1");
        createQueries.add("create sequence CATEGORY_ID_SEQ minvalue 1 start with 1 increment by 1 cache 1");
        createQueries.add("create sequence FAQ_ID_SEQ minvalue 1 start with 1 increment by 1 cache 1");
        createQueries.add("create sequence PROJECT_EVENT_ID_SEQ minvalue 1 start with 1 increment by 1 cache 1");
        createQueries.add("create sequence PROJECT_ID_SEQ minvalue 1 start with 1 increment by 1 cache 1");
        createQueries.add("create sequence REWARD_ID_SEQ minvalue 1 start with 1 increment by 1 cache 1");
        createQueries.add("insert into version(id, version_number) values (" + COMPONENT_ID + ", '" + CURRENT_VERSION + "'");
    }

    public StepDdlUpdator(InstallerOutput output, PostgreSQLProvider dataSource) {
        super(output, dataSource);
    }

    private String getVersion() {
        String result = "";
        String sql = "select v.version_number as version from version v where v.id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, COMPONENT_ID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getString("version");
                break;
            }
            connection.commit();
        } catch (SQLException e) {
        }
        return result;
    }

    public void executeDDL() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            for (String query : createQueries) {
                try {
                    statement.execute(query);
                    output.writeLine("Executed query: " + query);
                } catch (SQLException e) {
                    output.writeLine("Can't execute query: " + query);
                    throw e;
                }
            }
            connection.commit();
        } catch (SQLException e) {
            String message = "Error when creating database";
            output.writeLine(message);
            throw new RuntimeException(message, e);
        }
    }

    public void update() {
        String currentDbVersion = getVersion();
        if (currentDbVersion.isEmpty()) {
            executeDDL();
        }
    }
}
