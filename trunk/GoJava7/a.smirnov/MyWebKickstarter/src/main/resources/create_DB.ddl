CREATE SCHEMA `kickstarter` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `kickstarter`.`quote` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`text` TEXT(2000) NOT NULL,
	`author` VARCHAR(100) NOT NULL,
	PRIMARY KEY (id), 
	UNIQUE INDEX (id)
)

CREATE TABLE `kickstarter`.`category` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	PRIMARY KEY (id), 
	UNIQUE INDEX (id)
)

CREATE TABLE `kickstarter`.`project` (
	`id` INT NOT NULL,
	`name` VARCHAR(100) NOT NULL,
	`short_description` LONGTEXT NOT NULL,
	`required_sum` INT NOT NULL,
	`full_description` LONGTEXT,
	`link_on_video` VARCHAR(100),
	`collected_sum` INT,
	`days_left` INT,
	`category_id` INT NOT NULL, 
	PRIMARY KEY (id), 
	UNIQUE INDEX (id),
	FOREIGN KEY (`category_id`) 
	REFERENCES `kickstarter`.`category` (`id`) 
	ON DELETE NO ACTION ON UPDATE NO ACTION
)

CREATE TABLE `kickstarter`.`reward` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`pledge` INT NOT NULL,
	`description` TEXT(1000) NOT NULL,
	`project_id` INT NOT NULL,
	PRIMARY KEY (id), 
	UNIQUE INDEX (id),
	FOREIGN KEY (`project_id`) 
	REFERENCES `kickstarter`.`project` (`id`) 
	ON DELETE NO ACTION ON UPDATE NO ACTION
)

CREATE TABLE `kickstarter`.`payment` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`owner_name` VARCHAR(100) NOT NULL,
	`credit_card_number` BIGINT NOT NULL,
	`pledge` INT NOT NULL,
	`project_id` INT NOT NULL,
	PRIMARY KEY (id), 
	UNIQUE INDEX (id),
	FOREIGN KEY (`project_id`) 
	REFERENCES `kickstarter`.`project` (`id`) 
	ON DELETE NO ACTION ON UPDATE NO ACTION
)

CREATE TABLE `kickstarter`.`faq` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`question` TEXT(1000) NOT NULL,
	`project_id` INT NOT NULL,
	PRIMARY KEY (id), 
	UNIQUE INDEX (id),
	FOREIGN KEY (`project_id`) 
	REFERENCES `kickstarter`.`project` (`id`) 
	ON DELETE NO ACTION ON UPDATE NO ACTION
)






  

