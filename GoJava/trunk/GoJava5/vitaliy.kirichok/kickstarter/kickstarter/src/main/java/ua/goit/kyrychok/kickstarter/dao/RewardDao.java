package ua.goit.kyrychok.kickstarter.dao;

import ua.goit.kyrychok.kickstarter.model.Reward;

import java.util.List;

public interface RewardDao {

    List<Reward> fetch(int projectId);

    Reward load(int id);
}
