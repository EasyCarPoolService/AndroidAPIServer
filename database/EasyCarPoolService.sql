-- MySQL dump 10.13  Distrib 8.0.27, for macos11.6 (arm64)
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_message_entity`
--

LOCK TABLES `chat_message_entity` WRITE;
/*!40000 ALTER TABLE `chat_message_entity` DISABLE KEYS */;
INSERT INTO `chat_message_entity` VALUES (22,'ad7bca88-c12c-4166-8873-d07c7f39c019','message','dhkim0405','test','20시 24분'),(23,'ad7bca88-c12c-4166-8873-d07c7f39c019','message','dhkim0405','test','20시 29분'),(24,'ad7bca88-c12c-4166-8873-d07c7f39c019','request','dhkim0405','request reservation','20시 29분'),(25,'ad7bca88-c12c-4166-8873-d07c7f39c019','request','dhkim0405','request reservation','20시 29분'),(26,'ad7bca88-c12c-4166-8873-d07c7f39c019','request','dhkim0405','request reservation','20시 29분'),(27,'b337e389-9757-42df-ac26-4636553dadf6','message','lee','hi there','21시 04분'),(28,'b337e389-9757-42df-ac26-4636553dadf6','request','lee','request reservation','21시 04분'),(29,'5290d8d3-606a-4b36-8c0e-46e7a5950337','request','dhkim0405','request reservation','21시 30분');
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_room_entity`
--

LOCK TABLES `chat_room_entity` WRITE;
/*!40000 ALTER TABLE `chat_room_entity` DISABLE KEYS */;
INSERT INTO `chat_room_entity` VALUES (14,'ad7bca88-c12c-4166-8873-d07c7f39c019','passenger',1,'dhkim0405','dhkim0405','kim','kim','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO'),(15,'205b0a24-8cae-402c-bebd-88a5f9508e32','driver',1,'dhkim0405','dhkim0405','kim','kim','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO'),(16,'b337e389-9757-42df-ac26-4636553dadf6','passenger',1,'lee','dhkim0405','kim','lee','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO'),(17,'5290d8d3-606a-4b36-8c0e-46e7a5950337','driver',1,'dhkim0405','dhkim0405','kim','kim','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO');
/*!40000 ALTER TABLE `chat_room_entity` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_driver`
--

LOCK TABLES `post_driver` WRITE;
/*!40000 ALTER TABLE `post_driver` DISABLE KEYS */;
INSERT INTO `post_driver` VALUES (1,'driver','2022-02-16 07:57:26.948523','2022-02-16 07:57:26.948523','dhkim0405','kim','female','경기도 수원시 장안구 파장동','경기도 수원시 장안구 파장동','2022.02.16','16:2','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO','음료,간식거리,','cghu');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_passenger`
--

LOCK TABLES `post_passenger` WRITE;
/*!40000 ALTER TABLE `post_passenger` DISABLE KEYS */;
INSERT INTO `post_passenger` VALUES (1,'passenger','2022-02-17 10:44:19.416247','2022-02-17 10:44:19.416247','dhkim0405','kim','female','대전광역시 동구 원동','경기도 수원시 장안구 파장동','2022.02.17','19:2','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO','간식거리,기프티콘,','test'),(2,'passenger','2022-02-17 10:44:41.173945','2022-02-17 10:44:41.173945','dhkim0405','kim','female','인천광역시 중구 중앙동','세종특별자치시 세종특별자치시 조치원읍','2022.02.22','19:2','cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO','간식거리,기프티콘,','test');
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
  `driver` varchar(100) DEFAULT NULL,
  `passenger` varchar(100) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserved_post_entity`
--

LOCK TABLES `reserved_post_entity` WRITE;
/*!40000 ALTER TABLE `reserved_post_entity` DISABLE KEYS */;
INSERT INTO `reserved_post_entity` VALUES (1,NULL,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL,NULL),(3,1,'lee','dhkim0405','2022.02.17','19:2'),(4,1,'lee','dhkim0405','2022.02.17','19:2');
/*!40000 ALTER TABLE `reserved_post_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testTBL`
--

DROP TABLE IF EXISTS `testTBL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testTBL` (
  `test` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testTBL`
--

LOCK TABLES `testTBL` WRITE;
/*!40000 ALTER TABLE `testTBL` DISABLE KEYS */;
INSERT INTO `testTBL` VALUES ('testMessage');
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
INSERT INTO `user` VALUES ('kim','2022-02-14 12:33:04.05122','2022-02-14 12:33:04.05122','dhkim0405','kim','$2a$10$2lMJ8kGhJrO.nkvStL1a0eW3G6UohQuizUFw4uHUPTKM0HKLJiCcG','19950405','female',1,'cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO',1,'USER'),('lee','2022-02-21 12:03:08.605334','2022-02-21 12:03:08.605334','lee','lee','$2a$10$wNJcgx.r93TRJSzXbIBEvuGSgFeyelJUUORaGs5wQXFfSsrg4slk6','123456','male',1,'cFoV6oduTvOh2CRzXsQvFI:APA91bFNmMq7rz-c9rfX_z95etx0csnM8eGAbuiP7wroZVBuNdJq_lup0lOFBEKS6bNj7AH7dm1bL3VhcoGrx_7UQkGoW95m_9LOi71mFavKUS9UuEr4Y4Yy6TJ6KloDfb3WCILKB1uO',1,'USER');
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

-- Dump completed on 2022-02-21 22:42:50
