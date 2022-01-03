CREATE SCHEMA `fruit_shop_exam` ;

CREATE TABLE `fruit_shop_exam`.`fruit` (
  `fr_name` 	VARCHAR(15) NOT NULL,
  `fr_price` 	INT 		NOT NULL,
  `fr_amount` 	INT 		NOT NULL,
  PRIMARY KEY (`fr_name`));

CREATE TABLE `fruit_shop_exam`.`trade` (
  `tr_num` 		INT 		NOT NULL auto_increment,
  `tr_amount` 	INT 		NOT NULL,
  `tr_type` 	VARCHAR(4) 	NOT NULL DEFAULT 'sell',
  `tr_date` 	DATETIME 	NOT NULL DEFAULT current_timestamp,
  `tr_price` 	INT 		NOT NULL,
  `tr_fr_name` 	VARCHAR(15) NOT NULL,
  PRIMARY KEY (`tr_num`));

ALTER TABLE `trade` ADD CONSTRAINT `FK_BUY_STORE` FOREIGN KEY (
	`tr_fr_name`
) REFERENCES `fruit` (`fr_name`);