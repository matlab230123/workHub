-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dssdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dssdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dssdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `dssdb` ;

-- -----------------------------------------------------
-- Table `dssdb`.`actors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dssdb`.`actors` (
  `ACTOR_ID` BIGINT NOT NULL,
  `FIRST_NAME` VARCHAR(25) NULL DEFAULT NULL,
  `LAST_NAME` VARCHAR(25) NULL DEFAULT NULL,
  `GENDER` CHAR(1) NULL DEFAULT NULL,
  `AGE` INT NULL DEFAULT NULL,
  PRIMARY KEY (`ACTOR_ID`));


-- -----------------------------------------------------
-- Table `dssdb`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dssdb`.`admin` (
  `FIRST_NAME` VARCHAR(45) NULL DEFAULT NULL,
  `LAST_NAME` VARCHAR(45) NULL DEFAULT NULL,
  `PASSWORD` VARCHAR(45) NULL DEFAULT NULL,
  `ADMIN_ID` INT NOT NULL,
  PRIMARY KEY (`ADMIN_ID`));


-- -----------------------------------------------------
-- Table `dssdb`.`movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dssdb`.`movies` (
  `MOVIE_ID` INT NOT NULL,
  `MOVIE_TITLE` VARCHAR(50) NULL DEFAULT NULL,
  `MOVIE_COST` INT NULL DEFAULT NULL,
  `MOVIE_YEAR` INT NULL DEFAULT NULL,
  PRIMARY KEY (`MOVIE_ID`));


-- -----------------------------------------------------
-- Table `dssdb`.`movieactors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dssdb`.`movieactors` (
  `ma_id` BIGINT NOT NULL,
  `movie_id` INT NULL DEFAULT NULL,
  `actor_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`ma_id`),
  INDEX `movie_id` (`movie_id` ASC) VISIBLE,
  INDEX `actor_id` (`actor_id` ASC) VISIBLE,
  CONSTRAINT `movieactors_ibfk_1`
    FOREIGN KEY (`movie_id`)
    REFERENCES `dssdb`.`movies` (`MOVIE_ID`),
  CONSTRAINT `movieactors_ibfk_2`
    FOREIGN KEY (`actor_id`)
    REFERENCES `dssdb`.`actors` (`ACTOR_ID`));


-- -----------------------------------------------------
-- Table `dssdb`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dssdb`.`review` (
  `REVIEW_ID` INT NOT NULL,
  `DATE_POSTED` DATETIME NULL DEFAULT NULL,
  `DESCRIPTION` VARCHAR(45) NULL DEFAULT NULL,
  `RATING` INT NULL DEFAULT NULL,
  `MOVIE_ID` INT NULL DEFAULT NULL,
  PRIMARY KEY (`REVIEW_ID`),
  INDEX `MOVIE_ID` (`MOVIE_ID` ASC) VISIBLE,
  CONSTRAINT `review_ibfk_1`
    FOREIGN KEY (`MOVIE_ID`)
    REFERENCES `dssdb`.`movies` (`MOVIE_ID`));


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
