package ua.com.goit.kyrychok.dao;

import ua.com.goit.kyrychok.domain.Project;

public interface ProjectDao {

    Project load(int id);

    void setBalance(int projectId, int amount);

    int getBalance(int projectId);

}
