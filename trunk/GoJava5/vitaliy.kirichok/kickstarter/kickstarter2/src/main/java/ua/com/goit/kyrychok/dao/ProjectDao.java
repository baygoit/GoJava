package ua.com.goit.kyrychok.dao;

import ua.com.goit.kyrychok.domain.Project;

import java.util.List;

public interface ProjectDao {

    Project get(int id);

    void setBalance(int projectId, int amount);

    int getBalance(int projectId);

    List<Project> fetch(int categoryId);
}
