-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema economize-ASI
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema economize-ASI
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `economize-ASI` DEFAULT CHARACTER SET utf8 ;
USE `economize-ASI` ;

-- -----------------------------------------------------
-- Table `economize-ASI`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `economize-ASI`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `valorTotal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `economize-ASI`.`forma_de_pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `economize-ASI`.`forma_de_pagamento` (
  `idformadepagamento` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idformadepagamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `economize-ASI`.`lancamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `economize-ASI`.`lancamento` (
  `idLancamento` INT NOT NULL AUTO_INCREMENT,
  `valor` DOUBLE NOT NULL,
  `data` DATE NOT NULL,
  `parcela` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `fk_formadepagamento` INT NOT NULL,
  `fk_usuario` INT NOT NULL,
  PRIMARY KEY (`idLancamento`),
  INDEX `fk_Lancamento_formadepagamento_idx` (`fk_formadepagamento` ASC),
  INDEX `fk_lancamento_usuario1_idx` (`fk_usuario` ASC),
  CONSTRAINT `fk_Lancamento_formadepagamento`
    FOREIGN KEY (`fk_formadepagamento`)
    REFERENCES `economize-ASI`.`forma_de_pagamento` (`idformadepagamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lancamento_usuario1`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `economize-ASI`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `economize-ASI`.`categoria_ganho`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `economize-ASI`.`categoria_ganho` (
  `idcategoria_ganho` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcategoria_ganho`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `economize-ASI`.`lancamentos_ganhos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `economize-ASI`.`lancamentos_ganhos` (
  `idlancamentos_ganhos` INT NOT NULL,
  `fk_categoria_ganho` INT NOT NULL,
  PRIMARY KEY (`idlancamentos_ganhos`),
  INDEX `fk_lancamentos_ganhos_categoria_ganho1_idx` (`fk_categoria_ganho` ASC),
  INDEX `fk_lancamentos_ganhos_lancamento1_idx` (`idlancamentos_ganhos` ASC),
  CONSTRAINT `fk_lancamentos_ganhos_categoria_ganho1`
    FOREIGN KEY (`fk_categoria_ganho`)
    REFERENCES `economize-ASI`.`categoria_ganho` (`idcategoria_ganho`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lancamentos_ganhos_lancamento1`
    FOREIGN KEY (`idlancamentos_ganhos`)
    REFERENCES `economize-ASI`.`lancamento` (`idLancamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `economize-ASI`.`categoria_gasto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `economize-ASI`.`categoria_gasto` (
  `idcategoria_gasto` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcategoria_gasto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `economize-ASI`.`lancamentos_gastos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `economize-ASI`.`lancamentos_gastos` (
  `idlancamentos_gastos` INT NOT NULL,
  `fk_categoria_gasto` INT NOT NULL,
  PRIMARY KEY (`idlancamentos_gastos`),
  INDEX `fk_lancamentos_gastos_categoria_gasto1_idx` (`fk_categoria_gasto` ASC),
  INDEX `fk_lancamentos_gastos_lancamento1_idx` (`idlancamentos_gastos` ASC),
  CONSTRAINT `fk_lancamentos_gastos_categoria_gasto1`
    FOREIGN KEY (`fk_categoria_gasto`)
    REFERENCES `economize-ASI`.`categoria_gasto` (`idcategoria_gasto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lancamentos_gastos_lancamento1`
    FOREIGN KEY (`idlancamentos_gastos`)
    REFERENCES `economize-ASI`.`lancamento` (`idLancamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `economize-ASI`.`meta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `economize-ASI`.`meta` (
  `idmeta` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `prazo` DATE NOT NULL,
  `valormaximo` DOUBLE NOT NULL,
  `fk_categoria_gasto` INT NOT NULL,
  `fk_usuario` INT NOT NULL,
  PRIMARY KEY (`idmeta`),
  INDEX `fk_meta_categoria_gasto1_idx` (`fk_categoria_gasto` ASC),
  INDEX `fk_meta_usuario1_idx` (`fk_usuario` ASC),
  CONSTRAINT `fk_meta_categoria_gasto1`
    FOREIGN KEY (`fk_categoria_gasto`)
    REFERENCES `economize-ASI`.`categoria_gasto` (`idcategoria_gasto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_meta_usuario1`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `economize-ASI`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
