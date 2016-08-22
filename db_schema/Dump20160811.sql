CREATE DATABASE  IF NOT EXISTS `shopcenterdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `shopcenterdb`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: shopcenterdb
-- ------------------------------------------------------
-- Server version	5.5.35

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
-- Table structure for table `ums_user`
--

DROP TABLE IF EXISTS `ums_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ums_user` (
  `id` char(32) NOT NULL,
  `name` varchar(45) DEFAULT NULL COMMENT '姓名',
  `nickname` varchar(45) DEFAULT NULL COMMENT '昵称',
  `account` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `salt` varchar(32) DEFAULT NULL COMMENT '盐值',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  `account_type_fk` int(11) NOT NULL,
  `date_create` datetime NOT NULL,
  `date_update` datetime NOT NULL,
  `creator_fk` varchar(32) NOT NULL,
  `updater_fk` varchar(32) NOT NULL,
  `is_valid` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `ums_product`;

CREATE TABLE `ums_product` (
  `id` char(32) NOT NULL,
  `name` varchar(45) DEFAULT NULL COMMENT '商品名称',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `price` DECIMAL(7,2) DEFAULT NULL COMMENT '单价',
  `image_full_path` varchar(256) DEFAULT NULL COMMENT '图片全称',
  `date_create` datetime NOT NULL,
  `date_update` datetime NOT NULL,
  `creator_fk` varchar(32) NOT NULL,
  `updater_fk` varchar(32) NOT NULL,
  `is_valid` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';


INSERT INTO `ums_product` VALUES ('QE938PJ0YWHXPWVQL4Z3UMRAAXPJRP4R','西瓜',NULL,30.00,NULL,'2016-08-20 14:00:00','2016-08-20 14:00:00','ADMIN1E35D8911E68C9F3C970ED7EF76','ADMIN1E35D8911E68C9F3C970ED7EF76',1),('SK1EUOOYPUL0S3L0NA9H281351EQF1IU','香蕉',NULL,20.00,NULL,'2016-08-20 14:00:00','2016-08-20 14:00:00','ADMIN1E35D8911E68C9F3C970ED7EF76','ADMIN1E35D8911E68C9F3C970ED7EF76',1),('XHO520B6CKD02I7YS3V4DQ7C5CKG87RI','苹果',NULL,10.00,NULL,'2016-08-20 14:00:00','2016-08-20 14:00:00','ADMIN1E35D8911E68C9F3C970ED7EF76','ADMIN1E35D8911E68C9F3C970ED7EF76',1);


DROP TABLE IF EXISTS `ums_order`;

CREATE TABLE `ums_order` (
  `id` char(32) NOT NULL,
  `amount` DECIMAL(9,2) DEFAULT NULL COMMENT '总价',
  `title` varchar(512) DEFAULT NULL COMMENT '描述',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `status` tinyint(4) DEFAULT 0 COMMENT '0-Draft,1-commit,2-payment,3-recive,4-close',
  `date_create` datetime NOT NULL,
  `date_update` datetime NOT NULL,
  `creator_fk` varchar(32) NOT NULL,
  `updater_fk` varchar(32) NOT NULL,
  `is_valid` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

DROP TABLE IF EXISTS `ums_order_item`;

CREATE TABLE `ums_order_item` (
  `id` char(32) NOT NULL,
  `order_id` char(32) NOT NULL,
  `number` DECIMAL(3) DEFAULT NULL COMMENT '数量',
  `product_name` varchar(512) DEFAULT NULL COMMENT '描述',
  `price` DECIMAL(7,2) DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细表';



--
-- Dumping data for table `ums_user`
--

LOCK TABLES `ums_user` WRITE;
/*!40000 ALTER TABLE `ums_user` DISABLE KEYS */;
INSERT INTO `ums_user` VALUES ('ADMIN1E35D8911E68C9F3C970ED7EF76','超级管理员','超级管理员','admin','a3d6986f3906109e533c35eff5ffed3f','93a59541633501ca6d5bc52a78531432',1,200,'2016-08-09 12:54:55','2016-08-09 12:54:55','ADMIN1E35D8911E68C9F3C970ED7EF76','ADMIN1E35D8911E68C9F3C970ED7EF76',1);
/*!40000 ALTER TABLE `ums_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'shopcenterdb'
--

--
-- Dumping routines for database 'shopcenterdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-11 21:38:17
