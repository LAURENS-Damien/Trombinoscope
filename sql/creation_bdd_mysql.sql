-- Création du schéma
CREATE SCHEMA `trombinoscope` DEFAULT CHARACTER SET utf8 ;

-- Création de la table collaborateurs
CREATE TABLE `trombinoscope`.`collaborateurs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(100) NOT NULL,
  `prenom` VARCHAR(100) NOT NULL,
  `photo` LONGBLOB NULL,
  `photoFormatee` MEDIUMTEXT NULL,
  `poste` VARCHAR(100) NULL,
  `dateEntree` DATE NULL,
  `numeroTelephone` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));