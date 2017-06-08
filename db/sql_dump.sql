-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.18-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for bookstore
CREATE DATABASE IF NOT EXISTS `bookstore` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bookstore`;

-- Dumping structure for table bookstore.book
CREATE TABLE IF NOT EXISTS `book` (
  `ISBN` varchar(50) NOT NULL,
  `BOOK_NAME` varchar(100) NOT NULL,
  `PUBLISHER_CODE` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`ISBN`),
  KEY `PUBLISHER_CODE` (`PUBLISHER_CODE`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`PUBLISHER_CODE`) REFERENCES `publisher` (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table bookstore.chapter
CREATE TABLE IF NOT EXISTS `chapter` (
  `BOOK_ISBN` varchar(50) NOT NULL,
  `CHAPTER_NUM` int(11) NOT NULL,
  `TITLE` varchar(100) NOT NULL,
  PRIMARY KEY (`BOOK_ISBN`,`CHAPTER_NUM`),
  CONSTRAINT `chapter_ibfk_1` FOREIGN KEY (`BOOK_ISBN`) REFERENCES `book` (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table bookstore.publisher
CREATE TABLE IF NOT EXISTS `publisher` (
  `CODE` varchar(4) NOT NULL,
  `PUBLISHER_NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping database structure for hello-world
CREATE DATABASE IF NOT EXISTS `hello-world` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hello-world`;

-- Dumping structure for table hello-world.guide
CREATE TABLE IF NOT EXISTS `guide` (
  `ID` int(4) NOT NULL AUTO_INCREMENT,
  `STAFF_ID` varchar(12) NOT NULL,
  `NAME` varchar(12) NOT NULL,
  `SALARY` int(5) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table hello-world.message
CREATE TABLE IF NOT EXISTS `message` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TEXT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table hello-world.student
CREATE TABLE IF NOT EXISTS `student` (
  `ID` int(4) NOT NULL AUTO_INCREMENT,
  `ENROLLMENT_ID` varchar(12) NOT NULL,
  `NAME` varchar(12) NOT NULL,
  `GUIDE_ID` int(4) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKb4ny3l3cnsxbbn601ev8mhlj5` (`GUIDE_ID`),
  CONSTRAINT `FKb4ny3l3cnsxbbn601ev8mhlj5` FOREIGN KEY (`GUIDE_ID`) REFERENCES `guide` (`ID`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`GUIDE_ID`) REFERENCES `guide` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
