/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.5.56 : Database - choicefoods
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`choicefoods` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `choicefoods`;

/*Table structure for table `assessfood` */

DROP TABLE IF EXISTS `assessfood`;

CREATE TABLE `assessfood` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `assess` varchar(100) NOT NULL,
  `user_id` int(11) NOT NULL,
  `commentTime` datetime NOT NULL,
  `picSrc` varchar(100) DEFAULT NULL,
  `rank` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `assessfood` */

insert  into `assessfood`(`id`,`assess`,`user_id`,`commentTime`,`picSrc`,`rank`) values 
(1,'真的好好吃啊！',1,'2018-02-02 00:00:00','./public',5),
(2,'还可以',2,'2018-02-02 00:00:00','./public/Uploads/2018-04-09/5acb53c78e48c.jpg',4),
(3,'东西还可以，服务态度太差了！',3,'2018-02-02 00:00:00','./public/Uploads/2018-04-09/5acb53c78e48c.jpg',2),
(4,'还可以',2,'2018-01-02 00:00:00','./public/Uploads/2018-04-09/5acb53c78e48c.jpg',4),
(5,'东西还可以，服务态度太差了！',3,'2017-12-02 00:00:00','./public/Uploads/2018-04-09/5acb53c78e48c.jpg',2),
(6,'1',1,'2011-01-01 00:00:00','./public/Uploads/2018-04-09/5acb53c78e48c.jpg',0),
(7,'1',0,'1999-01-01 00:00:00','images/test.png',1),
(8,'123123',0,'1999-01-01 00:00:00','images/test.png',3),
(9,'123123',0,'1999-01-01 00:00:00','123',3),
(10,'1231232',0,'1999-01-01 00:00:00','123',3),
(11,'123123123',0,'1999-01-01 00:00:00','123',3),
(12,'123123123',0,'1999-01-01 00:00:00','123',3),
(14,'还可以的不错的',14,'1999-01-01 00:00:00','./public/Uploads/2018-04-09/5acb53c78e48c.jpg',3),
(15,'',0,'0000-00-00 00:00:00',NULL,0),
(16,'123123123',14,'1999-01-01 00:00:00','./public/Uploads/2018-04-09/5acb53c78e48c.jpg',4),
(17,'对的,你来对了 ',14,'1999-01-01 00:00:00','./public/Uploads/2018-04-09/5acb55c408e32.jpg',3),
(18,'123123',14,'1999-01-01 00:00:00','./public/Uploads/2018-04-09/5acb5797d93c5.jpg',3),
(19,'飒飒大苏打',14,'1999-01-01 00:00:00','123',3),
(20,'我的天哪',14,'1999-01-01 00:00:00','./public/Uploads/2018-04-09/5acb615c63c24.jpg',3);

/*Table structure for table `board` */

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `board_Id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_boardType_board` (`board_Id`),
  CONSTRAINT `FK_boardType_board` FOREIGN KEY (`board_Id`) REFERENCES `boardtype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `board` */

insert  into `board`(`id`,`board_Id`,`status`) values 
(1,1,2),
(2,1,2),
(3,1,2),
(4,1,2),
(5,1,2),
(6,1,1),
(7,2,2),
(8,2,2),
(9,2,2),
(10,2,2),
(11,2,2),
(12,2,1),
(13,3,2),
(14,3,2),
(15,3,2),
(16,3,2),
(17,3,2),
(18,3,1),
(19,4,2),
(20,4,2),
(21,4,2),
(22,4,2),
(23,4,2),
(24,4,1);

/*Table structure for table `boardtype` */

DROP TABLE IF EXISTS `boardtype`;

CREATE TABLE `boardtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `board_type` varchar(20) NOT NULL,
  `maxCount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `boardtype` */

insert  into `boardtype`(`id`,`board_type`,`maxCount`) values 
(1,'小桌',2),
(2,'中桌',4),
(3,'大桌',8),
(4,'包厢',14);

/*Table structure for table `conservator` */

DROP TABLE IF EXISTS `conservator`;

CREATE TABLE `conservator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `ispwd` varchar(2) NOT NULL DEFAULT '否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `conservator` */

insert  into `conservator`(`id`,`username`,`password`,`ispwd`) values 
(1,'admin','123','是'),
(2,'小倪','123456','否'),
(3,'小磊','123456','否'),
(4,'小申','123456','否'),
(5,'小袁','123456','否');

/*Table structure for table `food` */

DROP TABLE IF EXISTS `food`;

CREATE TABLE `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `food_Name` varchar(20) NOT NULL,
  `type_Id` int(11) NOT NULL,
  `price` float NOT NULL,
  `count` int(11) NOT NULL,
  `salesCount` int(11) NOT NULL,
  `picSrc` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

/*Data for the table `food` */

insert  into `food`(`id`,`food_Name`,`type_Id`,`price`,`count`,`salesCount`,`picSrc`) values 
(1,' 中华海草',1,20,10,11,'1.jpg'),
(2,'芥末章鱼',1,5,10,11,'1.jpg'),
(3,'味付海螺',1,88,10,11,'1.jpg'),
(4,'日式泡菜',1,6,10,11,'1.jpg'),
(5,'麻辣鲜蛤',1,45,10,11,'1.jpg'),
(6,'清水毛豆',1,66,10,11,'1.jpg'),
(7,'禾风蔬菜沙拉',2,33,10,11,'1.jpg'),
(8,'土豆沙拉',2,12,0,0,'1.jpg'),
(9,'水果沙拉',2,23,0,0,'1.jpg'),
(10,'三文鱼牛油果沙拉',2,23,0,0,'1.jpg'),
(11,'金枪鱼牛油果沙拉',2,45,0,0,'1.jpg'),
(12,'蟹子水果沙拉',2,456,0,0,'1.jpg'),
(13,'三文鱼刺身(厚)',3,56,11,11,'1.jpg'),
(14,'三文鱼刺身(薄)',3,49,11,11,'1.jpg'),
(15,'蓝鳍金枪鱼刺身',3,61,11,11,'1.jpg'),
(16,'北极贝刺身(8片)',3,49,11,1,'1.jpg'),
(17,'甜虾刺身(6只)',3,53,11,11,'1.jpg'),
(18,' 蟹籽刺身',3,42,111,0,'1.jpg'),
(19,'刺身双拼',3,85,11,11,'1.jpg'),
(20,'刺身赤贝(2只)',3,48,0,0,'1.jpg'),
(21,'樱花卷4枚',4,20,0,0,'1.jpg'),
(22,' 樱花卷8枚',4,23,0,0,'1.jpg'),
(23,' 糊世卷4枚',4,12,0,0,'1.jpg'),
(24,' 糊世卷8枚',4,34,0,0,'1.jpg'),
(25,' 火炙招牌卷4枚',4,34,0,0,'1.jpg'),
(26,' 三文鱼握寿司',5,34,0,0,'1.jpg'),
(27,'甜虾寿司',5,45,0,0,'1.jpg'),
(28,' 鳗鱼寿司',5,56,0,0,'1.jpg'),
(29,'枪烤特色寿司',5,56,0,0,'1.jpg'),
(30,'芒果三文鱼寿司',5,67,0,0,'1.jpg'),
(31,'铁板牛仔饭',6,78,0,0,'1.jpg'),
(32,'滑菇味汤',6,89,0,0,'1.jpg'),
(33,'海鲜汤',6,56,0,0,'1.jpg'),
(34,'铁板鱿鱼须',6,56,0,0,'1.jpg'),
(35,'日式咖喱虾',6,56,0,0,'1.jpg'),
(36,'芝士配手握',7,34,0,0,'1.jpg'),
(37,'寿司拼盘',7,23,0,0,'1.jpg'),
(38,'卷物评判',7,213,0,0,'1.jpg'),
(39,'串烧拼盘',7,34,0,0,'1.jpg'),
(40,'鲜虾(5只)',8,345,0,0,'1.jpg'),
(41,'日式鸡块',8,345,0,0,'1.jpg'),
(42,'章鱼小丸子',8,345,0,0,'1.jpg'),
(43,'什锦天',8,345,0,0,'1.jpg'),
(44,'可乐',8,4,0,0,'1.jpg'),
(45,'雪碧',8,4,0,0,'1.jpg'),
(46,'芬达',8,4,0,0,'1.jpg'),
(47,'波子汽水',8,4,0,0,'1.jpg'),
(48,'朝日啤酒',8,4,0,0,'1.jpg');

/*Table structure for table `foodtype` */

DROP TABLE IF EXISTS `foodtype`;

CREATE TABLE `foodtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `foodtype` */

insert  into `foodtype`(`id`,`typeName`) values 
(1,'一品料理'),
(2,'沙拉系列'),
(3,'刺身系列'),
(4,'美式中卷'),
(8,'饮料酒水');

/*Table structure for table `orderdetail` */

DROP TABLE IF EXISTS `orderdetail`;

CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `food_info` text,
  `sum` int(110) DEFAULT NULL,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_order` (`order_id`),
  CONSTRAINT `FK_user_order` FOREIGN KEY (`order_id`) REFERENCES `orderrecorder` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderdetail` */

/*Table structure for table `orderrecorder` */

DROP TABLE IF EXISTS `orderrecorder`;

CREATE TABLE `orderrecorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(111) DEFAULT NULL,
  `board_Id` int(110) DEFAULT NULL,
  `recorder_time` datetime DEFAULT NULL,
  `taste` int(11) DEFAULT '1',
  `status` varchar(11) DEFAULT '0',
  `total` double DEFAULT '0',
  `food_info` text,
  PRIMARY KEY (`id`),
  KEY `FK_user_shoppingCar` (`user_id`),
  KEY `FK_board_shoppingCar` (`board_Id`),
  CONSTRAINT `FK_board_shoppingCar` FOREIGN KEY (`board_Id`) REFERENCES `board` (`id`),
  CONSTRAINT `FK_user_shoppingCar` FOREIGN KEY (`user_id`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `orderrecorder` */

insert  into `orderrecorder`(`id`,`user_id`,`board_Id`,`recorder_time`,`taste`,`status`,`total`,`food_info`) values 
(28,13,4,'2018-04-09 19:14:11',1,'1',55,'1:2!2:3!'),
(29,14,4,'2018-04-09 19:20:23',1,'2',1199,'1:6!2:3!3:5!4:5!6:7!7:4!'),
(30,13,4,'2018-04-09 22:27:02',1,'0',3352,'11:0!12:6!13:11!'),
(31,13,4,'2018-04-09 23:03:15',1,'0',257,'1:4!3:1!2:1!4:1!5:1!7:1!'),
(32,14,4,'2018-04-23 22:40:37',1,'0',20,'1:1!'),
(33,14,4,'2018-04-23 22:42:42',1,'0',20,'1:1!');

/*Table structure for table `source` */

DROP TABLE IF EXISTS `source`;

CREATE TABLE `source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `source_name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `source` */

insert  into `source`(`id`,`source_name`) values 
(1,'客户端'),
(2,'收银端');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(200) NOT NULL,
  `salt` varchar(200) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`Id`,`account`,`password`,`salt`) values 
(1,'1','123','1'),
(2,'1','123','2'),
(3,'1','123','3'),
(4,'1','123','4'),
(5,'1','EDGM@MAMABDACFDLLG','e9f78a144880363f5f7c91b9155116b4'),
(6,'1','EDGM@MAMABDACFDLLG','e22c603b11cd2b49b0b4b7a52c05c9b8'),
(7,'1','EDGM@MAMABDACFDLLG','fd9ed98a8fb496bcb01c982d577678ad'),
(8,'1','BMLAEEMLEFEALE@MMCCDEBBL','0c9095e86cb516de4b5f1ad49cfc4bb5'),
(9,'1','AMGMLGAF@G@B@@BMFMG','ed5540587f4ef16c602cddccedae6e98'),
(10,'1','@ELMLDDFD@MLDDMMLL@FC','db66461e3dfc9c426053e1a81bcafab1'),
(11,'1','@ELMLDDFD@MLDDMMLL@FC','9defb099c47157d4d3e0e3f6f89538e5'),
(12,'1','@ELMLDDFD@MLDDMMLL@FC','47da8e85de2567fd00b3241d07f40821'),
(13,'123123','@FMC@@EGMAAFGAF@AF@MCGMMCMG','588da23c68e7959c427452156e888e54'),
(14,'qweqwe','BGMLEFCMFLEFMGFDCLFBBG','c2e5b6096aabd052c3d7cd7c700cd8fc');

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_Id` int(100) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user_photo` varchar(100) NOT NULL,
  `user_gender` char(100) NOT NULL,
  `user_phoneNo` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_userinfo` (`user_Id`),
  CONSTRAINT `FK_user_userinfo` FOREIGN KEY (`user_Id`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`id`,`user_Id`,`user_name`,`user_photo`,`user_gender`,`user_phoneNo`) values 
(1,1,'张三','./public/Uploads/2018-04-09/5acb4b0abac70.jpg','男','12345678910'),
(2,2,'李四','./public/Uploads/2018-04-09/5acb4b0abac70.jpg','男','12345678910'),
(3,3,'王五','./public/Uploads/2018-04-09/5acb4b0abac70.jpg','男','12345678910'),
(4,4,'xixi','images/order-my.png','女','12345678910'),
(5,5,'ooo','images/order-my.png','男','13684197392'),
(6,2,'ok','./public/Uploads/2018-04-09/5acb4b0abac70.jpg','男','13684197392'),
(7,9,'ok','images/order-my.png','男','110'),
(8,9,'','images/order-my.png','男',''),
(9,11,'','images/order-my.png','男',''),
(10,12,'','images/order-my.png','男',''),
(11,13,'123','./public/Uploads/2018-04-09/5acb808d5edd3.png','男','123'),
(12,14,'周抄123','./public/Uploads/2018-04-23/5addf0cc62c20.jpg','女','13382058445');

/*Table structure for table `waitlist` */

DROP TABLE IF EXISTS `waitlist`;

CREATE TABLE `waitlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `getNo` varchar(20) NOT NULL,
  `boardType_Id` int(11) NOT NULL,
  `waitTime` datetime NOT NULL,
  `predictTime` datetime NOT NULL,
  `source_id` int(11) NOT NULL,
  `waitCount` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_source_waitList` (`source_id`),
  CONSTRAINT `FK_source_waitList` FOREIGN KEY (`source_id`) REFERENCES `source` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `waitlist` */

insert  into `waitlist`(`id`,`user_id`,`getNo`,`boardType_Id`,`waitTime`,`predictTime`,`source_id`,`waitCount`) values 
(19,1,'S0005',4,'2018-04-07 11:55:55','2018-08-08 00:00:00',1,14),
(20,1,'S0006',4,'2018-04-07 11:55:56','2018-08-08 00:00:00',1,14),
(21,1,'S0007',4,'2018-04-07 11:55:58','2018-08-08 00:00:00',1,14),
(22,1,'C0006',1,'2018-04-07 11:56:59','2018-08-08 00:00:00',1,1),
(23,1,'S0008',4,'2018-04-07 11:58:18','2018-08-08 00:00:00',1,12),
(24,1,'B0005',2,'2018-04-09 22:28:38','2018-08-08 00:00:00',1,3),
(25,1,'A0005',3,'2018-04-23 22:42:52','2018-08-08 00:00:00',1,5);

/*Table structure for table `waitnum` */

DROP TABLE IF EXISTS `waitnum`;

CREATE TABLE `waitnum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `waitNum` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `waitnum` */

insert  into `waitnum`(`id`,`waitNum`) values 
(1,'C0001'),
(2,'C0002'),
(3,'C0003'),
(4,'C0004'),
(5,'B0001'),
(6,'B0002'),
(7,'A0001'),
(8,'A0002'),
(9,'S0001'),
(10,'S0002'),
(11,'B0003'),
(12,'B0004'),
(13,'C0005'),
(14,'A0003'),
(15,'A0004'),
(16,'0001'),
(17,'S0003'),
(18,'S0004'),
(19,'S0005'),
(20,'S0006'),
(21,'S0007'),
(22,'C0006'),
(23,'S0008'),
(24,'waitNum'),
(25,'B0005'),
(26,'A0005');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
