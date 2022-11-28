-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`product` ;

CREATE TABLE IF NOT EXISTS `mydb`.`product` (
  `productID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(140) NULL,
  `Category` VARCHAR(45) NOT NULL,
  `Location` VARCHAR(60) NOT NULL,
  `Status` INT NOT NULL,
  PRIMARY KEY (`productID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`user` ;

CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `userID` INT NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `hashed password` VARCHAR(30) NOT NULL,
  `FirstLineAddress` VARCHAR(60) NULL,
  `Town` VARCHAR(45) NULL,
  `City` VARCHAR(45) NULL,
  `Postcode` VARCHAR(45) NULL,
  `userType` BINARY(0) NOT NULL,
  `` VARCHAR(45) NULL,
  PRIMARY KEY (`userID`))
ENGINE = InnoDB;

DROP TABLE IF EXISTS `repair_Cafe`;

CREATE TABLE IF NOT EXISTS repair_Cafe
(
    cafe_id         INTEGER AUTO_INCREMENT NOT NULL,
    name            VARCHAR(200) NOT NULL,
    address         VARCHAR(2000) NOT NULL,
    PRIMARY KEY(`cafe_id`)
    )
    ENGINE = INNODB;

DROP TABLE IF EXISTS `repair_Booking`;

CREATE TABLE IF NOT EXISTS repair_Booking
(
    booking_id      INTEGER AUTO_INCREMENT NOT NULL,
    firstName       VARCHAR(200) NOT NULL,
    lastName        VARCHAR(200) NOT NULL,
    email           VARCHAR(200) NOT NULL,
    repairDate      DATE NOT NULL,
    location        VARCHAR(1000) NOT NULL,
    PRIMARY KEY(`booking_id`)
    )
    ENGINE = INNODB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
>>>>>>> src/main/resources/schema.sql
