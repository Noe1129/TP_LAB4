CREATE DATABASE  IF NOT EXISTS `tpi_lciv` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tpi_lciv`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: tpi_lciv
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `legajo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `fecha_nac` date NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `area` varchar(30) NOT NULL,
  `sueldo_bruto` decimal(8,2) NOT NULL,
  PRIMARY KEY (`legajo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'Juan','Perez','1999-05-12','2020-02-03','RRHH',55000.00),(2,'pedro','lopez','1999-08-18','2015-05-05','tesoreria',200000.00),(3,'martin','perez','1985-04-15','2007-03-08','marketing',280000.00);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibos`
--

DROP TABLE IF EXISTS `recibos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recibos` (
  `nro_recibo` int NOT NULL AUTO_INCREMENT,
  `anio` int NOT NULL,
  `mes` int NOT NULL,
  `monto_antig` decimal(8,2) NOT NULL,
  `jubilacion` decimal(8,2) NOT NULL,
  `obra_social` decimal(8,2) NOT NULL,
  `fondo_complej` decimal(8,2) NOT NULL,
  `legajo` int NOT NULL,
  PRIMARY KEY (`nro_recibo`),
  KEY `legajo` (`legajo`),
  CONSTRAINT `recibos_ibfk_1` FOREIGN KEY (`legajo`) REFERENCES `empleados` (`legajo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibos`
--
INSERT INTO empleados (nombre,apellido,fecha_nac,fecha_ingreso,area,sueldo_bruto)
VALUES ('jose','ramirez',"1995-03-17","2018-10-27",'tesoreria',210000);

INSERT INTO recibos (anio,mes,monto_antig,jubilacion,obra_social,fondo_complej,legajo)
VALUES (2022,11,13000,7000,6000,4000,3);

CREATE VIEW ReporteSueldoArea as
SELECT anio, mes, area, SUM(sueldo_bruto+monto_antig-(jubilacion+obra_social+fondo_complej)) as 'Neto'
FROM empleados e JOIN recibos r ON e.legajo= r.legajo
GROUP BY area,mes,anio
ORDER BY 4;

LOCK TABLES `recibos` WRITE;
/*!40000 ALTER TABLE `recibos` DISABLE KEYS */;
INSERT INTO `recibos` VALUES (1,2022,11,15000.00,9000.00,7000.00,5000.00,1),(2,2022,11,35000.00,11000.00,8500.00,6300.00,2);
/*!40000 ALTER TABLE `recibos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-11 18:38:46
