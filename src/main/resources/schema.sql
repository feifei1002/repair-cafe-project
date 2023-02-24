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
DROP TABLE IF EXISTS `product` ;

CREATE TABLE IF NOT EXISTS product (
                                       productID INTEGER NOT NULL,
                                       name VARCHAR(45) NOT NULL,
    description VARCHAR(140) NULL,
    category VARCHAR(45) NOT NULL,
    location VARCHAR(60) NOT NULL,
    status INT NOT NULL,
    availability INT NOT NULL,
    PRIMARY KEY (productID))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS user (
    user_id INTEGER AUTO_INCREMENT NOT NULL,
    firstName VARCHAR(45) NOT NULL,
    lastName VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    phoneNo VARCHAR(10) NOT NULL,
    password VARCHAR(200) NOT NULL,
    address VARCHAR(60) NULL,
    city VARCHAR(45) NULL,
    postcode VARCHAR(45) NULL,
    role VARCHAR(45),
    enabled TINYINT,
    PRIMARY KEY (`user_id`))
    ENGINE = InnoDB;

DROP TABLE IF EXISTS `RepairCafe`;

CREATE TABLE IF NOT EXISTS RepairCafe
(
    cafe_id         INTEGER AUTO_INCREMENT NOT NULL,
    name            VARCHAR(200) NOT NULL,
    address         VARCHAR(2000) NOT NULL,
    city            VARCHAR(200) NOT NULL,
    postcode        VARCHAR(10) NOT NULL,
    PRIMARY KEY(`cafe_id`)
    )
    ENGINE = INNODB;

DROP TABLE IF EXISTS `RepairBooking`;

CREATE TABLE IF NOT EXISTS RepairBooking
(
    booking_id      INTEGER AUTO_INCREMENT NOT NULL,
    firstName       VARCHAR(200) NOT NULL,
    lastName        VARCHAR(200) NOT NULL,
    email           VARCHAR(200) NOT NULL,
    repairDate      DATE NOT NULL,
    category        VARCHAR(200) NOT NULL,
    location        VARCHAR(1000) NOT NULL,
    PRIMARY KEY(`booking_id`)
    )
    ENGINE = INNODB;
    
DROP TABLE IF EXISTS `RepairCategory`;

CREATE TABLE IF NOT EXISTS RepairCategory
(
    category_id      INTEGER AUTO_INCREMENT NOT NULL,
    name       VARCHAR(200) NOT NULL,
    PRIMARY KEY(`category_id`)
    )
    ENGINE = INNODB;

DROP TABLE IF EXISTS `repair_Product`;

CREATE TABLE IF NOT EXISTS repair_Product (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(45) NOT NULL,
  `condition` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `photo` LONGBLOB NULL,
  `is_Approved` VARCHAR(10),
  -- `name` VARCHAR(200) NOT NULL,
    -- CONSTRAINT fk_category FOREIGN KEY (name)
   --  REFERENCES repair_Category(name),
    PRIMARY KEY (`product_id`))
ENGINE = INNODB;

DROP TABLE IF EXISTS `product_Booking`;

CREATE TABLE IF NOT EXISTS repair_Borrow
(
    borrow_id          INTEGER AUTO_INCREMENT NOT NULL,
    firstName                 VARCHAR(200) NOT NULL,
    lastName                  VARCHAR(200) NOT NULL,
    email                     VARCHAR(200) NOT NULL,
    productName               VARCHAR(200) NOT NULL,
    product_id                 INTEGER NOT NULL,
    PRIMARY KEY(`borrow_id`)
    )
    ENGINE = INNODB;

DROP TABLE IF EXISTS `contactUs`;

CREATE TABLE IF NOT EXISTS contactUs (
	`instanceID` INT NOT NULL AUTO_INCREMENT,
	`full_name` VARCHAR(45) NOT NULL,
    `email` VARCHAR(60) NOT NULL,
    `reason` VARCHAR(60) NOT NULL,
    `message` VARCHAR(140),
    PRIMARY KEY(`instanceID`))
ENGINE = INNODB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
>>>>>>> src/main/resources/schema.sql
