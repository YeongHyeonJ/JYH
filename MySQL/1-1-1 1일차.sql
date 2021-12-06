-- database 인 university_jyh 생성
DROP SCHEMA IF EXISTS `university_jyh` ;
CREATE SCHEMA `university_jyh` ;
USE `university_jyh`;

-- student 테이블 생성
-- pw가 255자인 이유 : 암호는 노출되면 안되서 암호화가 이루어지기 때문에
-- 암호화가 이루어지면 비밀번호가 긴 문자열로 바뀜
DROP TABLE IF EXISTS `university_jyh`.`student`;
CREATE TABLE `university_jyh`.`student` (
  `st_num` CHAR(10) NOT NULL,
  `st_id` VARCHAR(15) NOT NULL,
  `st_pw` VARCHAR(255) NOT NULL,
  `st_name` VARCHAR(50) NOT NULL,
  `st_reg_num` CHAR(15) NOT NULL,
  PRIMARY KEY (`st_num`),
  UNIQUE INDEX `st_id_UNIQUE` (`st_id` ASC) VISIBLE,
  UNIQUE INDEX `st_reg_num_UNIQUE` (`st_reg_num` ASC) VISIBLE);
  
DROP TABLE IF EXISTS `university_jyh`.`professor`;
CREATE TABLE `university_jyh`.`professor` (
  `pr_num` CHAR(10) NOT NULL,
  `pr_id` VARCHAR(15) NOT NULL,
  `pr_pw` VARCHAR(255) NOT NULL,
  `pr_name` VARCHAR(50) NOT NULL,
  `pr_reg_num` CHAR(14) NOT NULL,
  PRIMARY KEY (`pr_nnum`),
  UNIQUE INDEX `pr_id_UNIQUE` (`pr_id` ASC) VISIBLE,
  UNIQUE INDEX `pr_reg_num_UNIQUE` (`pr_reg_num` ASC) VISIBLE);

DROP TABLE IF EXISTS `university_jyh`.`subject`;
CREATE TABLE `university_jyh`.`subject` (
  `su_num` INT NOT NULL AUTO_INCREMENT,
  `su_code` CHAR(6) NOT NULL,
  `su_schedule` VARCHAR(30) NULL DEFAULT NULL,
  `su_class_num` INT NOT NULL DEFAULT 1,
  `su_title` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`su_num`));

DROP TABLE IF EXISTS `university_jyh`.`course`;
CREATE TABLE `university_jyh`.`course` (
  `co_num` INT NOT NULL AUTO_INCREMENT,
  `co_st_num` CHAR(10) NOT NULL,
  `co_su_num` INT NOT NULL,
  `co_score` VARCHAR(4) NULL,
  PRIMARY KEY (`co_num`),
  INDEX `co_st_num_idx` (`co_st_num` ASC) VISIBLE,
  INDEX `co_su_num_idx` (`co_su_num` ASC) VISIBLE,
  CONSTRAINT `co_st_num` FOREIGN KEY (`co_st_num`) 
    REFERENCES `university_jyh`.`student` (`st_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `co_su_num` FOREIGN KEY (`co_su_num`)
    REFERENCES `university_jyh`.`subject` (`su_num`) ON DELETE CASCADE ON UPDATE CASCADE);
-- 6. lecture 테이블 생성
DROP TABLE IF EXISTS `university_jyh`.`lecture`;
CREATE TABLE `university_jyh`.`lecture` (
  `le_num` INT NOT NULL,
  `le_pr_num` CHAR(10) NOT NULL,
  `le_su_num` INT NOT NULL,
  PRIMARY KEY (`le_num`),
  INDEX `le_pr_num_idx` (`le_pr_num` ASC) VISIBLE,
  INDEX `le_su_num_idx` (`le_su_num` ASC) VISIBLE,
  CONSTRAINT `le_pr_num` FOREIGN KEY (`le_pr_num`)
    REFERENCES `university_jyh`.`professor` (`pr_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `le_su_num` FOREIGN KEY (`le_su_num`)
    REFERENCES `university_jyh`.`subject` (`su_num`)   ON DELETE CASCADE ON UPDATE CASCADE);