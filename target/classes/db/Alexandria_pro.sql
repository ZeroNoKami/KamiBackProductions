CREATE DATABASE  IF NOT EXISTS `proyectoalexandria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `proyectoalexandria`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: proyectoalexandria
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ciudades`
--

DROP TABLE IF EXISTS `ciudades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ciudades` (
  `idciudad` int(20) NOT NULL AUTO_INCREMENT,
  `nombreciudad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudades`
--

LOCK TABLES `ciudades` WRITE;
/*!40000 ALTER TABLE `ciudades` DISABLE KEYS */;
INSERT INTO `ciudades` VALUES (1,'Alexandria'),(2,'Terra'),(3,'Midgar'),(4,'Horizon');
/*!40000 ALTER TABLE `ciudades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopersonaje`
--

DROP TABLE IF EXISTS `tipopersonaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipopersonaje` (
  `idtipo` int(1) NOT NULL AUTO_INCREMENT,
  `nombretipo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idtipo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopersonaje`
--

LOCK TABLES `tipopersonaje` WRITE;
/*!40000 ALTER TABLE `tipopersonaje` DISABLE KEYS */;
INSERT INTO `tipopersonaje` VALUES (1,'Antiheroe'),(2,'Villano'),(3,'Heroe'),(4,'Secundario');
/*!40000 ALTER TABLE `tipopersonaje` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personajes`
--

DROP TABLE IF EXISTS `personajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `personajes` (
  `id_personaje` int(100) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `deidad` varchar(30) DEFAULT NULL,
  `tipo` int(1) DEFAULT NULL,
  `arma` varchar(50) DEFAULT NULL,
  `ciu_nac` int(50) DEFAULT NULL,
  PRIMARY KEY (`id_personaje`),
  KEY `tipo` (`tipo`),
  KEY `ciu_nac` (`ciu_nac`),
  CONSTRAINT `personajes_ibfk_1` FOREIGN KEY (`tipo`) REFERENCES `tipopersonaje` (`idtipo`),
  CONSTRAINT `personajes_ibfk_2` FOREIGN KEY (`ciu_nac`) REFERENCES `ciudades` (`idciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajes`
--

LOCK TABLES `personajes` WRITE;
/*!40000 ALTER TABLE `personajes` DISABLE KEYS */;
INSERT INTO `personajes` VALUES (1,'Zero','Tiempo y espacio',2,'Bloodborne',1),(2,'Tophox','Guerra',2,'Pena Capital',1),(3,'Caput','Sabiduría',2,'Luciferum',1),(4,'Acha','Tiempo',2,'Vane(Alfanje) y Bonnie, Low y Every (Pistolas)',1),(5,'Aga','Agua',2,'Nejibana',2),(6,'Armiche','Fuego',2,'Armas de puño',2),(7,'Tito','Formless',2,'Camaleónica',1),(8,'Knox','Muerte',3,'Knoxnomicón',1),(9,'Leo','Vida',3,'Báculo de Vida',1),(10,'Orm','Sueño',3,'Phantaso y Phobos',1),(11,'Greyman','Naturaleza',3,'Báculo de magia',3),(12,'Vento','Viento',3,'Viento doble',3),(13,'Knost','Tierra',3,'Ornstein',4),(14,'Ryu','Rayo',3,'Naginata',4);
/*!40000 ALTER TABLE `personajes` ENABLE KEYS */;
UNLOCK TABLES;



-- Dump completed on 2018-09-21 12:08:51
