CREATE DATABASE  IF NOT EXISTS `recetorium` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `recetorium`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: recetorium
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `ingrediente`
--

DROP TABLE IF EXISTS `ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingrediente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `foto` varchar(45) DEFAULT NULL,
  `color` char(7) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingrediente`
--

LOCK TABLES `ingrediente` WRITE;
/*!40000 ALTER TABLE `ingrediente` DISABLE KEYS */;
INSERT INTO `ingrediente` VALUES (1,'Harina de trigo','ing_1.jpg','#FFFFFF'),(2,'Azúcar','ing_2.jpg','#FFC0CB'),(3,'Huevos','ing_3.jpg','#FFD700'),(4,'Leche','ing_4.jpg','#FFFAF0'),(5,'Sal','ing_5.jpg','#FFFFFF'),(6,'Levadura','ing_6.jpg','#D3B980'),(7,'Aceite de oliva','ing_7.jpg','#FDBC00'),(8,'Tomate','ing_8.jpg','#F52406'),(9,'Cebolla','ing_9.jpg','#DCAD97'),(10,'Pimiento rojo','ing_10.jpg','#B81E12'),(11,'Pimiento verde','ing_11.jpg','#275104'),(12,'Pimiento amarillo','ing_12.jpg','#E9C302'),(13,'Ajo','ing_13.jpg','#EAD8CF'),(14,'Arroz','ing_14.jpg','#D4D1B9'),(15,'Carne molida','ing_15.jpg','#75080C'),(16,'Pollo','ing_16.jpg','#CC8E85'),(17,'Queso cheddar','ing_17.jpg','#FFA500'),(18,'Queso parmesano','ing_18.jpg','#F5DEB3'),(19,'Jamón','ing_19.jpg','#FFB6C1'),(20,'Pan','ing_20.jpg','#BB701D');
/*!40000 ALTER TABLE `ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `foto` varchar(45) CHARACTER SET ascii COLLATE ascii_general_ci DEFAULT NULL,
  `usuario_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_perfil_usuario_idx` (`usuario_id`),
  CONSTRAINT `fk_perfil_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'aturing','perfil_1.png',1),(2,'alovelace','perfil_2.png',2),(3,'cbabbage',NULL,3),(4,'ghopper','perfil_4.png',4);
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta`
--

DROP TABLE IF EXISTS `receta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `foto` varchar(45) DEFAULT NULL,
  `instrucciones` text NOT NULL,
  `perfil_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_playlist_perfil1_idx` (`perfil_id`),
  CONSTRAINT `fk_playlist_perfil1` FOREIGN KEY (`perfil_id`) REFERENCES `perfil` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta`
--

LOCK TABLES `receta` WRITE;
/*!40000 ALTER TABLE `receta` DISABLE KEYS */;
INSERT INTO `receta` VALUES (1,'Pizza Margarita','receta_1.jpg','Preparar la masa y extenderla en una bandeja. Agregar salsa de tomate, mozzarella, albahaca y hornear.',2),(2,'Ensalada César','receta_2.jpg','Mezclar lechuga, crutones, pollo a la parrilla, queso parmesano y aderezo César.',3),(3,'Lasagna de Carne','receta_3.jpg','Cocinar pasta, hacer salsa de carne, armar capas de pasta, carne, queso ricotta, mozzarella y hornear.',2),(4,'Sushi de Salmón',NULL,'Hacer arroz de sushi, colocarlo sobre nori, agregar salmón y aguacate, enrollar y cortar.',4),(5,'Tacos de Camarones','receta_5.jpg','Preparar camarones a la parrilla, servir en tortillas de maíz con repollo y salsa de aguacate.',4),(6,'Risotto de Champiñones','receta_6.jpg','Saltear champiñones y cebolla, agregar arroz Arborio y caldo de pollo, cocinar y agregar queso parmesano.',3),(7,'Sopa de Lentejas',NULL,'Cocinar lentejas con zanahorias, cebolla y especias hasta que estén tiernas.',4),(8,'Tarta de Manzana','receta_8.jpg','Preparar masa, cortar manzanas, colocarlas sobre la masa, espolvorear canela y hornear.',2);
/*!40000 ALTER TABLE `receta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta_ingrediente`
--

DROP TABLE IF EXISTS `receta_ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receta_ingrediente` (
  `receta_id` int NOT NULL,
  `ingrediente_id` int NOT NULL,
  `cantidad` int NOT NULL,
  `unidad_medida` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`receta_id`,`ingrediente_id`),
  KEY `fk_receta_has_ingrediente_ingrediente1_idx` (`ingrediente_id`),
  KEY `fk_receta_has_ingrediente_receta1_idx` (`receta_id`),
  CONSTRAINT `fk_receta_has_ingrediente_ingrediente1` FOREIGN KEY (`ingrediente_id`) REFERENCES `ingrediente` (`id`),
  CONSTRAINT `fk_receta_has_ingrediente_receta1` FOREIGN KEY (`receta_id`) REFERENCES `receta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta_ingrediente`
--

LOCK TABLES `receta_ingrediente` WRITE;
/*!40000 ALTER TABLE `receta_ingrediente` DISABLE KEYS */;
INSERT INTO `receta_ingrediente` VALUES (1,1,250,'g'),(1,4,200,'g'),(1,6,10,'g'),(1,10,1,'pizca'),(1,11,30,'g'),(2,3,200,'g'),(2,7,100,'g'),(2,8,50,'g'),(2,9,50,'g'),(2,10,1,'pizca'),(3,1,300,'g'),(3,2,200,'g'),(3,3,3,'unidades'),(3,9,150,'g'),(3,12,100,'g'),(4,5,100,'g'),(4,6,5,'g'),(4,10,1,'pizca'),(4,13,200,'g'),(4,14,150,'g'),(5,3,300,'g'),(5,4,2,'unidades'),(5,10,8,'unidades'),(6,1,200,'g'),(6,2,50,'g'),(6,6,5,'g'),(6,10,200,'g'),(7,2,200,'g'),(7,3,2,'unidades'),(7,8,150,'g'),(7,9,150,'g'),(7,10,1,'pizca'),(8,1,200,'g'),(8,2,100,'g'),(8,4,4,'unidades'),(8,7,50,'g'),(8,10,1,'pizca');
/*!40000 ALTER TABLE `receta_ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(16) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `tipo` enum('STD','ADMIN') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'aturing','aturing','ADMIN'),(2,'alovelace','alovelace','STD'),(3,'cbabbage','cbabbage','STD'),(4,'ghopper','ghopper','STD');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-06 12:19:35
