CREATE TABLE IF NOT EXISTS `kickstarter`.`reward` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `amount` INT NOT NULL,
  `reward` VARCHAR(200) NOT NULL,
  `project_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reward_project1_idx` (`project_id` ASC),
  CONSTRAINT `fk_reward_project1`
    FOREIGN KEY (`project_id`)
    REFERENCES `kickstarter`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB