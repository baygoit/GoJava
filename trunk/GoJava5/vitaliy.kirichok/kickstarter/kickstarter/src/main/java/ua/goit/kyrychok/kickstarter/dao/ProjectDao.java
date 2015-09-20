package ua.goit.kyrychok.kickstarter.dao;

import ua.goit.kyrychok.kickstarter.model.Project;

public interface ProjectDao {

    Project load(int id);

    void setBalance(int projectId, int amount);

    int getBalance(int projectId);

}
