-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 09, 2019 at 06:06 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `itp100_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `ciklus`
--

CREATE TABLE `ciklus` (
  `id_ciklus` int(11) NOT NULL,
  `naziv` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ciklus`
--

INSERT INTO `ciklus` (`id_ciklus`, `naziv`) VALUES
(1, 'prvi ciklus'),
(2, 'drugi ciklus'),
(3, 'treci ciklus'),
(4, 'd'),
(5, '232323'),
(6, ''),
(7, '               '),
(8, 'dsds'),
(9, 'fser'),
(10, 'wewewew');

-- --------------------------------------------------------

--
-- Table structure for table `ispiti`
--

CREATE TABLE `ispiti` (
  `id_ispit` int(1) NOT NULL,
  `datum_ispita` varchar(45) NOT NULL,
  `ocjena` int(2) NOT NULL,
  `broj_bodova` int(4) NOT NULL,
  `nastavnik_id_nastavnika` int(11) NOT NULL,
  `predmet_id_predmeta` int(11) NOT NULL,
  `studenti_id_studenta` int(11) NOT NULL,
  `studijski_program_id_studijski_program` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ispiti`
--

INSERT INTO `ispiti` (`id_ispit`, `datum_ispita`, `ocjena`, `broj_bodova`, `nastavnik_id_nastavnika`, `predmet_id_predmeta`, `studenti_id_studenta`, `studijski_program_id_studijski_program`) VALUES
(1, '29. 11. 2019', 9, 85, 1, 1, 1, 1),
(2, '29.12.2019', 7, 63, 1, 1, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `nastavnik`
--

CREATE TABLE `nastavnik` (
  `id_nastavnika` int(11) NOT NULL,
  `ime_nastavnika` varchar(45) NOT NULL,
  `prezime_nastavnika` varchar(45) NOT NULL,
  `zvanje_nastavnika` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nastavnik`
--

INSERT INTO `nastavnik` (`id_nastavnika`, `ime_nastavnika`, `prezime_nastavnika`, `zvanje_nastavnika`) VALUES
(1, 'Ognjen', 'Calic', 'dipl. ing'),
(2, 'Sasa', 'Danilovic', 'prof. dr'),
(3, 'Igor', 'Skrebic', 'doc. dr'),
(4, 'Aleksandar', 'Kelec', 'visi asistent'),
(5, 'Ognjen', 'Joldzic', 'doc. dr'),
(6, 'Ognjen', 'Stankovic', 'dipl. oec'),
(7, 'Nikola', 'Obradovic', 'visi asistent'),
(8, 'sadas', 'asdasdas', 'wqrewre');

-- --------------------------------------------------------

--
-- Table structure for table `oglas`
--

CREATE TABLE `oglas` (
  `id_oglasa` int(11) NOT NULL,
  `naziv_oglasa` varchar(45) NOT NULL,
  `sadrzaj` varchar(450) NOT NULL,
  `datum` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `aktivan` tinyint(4) NOT NULL,
  `oglasna ploca_id_oglasne_ploce` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `oglas`
--

INSERT INTO `oglas` (`id_oglasa`, `naziv_oglasa`, `sadrzaj`, `datum`, `aktivan`, `oglasna ploca_id_oglasne_ploce`) VALUES
(1, 'Dodjela diploma', 'Dodjela diploma ce se odrzati u zgradi vlade.', '2019-11-30 22:36:51', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `oglasna_ploca`
--

CREATE TABLE `oglasna_ploca` (
  `id_oglasne_ploce` int(11) NOT NULL,
  `oglasna_ploca` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `oglasna_ploca`
--

INSERT INTO `oglasna_ploca` (`id_oglasne_ploce`, `oglasna_ploca`) VALUES
(1, 'Informacije'),
(2, 'sadasdasdqwewqdasdasdklasjdklasdj'),
(3, 'dfdsfsdfsdfsfkklsdjfkd'),
(4, '111111111111'),
(5, 'fgd4444');

-- --------------------------------------------------------

--
-- Table structure for table `predmet`
--

CREATE TABLE `predmet` (
  `id_predmeta` int(11) NOT NULL,
  `naziv_predmeta` varchar(45) NOT NULL,
  `obavezan_predmet` tinyint(4) NOT NULL,
  `ects` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `predmet`
--

INSERT INTO `predmet` (`id_predmeta`, `naziv_predmeta`, `obavezan_predmet`, `ects`) VALUES
(1, 'matematika', 1, 60),
(2, 'fizika', 1, 60),
(3, 'engleski jezik', 1, 30),
(4, 'hemija', 0, 30);

-- --------------------------------------------------------

--
-- Table structure for table `studenti`
--

CREATE TABLE `studenti` (
  `id_studenta` int(11) NOT NULL,
  `ime_studenta` varchar(45) NOT NULL,
  `prezime_studenta` varchar(45) NOT NULL,
  `broj_indeksa` varchar(45) NOT NULL,
  `godina_upisa` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `studenti`
--

INSERT INTO `studenti` (`id_studenta`, `ime_studenta`, `prezime_studenta`, `broj_indeksa`, `godina_upisa`) VALUES
(1, 'Aleksandar', 'Aćić', '11', 15),
(2, 'Branko', 'Branković', '22', 15),
(3, 'Veso', 'Vesić', '33', 16),
(4, 'Goran', 'Vesic', '16-19', 18),
(5, 'Sinisa', 'Kesic', '17-17', 17),
(6, 'Veso', 'Vesic', '11', 2019),
(7, 'Maja', 'Kumovic', '275', 2011),
(8, 'Aleksandar', 'Nikolic', '5', 2019),
(9, 'Aleksandar', 'Nikolic', '5', 2019),
(10, 'Dragan', 'Kovacevic', '12', 2018),
(11, 'Maja', 'Kumovic', '275', 2011),
(12, 'bla', 'nja', '2222', 1111);

-- --------------------------------------------------------

--
-- Table structure for table `studijski_program`
--

CREATE TABLE `studijski_program` (
  `id_studijski_program` int(11) NOT NULL,
  `naziv` varchar(45) NOT NULL,
  `ciklus_id_ciklus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `studijski_program`
--

INSERT INTO `studijski_program` (`id_studijski_program`, `naziv`, `ciklus_id_ciklus`) VALUES
(1, 'matematika', 1),
(2, 'bilogija', 1),
(3, 'informatika', 1),
(4, 'geografija', 1),
(5, 'prostorno planiranje', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ciklus`
--
ALTER TABLE `ciklus`
  ADD PRIMARY KEY (`id_ciklus`);

--
-- Indexes for table `ispiti`
--
ALTER TABLE `ispiti`
  ADD PRIMARY KEY (`id_ispit`),
  ADD KEY `fk_ispiti_nastavnik_idx` (`nastavnik_id_nastavnika`),
  ADD KEY `fk_ispiti_predmet1_idx` (`predmet_id_predmeta`),
  ADD KEY `fk_ispiti_studenti1_idx` (`studenti_id_studenta`),
  ADD KEY `fk_ispiti_studijski program1_idx` (`studijski_program_id_studijski_program`);

--
-- Indexes for table `nastavnik`
--
ALTER TABLE `nastavnik`
  ADD PRIMARY KEY (`id_nastavnika`);

--
-- Indexes for table `oglas`
--
ALTER TABLE `oglas`
  ADD PRIMARY KEY (`id_oglasa`),
  ADD KEY `fk_oglas_oglasna ploca1_idx` (`oglasna ploca_id_oglasne_ploce`);

--
-- Indexes for table `oglasna_ploca`
--
ALTER TABLE `oglasna_ploca`
  ADD PRIMARY KEY (`id_oglasne_ploce`);

--
-- Indexes for table `predmet`
--
ALTER TABLE `predmet`
  ADD PRIMARY KEY (`id_predmeta`);

--
-- Indexes for table `studenti`
--
ALTER TABLE `studenti`
  ADD PRIMARY KEY (`id_studenta`);

--
-- Indexes for table `studijski_program`
--
ALTER TABLE `studijski_program`
  ADD PRIMARY KEY (`id_studijski_program`),
  ADD KEY `fk_studijski program_ciklus1_idx` (`ciklus_id_ciklus`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ciklus`
--
ALTER TABLE `ciklus`
  MODIFY `id_ciklus` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `ispiti`
--
ALTER TABLE `ispiti`
  MODIFY `id_ispit` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `nastavnik`
--
ALTER TABLE `nastavnik`
  MODIFY `id_nastavnika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `oglas`
--
ALTER TABLE `oglas`
  MODIFY `id_oglasa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `oglasna_ploca`
--
ALTER TABLE `oglasna_ploca`
  MODIFY `id_oglasne_ploce` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `predmet`
--
ALTER TABLE `predmet`
  MODIFY `id_predmeta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `studenti`
--
ALTER TABLE `studenti`
  MODIFY `id_studenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `studijski_program`
--
ALTER TABLE `studijski_program`
  MODIFY `id_studijski_program` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ispiti`
--
ALTER TABLE `ispiti`
  ADD CONSTRAINT `fk_ispiti_nastavnik` FOREIGN KEY (`nastavnik_id_nastavnika`) REFERENCES `nastavnik` (`id_nastavnika`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ispiti_predmet1` FOREIGN KEY (`predmet_id_predmeta`) REFERENCES `predmet` (`id_predmeta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ispiti_studenti1` FOREIGN KEY (`studenti_id_studenta`) REFERENCES `studenti` (`id_studenta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ispiti_studijski program1` FOREIGN KEY (`studijski_program_id_studijski_program`) REFERENCES `studijski_program` (`id_studijski_program`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `oglas`
--
ALTER TABLE `oglas`
  ADD CONSTRAINT `fk_oglas_oglasna ploca1` FOREIGN KEY (`oglasna ploca_id_oglasne_ploce`) REFERENCES `oglasna_ploca` (`id_oglasne_ploce`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `studijski_program`
--
ALTER TABLE `studijski_program`
  ADD CONSTRAINT `fk_studijski program_ciklus1` FOREIGN KEY (`ciklus_id_ciklus`) REFERENCES `ciklus` (`id_ciklus`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
