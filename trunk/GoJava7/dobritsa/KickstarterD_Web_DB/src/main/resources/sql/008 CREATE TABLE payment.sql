CREATE TABLE IF NOT EXISTS `kickstarter`.`payment` (
  `id` INT NOT NULL,
  `user` VARCHAR(200) NOT NULL,
  `card` VARCHAR(200) NOT NULL,
  `amount` INT NOT NULL,
  `project_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_payment_project1_idx` (`project_id` ASC),
  CONSTRAINT `fk_payment_project1`
    FOREIGN KEY (`project_id`)
    REFERENCES `kickstarter`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB