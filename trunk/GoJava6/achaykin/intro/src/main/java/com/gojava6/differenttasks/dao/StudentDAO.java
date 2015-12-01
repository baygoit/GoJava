package com.gojava6.differenttasks.dao;

import com.gojava6.differenttasks.dao.domain.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 12.11.2015
 */
public interface StudentDAO {

    Student create();

    Student read(int key);

    void update(Student student);

    void delete(Student student);

    List<Student> getAll() throws SQLException;
}
