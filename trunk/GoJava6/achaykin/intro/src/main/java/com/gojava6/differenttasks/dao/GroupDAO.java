package com.gojava6.differenttasks.dao;

import com.gojava6.differenttasks.dao.domain.Group;

import java.sql.SQLException;
import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 12.11.2015
 */
public interface GroupDAO {

    Group create(Group group) throws SQLException;

    Group read(int key) throws SQLException;

    void update(Group group) throws SQLException;

    void delete(Group group);

    List<Group> getAll() throws SQLException;
}
