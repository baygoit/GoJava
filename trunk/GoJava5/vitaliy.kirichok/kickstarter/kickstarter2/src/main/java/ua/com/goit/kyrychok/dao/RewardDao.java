package ua.com.goit.kyrychok.dao;

import ua.com.goit.kyrychok.domain.Reward;

import java.util.List;

public interface RewardDao {

    List<Reward> fetch(int projectId);

    Reward load(int id);
}
