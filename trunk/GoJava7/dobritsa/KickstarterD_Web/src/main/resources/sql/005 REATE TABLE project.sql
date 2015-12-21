CREATE TABLE IF NOT EXISTS `kickstarter`.`project` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  `goal` INT NOT NULL,
  `pledged` INT NOT NULL,
  `daysToGo` INT NOT NULL,
  `history` VARCHAR(1000) NOT NULL,
  `link` VARCHAR(100) NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_project_Category_idx` (`category_id` ASC),
  CONSTRAINT `fk_project_Category`
    FOREIGN KEY (`category_id`)
    REFERENCES `kickstarter`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB