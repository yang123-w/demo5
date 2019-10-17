/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.45 : Database - testdemo
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

http://localhost:9999/demo/testBoot/thread
CREATE DATABASE /*!32312 IF NOT EXISTS*/`testdemo` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `testdemo`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) NOT NULL,
  `passWord` varchar(50) NOT NULL,
  `realName` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`userName`,`passWord`,`realName`) values (3,'admin','qqw','管理员'),(4,'www','aaa','管理员'),(5,'qqqq','111','aaaa'),(6,'qqqq','111','aaaa'),(7,'qqqq','111','aaaa'),(8,'qqqq','111','aaaa'),(9,'qqqq','111','aaaa'),(10,'qqqq','111','aaaa'),(11,'qqqq','111','aaaa'),(12,'qqqq','111','aaaa'),(13,'qqqq','111','aaaa'),(14,'qqqq','111','aaaa');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
