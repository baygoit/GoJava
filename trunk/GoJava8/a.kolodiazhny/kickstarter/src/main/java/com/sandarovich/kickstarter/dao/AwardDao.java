package com.sandarovich.kickstarter.dao;


import com.sandarovich.kickstarter.model.Award;
import com.sandarovich.kickstarter.model.Project;

import java.util.List;

public interface AwardDao {
    List<Award> getByProject(Project project);

    Award getById(long id);
}
