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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `bd_num` int NOT NULL AUTO_INCREMENT,
  `bd_title` varchar(100) DEFAULT NULL,
  `bd_contents` longtext,
  `bd_reg_date` datetime DEFAULT NULL,
  `bd_up_date` datetime DEFAULT NULL,
  `bd_type` varchar(10) DEFAULT NULL,
  `bd_me_id` varchar(20) NOT NULL,
  `bd_ori_num` int NOT NULL,
  `bd_del` varchar(2) DEFAULT NULL,
  `bd_del_date` datetime DEFAULT NULL,
  `bd_views` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`bd_num`),
  KEY `FK_board_TO_board_1` (`bd_ori_num`),
  CONSTRAINT `FK_board_TO_board_1` FOREIGN KEY (`bd_ori_num`) REFERENCES `board` (`bd_num`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'제목테스트1','내용테스트1','2022-01-07 09:34:00',NULL,'NORMAL','qwe',1,'N',NULL,0),(2,'제목테스트2','내용테스트2','2022-01-07 12:00:52',NULL,'NORMAL','qwe',2,'Y','2022-01-07 16:08:41',0),(3,'수정테스트 두번째','수정한 내용 추가','2022-01-10 09:41:08','2022-01-14 14:36:38','NORMAL','qwe',3,'N',NULL,0),(4,'업로드 테스트','업로드 테스트','2022-01-14 14:37:12','2022-01-14 15:04:25','NORMAL','qwe',4,'Y','2022-01-17 17:30:59',0),(5,'파일업로드 테스트','파일업로드','2022-01-14 15:05:04','2022-01-17 17:30:48','NORMAL','qwe',5,'Y','2022-01-17 17:30:54',0),(6,'업로드 DB테스트','DB테스트','2022-01-14 15:15:50','2022-01-17 17:30:42','NORMAL','qwe',6,'Y','2022-01-17 17:30:58',0),(7,'파일2개 테스트','파일 2개 등록','2022-01-17 15:35:50','2022-01-17 17:30:31','NORMAL','qwe',7,'Y','2022-01-17 17:30:55',0),(8,'파일추가 테스트 2번째','2번째','2022-01-17 16:23:48','2022-01-17 17:30:25','NORMAL','qwe',8,'Y','2022-01-17 17:30:57',0),(9,'등록테스트','등록테스트','2022-01-17 17:13:30','2022-01-17 17:23:17','NORMAL','qwe',9,'Y','2022-01-17 17:30:10',0),(10,'사진 업로드 테스트용','테스트','2022-01-17 17:31:19','2022-01-17 17:43:17','NORMAL','qwe',10,'N',NULL,0),(11,'일반회원 게시글 테스트 01','<p>일반회원 게시글 테스트 01<br></p>','2022-01-19 09:58:40',NULL,'NORMAL','asd123',11,'N',NULL,0),(12,'일반회원 게시글 테스트 01 답글 01','<p>일반회원 게시글 테스트 01 답글 01<br></p>','2022-01-19 09:58:51',NULL,'NORMAL','asd123',11,'N',NULL,0),(13,'제목 테스트 01','<p>제목 테스트 01<br></p>','2022-01-19 09:59:16',NULL,'NORMAL','qwe',13,'N',NULL,0),(14,'제목 테스트 02','<p>제목 테스트 02<br></p>','2022-01-19 09:59:20',NULL,'NORMAL','qwe',14,'N',NULL,0),(15,'제목 테스트 03','<p>제목 테스트 03<br></p>','2022-01-19 09:59:25',NULL,'NORMAL','qwe',15,'N',NULL,0),(16,'제목 테스트 04','<p>제목 테스트 04<br></p>','2022-01-19 09:59:31',NULL,'NORMAL','qwe',16,'N',NULL,0),(17,'제목 테스트 05','<p>제목 테스트 05<br></p>','2022-01-19 09:59:36',NULL,'NORMAL','qwe',17,'N',NULL,0),(18,'제목 테스트 06','<p>제목 테스트 06<br></p>','2022-01-19 09:59:42',NULL,'NORMAL','qwe',18,'N',NULL,0),(19,'사진 업로드 테스트 01','<p>사진 업로드 테스트 01<br></p>','2022-01-19 09:59:53',NULL,'NORMAL','qwe',19,'N',NULL,0),(20,'사진 업로드 테스트 02','<p>사진 업로드 테스트 02<br></p>','2022-01-19 10:00:04',NULL,'NORMAL','qwe',20,'N',NULL,0),(21,'사진 업로드 테스트 03','<p>사진 업로드 테스트 03<br></p>','2022-01-19 10:00:15',NULL,'NORMAL','qwe',21,'N',NULL,0),(22,'사진 업로드 및 수정 테스트 01','<p>사진 업로드 및 수정 테스트 01<br></p>','2022-01-19 10:00:27','2022-01-19 10:00:33','NORMAL','qwe',22,'N',NULL,0),(23,'사진 업로드 및 수정 테스트 02','<p>사진 업로드 및 수정 테스트 02<br></p>','2022-01-19 10:00:45',NULL,'NORMAL','qwe',23,'N',NULL,0),(24,'사진 업로드 및 수정 테스트 03','<p>사진 업로드 및 수정 테스트 03<br></p>','2022-01-19 10:00:52',NULL,'NORMAL','qwe',24,'N',NULL,2),(25,'공지사항 01','<p>공지사항 01<br></p>','2022-01-19 10:01:10',NULL,'공지','qwe',25,'N',NULL,0),(26,'공지사항 02','<p>공지사항 02<br></p>','2022-01-19 10:01:14',NULL,'공지','qwe',26,'N',NULL,0),(27,'공지사항 03','<p>공지사항 03<br></p>','2022-01-19 10:01:19',NULL,'공지','qwe',27,'N',NULL,0),(28,'공지사항 04','<p>공지사항 04<br></p>','2022-01-19 10:01:23',NULL,'공지','qwe',28,'N',NULL,1),(29,'ㅁㄴㅇ','ㅁㄴㅇ','2022-01-19 10:04:05',NULL,'NORMAL','asd123',29,'Y','2022-01-19 10:04:12',0),(30,'일반회원 글쓰기 01','<p>일반회원 글쓰기 01<br></p>','2022-01-19 10:34:49',NULL,'NORMAL','asd123',30,'N',NULL,38);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
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
