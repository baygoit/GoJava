package ua.com.goit.gojava7.kickstarter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.dto.RewardDto;
import ua.com.goit.gojava7.kickstarter.model.Reward;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RewardService {

    private static final Logger log = LoggerFactory.getLogger(RewardService.class);

    @Autowired
    private RewardDao rewardDao;

    public RewardDto get(Long rewardId) {
        log.info("<RewardDto> get(rewardId = {})...", rewardId);

        return constuctRewardDto(rewardDao.get(rewardId));
    }

    public List<RewardDto> getByProject(Long projectId) {
        log.info("<RewardDto> getByProject({})...", projectId);

        List<RewardDto> rewardsDto = new ArrayList<>();

        for(Reward reward : rewardDao.getByProject(projectId)) {
            rewardsDto.add(constuctRewardDto(reward));
        }

        return  rewardsDto;
    }

    private RewardDto constuctRewardDto(Reward reward) {
        log.info("<RewardDto> constuctRewardDto({})...", reward);

        RewardDto rewardDto = new RewardDto();
        rewardDto.setRewardId(reward.getRewardId());
        rewardDto.setAmount(reward.getAmount());
        rewardDto.setReward(reward.getReward());

        rewardDto.setProject(reward.getProject());
        log.info("<RewardDto> constuctRewardDto({}) set projectId = {}", reward, rewardDto.getProject().getProjectId());

        return rewardDto;
    }
}
