use kickstarter;

CREATE TABLE quote (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `text` text NOT NULL,
    `author` varchar(200) NOT NULL
);

CREATE TABLE category (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(200) NOT NULL
);

CREATE TABLE project (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `categoryId` INT NOT NULL,
    `name` varchar(200) NOT NULL,
	`description` text NOT NULL,
	`goal` bigint NOT NULL DEFAULT 0,
	`daysToGo` int NOT NULL,
	`owner` text,
	`videoUrl` text 
);
ALTER TABLE `project` ADD CONSTRAINT `category_fk` FOREIGN KEY (`categoryId`) REFERENCES `category`(`id`);

CREATE TABLE reward (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `projectId` INT NOT NULL,
  `pledge` INT NOT NULL,
  `benefit` varchar(200) NOT NULL
);
ALTER TABLE `reward` ADD CONSTRAINT `project_fk` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`);

CREATE TABLE question (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `projectId` INT NOT NULL,
  `questionText` varchar(200) NOT NULL
);
ALTER TABLE `question` ADD CONSTRAINT `project_fk1` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`);

CREATE TABLE payment (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `projectId` INT NOT NULL,
  `name` varchar(200) NOT NULL,
  `cardNumber` varchar(20) NOT NULL,
  `pledge` INT NOT NULL
);
ALTER TABLE `payment` ADD CONSTRAINT `project_fk2` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`);