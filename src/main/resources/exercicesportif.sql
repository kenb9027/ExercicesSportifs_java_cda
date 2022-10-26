-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 26 oct. 2022 à 15:00
-- Version du serveur : 5.7.36
-- Version de PHP : 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `exercicesportif`
--

-- --------------------------------------------------------

--
-- Structure de la table `centresportif`
--

DROP TABLE IF EXISTS `centresportif`;
CREATE TABLE IF NOT EXISTS `centresportif` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `city` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `centresportif`
--

INSERT INTO `centresportif` (`id`, `name`, `city`) VALUES
(1, 'Les Lilas', 'Bordeaux'),
(2, 'Orange', 'Floirac'),
(3, 'Basic', 'Bordeaux');

-- --------------------------------------------------------

--
-- Structure de la table `exercice`
--

DROP TABLE IF EXISTS `exercice`;
CREATE TABLE IF NOT EXISTS `exercice` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `timeStart` time NOT NULL,
  `timeEnd` time NOT NULL,
  `machine` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `exercice`
--

INSERT INTO `exercice` (`id`, `date`, `timeStart`, `timeEnd`, `machine`) VALUES
(2, '2021-10-14', '08:00:00', '12:00:00', 1),
(3, '2020-10-01', '10:00:00', '20:00:00', 5),
(4, '2020-02-02', '10:50:00', '12:00:00', 2),
(5, '2021-05-02', '20:00:00', '23:45:00', 3),
(7, '2020-10-01', '10:00:00', '20:00:00', 1);

-- --------------------------------------------------------

--
-- Structure de la table `machinedesport`
--

DROP TABLE IF EXISTS `machinedesport`;
CREATE TABLE IF NOT EXISTS `machinedesport` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `centreSportifId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `machinedesport`
--

INSERT INTO `machinedesport` (`id`, `name`, `centreSportifId`) VALUES
(1, 'tapis de course', 1),
(2, 'tapis de course', 2),
(3, 'corde à sauter', 3),
(4, 'corde à sauter', 2),
(5, 'haltères', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
