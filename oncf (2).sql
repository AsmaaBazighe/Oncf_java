-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 16 fév. 2024 à 09:05
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `oncf`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `user` varchar(30) NOT NULL,
  `pwd` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`user`, `pwd`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `gares`
--

CREATE TABLE `gares` (
  `Ville` varchar(30) NOT NULL,
  `Gare` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `gares`
--

INSERT INTO `gares` (`Ville`, `Gare`) VALUES
('casablanca', 'Casa-Voyageurs'),
('casablanca', 'Casa-Port'),
('casablanca', 'Oasis'),
('casablanca', 'Ain Sebaa'),
('rabat', 'Rabat-Agdal'),
('rabat', 'Rabat-Ville');

-- --------------------------------------------------------

--
-- Structure de la table `reduction`
--

CREATE TABLE `reduction` (
  `Carte` varchar(30) NOT NULL,
  `CodeAdhérent` int(30) NOT NULL,
  `Pourcentage` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `reduction`
--

INSERT INTO `reduction` (`Carte`, `CodeAdhérent`, `Pourcentage`) VALUES
('attalib', 1122, 30),
('attalib', 1234, 30),
('esi', 123, 50);

-- --------------------------------------------------------

--
-- Structure de la table `train`
--

CREATE TABLE `train` (
  `GareDepart` varchar(30) NOT NULL,
  `GareArrivee` varchar(30) NOT NULL,
  `Date` datetime(6) NOT NULL,
  `Prix` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `train`
--

INSERT INTO `train` (`GareDepart`, `GareArrivee`, `Date`, `Prix`) VALUES
('Ain Sebaa', 'Rabat-Agdal', '2024-01-12 18:17:00.000000', 40),
('Ain Sebaa', 'Rabat-Ville', '2024-01-12 18:17:00.000000', 45),
('Ain Sebaa', 'Casa-Voyageurs', '2024-01-12 18:17:00.000000', 20),
('Ain Sebaa', 'Oasis', '2024-01-12 18:17:00.000000', 25),
('Ain Sebaa', 'Casa-Port', '2024-01-12 18:17:00.000000', 30),
('Casa-Voyageurs', 'Rabat-Agdal', '2024-01-12 18:17:00.000000', 45),
('Casa-Voyageurs', 'Rabat-Ville', '2024-01-12 18:17:00.000000', 50),
('Casa-Voyageurs', 'Casa-Port', '2024-01-12 18:17:00.000000', 25),
('Casa-Voyageurs', 'Oasis', '2024-01-12 18:17:00.000000', 20),
('Casa-Voyageurs', 'Ain Sebaa', '2024-01-12 18:17:00.000000', 20),
('Oasis', 'Rabat-Agdal', '2024-01-12 18:17:00.000000', 50),
('Oasis', 'Rabat-Ville', '2024-01-12 18:17:00.000000', 55),
('Oasis', 'Casa-Port', '2024-01-12 18:17:00.000000', 20),
('Oasis', 'Ain Sebaa', '2024-01-12 18:17:00.000000', 25),
('Oasis', 'Casa-Voyageurs', '2024-01-12 18:17:00.000000', 20),
('Casa-Port', 'Rabat-Agdal', '2024-01-12 18:17:00.000000', 50),
('Casa-Port', 'Rabat-Ville', '2024-01-12 18:17:00.000000', 55),
('Casa-Port', 'Casa-Voyageurs', '2024-01-12 18:17:00.000000', 25),
('Casa-Port', 'Oasis', '2024-01-12 18:17:00.000000', 20),
('Casa-Port', 'Ain Sebaa', '2024-01-12 18:17:00.000000', 30),
('Rabat-Agdal', 'Oasis', '2024-01-12 18:17:00.000000', 50),
('Rabat-Agdal', 'Rabat-Ville', '2024-01-12 18:17:00.000000', 10),
('Rabat-Agdal', 'Casa-Port', '2024-01-12 18:17:00.000000', 50),
('Rabat-Agdal', 'Ain Sebaa', '2024-01-12 18:17:00.000000', 40),
('Rabat-Agdal', 'Casa-Voyageurs', '2024-01-12 18:17:00.000000', 45),
('Rabat-Ville', 'Rabat-Agdal', '2024-01-12 18:17:00.000000', 10),
('Rabat-Ville', 'Oasis', '2024-01-12 18:17:00.000000', 55),
('Rabat-Ville', 'Casa-Port', '2024-01-12 18:17:00.000000', 55),
('Rabat-Ville', 'Ain Sebaa', '2024-01-12 18:17:00.000000', 45),
('Rabat-Ville', 'Casa-Voyageurs', '2024-01-12 18:17:00.000000', 50),
('Ain Sebaa', 'Rabat-Agdal', '2024-01-12 20:17:00.000000', 40),
('Ain Sebaa', 'Rabat-Ville', '2024-01-12 20:17:00.000000', 45),
('Ain Sebaa', 'Casa-Voyageurs', '2024-01-12 20:17:00.000000', 20),
('Ain Sebaa', 'Oasis', '2024-01-12 20:17:00.000000', 25),
('Ain Sebaa', 'Casa-Port', '2024-01-12 20:17:00.000000', 30),
('Casa-Voyageurs', 'Rabat-Agdal', '2024-01-12 20:17:00.000000', 45),
('Casa-Voyageurs', 'Rabat-Ville', '2024-01-12 20:17:00.000000', 50),
('Casa-Voyageurs', 'Casa-Port', '2024-01-12 20:17:00.000000', 25),
('Casa-Voyageurs', 'Oasis', '2024-01-12 20:17:00.000000', 20),
('Casa-Voyageurs', 'Ain Sebaa', '2024-01-12 20:17:00.000000', 20),
('Oasis', 'Rabat-Agdal', '2024-01-12 20:17:00.000000', 50),
('Oasis', 'Rabat-Ville', '2024-01-12 20:17:00.000000', 55),
('Oasis', 'Casa-Port', '2024-01-12 20:17:00.000000', 20),
('Oasis', 'Ain Sebaa', '2024-01-12 20:17:00.000000', 25),
('Oasis', 'Casa-Voyageurs', '2024-01-12 20:17:00.000000', 20),
('Casa-Port', 'Rabat-Agdal', '2024-01-12 20:17:00.000000', 50),
('Casa-Port', 'Rabat-Ville', '2024-01-12 20:17:00.000000', 55),
('Casa-Port', 'Casa-Voyageurs', '2024-01-12 20:17:00.000000', 25),
('Casa-Port', 'Oasis', '2024-01-12 20:17:00.000000', 20),
('Casa-Port', 'Ain Sebaa', '2024-01-12 20:17:00.000000', 30),
('Rabat-Agdal', 'Oasis', '2024-01-12 20:17:00.000000', 50),
('Rabat-Agdal', 'Rabat-Ville', '2024-01-12 20:17:00.000000', 10),
('Rabat-Agdal', 'Casa-Port', '2024-01-12 20:17:00.000000', 50),
('Rabat-Agdal', 'Ain Sebaa', '2024-01-12 20:17:00.000000', 40),
('Rabat-Agdal', 'Casa-Voyageurs', '2024-01-12 20:17:00.000000', 45),
('Rabat-Ville', 'Rabat-Agdal', '2024-01-12 20:17:00.000000', 10),
('Rabat-Ville', 'Oasis', '2024-01-12 20:17:00.000000', 55),
('Rabat-Ville', 'Casa-Port', '2024-01-12 20:17:00.000000', 55),
('Rabat-Ville', 'Ain Sebaa', '2024-01-12 20:17:00.000000', 45),
('Rabat-Ville', 'Casa-Voyageurs', '2024-01-12 20:17:00.000000', 50),
('Ain Sebaa', 'Rabat-Agdal', '2024-01-12 22:17:00.000000', 40),
('Ain Sebaa', 'Rabat-Ville', '2024-01-12 22:17:00.000000', 45),
('Ain Sebaa', 'Casa-Voyageurs', '2024-01-12 22:17:00.000000', 20),
('Ain Sebaa', 'Oasis', '2024-01-12 22:17:00.000000', 25),
('Ain Sebaa', 'Casa-Port', '2024-01-12 22:17:00.000000', 30),
('Casa-Voyageurs', 'Rabat-Agdal', '2024-01-12 22:17:00.000000', 45),
('Casa-Voyageurs', 'Rabat-Ville', '2024-01-12 22:17:00.000000', 50),
('Casa-Voyageurs', 'Casa-Port', '2024-01-12 22:17:00.000000', 25),
('Casa-Voyageurs', 'Oasis', '2024-01-12 22:17:00.000000', 20),
('Casa-Voyageurs', 'Ain Sebaa', '2024-01-12 22:17:00.000000', 20),
('Oasis', 'Rabat-Agdal', '2024-01-12 22:17:00.000000', 50),
('Oasis', 'Rabat-Ville', '2024-01-12 22:17:00.000000', 55),
('Oasis', 'Casa-Port', '2024-01-12 22:17:00.000000', 20),
('Oasis', 'Ain Sebaa', '2024-01-12 22:17:00.000000', 25),
('Oasis', 'Casa-Voyageurs', '2024-01-12 22:17:00.000000', 20),
('Casa-Port', 'Rabat-Agdal', '2024-01-12 22:17:00.000000', 50),
('Casa-Port', 'Rabat-Ville', '2024-01-12 22:17:00.000000', 55),
('Casa-Port', 'Casa-Voyageurs', '2024-01-12 22:17:00.000000', 25),
('Casa-Port', 'Oasis', '2024-01-12 22:17:00.000000', 20),
('Casa-Port', 'Ain Sebaa', '2024-01-12 22:17:00.000000', 30),
('Rabat-Agdal', 'Oasis', '2024-01-12 22:17:00.000000', 50),
('Rabat-Agdal', 'Rabat-Ville', '2024-01-12 22:17:00.000000', 10),
('Rabat-Agdal', 'Casa-Port', '2024-01-12 22:17:00.000000', 50),
('Rabat-Agdal', 'Ain Sebaa', '2024-01-12 22:17:00.000000', 40),
('Rabat-Agdal', 'Casa-Voyageurs', '2024-01-12 22:17:00.000000', 45),
('Rabat-Ville', 'Rabat-Agdal', '2024-01-12 22:17:00.000000', 10),
('Rabat-Ville', 'Oasis', '2024-01-12 22:17:00.000000', 55),
('Rabat-Ville', 'Casa-Port', '2024-01-12 22:17:00.000000', 55),
('Rabat-Ville', 'Ain Sebaa', '2024-01-12 22:17:00.000000', 45),
('Rabat-Ville', 'Casa-Voyageurs', '2024-01-12 22:17:00.000000', 50);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `User` varchar(30) NOT NULL,
  `Pwd` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`User`, `Pwd`) VALUES
('admin', 'admin');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
