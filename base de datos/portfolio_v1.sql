-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema portfolio_v1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema portfolio_v1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `portfolio_v1` DEFAULT CHARACTER SET utf8 ;
USE `portfolio_v1` ;

-- -----------------------------------------------------
-- Table `portfolio_v1`.`domicilio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio_v1`.`domicilio` (
  `id` INT NOT NULL,
  `provincia` VARCHAR(60) NOT NULL,
  `localidad` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio_v1`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio_v1`.`persona` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `fecha_nac` DATE NOT NULL,
  `nacionalidad` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `ocupacion` VARCHAR(50) NOT NULL,
  `mail` VARCHAR(45) NOT NULL,
  `url_foto_perfil` VARCHAR(100) NOT NULL,
  `url_header` VARCHAR(100) NOT NULL,
  `domicilio_id` INT NOT NULL,
  PRIMARY KEY (`id`, `domicilio_id`),
  INDEX `fk_persona_domicilio1_idx` (`domicilio_id` ASC) VISIBLE,
  CONSTRAINT `fk_persona_domicilio1`
    FOREIGN KEY (`domicilio_id`)
    REFERENCES `portfolio_v1`.`domicilio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio_v1`.`educacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio_v1`.`educacion` (
  `id` INT NOT NULL,
  `escuela` VARCHAR(60) NOT NULL,
  `titulo` VARCHAR(50) NOT NULL,
  `carrera` VARCHAR(45) NOT NULL,
  `año_inicio` INT NOT NULL,
  `año_fin` INT NOT NULL,
  `url_imagen` VARCHAR(100) NOT NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `persona_id`),
  INDEX `fk_educacion_persona_idx` (`persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_educacion_persona`
    FOREIGN KEY (`persona_id`)
    REFERENCES `portfolio_v1`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio_v1`.`experiencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio_v1`.`experiencia` (
  `id` INT NOT NULL,
  `nombre_org` VARCHAR(45) NOT NULL,
  `area_cargo` VARCHAR(45) NOT NULL,
  `fecha_inicio` DATE NOT NULL,
  `fecha_fin` DATE NOT NULL,
  `url_imagen` VARCHAR(100) NOT NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `persona_id`),
  INDEX `fk_experiencia_persona1_idx` (`persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_experiencia_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `portfolio_v1`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio_v1`.`aptitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio_v1`.`aptitud` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `porcentaje` INT NOT NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `persona_id`),
  INDEX `fk_aptitud_persona1_idx` (`persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_aptitud_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `portfolio_v1`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio_v1`.`proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio_v1`.`proyecto` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(70) NOT NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `persona_id`),
  INDEX `fk_proyecto_persona1_idx` (`persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_proyecto_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `portfolio_v1`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio_v1`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio_v1`.`usuario` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
