package ua.com.goit.gojava7.kickstarter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.goit.gojava7.kickstarter.dao.db.ProjectDao;
import ua.com.goit.gojava7.kickstarter.model.Project;

@RestController
@RequestMapping("/rest")
public class ProjectRestService{

    @Autowired
    private ProjectDao projectDao;
    @RequestMapping("/project/{projectId}")
    public Project getProject(@PathVariable("projectId") Integer projectId) {
        return projectDao.getProject(projectId);
    }

}
