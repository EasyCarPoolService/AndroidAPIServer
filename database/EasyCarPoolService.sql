-- MySQL dump 10.13  Distrib 8.0.27, for macos11.6 (x86_64)
--
-- Host: localhost    Database: EasyCarPoolService
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `chat_message_entity`
--

DROP TABLE IF EXISTS `chat_message_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat_message_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roomid` varchar(255) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `writer` varchar(100) DEFAULT NULL,
  `message` text,
  `time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_message_entity`
--

LOCK TABLES `chat_message_entity` WRITE;
/*!40000 ALTER TABLE `chat_message_entity` DISABLE KEYS */;
INSERT INTO `chat_message_entity` VALUES (22,'ad7bca88-c12c-4166-8873-d07c7f39c019','message','dhkim0405','test','20시 24분'),(23,'ad7bca88-c12c-4166-8873-d07c7f39c019','message','dhkim0405','test','20시 29분'),(24,'ad7bca88-c12c-4166-8873-d07c7f39c019','request','dhkim0405','request reservation','20시 29분'),(25,'ad7bca88-c12c-4166-8873-d07c7f39c019','request','dhkim0405','request reservation','20시 29분'),(26,'ad7bca88-c12c-4166-8873-d07c7f39c019','request','dhkim0405','request reservation','20시 29분'),(27,'b337e389-9757-42df-ac26-4636553dadf6','message','lee','hi there','21시 04분'),(28,'b337e389-9757-42df-ac26-4636553dadf6','request','lee','request reservation','21시 04분'),(29,'5290d8d3-606a-4b36-8c0e-46e7a5950337','request','dhkim0405','request reservation','21시 30분'),(30,'b337e389-9757-42df-ac26-4636553dadf6','confirm','dhkim0405','confirm of request','13시 19분'),(31,'b337e389-9757-42df-ac26-4636553dadf6','message','lee','tet','13시 21분'),(32,'b337e389-9757-42df-ac26-4636553dadf6','message','lee','tet','13시 22분'),(33,'b337e389-9757-42df-ac26-4636553dadf6','request','dhkim0405','request reservation','14시 32분'),(34,'b337e389-9757-42df-ac26-4636553dadf6','confirm','lee','confirm of request','14시 33분'),(35,'aa8aee9c-2e40-490d-9a0c-c5f11e637f2a','request','lee','request reservation','16시 20분'),(36,'aa8aee9c-2e40-490d-9a0c-c5f11e637f2a','confirm','dhkim0405','confirm of request','16시 20분'),(37,'aa8aee9c-2e40-490d-9a0c-c5f11e637f2a','message','lee','ii','16시 37분'),(38,'aa8aee9c-2e40-490d-9a0c-c5f11e637f2a','message','lee','ii','16시 37분'),(39,'aa8aee9c-2e40-490d-9a0c-c5f11e637f2a','message','lee','ii','16시 37분'),(40,'aa8aee9c-2e40-490d-9a0c-c5f11e637f2a','message','lee','ii','16시 37분'),(41,'aa8aee9c-2e40-490d-9a0c-c5f11e637f2a','message','lee','ii','16시 37분'),(42,'aa8aee9c-2e40-490d-9a0c-c5f11e637f2a','message','lee','ii','16시 37분'),(43,'d90d8125-eb0d-4196-9f1e-1faed11e1113','message','lee','j','16시 37분'),(44,'d90d8125-eb0d-4196-9f1e-1faed11e1113','message','lee','j','16시 38분'),(45,'d90d8125-eb0d-4196-9f1e-1faed11e1113','message','lee','jhiii','16시 38분'),(46,'d90d8125-eb0d-4196-9f1e-1faed11e1113','message','lee','jhiii','16시 42분'),(47,'d90d8125-eb0d-4196-9f1e-1faed11e1113','message','lee','hj','16시 48분'),(48,'d90d8125-eb0d-4196-9f1e-1faed11e1113','message','lee','hj','16시 48분'),(49,'d90d8125-eb0d-4196-9f1e-1faed11e1113','message','lee','fgh','16시 52분'),(50,'1df543b9-e8a8-41f3-9edd-139d21d404ef','message','kim','jeiek','16시 54분'),(51,'1df543b9-e8a8-41f3-9edd-139d21d404ef','message','kim','jeiek','17시 06분'),(52,'b337e389-9757-42df-ac26-4636553dadf6','confirm','lee','confirm of request','18시 23분'),(53,'b337e389-9757-42df-ac26-4636553dadf6','confirm','lee','confirm of request','18시 26분'),(54,'b337e389-9757-42df-ac26-4636553dadf6','confirm','lee','confirm of request','18시 27분'),(55,'1a9bf60f-f861-44f9-a55a-e9309006c722','request','lee','request reservation','16시 10분'),(56,'b8801dfa-c7c6-466b-a697-8d2c1d8ea7ac','message','lee','hellow','16시 12분'),(57,'b8801dfa-c7c6-466b-a697-8d2c1d8ea7ac','request','lee','request reservation','16시 12분'),(58,'ac4d224b-fbd8-49a7-9519-f8c91bab9a54','request','kim','request reservation','16시 14분'),(59,'ac4d224b-fbd8-49a7-9519-f8c91bab9a54','confirm','lee','confirm of request','16시 14분');
/*!40000 ALTER TABLE `chat_message_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat_room_entity`
--

DROP TABLE IF EXISTS `chat_room_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat_room_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roomid` varchar(255) DEFAULT NULL,
  `post_type` varchar(100) DEFAULT NULL,
  `post_id` int DEFAULT NULL,
  `driver` varchar(100) DEFAULT NULL,
  `passenger` varchar(100) DEFAULT NULL,
  `passenger_nickname` varchar(100) DEFAULT NULL,
  `driver_nickname` varchar(100) DEFAULT NULL,
  `driver_fcm_token` varchar(255) DEFAULT NULL,
  `passenger_fcm_token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_room_entity`
--

LOCK TABLES `chat_room_entity` WRITE;
/*!40000 ALTER TABLE `chat_room_entity` DISABLE KEYS */;
INSERT INTO `chat_room_entity` VALUES (23,'ac4d224b-fbd8-49a7-9519-f8c91bab9a54','driver',2,'kim','lee','lee','kim','ccR6xxpDTTuP15bAPcblk-:APA91bFqd0dBNDh8n9ByN7fHvbV7XGOQ3f6K7dTglg7nbYkBVa9dwXGNY3wM0ABw0fHZ8kl16QIE2C4p8a9VtENtZX6BBUVBTcJkaNLzLZBVpfoxGnQNBPTQJE7sBxKyZZ-3c6Gh7aQQ','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO'),(24,'5ee3acb4-a251-4b2d-8225-94d0abf08b3f','passenger',1,'lee','dhkim0405','kim','lees','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO');
/*!40000 ALTER TABLE `chat_room_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_complete`
--

DROP TABLE IF EXISTS `post_complete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_complete` (
  `id` int NOT NULL AUTO_INCREMENT,
  `driver` varchar(100) DEFAULT NULL,
  `passenger` varchar(100) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_complete`
--

LOCK TABLES `post_complete` WRITE;
/*!40000 ALTER TABLE `post_complete` DISABLE KEYS */;
INSERT INTO `post_complete` VALUES (1,'lee','dhkim0405','2022.02.17','19:2');
/*!40000 ALTER TABLE `post_complete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_driver`
--

DROP TABLE IF EXISTS `post_driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_driver` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(100) DEFAULT NULL,
  `created_date` varchar(100) DEFAULT NULL,
  `modified_date` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nickname` varchar(100) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `departure` varchar(100) DEFAULT NULL,
  `destination` varchar(100) DEFAULT NULL,
  `departure_date` varchar(100) DEFAULT NULL,
  `departure_time` varchar(100) DEFAULT NULL,
  `fcm_token` varchar(255) DEFAULT NULL,
  `gift` varchar(100) DEFAULT NULL,
  `message` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_driver`
--

LOCK TABLES `post_driver` WRITE;
/*!40000 ALTER TABLE `post_driver` DISABLE KEYS */;
INSERT INTO `post_driver` VALUES (2,'driver','2022-02-24 07:31:08.78608','2022-02-24 07:31:08.78608','lee','lee','male','울산광역시 중구 학성동','경기도 수원시 장안구 파장동','2022.02.25','16:2','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO','간식거리,기프티콘,','test'),(3,'driver','2022-02-24 07:54:35.956815','2022-02-24 07:54:35.956815','kim','kim','male','광주광역시 동구 대인동','세종특별자치시 세종특별자치시 조치원읍','2022.02.24','16:2','ccR6xxpDTTuP15bAPcblk-:APA91bFqd0dBNDh8n9ByN7fHvbV7XGOQ3f6K7dTglg7nbYkBVa9dwXGNY3wM0ABw0fHZ8kl16QIE2C4p8a9VtENtZX6BBUVBTcJkaNLzLZBVpfoxGnQNBPTQJE7sBxKyZZ-3c6Gh7aQQ','간식거리,기프티콘,','jej');
/*!40000 ALTER TABLE `post_driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_passenger`
--

DROP TABLE IF EXISTS `post_passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_passenger` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(100) DEFAULT NULL,
  `created_date` varchar(100) DEFAULT NULL,
  `modified_date` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nickname` varchar(100) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `departure` varchar(100) DEFAULT NULL,
  `destination` varchar(100) DEFAULT NULL,
  `departure_date` varchar(100) DEFAULT NULL,
  `departure_time` varchar(100) DEFAULT NULL,
  `fcm_token` varchar(255) DEFAULT NULL,
  `gift` varchar(100) DEFAULT NULL,
  `message` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_passenger`
--

LOCK TABLES `post_passenger` WRITE;
/*!40000 ALTER TABLE `post_passenger` DISABLE KEYS */;
INSERT INTO `post_passenger` VALUES (1,'passenger','2022-02-17 10:44:19.416247','2022-02-17 10:44:19.416247','dhkim0405','kim','female','대전광역시 동구 원동','경기도 수원시 장안구 파장동','2022.02.17','19:2','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO','간식거리,기프티콘,','test'),(2,'passenger','2022-02-17 10:44:41.173945','2022-02-17 10:44:41.173945','dhkim0405','kim','female','인천광역시 중구 중앙동','세종특별자치시 세종특별자치시 조치원읍','2022.02.22','19:2','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO','간식거리,기프티콘,','test'),(3,'passenger','2022-02-24 07:30:30.384314','2022-02-24 07:30:30.384314','dhkim0405','kim','female','울산광역시 중구 학성동','세종특별자치시 세종특별자치시 조치원읍','2022.02.24','16:2','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO','간식거리,기프티콘,','gujmk');
/*!40000 ALTER TABLE `post_passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserved_post_entity`
--

DROP TABLE IF EXISTS `reserved_post_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserved_post_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `post_id` int DEFAULT NULL,
  `post_type` varchar(100) DEFAULT NULL,
  `location_room_id` varchar(100) DEFAULT NULL,
  `driver` varchar(100) DEFAULT NULL,
  `driver_fcm_token` varchar(255) DEFAULT NULL,
  `passenger` varchar(100) DEFAULT NULL,
  `passenger_fcm_token` varchar(255) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserved_post_entity`
--

LOCK TABLES `reserved_post_entity` WRITE;
/*!40000 ALTER TABLE `reserved_post_entity` DISABLE KEYS */;
INSERT INTO `reserved_post_entity` VALUES (10,2,'driver','5e6fb98c-13b3-4373-9b7f-4ad5e7e7bbf6','kim','ccR6xxpDTTuP15bAPcblk-:APA91bFqd0dBNDh8n9ByN7fHvbV7XGOQ3f6K7dTglg7nbYkBVa9dwXGNY3wM0ABw0fHZ8kl16QIE2C4p8a9VtENtZX6BBUVBTcJkaNLzLZBVpfoxGnQNBPTQJE7sBxKyZZ-3c6Gh7aQQ','lee','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO','2022.02.25','16:2');
/*!40000 ALTER TABLE `reserved_post_entity` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `mv_reserved_complete` AFTER DELETE ON `reserved_post_entity` FOR EACH ROW BEGIN 
INSERT INTO post_complete 
VALUES(
NULL,
OLD.driver,
OLD.passenger,
OLD.date,
OLD.time
);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `testTBL`
--

DROP TABLE IF EXISTS `testTBL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testTBL` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testTBL`
--

LOCK TABLES `testTBL` WRITE;
/*!40000 ALTER TABLE `testTBL` DISABLE KEYS */;
INSERT INTO `testTBL` VALUES (1,'kim'),(2,'kim'),(3,'kim'),(4,'kim'),(5,'kim'),(6,'kim'),(7,'kim'),(8,'kim'),(9,'kim'),(10,'kim'),(11,'kim'),(12,'kim');
/*!40000 ALTER TABLE `testTBL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `name` varchar(30) DEFAULT NULL,
  `created_date` varchar(100) DEFAULT NULL,
  `modified_date` varchar(100) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `birth` varchar(8) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `driver_authentication` tinyint(1) DEFAULT NULL,
  `fcm_token` varchar(200) DEFAULT NULL,
  `activated` tinyint(1) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('kim',NULL,'2022-02-24 07:53:45.172364','kim','kim','$2a$10$xDkcxEUAZpuzvPG4PzY3auphxy34aVMQhulmJekNXknO5LEI89Ary','950405','male',NULL,1,'ccR6xxpDTTuP15bAPcblk-:APA91bFqd0dBNDh8n9ByN7fHvbV7XGOQ3f6K7dTglg7nbYkBVa9dwXGNY3wM0ABw0fHZ8kl16QIE2C4p8a9VtENtZX6BBUVBTcJkaNLzLZBVpfoxGnQNBPTQJE7sBxKyZZ-3c6Gh7aQQ',1,'USER'),('lee','2022-02-21 12:03:08.605334','2022-02-21 12:03:08.605334','lee','lees','$2a$10$wNJcgx.r93TRJSzXbIBEvuGSgFeyelJUUORaGs5wQXFfSsrg4slk6','123456','male',NULL,1,'cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO',1,'USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-08 18:11:58
