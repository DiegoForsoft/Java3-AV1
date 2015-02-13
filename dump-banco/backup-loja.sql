-- MySQL dump 10.15  Distrib 10.0.16-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: loja
-- ------------------------------------------------------
-- Server version	10.0.16-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `carro`
--

DROP TABLE IF EXISTS `carro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carro` (
  `carro_id` int(11) NOT NULL AUTO_INCREMENT,
  `chassi` varchar(50) NOT NULL,
  `montadora` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `tipo` int(11) NOT NULL,
  `cor` int(11) NOT NULL,
  `motorizacao` float NOT NULL,
  `cambio` int(11) NOT NULL,
  `preco` float NOT NULL,
  PRIMARY KEY (`carro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro`
--

LOCK TABLES `carro` WRITE;
/*!40000 ALTER TABLE `carro` DISABLE KEYS */;
/*!40000 ALTER TABLE `carro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motocicleta`
--

DROP TABLE IF EXISTS `motocicleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motocicleta` (
  `motocicleta_id` int(11) NOT NULL AUTO_INCREMENT,
  `chassi` varchar(50) NOT NULL,
  `montadora` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `tipo` int(11) NOT NULL,
  `cor` int(11) NOT NULL,
  `cilindrada` int(11) NOT NULL,
  `capacidade_tanque` int(11) NOT NULL,
  `preco` float NOT NULL,
  PRIMARY KEY (`motocicleta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motocicleta`
--

LOCK TABLES `motocicleta` WRITE;
/*!40000 ALTER TABLE `motocicleta` DISABLE KEYS */;
/*!40000 ALTER TABLE `motocicleta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-13 19:54:20
