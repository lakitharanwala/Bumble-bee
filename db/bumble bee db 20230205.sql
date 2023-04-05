-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: bumble_bee
-- ------------------------------------------------------
-- Server version	5.7.35-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `ID` varchar(45) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `STATUS` tinyint(4) DEFAULT NULL,
  `INSERT_DATE_TIME` varchar(45) DEFAULT NULL,
  `UPDATE_DATE_TIME` varchar(45) DEFAULT NULL,
  `INSERT_USER` varchar(45) DEFAULT NULL,
  `UPDATE_USER` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES ('1','bumble bee',0,NULL,NULL,NULL,NULL),('22425782','hp',0,NULL,NULL,NULL,NULL),('34665915','dell',0,NULL,NULL,NULL,NULL),('38739670','panasonic',0,NULL,NULL,NULL,NULL),('38846378','MSI',0,NULL,NULL,NULL,NULL),('76069430','sinhagiri',0,NULL,NULL,NULL,NULL),('77526129','hitacahi',0,NULL,NULL,NULL,NULL),('88330918','samsung',0,NULL,NULL,NULL,NULL),('97035377','real me',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorys`
--

DROP TABLE IF EXISTS `categorys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorys` (
  `ID` char(32) NOT NULL,
  `CATEGORYE` char(32) DEFAULT NULL,
  `STATUS` tinyint(4) DEFAULT NULL,
  `INSERT_DATE_TIME` varchar(45) DEFAULT NULL,
  `UPDAETE_DATE_TIME` varchar(45) DEFAULT NULL,
  `INSER_USER` varchar(45) DEFAULT NULL,
  `UPDAET_USER` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorys`
--

LOCK TABLES `categorys` WRITE;
/*!40000 ALTER TABLE `categorys` DISABLE KEYS */;
INSERT INTO `categorys` VALUES ('1','ELECTRONICS GOOD',0,NULL,NULL,NULL,NULL),('10006306','Automotive & Motorbike',1,NULL,NULL,NULL,NULL),('117895','wwwwwwwwwwww',1,NULL,NULL,NULL,NULL),('12289784','Groceries & Pets',0,NULL,NULL,NULL,NULL),('19652632','plant basis',0,NULL,NULL,NULL,NULL),('21106418','Health & Beauty',0,NULL,NULL,NULL,NULL),('41565131','GARDERN GOODS',0,NULL,NULL,NULL,NULL),('58592031','CONSUMER GOODS',0,NULL,NULL,NULL,NULL),('62160914','Women\'s Fashion',0,NULL,NULL,NULL,NULL),('65796036','Watches & Accessories',0,NULL,NULL,NULL,NULL),('95516714','Sports & Outdoor',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `categorys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `ID` char(32) NOT NULL,
  `CATEGORY_ID` char(32) DEFAULT NULL,
  `BRAND_ID` varchar(45) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `PRICE` varchar(45) DEFAULT NULL,
  `QUANTITY` varchar(45) DEFAULT NULL,
  `STATUS` tinyint(4) DEFAULT NULL,
  `INSER_DATE_TIME` varchar(45) DEFAULT NULL,
  `UPDATE_DATE_TIME` varchar(45) DEFAULT NULL,
  `INSERT_USER` varchar(45) DEFAULT NULL,
  `UPDATE_USER` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CATEGORY_ID_idx` (`CATEGORY_ID`),
  KEY `fk_products_brand1_idx` (`BRAND_ID`),
  CONSTRAINT `CATEGORY_ID` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `categorys` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_brand1` FOREIGN KEY (`BRAND_ID`) REFERENCES `brand` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('1','1','1','i watch','15000','0',0,NULL,NULL,NULL,NULL),('15916688','1','1','watch','13,000','20',0,NULL,NULL,NULL,NULL),('2','1','1','samsung smart watch','10000','0',0,NULL,NULL,NULL,NULL),('62129333','1','38846378','msi heasdphone','13,000','0',0,NULL,NULL,NULL,NULL),('98480475','58592031','1','chocolate 500g','500','100',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `USER_ID` char(32) NOT NULL,
  `USER_ROLE` char(32) NOT NULL,
  `FIRST_NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `DATE_OF_BIRTH` varchar(45) DEFAULT NULL,
  `USER_NAME` varchar(45) DEFAULT NULL,
  `PASWORD` varchar(45) DEFAULT NULL,
  `ADDRES` varchar(45) DEFAULT NULL,
  `CONTACT` varchar(45) DEFAULT NULL,
  `STATUS` tinyint(4) DEFAULT NULL,
  `SORT_ODER` varchar(45) DEFAULT NULL,
  `INSERT_USER_ID` varchar(45) DEFAULT NULL,
  `UPDATE_USER_ID` varchar(45) DEFAULT NULL,
  `INSERT_DATE_TIME` varchar(45) DEFAULT NULL,
  `UPDATE_DATE_TIME` varchar(45) DEFAULT NULL,
  `REMAING_AMOUNT` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `USER_ROLE_idx` (`USER_ROLE`),
  CONSTRAINT `USER_ROLE` FOREIGN KEY (`USER_ROLE`) REFERENCES `user_role` (`USER_ROLE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1','1','admin','admin','','admin','123','',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('12375208','2','saman1','ranwala',NULL,'laki','LAKIWHITE','455/c pollgolla','0783492132',0,NULL,NULL,NULL,NULL,NULL,'15,000','lakitharanwala@gmail.com'),('22441971','2','Sudeshik','Gunawardahana',NULL,'admin',NULL,'455/c','0783492132',1,NULL,NULL,NULL,NULL,NULL,'15,000','lakitharanwala@gmail.com'),('23568879','2','aruna','ranwala',NULL,'neranjan',NULL,'455/c','0783492132',1,NULL,NULL,NULL,NULL,NULL,'15,000','lakitharanwala@gmail.com'),('34488124','2','ruwan','prabth',NULL,'dinobunny','LAKIWHITE','455/c galagedra kandy','0783492132',1,NULL,NULL,NULL,NULL,NULL,'15,000','lakitharanwala@gmail.com'),('48365523','2','Sudeshikaq','Gunawardahanaq',NULL,'SUDESHIKA','admin','455/c gannaoruwa ','0783492132',0,NULL,NULL,NULL,NULL,NULL,'15,000','lakitharanwala@gmail.com'),('62152432','2','sampath','ruwan',NULL,'dinobunny','LAKIWHITE','455/c','0783492132',0,NULL,NULL,NULL,NULL,NULL,'15,000','lakitharanwala@gmail.com'),('63763551','2','lakitha','ranwala',NULL,'dinobunny','LAKIWHITE','455/c','0783492132',0,NULL,NULL,NULL,NULL,NULL,'15,000','lakitharanwala@gmail.com'),('64154974','2','niluka','round',NULL,'idunil',NULL,'455/c','0783492132',0,NULL,NULL,NULL,NULL,NULL,'15,000','lakitharanwala@gmail.com'),('97580432','2','lakitha','ranwala',NULL,'dinobunny','admin','455/c','0783492132',0,NULL,NULL,NULL,NULL,NULL,'15,000','lakitharanwala@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_products`
--

DROP TABLE IF EXISTS `user_has_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_has_products` (
  `ID` varchar(45) NOT NULL,
  `USER_ID` char(32) NOT NULL,
  `PRODUCT_ID` char(32) NOT NULL,
  `LOAN_BALANCE` varchar(45) DEFAULT NULL,
  `INSTALMENT_PLAN` varchar(45) DEFAULT NULL,
  `STATUS` tinyint(4) DEFAULT NULL,
  `INSERT_DATE_TIME` varchar(45) DEFAULT NULL,
  `UPDATE_DATE_TIME` varchar(45) DEFAULT NULL,
  `INSERT_USER` varchar(45) DEFAULT NULL,
  `UPDATE_USER` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_user_has_products_products1_idx` (`PRODUCT_ID`),
  KEY `fk_user_has_products_user1_idx` (`USER_ID`),
  CONSTRAINT `fk_user_has_products_products1` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `products` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_products_user1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_products`
--

LOCK TABLES `user_has_products` WRITE;
/*!40000 ALTER TABLE `user_has_products` DISABLE KEYS */;
INSERT INTO `user_has_products` VALUES ('1','12375208','15916688','13000','3',0,NULL,NULL,NULL,NULL),('2','22441971','2','0','3',3,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_has_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `USER_ROLE_ID` char(32) NOT NULL,
  `ROLE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`USER_ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('1','admin'),('2','user');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-05 10:29:57
