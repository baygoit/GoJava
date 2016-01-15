package com.kickstarter.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.kickstarter.dao.Impl.ProjectDaoImpl;
import com.kickstarter.dao.Impl.QuestionDaoImpl;
import com.kickstarter.model.Project;

@Controller
@RequestMapping("/questions") // FIXME question
public class questionController {

    @Autowired
    QuestionDaoImpl questionDao;
    @Autowired
    ProjectDaoImpl projectDao;

    @RequestMapping(method = RequestMethod.POST)
    public String addQuestion(@RequestParam Map<String, String> requestParams) {
        int projectId = Integer.parseInt(requestParams.get("projectId"));
        String question = requestParams.get("question");

        if (question.length() >= 1) { // FIXME const
            Project project = projectDao.getOneProject(projectId);
            questionDao.add(question, project);
        }
        return "redirect:/project?projectId=" + projectId;
    }


}

