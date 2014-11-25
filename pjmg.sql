-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Mar 25 Novembre 2014 à 10:12
-- Version du serveur: 5.5.8
-- Version de PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `pjmg`
--

-- --------------------------------------------------------

--
-- Structure de la table `presence`
--

CREATE TABLE IF NOT EXISTS `presence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `entrydate` date DEFAULT NULL,
  `entrytime` time DEFAULT NULL,
  `exitdate` date DEFAULT NULL,
  `exittime` time DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `total` varchar(8) DEFAULT NULL,
  `idPU` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB7C2011B32BD016E` (`idPU`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `presence`
--

INSERT INTO `presence` (`id`, `comment`, `entrydate`, `entrytime`, `exitdate`, `exittime`, `mail`, `state`, `total`, `idPU`) VALUES
(1, NULL, '2014-11-17', '08:30:10', '2014-11-17', '18:30:10', 'test@test.com', NULL, '10H :00 ', 'test@test.com');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `mail` varchar(255) NOT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`mail`, `lastname`, `firstname`, `password`) VALUES
('test@test.com', 'Berguiga', 'Amine', '7777777777777777');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `presence`
--
ALTER TABLE `presence`
  ADD CONSTRAINT `FKB7C2011B32BD016E` FOREIGN KEY (`idPU`) REFERENCES `user` (`mail`);
