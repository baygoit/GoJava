create schema jpa;

use jpa;

CREATE TABLE book (  id int(11) NOT NULL,  title varchar(45) DEFAULT NULL,  unitCost decimal(5,0) DEFAULT NULL,  isbn varchar(45) DEFAULT NULL,  nbOfPage int(11) DEFAULT NULL,  description varchar(245) DEFAULT NULL,  PRIMARY KEY (id));

CREATE TABLE `author` (  `id` INT NOT NULL AUTO_INCREMENT,  `first_name` VARCHAR(45) NULL COMMENT '',  `last_name` VARCHAR(45) NULL COMMENT '',  `bio` VARCHAR(45) NULL COMMENT '',  `date_of_birth` DATE NULL COMMENT '',  `language` VARCHAR(45) NULL COMMENT '',  PRIMARY KEY (`id`)  );


