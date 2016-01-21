package ua.com.goit.gojava7.kickstarter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.dto.RewardDto;
import ua.com.goit.gojava7.kickstarter.model.Reward;

@Repository
public class RewardService {

    private static final Logger log = LoggerFactory.getLogger(RewardService.class);

    @Autowired
    private RewardDao rewardDao;
    @Autowired
    private ProjectService projectService;

    public RewardDto get(Long rewardId) {
        log.info("<RewardDto> get(rewardId = {})...", rewardId);

        return constuctRewardDto(rewardDao.get(rewardId));
    }

    private RewardDto constuctRewardDto(Reward reward) {
        log.info("<RewardDto> constuctRewardDto(rewardId = {})...", reward.getRewardId());

        RewardDto rewardDto = new RewardDto();
        rewardDto.setRewardId(reward.getRewardId());
        rewardDto.setAmount(reward.getAmount());
        rewardDto.setReward(reward.getReward());

        rewardDto.setProjectDto(projectService.constructProjectDtoIdNameCategory(reward.getProject()));
        log.info("<RewardDto> constuctRewardDto({}) set projectId = {}", reward, rewardDto.getProjectDtoId());

        log.info("<RewardDto> constuctRewardDto(rewardId = {}) returned ", reward.getRewardId(), rewardDto);
        return rewardDto;
    }
}
