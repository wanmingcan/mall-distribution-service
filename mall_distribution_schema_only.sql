-- MySQL dump 10.13  Distrib 8.4.0, for macos14 (arm64)
--
-- Host: 127.0.0.1    Database: mall_distribution
-- ------------------------------------------------------
-- Server version	8.4.5

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `distribution_commission_cash`
--

DROP TABLE IF EXISTS `distribution_commission_cash`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distribution_commission_cash` (
  `cash_id` bigint NOT NULL AUTO_INCREMENT,
  `account_type` varchar(255) DEFAULT NULL,
  `add_time` datetime NOT NULL,
  `admin_id` int DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `amount` decimal(19,2) NOT NULL,
  `bank_account_name` varchar(255) DEFAULT NULL,
  `bank_account_number` varchar(255) DEFAULT NULL,
  `bind_phone` varchar(255) DEFAULT NULL,
  `cash_sn` varchar(100) NOT NULL,
  `distributor_id` int NOT NULL,
  `id_cart_number` varchar(18) DEFAULT NULL,
  `member_id` int NOT NULL,
  `member_name` varchar(255) DEFAULT NULL,
  `pay_person` varchar(255) DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `refuse_reason` varchar(1000) DEFAULT NULL,
  `state` int NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`cash_id`),
  UNIQUE KEY `UK_1mp8vqwaxmgslqxw0tjx7ablv` (`cash_sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `distribution_goods`
--

DROP TABLE IF EXISTS `distribution_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distribution_goods` (
  `common_id` bigint NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `commission_rate` int DEFAULT NULL,
  `commission_total` decimal(19,2) DEFAULT NULL,
  `orders_count` bigint DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`common_id`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `distribution_orders`
--

DROP TABLE IF EXISTS `distribution_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distribution_orders` (
  `distribution_orders_id` bigint NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `commission_rate` int DEFAULT NULL,
  `common_id` int DEFAULT NULL,
  `distribution_orders_type` int DEFAULT NULL,
  `distribution_store_pay` int DEFAULT NULL,
  `distribution_store_pay_time` datetime DEFAULT NULL,
  `distributor_id` int DEFAULT NULL,
  `finish_time` datetime DEFAULT NULL,
  `member_id` int DEFAULT NULL,
  `orders_finish_time` datetime DEFAULT NULL,
  `orders_goods_id` int DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`distribution_orders_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `distribution_store_site`
--

DROP TABLE IF EXISTS `distribution_store_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distribution_store_site` (
  `store_id` bigint NOT NULL AUTO_INCREMENT,
  `commission_rate` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `distribution_store_stat`
--

DROP TABLE IF EXISTS `distribution_store_stat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distribution_store_stat` (
  `stat_id` bigint NOT NULL AUTO_INCREMENT,
  `commission_amount` decimal(19,2) NOT NULL,
  `distribution_num` bigint NOT NULL,
  `stat_date` datetime NOT NULL,
  `stat_hour` int NOT NULL,
  `store_id` int NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`stat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `distributor`
--

DROP TABLE IF EXISTS `distributor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distributor` (
  `distributor_id` bigint NOT NULL AUTO_INCREMENT,
  `account_type` varchar(255) NOT NULL,
  `bank_account_name` varchar(255) DEFAULT NULL,
  `bank_account_number` varchar(255) NOT NULL,
  `bind_email` varchar(255) DEFAULT NULL,
  `bind_phone` varchar(255) DEFAULT NULL,
  `commission_available` decimal(19,2) DEFAULT NULL,
  `commission_freeze` decimal(19,2) DEFAULT NULL,
  `default_favorites_id` int DEFAULT NULL,
  `distribution_amount` decimal(19,2) DEFAULT NULL,
  `distribution_orders_count` int DEFAULT NULL,
  `id_cart_back_image` varchar(255) DEFAULT NULL COMMENT '身份证背面照片',
  `id_cart_front_image` varchar(255) DEFAULT NULL COMMENT '身份证正面照片',
  `id_cart_hand_image` varchar(255) DEFAULT NULL COMMENT '手持身份证照片',
  `id_cart_number` varchar(18) NOT NULL,
  `joinin_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `member_id` int NOT NULL,
  `member_name` varchar(255) DEFAULT NULL,
  `pay_commission` decimal(19,2) DEFAULT NULL,
  `pay_person` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `state` int DEFAULT NULL,
  `unpay_commission` decimal(19,2) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`distributor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `distributor_commission_log`
--

DROP TABLE IF EXISTS `distributor_commission_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distributor_commission_log` (
  `log_id` bigint NOT NULL AUTO_INCREMENT,
  `add_time` datetime NOT NULL,
  `admin_id` int DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `available_amount` decimal(19,2) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `distributor_id` int NOT NULL,
  `freeze_amount` decimal(19,2) DEFAULT NULL,
  `member_id` int NOT NULL,
  `member_name` varchar(255) DEFAULT NULL,
  `operation_stage` varchar(50) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `distributor_favorites`
--

DROP TABLE IF EXISTS `distributor_favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distributor_favorites` (
  `distributor_favorites_id` bigint NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `distributor_favorites_name` varchar(255) NOT NULL,
  `distributor_id` int DEFAULT NULL,
  `is_default` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`distributor_favorites_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `distributor_goods`
--

DROP TABLE IF EXISTS `distributor_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distributor_goods` (
  `distributor_goods_id` bigint NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `common_id` int DEFAULT NULL,
  `distribution_count` int DEFAULT NULL,
  `distributor_favorites_id` int DEFAULT NULL,
  `distributor_id` int DEFAULT NULL,
  `member_id` int DEFAULT NULL,
  `member_name` varchar(255) DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `store_name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`distributor_goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `distributor_join`
--

DROP TABLE IF EXISTS `distributor_join`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distributor_join` (
  `member_id` bigint NOT NULL AUTO_INCREMENT,
  `account_type` varchar(255) NOT NULL,
  `bank_account_name` varchar(255) DEFAULT NULL,
  `bank_account_number` varchar(255) DEFAULT NULL,
  `handle_time` datetime DEFAULT NULL,
  `id_cart_back_image` varchar(255) DEFAULT NULL COMMENT '身份证背面照片',
  `id_cart_front_image` varchar(255) DEFAULT NULL COMMENT '身份证正面照片',
  `id_cart_hand_image` varchar(255) DEFAULT NULL COMMENT '手持身份证照片',
  `id_cart_number` varchar(18) NOT NULL,
  `joinin_message` varchar(255) DEFAULT NULL,
  `joinin_time` datetime DEFAULT NULL,
  `member_name` varchar(255) DEFAULT NULL,
  `pay_person` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `state` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=529 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-07  5:59:07
