-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: community_jyh
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `me_id` varchar(20) NOT NULL,
  `me_pw` varchar(255) DEFAULT NULL,
  `me_name` varchar(30) DEFAULT NULL,
  `me_gender` varchar(6) DEFAULT NULL,
  `me_birth` date DEFAULT NULL,
  `me_address` varchar(100) DEFAULT NULL,
  `me_phone` varchar(13) DEFAULT NULL,
  `me_authority` varchar(10) NOT NULL DEFAULT '회원',
  PRIMARY KEY (`me_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('asd','$2a$10$WMTAIv2ao.Nx/L0K0z.aSukHEh4ASi/oze4Hn6BmnB94vzxC5Vsxu','아무개','남성','2022-01-02','충남 서천군 판교면 금덕길 9 711,충남 서천군 판교면 금덕길 9 711','010-0000-0002','관리자'),('asd123','$2a$10$0N7yb3vEHxjYqD2QGqrrCubSC.0zub.VrCXNslOtIzQ0bWT.Wyi1K','asd123','남성','2022-01-08','충북 청주시 상당구 가덕면 가덕시동길 10 001,충북 청주시 상당구 가덕면 가덕시동길 10 001','01000000008','회원'),('qwe','$2a$10$Hf27vrA0cIKXFKmbovRCduoL90b3vuF9MDietsp4fqISS9tWuJVFq','홍길동','남성','2022-01-31','서울 강남구 가로수길 5 333,서울 강남구 가로수길 5 333','010-0000-0001','슈퍼 관리자'),('qwe123','$2a$10$Kdm8XL2CdXy2yfOghFd6DOQqC6D4SwFRVDpkgckMtom.g9Y7em2JK','이름qwe','남성','2022-01-01','인천 부평구 청중로 46 1,인천 부평구 청중로 46 1','010-0000-0006','회원'),('테스트1','$2a$10$T./DedV/x2ItvqpRAw5TROk.Z9LiIUTXasiMLOu/Drlf6/le6BXV2','테스트이름','남성','2022-01-02','충북 청주시 상당구 가덕면 가덕시동길 10 12,충북 청주시 상당구 가덕면 가덕시동길 10 12','010-0000-0003','회원');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-25 21:16:20
