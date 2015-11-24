CREATE TABLE IF NOT EXISTS `kickstarter`.`question` (
  `id` INT NOT NULL,
  `question` VARCHAR(200) NOT NULL,
  `answer` VARCHAR(200) NULL,
  `time` DATE NOT NULL,
  `project_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_question_project1_idx` (`project_id` ASC),
  CONSTRAINT `fk_question_project1`
    FOREIGN KEY (`project_id`)
    REFERENCES `kickstarter`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB