-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: kickstarter
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `needMoney` int(11) DEFAULT NULL,
  `haveMoney` int(11) DEFAULT NULL,
  `start` date NOT NULL,
  `comments` longtext,
  `history` varchar(200) NOT NULL,
  `url` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'Romeo & Juliet','William Shakespeare','APORIA',2100,20,'2016-03-15',' !@#$%Jimbo: `Hello`!@#$%Lana: `Hello=)`','What’s in a name? That which we call a rose by any other name would smell as sweet.','www.shakspear.com'),(2,'Bill Clinton','2012 DNC Speech','APORIA',5000,100,'2016-03-14',' ','You see, we believe that ‘We’re all in this together’ is a far better philosophy than ‘You’re on your own.’ So who’s right?','www.della.com'),(3,'WHAT IS BETTER','ETERNAL BLISS OR A SIMPLE BREAD?','SOPHISM',3210,5,'2016-03-08','','What is better than eternal bliss?','www.fdr.com'),(4,'Have','GIVE WHAT WE DON\'T HAVE','SOPHISM',4009,0,'2016-03-11','','Yes, greedy man gives his cash with sorrow.','www.cost.com'),(5,'Barber','Rusell`s paradox','PARADOX',1050,555,'2016-03-15',' ','Who shaves the barber?','www.abc.com'),(6,'Double Liar','Jordain`s paradox','PARADOX',3050,0,'2016-03-16',' ','1913','www.cards.com'),(7,'Liar','Epimendies paradox','PARADOX',7050,9,'2016-03-17','!@#$%Sisi: `How are You?`!@#$%Bob: `Great! Thank You! You?`!@#$%Sisi: `=)`','Certan: `All Cretans are liars`','www.greece.com');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-24 22:20:46
