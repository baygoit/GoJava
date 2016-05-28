CREATE DATABASE  IF NOT EXISTS `kickstarter_test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `kickstarter_test`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: kickstarter_test
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
-- Table structure for table `accounting`
--

DROP TABLE IF EXISTS `accounting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accounting` (
  `invoice` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`invoice`),
  UNIQUE KEY `invoice_UNIQUE` (`invoice`),
  KEY `id` (`id`),
  CONSTRAINT `accounting_ibfk_1` FOREIGN KEY (`id`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounting`
--

LOCK TABLES `accounting` WRITE;
/*!40000 ALTER TABLE `accounting` DISABLE KEYS */;
INSERT INTO `accounting` VALUES (1,'2016-04-08 16:07:58',1,5),(2,'2016-05-28 17:31:09',1,1),(3,'2016-05-28 17:31:19',1,1),(4,'2016-05-28 17:31:33',1,1),(5,'2016-05-28 17:44:24',1,1),(6,'2016-05-28 18:11:18',1,1),(7,'2016-05-28 18:13:15',1,1),(8,'2016-05-28 18:13:36',1,1),(9,'2016-05-28 18:22:36',1,1),(10,'2016-05-28 18:29:52',1,1),(11,'2016-05-28 18:31:33',1,1),(12,'2016-05-28 18:35:29',1,1),(13,'2016-05-28 18:36:17',1,1),(14,'2016-05-28 18:45:34',1,1),(15,'2016-05-28 18:48:01',1,1),(16,'2016-05-28 18:49:38',1,1),(17,'2016-05-28 18:52:16',1,1),(18,'2016-05-28 18:55:14',1,1),(19,'2016-05-28 18:56:02',1,1),(20,'2016-05-28 18:57:32',1,1),(21,'2016-05-28 18:58:07',1,1),(22,'2016-05-28 18:58:51',1,1),(23,'2016-05-28 18:59:34',1,1),(24,'2016-05-28 19:05:22',1,1),(25,'2016-05-28 19:10:36',1,1),(26,'2016-05-29 00:21:42',1,1),(27,'2016-05-29 00:53:11',1,1),(28,'2016-05-29 00:54:24',1,1),(29,'2016-05-29 00:56:38',1,1),(30,'2016-05-29 00:57:12',1,1);
/*!40000 ALTER TABLE `accounting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `category_UNIQUE` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'category1'),(2,'category2');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `number` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `author` varchar(20) NOT NULL,
  `text` varchar(200) NOT NULL,
  PRIMARY KEY (`number`),
  UNIQUE KEY `invoice_UNIQUE` (`number`),
  KEY `id` (`id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`id`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,1,'2016-05-28 18:45:34','test(45:34)','1464450334917'),(2,1,'2016-05-28 18:48:02','test(48:2)','1464450482560'),(3,1,'2016-05-28 18:49:39','test(49:39)','1464450579011'),(4,1,'2016-05-28 18:52:17','test(52:17)','1464450737367'),(5,1,'2016-05-28 18:55:15','test(55:15)','1464450915000'),(6,1,'2016-05-28 18:56:03','test(56:3)','1464450963228'),(7,1,'2016-05-28 18:57:32','test(57:32)','1464451052911'),(8,1,'2016-05-28 18:58:08','test(58:8)','1464451088257'),(9,1,'2016-05-28 18:58:53','test(58:53)','1464451133296'),(10,1,'2016-05-28 18:59:36','test(59:36)','1464451176532'),(11,1,'2016-05-28 19:05:24','test(5:24)','1464451524000'),(12,1,'2016-05-28 19:10:38','test(10:38)','1464451838368'),(13,1,'2016-05-29 00:21:44','test(21:44)','1464470504791'),(14,1,'2016-05-29 00:53:13','test(53:13)','1464472393258'),(15,1,'2016-05-29 00:54:26','test(54:26)','1464472466431'),(16,1,'2016-05-29 00:56:40','test(56:40)','1464472600961'),(17,1,'2016-05-29 00:57:14','test(57:14)','1464472634483');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `need_money` int(11) NOT NULL,
  `start` datetime NOT NULL,
  `story` varchar(100) NOT NULL,
  `url` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `category` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'project1','category1',100,'2016-04-03 13:07:58','test','test'),(2,'project2','category2',100,'2016-04-03 13:17:18','test','test'),(3,'project3','category3',100,'2016-04-03 13:17:18','test','test');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quotes`
--

DROP TABLE IF EXISTS `quotes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quotes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quote` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `category_UNIQUE` (`quote`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quotes`
--

LOCK TABLES `quotes` WRITE;
/*!40000 ALTER TABLE `quotes` DISABLE KEYS */;
INSERT INTO `quotes` VALUES (1,'quote1'),(2,'quote2');
/*!40000 ALTER TABLE `quotes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'kickstarter_test'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-29  1:10:06
