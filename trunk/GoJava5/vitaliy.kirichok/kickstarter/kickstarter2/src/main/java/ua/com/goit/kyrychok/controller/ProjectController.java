package ua.com.goit.kyrychok.controller;

import org.apache.commons.validator.routines.FloatValidator;
import ua.com.goit.kyrychok.dao.ProjectDao;
import ua.com.goit.kyrychok.dao.RewardDao;
import ua.com.goit.kyrychok.model.Converter;
import ua.com.goit.kyrychok.model.ProjectModel;

import java.util.List;

public class ProjectController {
    private ProjectDao projectDao;
    private RewardDao rewardDao;

    public ProjectController(ProjectDao projectDao, RewardDao rewardDao) {
        this.projectDao = projectDao;
        this.rewardDao = rewardDao;
    }

    public List<ProjectModel> fetch(int categoryId) {
        return Converter.convertProjects(projectDao.fetch(categoryId));
    }

    public ProjectModel get(int id) {
        return Converter.convert(projectDao.get(id));
    }

    public void doDonate(int projectId, String rewardId, String userName, String CardNo, String pledge) {
        //Validation

        int balance = projectDao.getBalance(projectId);
        int amount;
        if (rewardId != null) {
            amount = rewardDao.load(Integer.parseInt(rewardId)).getAmount();
        } else {
            amount = (int) (FloatValidator.getInstance().validate(pledge) * 100);
        }
        projectDao.setBalance(projectId, balance + amount);
    }

}
