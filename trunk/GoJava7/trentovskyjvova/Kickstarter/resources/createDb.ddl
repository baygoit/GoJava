CREATE TABLE quote (
    id int AUTO_INCREMENT PRIMARY KEY,
    `text` text NOT NULL,
    author varchar(200) NOT NULL
);

CREATE TABLE category (
  id int(11) AUTO_INCREMENT PRIMARY KEY,
  name varchar(200) NOT NULL
);

CREATE TABLE project (
    id int AUTO_INCREMENT PRIMARY KEY,
    categoryId int NOT NULL,
    name varchar(200) NOT NULL,
	description text NOT NULL,
	goal bigint NOT NULL DEFAULT 0,
	daysToGo int NOT NULL,
	owner text,
	videoUrl text 
);

ALTER TABLE `project` ADD `category_id` INT NOT NULL AFTER `id`;

ALTER TABLE `project` ADD CONSTRAINT `category_fk` FOREIGN KEY (`category_id`) REFERENCES `category`(`id`);