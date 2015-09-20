package ua.goit.kyrychok.kickstarter.dao.database;

public interface ProjectSqlProvider {

    String get4Load();

    String get4SetBalance();

    String get4GetBalance();

    String get4Fetch();

    String get4Add();
}
