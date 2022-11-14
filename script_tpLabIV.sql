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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'Juan','Perez','1999-05-12','2020-02-03','Recursos Humanos',55000.00),(2,'Pedro','Lopez','1999-08-18','2015-05-05','Tesoreria',200000.00),(3,'Martin','Perez','1985-04-15','2007-03-08','Marketing',280000.00),(4,'Florencia','Perez','1999-05-12','2020-02-03','Recursos Humanos',55000.00),(5,'Jose','Ramirez','1995-03-17','2018-10-27','Tesoreria',210000.00),(6,'Juan','Castillo','1982-05-11','2018-10-17','Finanzas',200000.00),(7,'María','Ferreyra','2000-03-01','2018-04-14','Ventas',85000.00),(8,'Rodrigo','Sanchez','1994-12-08','2019-10-13','Ventas',85000.00),(9,'Ayelén','González','1995-11-21','2022-11-12','Marketing',200000.00),(10,'Elba','Lupi','2000-11-02','2022-11-04','Ventas',150000.00);
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibos`
--

LOCK TABLES `recibos` WRITE;
/*!40000 ALTER TABLE `recibos` DISABLE KEYS */;
INSERT INTO `recibos` VALUES (1,2022,11,1500.00,5000.00,7000.00,1500.00,1),(2,2022,11,3200.00,11000.00,6000.00,2000.00,2),(3,2022,11,3200.00,10000.00,4000.00,2300.00,1),(4,2020,9,2500.00,5000.00,2300.00,2500.00,2),(5,2022,11,1300.00,7000.00,6000.00,1500.00,3),(6,2022,11,1300.00,1500.00,1000.00,1200.00,4),(7,2022,11,1200.00,1500.00,1500.00,1200.00,5),(8,2022,11,1200.00,1200.00,1200.00,1200.00,6),(9,2022,11,2000.00,2500.00,3000.00,2500.00,7);
/*!40000 ALTER TABLE `recibos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `reportesueldoarea`
--

DROP TABLE IF EXISTS `reportesueldoarea`;
/*!50001 DROP VIEW IF EXISTS `reportesueldoarea`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `reportesueldoarea` AS SELECT 
 1 AS `anio`,
 1 AS `mes`,
 1 AS `area`,
 1 AS `Neto`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `reportesueldoarea`
--

/*!50001 DROP VIEW IF EXISTS `reportesueldoarea`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `reportesueldoarea` AS select `r`.`anio` AS `anio`,`r`.`mes` AS `mes`,`e`.`area` AS `area`,sum(((`e`.`sueldo_bruto` + `r`.`monto_antig`) - ((`r`.`jubilacion` + `r`.`obra_social`) + `r`.`fondo_complej`))) AS `Neto` from (`empleados` `e` join `recibos` `r` on((`e`.`legajo` = `r`.`legajo`))) group by `e`.`area`,`r`.`mes`,`r`.`anio` order by sum(((`e`.`sueldo_bruto` + `r`.`monto_antig`) - ((`r`.`jubilacion` + `r`.`obra_social`) + `r`.`fondo_complej`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-14  1:07:16
