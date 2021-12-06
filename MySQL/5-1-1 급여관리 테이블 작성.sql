
CREATE TABLE `company`.`employee` (
  `em_num` INT NOT NULL,
  `em_reg_num` CHAR(14) NOT NULL,
  `em_name` VARCHAR(45) NOT NULL,
  `em_sa_level` VARCHAR(4) NOT NULL,
  `em_year` INT NOT NULL,
  `em_de_department` VARCHAR(10) NULL,
  PRIMARY KEY (`em_num`),
  UNIQUE INDEX `em_reg_num_UNIQUE` (`em_reg_num` ASC) VISIBLE);
  -- 외래키는 아직 작성되어있지 않음 

CREATE TABLE `company`.`department` (
  `de_department` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`de_department`));

CREATE TABLE `company`.`salary` (
  `sa_level` VARCHAR(4) NOT NULL,
  `sa_base_salary` INT NOT NULL,
  `sa_add_salary` INT NOT NULL,
  PRIMARY KEY (`sa_level`));

-- 사원 테이블에서 외래키 지정(항상 데이터를 받아야 되는 테이블에서 외래키를 지정해준다)
-- 부서테이블에서 자료를 받을것이기 때문에 사원테이블 - (부서테이블) 지정으로 해준다.
ALTER TABLE `company`.`employee` 
ADD CONSTRAINT `em_de_department`
  FOREIGN KEY (`em_de_department`)
  REFERENCES `company`.`department` (`de_department`)
  ON DELETE SET NULL
  ON UPDATE SET NULL;
-- 급여테이블에서 자료를 받을것이기 때문에 사원테이블 - (급여테이블) 지정으로 해준다.
ALTER TABLE `company`.`employee` 
ADD CONSTRAINT `em_sa_level`
  FOREIGN KEY (`em_sa_level`)
  REFERENCES `company`.`salary` (`sa_level`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

