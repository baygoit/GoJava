CREATE DATABASE `kickstarter`;
CREATE TABLE `category` (
    `CategoryId` INT(11) NOT NULL AUTO_INCREMENT,
    `Name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`CategoryId`)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;
CREATE TABLE `faq` (
  `IdProject` int(11) NOT NULL,
  `Context` text NOT NULL,
  KEY `IdProject_idx` (`IdProject`),
  CONSTRAINT `IdProject` FOREIGN KEY (`IdProject`) REFERENCES `project` (`IdProject`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `payment` (
  `IdInvestor` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `NumberCard` bigint(20) NOT NULL,
  `Total` int(11) NOT NULL,
  `IdProject` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdInvestor`),
  KEY `ProjectId_idx` (`IdProject`),
  CONSTRAINT `ProjectId` FOREIGN KEY (`IdProject`) REFERENCES `project` (`IdProject`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `project` (
  `IdProject` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) NOT NULL,
  `Total` int(11) NOT NULL,
  `IdCategory` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdProject`),
  KEY `IdCategory_idx` (`IdCategory`),
  CONSTRAINT `IdCategory` FOREIGN KEY (`IdCategory`) REFERENCES `category` (`IdCategory`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `quote` (
  `IdQuote` int(11) NOT NULL AUTO_INCREMENT,
  `Text` text NOT NULL,
  `Author` varchar(100) NOT NULL,
  PRIMARY KEY (`IdQuote`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `category` (`Name`) VALUES ('Games'),('Art'),('Comics');
INSERT INTO quote (Text, Author)
VALUES ("Two things are infinite: the universe and human stupidity and I'm not sure about the universe.",' Albert Einstein'),
('Be the change that you wish to see in the world.','Mahatma Gandhi'),
("If you tell the truth, you don't have to remember anything.",'Mark Twain');
INSERT INTO project (Name,Total,IdCategory)
VALUES ('Failsafe',1025,1),('Centauri Saga',650,1),('Circle',5689,2),
('Elips',6920,2),('Line',6321,2),('The Man with Ten Thousand Eyes',846,3),
('SkyHeart Book I: The Star Seed',9874,3),('Deeds Not Words',1035,3),('Square',2368,2);
INSERT INTO project (Name,Total,IdCategory)
VALUES ('Song of Horror by Protocol Games',5968,1);
INSERT INTO faq VALUES(5,'How are you?');
INSERT INTO faq VALUES(1,'How are you?');
INSERT INTO faq VALUES(1,'And you?');
CREATE TABLE IF NOT EXISTS `kickstarter`.`project_payment` (
  `IdProject` INT NOT NULL COMMENT '',
  `IdInvestor` INT NOT NULL COMMENT '',
  INDEX `project_payment project_idx` (`IdInvestor` ASC)  COMMENT '',
  INDEX `project_payment payment_idx` (`IdProject` ASC)  COMMENT '',
  CONSTRAINT `project_payment project`
    FOREIGN KEY (`IdInvestor`)
    REFERENCES `kickstarter`.`project` (`IdProject`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `project_payment payment`
    FOREIGN KEY (`IdProject`)
    REFERENCES `kickstarter`.`payment` (`IdInvestor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB