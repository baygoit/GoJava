-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Час створення: Квт 03 2016 р., 09:29
-- Версія сервера: 5.6.29
-- Версія PHP: 5.3.10-1ubuntu3.21

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- БД: `kickstarter`
--

-- --------------------------------------------------------

--
-- Структура таблиці `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Дамп даних таблиці `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Sport(BD)'),
(2, 'IT'),
(3, 'Medicine'),
(4, 'Photo'),
(5, 'Music'),
(6, 'Video');

-- --------------------------------------------------------

--
-- Структура таблиці `investment`
--

CREATE TABLE IF NOT EXISTS `investment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `cardholder_name` varchar(50) NOT NULL,
  `card_number` varchar(16) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Дамп даних таблиці `investment`
--

INSERT INTO `investment` (`id`, `project_id`, `cardholder_name`, `card_number`, `amount`) VALUES
(1, 1, 'Josh Jenison', '2345543223455432', 230),
(2, 1, 'Tim Holin', '8998899889988998', 300),
(3, 1, 'Hin Opin', '8778877887788778', 10),
(4, 2, 'Kil Margin', '5665566556655665', 45),
(5, 2, 'Tony Tuson', '4554455445544554', 50),
(6, 3, 'Rob Tovn', '6776677667766776', 80),
(7, 4, 'Hunt Enison', '2442424224422442', 60),
(8, 5, 'Bilin Lion', '6776554455567765', 50),
(9, 6, 'Troy Noris', '5252525245454545', 700);

-- --------------------------------------------------------

--
-- Структура таблиці `project`
--

CREATE TABLE IF NOT EXISTS `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  `required_budget` int(11) NOT NULL,
  `days_left` int(11) NOT NULL,
  `history` varchar(500) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Дамп даних таблиці `project`
--

INSERT INTO `project` (`id`, `category_id`, `name`, `description`, `required_budget`, `days_left`, `history`, `url`) VALUES
(1, 1, 'Cube soccer ball(BD)', 'Test description', 2000, 7, 'Test history', 'Test url'),
(2, 1, 'La Liga Weekly Podcast', 'Test description', 400, 3, 'Test history', 'Test url'),
(3, 2, 'Author’s vocabulary', 'Test description', 200000, 365, 'Test history', 'Test url'),
(4, 2, 'Reporter camera', 'Test description', 10000, 150, 'Test history', 'Test url'),
(5, 3, 'Yes Cart', 'Test description', 7000, 15, 'Test history', 'Test url'),
(6, 3, 'ARoglyph', 'Test description', 15000, 30, 'Test history', 'Test url'),
(7, 4, 'Start Control', 'Test description', 16000, 40, 'Test history', 'Test url'),
(8, 4, 'OldStyleRacing', 'Test description', 17000, 17, 'Test history', 'Test url'),
(9, 5, 'Poughkeepsie', 'Test description', 9000, 120, 'Test history', 'Test url'),
(10, 5, 'Photobook', 'Test description', 7000, 10, 'Test history', 'Test url'),
(11, 6, 'Portraits & Stories', 'Test description', 89000, 20, 'Test history', 'Test url'),
(12, 6, 'Alzheimer', 'Test description', 8000, 120, 'Test history', 'Test url');

-- --------------------------------------------------------

--
-- Структура таблиці `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `question` varchar(500) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Дамп даних таблиці `question`
--

INSERT INTO `question` (`id`, `project_id`, `question`) VALUES
(1, 1, 'Why?'),
(2, 1, 'Who?'),
(3, 1, 'What?'),
(4, 2, 'Which?'),
(5, 2, 'Is it really?'),
(6, 3, 'Who?'),
(7, 4, 'What?'),
(8, 5, 'Which?'),
(9, 6, 'Is it really?');

-- --------------------------------------------------------

--
-- Структура таблиці `quote`
--

CREATE TABLE IF NOT EXISTS `quote` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `author` varchar(200) NOT NULL,
  `text` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Дамп даних таблиці `quote`
--

INSERT INTO `quote` (`id`, `author`, `text`) VALUES
(1, 'Robin Sharma', 'By pursuing the things that petrify you, you become peerless.'),
(2, 'Robin Sharma', 'Protect your pristine reputation. It is an asset of priceless value.'),
(3, 'Robin Sharma', 'You have the life you have settled for.'),
(4, 'Robin Sharma', 'Buy a smaller TV and build a larger library.'),
(5, 'Robin Sharma', 'Genius is more about what you have the discipline to say no to versus yes to.');

-- --------------------------------------------------------

--
-- Структура таблиці `reward`
--

CREATE TABLE IF NOT EXISTS `reward` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Дамп даних таблиці `reward`
--

INSERT INTO `reward` (`id`, `name`, `amount`, `description`) VALUES
(1, '1$', 1, 'You obtain a reward: BIG THANK!'),
(2, '10$', 10, 'You obtain a reward: Solo supporter!'),
(3, '100$', 100, 'You obtain a reward: Calm supporter!');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `investment`
--
ALTER TABLE `investment`
  ADD CONSTRAINT `investment_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `project_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
