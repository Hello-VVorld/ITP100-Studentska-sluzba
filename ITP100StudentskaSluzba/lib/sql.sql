CREATE DATABASE  IF NOT EXISTS `itp100_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `itp100_db`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: itp100_db
-- ------------------------------------------------------
-- Server version	5.7.28-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ciklus`
--

DROP TABLE IF EXISTS `ciklus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciklus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciklus`
--

LOCK TABLES `ciklus` WRITE;
/*!40000 ALTER TABLE `ciklus` DISABLE KEYS */;
INSERT INTO `ciklus` VALUES (1,'prvi ciklus'),(2,'drugi ciklus'),(3,'treci ciklus'),(4,'osnovni'),(5,'postdoc'),(6,'cetvrti ciklus');
/*!40000 ALTER TABLE `ciklus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ispiti`
--

DROP TABLE IF EXISTS `ispiti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ispiti` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `datum` varchar(45) NOT NULL,
  `ocjena` int(2) NOT NULL,
  `bodovi` int(4) NOT NULL,
  `nastavnik_fk` int(11) NOT NULL,
  `predmet_fk` int(11) NOT NULL,
  `studenti_fk` int(11) NOT NULL,
  `program_fk` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ispiti_nastavnik_idx` (`nastavnik_fk`),
  KEY `fk_ispiti_predmet1_idx` (`predmet_fk`),
  KEY `fk_ispiti_studenti1_idx` (`studenti_fk`),
  KEY `fk_ispiti_studijski program1_idx` (`program_fk`),
  CONSTRAINT `fk_ispiti_nastavnik` FOREIGN KEY (`nastavnik_fk`) REFERENCES `nastavnik` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ispiti_predmet1` FOREIGN KEY (`predmet_fk`) REFERENCES `predmet` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ispiti_studenti1` FOREIGN KEY (`studenti_fk`) REFERENCES `studenti` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ispiti_studijski program1` FOREIGN KEY (`program_fk`) REFERENCES `program` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ispiti`
--

LOCK TABLES `ispiti` WRITE;
/*!40000 ALTER TABLE `ispiti` DISABLE KEYS */;
INSERT INTO `ispiti` VALUES (1,'29. 11. 2019',9,85,1,1,1,1),(2,'29.12.2019',7,63,1,1,2,1);
/*!40000 ALTER TABLE `ispiti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nastavnik`
--

DROP TABLE IF EXISTS `nastavnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nastavnik` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `zvanje` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nastavnik`
--

LOCK TABLES `nastavnik` WRITE;
/*!40000 ALTER TABLE `nastavnik` DISABLE KEYS */;
INSERT INTO `nastavnik` VALUES (1,'Ognjen','Calic','dipl. ing'),(2,'Sasa','Danilovic','prof. dr'),(3,'Igor','Skrebic','doc. dr'),(4,'Aleksandar','Kelec','visi asistent'),(5,'Ognjen','Joldzic','doc. dr'),(6,'Ognjen','Stankovic','dipl. oec'),(7,'Nikola','Obradovic','visi asistent'),(8,'iu','uyiyui','yuiyuiy');
/*!40000 ALTER TABLE `nastavnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oglas`
--

DROP TABLE IF EXISTS `oglas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oglas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  `sadrzaj` varchar(450) NOT NULL,
  `datum` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `aktivan` tinyint(4) NOT NULL,
  `ploca_fk` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_oglas_oglasna ploca1_idx` (`ploca_fk`),
  CONSTRAINT `fk_oglas_oglasna ploca1` FOREIGN KEY (`ploca_fk`) REFERENCES `ploca` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oglas`
--

LOCK TABLES `oglas` WRITE;
/*!40000 ALTER TABLE `oglas` DISABLE KEYS */;
INSERT INTO `oglas` VALUES (1,'Dodjela diploma','Dodjela diploma ce se odrzati u zgradi vlade.','2019-11-30 22:36:51',1,1);
/*!40000 ALTER TABLE `oglas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ploca`
--

DROP TABLE IF EXISTS `ploca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ploca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ploca` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ploca`
--

LOCK TABLES `ploca` WRITE;
/*!40000 ALTER TABLE `ploca` DISABLE KEYS */;
INSERT INTO `ploca` VALUES (1,'Informacije');
/*!40000 ALTER TABLE `ploca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `predmet`
--

DROP TABLE IF EXISTS `predmet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `predmet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  `obavezan` tinyint(4) NOT NULL,
  `ects` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `predmet`
--

LOCK TABLES `predmet` WRITE;
/*!40000 ALTER TABLE `predmet` DISABLE KEYS */;
INSERT INTO `predmet` VALUES (1,'matematika',1,60),(2,'fizika',1,60),(3,'engleski jezik',1,30),(4,'hemija',0,30);
/*!40000 ALTER TABLE `predmet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `program` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  `ciklus_fk` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_studijski program_ciklus1_idx` (`ciklus_fk`),
  CONSTRAINT `fk_studijski program_ciklus1` FOREIGN KEY (`ciklus_fk`) REFERENCES `ciklus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
INSERT INTO `program` VALUES (1,'matematika',1),(2,'bilogija',1),(3,'informatika',1),(4,'geografija',1),(5,'prostorno planiranje',1),(6,'ITP100',1),(7,'ITP1000',3);
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studenti`
--

DROP TABLE IF EXISTS `studenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studenti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `indeks` varchar(45) NOT NULL,
  `upis` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studenti`
--

LOCK TABLES `studenti` WRITE;
/*!40000 ALTER TABLE `studenti` DISABLE KEYS */;
INSERT INTO `studenti` VALUES (1,'Aleksandar','Aćić','11',15),(2,'Branko','Branković','22',15),(3,'Veso','Vesić','33',16),(4,'Goran','Vesic','16-19',18),(5,'Sinisa','Kesic','17-17',17),(6,'Veso','Vesic','11',2019),(7,'Maja','Kumovic','275',2011),(8,'Aleksandar','Nikolic','5',2019),(9,'Aleksandar','Nikolic','5',2019),(10,'Dragan','Kovacevic','12',2018),(11,'Maja','Kumovic','275',2011),(12,'j','hgjg','55',55),(13,'uy','tyuty','44',44);
/*!40000 ALTER TABLE `studenti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-09  9:19:29
