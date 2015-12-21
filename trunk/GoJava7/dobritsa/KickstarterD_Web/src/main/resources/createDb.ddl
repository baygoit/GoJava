create table quote (
    id int AUTO_INCREMENT PRIMARY KEY,
    `text` text NOT NULL,
    author varchar(200) NOT NULL
);

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(200) NOT NULL
);

create TABLE project (
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(200) not null,
	shortDescription text not null,
	requiredAmount bigint not null,
	gatheredAmount bigint not null DEFAULT 0,
	daysLeft int not null,
	videoUrl text null
);

ALTER TABLE `project` ADD `category_id` INT NOT NULL AFTER `id`;

ALTER TABLE `project` ADD CONSTRAINT `category_fk` FOREIGN KEY (`category_id`) REFERENCES `category`(`id`);