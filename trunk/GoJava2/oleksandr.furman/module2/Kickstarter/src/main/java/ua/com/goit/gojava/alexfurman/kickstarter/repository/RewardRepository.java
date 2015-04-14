package ua.com.goit.gojava.alexfurman.kickstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.Reward;

public interface RewardRepository extends JpaRepository<Reward, Integer> {

}
