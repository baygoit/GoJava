package ua.com.goit.kyrychok.controller;

import ua.com.goit.kyrychok.dao.RewardDao;
import ua.com.goit.kyrychok.model.Converter;
import ua.com.goit.kyrychok.model.RewardModel;

import java.util.List;

public class RewardController {
    private RewardDao rewardDao;

    public RewardController(RewardDao rewardDao) {
        this.rewardDao = rewardDao;
    }

    public List<RewardModel> fetch(int projectId) {
        return Converter.convertRewards(rewardDao.fetch(projectId));
    }

    public RewardModel get(int id) {
        return Converter.convert(rewardDao.load(id));
    }
}
