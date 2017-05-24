-- MySQL dump 10.13  Distrib 5.1.36, for Win32 (ia32)
--
-- Host: localhost    Database: cobranza
-- ------------------------------------------------------
-- Server version	5.1.36-community-log

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
-- Table structure for table `autoriza`
--

DROP TABLE IF EXISTS `autoriza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autoriza` (
  `id_autoriza` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) DEFAULT NULL,
  `cargo` varchar(80) DEFAULT NULL,
  `id_delegacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_autoriza`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autoriza`
--

LOCK TABLES `autoriza` WRITE;
/*!40000 ALTER TABLE `autoriza` DISABLE KEYS */;
INSERT INTO `autoriza` VALUES (1,'JUAN PEDRO MERCADER RODRIGUEZ','DIRECTOR GENERAL',1);
/*!40000 ALTER TABLE `autoriza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bancos`
--

DROP TABLE IF EXISTS `bancos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bancos` (
  `id_banco` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_banco`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bancos`
--

LOCK TABLES `bancos` WRITE;
/*!40000 ALTER TABLE `bancos` DISABLE KEYS */;
INSERT INTO `bancos` VALUES (1,'BANORTE'),(2,'HSBC');
/*!40000 ALTER TABLE `bancos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benef`
--

DROP TABLE IF EXISTS `benef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `benef` (
  `id_benef` int(11) NOT NULL AUTO_INCREMENT,
  `clave_elect` varchar(18) DEFAULT NULL,
  `curp` varchar(20) DEFAULT NULL,
  `clave_b` varchar(12) DEFAULT NULL,
  `nombre` varchar(80) DEFAULT NULL,
  `condonado` tinyint(4) DEFAULT NULL,
  `fecha_af` date DEFAULT NULL,
  `poliza` varchar(4) DEFAULT NULL,
  `fecha_pol` date DEFAULT NULL,
  `fecha_ip` date DEFAULT NULL,
  `fecha_cont` date DEFAULT NULL,
  `ref_cont` varchar(15) DEFAULT NULL,
  `sal_min` decimal(9,3) DEFAULT NULL,
  `cap_fon` decimal(9,3) DEFAULT NULL,
  `cap_inv` decimal(9,3) DEFAULT NULL,
  `fecha_can` date DEFAULT NULL,
  `pagant` decimal(9,2) DEFAULT NULL,
  `capital` decimal(10,3) DEFAULT NULL,
  `sub_inic` decimal(9,3) DEFAULT NULL,
  `enganche` decimal(9,3) DEFAULT NULL,
  `interes` decimal(9,3) DEFAULT NULL,
  `admon` decimal(7,2) DEFAULT NULL,
  `o_seg` decimal(9,3) DEFAULT NULL,
  `plazo` int(11) DEFAULT NULL,
  `pago_mes` decimal(9,3) DEFAULT NULL,
  `adm_seg` decimal(9,3) DEFAULT NULL,
  `estatus` char(1) DEFAULT NULL,
  `ref_estatus` varchar(12) DEFAULT NULL,
  `fecha_estatus` date DEFAULT NULL,
  `costo_m2` decimal(9,3) DEFAULT NULL,
  `clave_cat` varchar(20) DEFAULT NULL,
  `domicilio` varchar(50) DEFAULT NULL,
  `id_tipocredito` int(11) DEFAULT NULL,
  `fecha_condonacion` date DEFAULT NULL,
  `ref_condonacion` varchar(15) DEFAULT NULL,
  `convenio` tinyint(4) DEFAULT NULL,
  `fecha_convenio` date DEFAULT NULL,
  `saldo` decimal(13,2) DEFAULT NULL,
  `id_catprog` int(11) DEFAULT NULL,
  `id_delegacion` int(11) DEFAULT NULL,
  `fecha_if` date DEFAULT NULL,
  `validado` tinyint(4) DEFAULT NULL,
  `engacubrir` decimal(13,2) DEFAULT NULL,
  `tabla_comer` tinyint(4) DEFAULT NULL,
  `fecha_tabcomer` date DEFAULT NULL,
  `id_colonia` int(11) DEFAULT NULL,
  `id_localidad` int(11) DEFAULT NULL,
  `rap` varchar(11) DEFAULT NULL,
  `fecha_rap` date DEFAULT NULL,
  `id_banco` int(11) DEFAULT NULL,
  `sub_inf` decimal(9,3) DEFAULT NULL,
  `por_eng` int(11) DEFAULT NULL,
  `seguro` decimal(9,3) DEFAULT NULL,
  `notificado` varchar(1) DEFAULT NULL,
  `fecha_notif` date DEFAULT NULL,
  `turnado_aseg` varchar(1) DEFAULT NULL,
  `fecha_taseg` date DEFAULT NULL,
  `ref_taseg` varchar(12) DEFAULT NULL,
  `dsolid` varchar(50) DEFAULT NULL,
  `domicilio_dsolid` varchar(50) DEFAULT NULL,
  `conyuge` varchar(60) DEFAULT NULL,
  `juridico` varchar(1) DEFAULT NULL,
  `finado` varchar(1) DEFAULT NULL,
  `nombrecesion` varchar(70) DEFAULT NULL,
  `fecha_cesion` date DEFAULT NULL,
  `numcontrato` varchar(5) DEFAULT NULL,
  `rfc` varchar(13) DEFAULT NULL,
  `mza` varchar(3) DEFAULT NULL,
  `lte` varchar(6) DEFAULT NULL,
  `area` decimal(9,2) DEFAULT NULL,
  PRIMARY KEY (`id_benef`)
) ENGINE=MyISAM AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benef`
--

LOCK TABLES `benef` WRITE;
/*!40000 ALTER TABLE `benef` DISABLE KEYS */;
INSERT INTO `benef` VALUES (51,'FJKDKNVKNMNDKNNFNF','FJJDKJFJJFJFJFJJFJ','PROD10-00003','RAFA',NULL,NULL,'D001','2013-05-22','2013-05-22','2013-05-02',NULL,NULL,NULL,NULL,NULL,'100.00','1000.000','0.000','200.000','0.000','0.00','0.000',12,'0.000','0.000',NULL,NULL,NULL,'10.000','','CONOCIDO',NULL,NULL,NULL,NULL,NULL,NULL,71,NULL,'2013-05-22',NULL,'200.00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.000',20,'0.000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'VERO','',NULL,NULL,NULL,'00003','','001','001','100.00'),(52,'XXXXXXXXXXXXXXXXXX','DVDKFJFJJDKJFKJJFF','NUGD19-00046','AMARO TORRES MIGUEL',NULL,NULL,'D002','2012-02-08','2012-02-15','2012-01-23',NULL,NULL,NULL,NULL,NULL,'0.00','0.000','80000.000','0.000','0.000','0.00','0.000',0,'0.000','0.000',NULL,NULL,NULL,'1000.000','','C.2 AGUADAS 6-A/CHICOZAPOTE Y10',NULL,NULL,NULL,NULL,NULL,NULL,76,NULL,'2012-01-23',NULL,'24000.00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.000',0,'0.000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,'00046','','085','005','160.00');
/*!40000 ALTER TABLE `benef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benef_div`
--

DROP TABLE IF EXISTS `benef_div`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `benef_div` (
  `id_bendiv` int(11) NOT NULL AUTO_INCREMENT,
  `clave_elect` varchar(18) DEFAULT NULL,
  `curp` varchar(20) DEFAULT NULL,
  `clave_b` varchar(12) DEFAULT NULL,
  `nombre` varchar(80) DEFAULT NULL,
  `fecha_con` date DEFAULT NULL,
  `capital` decimal(10,2) DEFAULT NULL,
  `sub_inic` decimal(10,2) DEFAULT NULL,
  `enganche` decimal(10,2) DEFAULT NULL,
  `interes` decimal(10,2) DEFAULT NULL,
  `admon` decimal(10,2) DEFAULT NULL,
  `seguro` decimal(10,2) DEFAULT NULL,
  `o_seg` decimal(10,2) DEFAULT NULL,
  `plazo` int(11) DEFAULT NULL,
  `pago_mes` decimal(10,2) DEFAULT NULL,
  `sal_con` decimal(10,2) DEFAULT NULL,
  `juridico` char(1) DEFAULT NULL,
  `referencia_jur` varchar(14) DEFAULT NULL,
  `fecha_jur` date DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_catprog` int(11) DEFAULT NULL,
  `mza` varchar(3) DEFAULT NULL,
  `lte` varchar(6) DEFAULT NULL,
  `conyuge` varchar(30) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id_bendiv`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benef_div`
--

LOCK TABLES `benef_div` WRITE;
/*!40000 ALTER TABLE `benef_div` DISABLE KEYS */;
INSERT INTO `benef_div` VALUES (1,'MICLAVEELECT','MICURP','PROD10-00003','RAFAEL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'002','010',NULL,NULL),(2,'2DOELECT','MI2DOCURP','NUGD19-00046',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'085','005',NULL,NULL);
/*!40000 ALTER TABLE `benef_div` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bonific`
--

DROP TABLE IF EXISTS `bonific`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bonific` (
  `id_bonificacion` int(11) NOT NULL DEFAULT '0',
  `id_movedoscta` int(11) DEFAULT NULL,
  `id_benef` int(11) DEFAULT NULL,
  `imp_cap` decimal(11,3) DEFAULT NULL,
  `imp_int` decimal(11,3) DEFAULT NULL,
  `imp_adm` decimal(11,3) DEFAULT NULL,
  `imp_seg` decimal(11,3) DEFAULT NULL,
  `imp_osg` decimal(11,3) DEFAULT NULL,
  `id_catbonific` int(11) DEFAULT NULL,
  `estatus` char(1) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_autoriza` int(11) DEFAULT NULL,
  `clave_b` varchar(12) DEFAULT NULL,
  `recibo` int(11) DEFAULT NULL,
  `serie` char(1) DEFAULT NULL,
  `id_movdiversos` int(11) DEFAULT NULL,
  `numcontrato` varchar(5) DEFAULT NULL,
  `id_catprog` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_bonificacion`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bonific`
--

LOCK TABLES `bonific` WRITE;
/*!40000 ALTER TABLE `bonific` DISABLE KEYS */;
INSERT INTO `bonific` VALUES (0,NULL,NULL,'50.000','0.000','0.000','0.000','0.000',9,'A',NULL,NULL,'PROD10-00003',1,'A',NULL,'00003',71);
/*!40000 ALTER TABLE `bonific` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cajas`
--

DROP TABLE IF EXISTS `cajas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cajas` (
  `id_caja` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `folio_inicial` int(11) DEFAULT NULL,
  `folio_final` int(11) DEFAULT NULL,
  `poliza` varchar(4) DEFAULT NULL,
  `monto_inicial` decimal(12,2) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_caja`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cajas`
--

LOCK TABLES `cajas` WRITE;
/*!40000 ALTER TABLE `cajas` DISABLE KEYS */;
INSERT INTO `cajas` VALUES (18,'2013-08-12',50,0,'I050','20.00',1),(23,'2013-08-19',1,0,'I001','10.00',1),(20,'2013-08-13',1,0,'I001','50.00',2),(16,'2013-08-13',1,0,'I008','50.00',1),(22,'2013-08-14',1,0,'I005','0.00',1),(24,'2013-08-20',50,0,'I050','50.00',1),(25,'2013-08-21',5,0,'I005','0.00',1),(26,'2013-08-22',1,0,'I000','9999.99',1),(28,'2013-08-23',100,105,'I000','5554800.00',1);
/*!40000 ALTER TABLE `cajas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidatos`
--

DROP TABLE IF EXISTS `candidatos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidatos` (
  `id_candidato` int(11) NOT NULL AUTO_INCREMENT,
  `id_catprog` int(11) DEFAULT NULL,
  `numcontrato` varchar(5) DEFAULT NULL,
  `clave_elect` varchar(18) DEFAULT NULL,
  `curp` varchar(20) DEFAULT NULL,
  `rfc` varchar(13) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `conyuge` varchar(50) DEFAULT NULL,
  `capital` decimal(10,3) DEFAULT NULL,
  `sub_inic` decimal(9,3) DEFAULT NULL,
  `enganche` decimal(9,3) DEFAULT NULL,
  `interes` decimal(9,3) DEFAULT NULL,
  `admon` decimal(7,2) DEFAULT NULL,
  `o_seg` decimal(9,3) DEFAULT NULL,
  `sub_inf` decimal(9,3) DEFAULT NULL,
  `por_eng` int(11) DEFAULT NULL,
  `fecha_cont` date DEFAULT NULL,
  `mza` varchar(3) DEFAULT NULL,
  `lte` varchar(6) DEFAULT NULL,
  `area` decimal(9,2) DEFAULT NULL,
  `clave_cat` varchar(20) DEFAULT NULL,
  `domicilio` varchar(50) DEFAULT NULL,
  `fecha_con` date DEFAULT NULL,
  `poliza` varchar(4) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `fecha_pol` date DEFAULT NULL,
  `pagant` decimal(9,2) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `ref_cont` varchar(15) DEFAULT NULL,
  `seguro` decimal(9,3) DEFAULT NULL,
  `plazo` int(11) DEFAULT NULL,
  `pago_mes` decimal(9,3) DEFAULT NULL,
  `adm_seg` decimal(9,3) DEFAULT NULL,
  `costo_m2` decimal(9,3) DEFAULT NULL,
  `id_tipocredito` int(11) DEFAULT NULL,
  `fecha_if` date DEFAULT NULL,
  `validado` tinyint(4) DEFAULT NULL,
  `engacubrir` decimal(13,2) DEFAULT NULL,
  `dsolid` varchar(50) DEFAULT NULL,
  `domicilio_dsolid` varchar(50) DEFAULT NULL,
  `fecha_ip` date DEFAULT NULL,
  `clave_b` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id_candidato`)
) ENGINE=MyISAM AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidatos`
--

LOCK TABLES `candidatos` WRITE;
/*!40000 ALTER TABLE `candidatos` DISABLE KEYS */;
INSERT INTO `candidatos` VALUES (64,71,'00004','FJIEJIRJRJEIJJIEJF','JFIEJJFJIJEIFJIEJIJF','','VERO','RAFA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-02','010','001','180.00','','CONOCIDO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2013-05-30','PROD10-00004');
/*!40000 ALTER TABLE `candidatos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat_bonific`
--

DROP TABLE IF EXISTS `cat_bonific`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cat_bonific` (
  `id_bonific` int(11) NOT NULL AUTO_INCREMENT,
  `clave_bonific` varchar(5) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_bonific`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_bonific`
--

LOCK TABLES `cat_bonific` WRITE;
/*!40000 ALTER TABLE `cat_bonific` DISABLE KEYS */;
INSERT INTO `cat_bonific` VALUES (11,'BON01','BONIFICACION NUMERO 1'),(12,'BON03','BONIFICACION 03'),(9,'BON02','BONIFICACION DOS');
/*!40000 ALTER TABLE `cat_bonific` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat_emisores`
--

DROP TABLE IF EXISTS `cat_emisores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cat_emisores` (
  `id_emisor` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_emisor`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_emisores`
--

LOCK TABLES `cat_emisores` WRITE;
/*!40000 ALTER TABLE `cat_emisores` DISABLE KEYS */;
/*!40000 ALTER TABLE `cat_emisores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat_prog`
--

DROP TABLE IF EXISTS `cat_prog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cat_prog` (
  `id_catprog` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(6) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  `sub_ini` decimal(9,3) DEFAULT NULL,
  `eng_fon` decimal(9,3) DEFAULT NULL,
  `eng_inv` decimal(9,3) DEFAULT NULL,
  `interes` decimal(9,3) DEFAULT NULL,
  `admon` decimal(9,3) DEFAULT NULL,
  `seguro` decimal(9,3) DEFAULT NULL,
  `costo_m2` decimal(9,3) DEFAULT NULL,
  `por_sub` decimal(6,2) DEFAULT NULL,
  `por_admon` decimal(6,2) DEFAULT NULL,
  `por_sv` decimal(6,2) DEFAULT NULL,
  `por_os` decimal(6,2) DEFAULT NULL,
  `sal_min` decimal(9,3) DEFAULT NULL,
  `pago_mes` decimal(9,3) DEFAULT NULL,
  `por_eng` decimal(6,2) DEFAULT NULL,
  `anual` decimal(9,2) DEFAULT NULL,
  `plazo` int(11) DEFAULT NULL,
  `por_cap` decimal(6,2) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `mecanica` int(11) DEFAULT NULL,
  `id_del` int(11) DEFAULT NULL,
  `id_tipocred` int(11) DEFAULT NULL,
  `mensual` decimal(10,3) DEFAULT NULL,
  `sub_bp` decimal(9,3) DEFAULT NULL,
  `apor_fij` decimal(9,3) DEFAULT NULL,
  `por_pm` decimal(9,3) DEFAULT NULL,
  `por_pf` decimal(6,2) DEFAULT NULL,
  `clave_ant` varchar(6) DEFAULT NULL,
  `id_colonia` int(11) DEFAULT NULL,
  `dias_gracia` int(11) DEFAULT NULL,
  `mora` tinyint(4) DEFAULT NULL,
  `por_ga` decimal(6,2) DEFAULT NULL,
  `cuenta_cont` varchar(50) DEFAULT NULL,
  `id_delegacion` int(11) DEFAULT NULL,
  `id_modulo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_catprog`)
) ENGINE=MyISAM AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_prog`
--

LOCK TABLES `cat_prog` WRITE;
/*!40000 ALTER TABLE `cat_prog` DISABLE KEYS */;
INSERT INTO `cat_prog` VALUES (63,'PROD18','PROTERRITORIO COMERCIAL 18 MESES','0.000','0.000','0.000','0.000','0.000','0.000','0.000','0.00','0.00','0.00','0.00','0.000','150.000','30.00',NULL,NULL,NULL,NULL,29,1,NULL,NULL,'0.000',NULL,NULL,NULL,NULL,4,NULL,1,'0.00',NULL,NULL,NULL),(64,'R59D10','REGION 59 10 MESES','0.000','0.000','0.000','0.000','0.000','50.000','50.000','50.00','50.00','50.00','50.00','0.000','0.000','0.00','0.00',0,'15.00',1,29,3,NULL,NULL,'0.000',NULL,NULL,NULL,NULL,4,NULL,1,'0.00',NULL,NULL,NULL),(67,'PROD15','PROTERRITORIO 15 MESES','0.000','0.000','0.000','0.000','0.000','0.000','0.000','0.00','0.00','0.00','0.00','0.000','0.000','0.00','1500.00',12,NULL,NULL,29,1,NULL,NULL,'0.000',NULL,NULL,NULL,NULL,4,NULL,1,'0.00',NULL,NULL,NULL),(68,'PROD20','PROTERRITORIO 20 MESES','0.000','0.000','0.000','0.000','0.000','0.000','0.000','0.00','0.00','0.00','0.00','0.000','0.000','0.00','0.00',12,NULL,NULL,29,1,NULL,NULL,'0.000',NULL,NULL,NULL,NULL,6,NULL,1,'0.00',NULL,NULL,NULL),(71,'PROD10','PROTERRITORIO 10 MESES','0.000','0.000','0.000','0.000','0.000','0.000','0.000','0.00','0.00','0.00','0.00','0.000','0.000','0.00','0.00',12,'0.00',1,29,1,NULL,NULL,'0.000',NULL,NULL,NULL,NULL,4,NULL,1,'0.00',NULL,NULL,NULL),(72,'SOLD10','SOLIDARIDAD COMERCIAL 10 MESES','0.000','0.000','0.000','0.000','0.000','0.000','0.000','0.00','0.00','0.00','0.00','0.000','0.000','0.00','0.00',12,NULL,1,29,1,NULL,NULL,'0.000',NULL,NULL,NULL,NULL,6,NULL,1,'0.00',NULL,NULL,NULL),(76,'NUGD19','NUEVA GENERACION COMERCIAL','0.000','0.000','0.000','15.000','0.000','0.000','0.000','0.00','0.00','0.00','0.00','0.000','0.000','30.00','0.00',18,'0.00',1,29,1,NULL,NULL,'0.000',NULL,NULL,NULL,NULL,12,NULL,1,'0.00',NULL,NULL,NULL);
/*!40000 ALTER TABLE `cat_prog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clave_div`
--

DROP TABLE IF EXISTS `clave_div`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clave_div` (
  `id_clave_div` int(11) NOT NULL AUTO_INCREMENT,
  `clave_div` varchar(3) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `importe` decimal(8,2) DEFAULT NULL,
  `cuenta_cont` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_clave_div`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clave_div`
--

LOCK TABLES `clave_div` WRITE;
/*!40000 ALTER TABLE `clave_div` DISABLE KEYS */;
INSERT INTO `clave_div` VALUES (1,'E02','ENGANCHE','0.00',NULL),(2,'E05','E CERRO CINCO','50.00',NULL),(3,'E06','E CERO SEIS','0.00',NULL),(4,'E07','CERO SIETE','0.00',NULL),(7,'E20','E VEINTE','5.35',NULL);
/*!40000 ALTER TABLE `clave_div` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clave_mov`
--

DROP TABLE IF EXISTS `clave_mov`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clave_mov` (
  `id_clave_mov` int(11) NOT NULL AUTO_INCREMENT,
  `clave_mov` varchar(3) DEFAULT NULL,
  `descripcion` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_clave_mov`)
) ENGINE=MyISAM AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clave_mov`
--

LOCK TABLES `clave_mov` WRITE;
/*!40000 ALTER TABLE `clave_mov` DISABLE KEYS */;
INSERT INTO `clave_mov` VALUES (21,'CAP','CAPITAL'),(39,'ENG','ENGANCHE'),(40,'PAG','PAGOS ANTICIPADOS'),(41,'SUI','SUBSIDIO INICIAL'),(46,'001','MENSUALIDAD 01'),(43,'CAN','CANCELADO'),(44,'RES','REESTRUCTURADO'),(45,'CON','CONDONADO'),(47,'002','MENSUALIDAD 02'),(48,'003','MENSUALIDAD 03');
/*!40000 ALTER TABLE `clave_mov` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colonias`
--

DROP TABLE IF EXISTS `colonias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colonias` (
  `id_colonia` int(11) NOT NULL AUTO_INCREMENT,
  `id_delegacion` int(11) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_colonia`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colonias`
--

LOCK TABLES `colonias` WRITE;
/*!40000 ALTER TABLE `colonias` DISABLE KEYS */;
INSERT INTO `colonias` VALUES (4,1,'COLONIA PROTERRITORIO'),(12,1,'NUEVA GENERACION');
/*!40000 ALTER TABLE `colonias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cpp`
--

DROP TABLE IF EXISTS `cpp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cpp` (
  `id_cpp` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `importe` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_cpp`)
) ENGINE=MyISAM AUTO_INCREMENT=170 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpp`
--

LOCK TABLES `cpp` WRITE;
/*!40000 ALTER TABLE `cpp` DISABLE KEYS */;
INSERT INTO `cpp` VALUES (149,'2011-11-05','3.35'),(150,'2011-12-05','3.32'),(151,'2012-01-05','3.26'),(152,'2012-02-05','3.23'),(153,'2012-03-05','3.26'),(154,'2012-04-05','3.26'),(155,'2012-05-05','3.28'),(156,'2012-06-05','3.25'),(157,'2012-07-05','3.24'),(158,'2012-08-05','3.22'),(159,'2012-09-05','3.22'),(160,'2012-10-05','3.26'),(161,'2012-11-05','3.28'),(162,'2012-12-05','3.30'),(163,'2013-01-05','3.25'),(164,'2013-02-05','3.24'),(165,'2013-03-05','3.29'),(166,'2013-04-05','3.18'),(167,'2013-05-05','3.03'),(168,'2013-06-05','2.99'),(169,'2013-07-05','2.97');
/*!40000 ALTER TABLE `cpp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delegaciones`
--

DROP TABLE IF EXISTS `delegaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delegaciones` (
  `id_delegacion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  `direccion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_delegacion`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delegaciones`
--

LOCK TABLES `delegaciones` WRITE;
/*!40000 ALTER TABLE `delegaciones` DISABLE KEYS */;
INSERT INTO `delegaciones` VALUES (1,'OFICINAS CENTRALES',NULL),(2,'OFICINA EN BENITO JUAREZ',NULL),(3,'OFICINA EN OTHON P. BLANCO',NULL);
/*!40000 ALTER TABLE `delegaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `firmantes`
--

DROP TABLE IF EXISTS `firmantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `firmantes` (
  `id_firmante` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) DEFAULT NULL,
  `cargo` varchar(80) DEFAULT NULL,
  `firma` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_firmante`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `firmantes`
--

LOCK TABLES `firmantes` WRITE;
/*!40000 ALTER TABLE `firmantes` DISABLE KEYS */;
/*!40000 ALTER TABLE `firmantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidades`
--

DROP TABLE IF EXISTS `localidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localidades` (
  `id_localidad` int(11) NOT NULL AUTO_INCREMENT,
  `id_delegacion` int(11) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_localidad`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidades`
--

LOCK TABLES `localidades` WRITE;
/*!40000 ALTER TABLE `localidades` DISABLE KEYS */;
/*!40000 ALTER TABLE `localidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mecanica`
--

DROP TABLE IF EXISTS `mecanica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mecanica` (
  `id_mecanica` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id_mecanica`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mecanica`
--

LOCK TABLES `mecanica` WRITE;
/*!40000 ALTER TABLE `mecanica` DISABLE KEYS */;
INSERT INTO `mecanica` VALUES (1,'29'),(2,'10');
/*!40000 ALTER TABLE `mecanica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulos_recaudacion`
--

DROP TABLE IF EXISTS `modulos_recaudacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modulos_recaudacion` (
  `id_modulo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  `direccion` varchar(80) DEFAULT NULL,
  `id_delegacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_modulo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulos_recaudacion`
--

LOCK TABLES `modulos_recaudacion` WRITE;
/*!40000 ALTER TABLE `modulos_recaudacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `modulos_recaudacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mov_diversos`
--

DROP TABLE IF EXISTS `mov_diversos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mov_diversos` (
  `id_movdiversos` int(11) NOT NULL AUTO_INCREMENT,
  `id_bendiv` int(11) DEFAULT NULL,
  `clave_div` varchar(3) DEFAULT NULL,
  `fecha_div` date DEFAULT NULL,
  `poliza` varchar(4) DEFAULT NULL,
  `recibo` int(11) DEFAULT NULL,
  `cargo` decimal(12,2) DEFAULT NULL,
  `abono` decimal(12,2) DEFAULT NULL,
  `moratorios` decimal(12,2) DEFAULT NULL,
  `otros` decimal(12,2) DEFAULT NULL,
  `fecha_pol` date DEFAULT NULL,
  `estatus` char(1) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `aplicado` tinyint(4) DEFAULT NULL,
  `descripcion` varchar(120) DEFAULT NULL,
  `id_catprog` int(11) DEFAULT NULL,
  `bonificacion` decimal(12,2) DEFAULT NULL,
  `serie` char(1) DEFAULT NULL,
  `poliza_apli` varchar(4) DEFAULT NULL,
  `fecha_apli` date DEFAULT NULL,
  `interes` decimal(12,2) DEFAULT NULL,
  `seguro` decimal(12,2) DEFAULT NULL,
  `id_emisor` int(11) DEFAULT NULL,
  `clave_b` varchar(12) DEFAULT NULL,
  `numcontrato` varchar(5) DEFAULT NULL,
  `id_caja` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_movdiversos`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mov_diversos`
--

LOCK TABLES `mov_diversos` WRITE;
/*!40000 ALTER TABLE `mov_diversos` DISABLE KEYS */;
INSERT INTO `mov_diversos` VALUES (3,NULL,'E02','2013-05-20','I020',1,'0.00','100.99','10.00','0.00','2013-05-10','B',NULL,0,'RECIBO #1 JKJKHKJHKHJJKBBKJBKJHKJHKJHJHJKJKHJHJHJHJHJHJHJHJHJHJKHKJHHJKHJKHJKHKJH J       ',NULL,NULL,'A','D001',NULL,NULL,NULL,NULL,'PROD10-00003',NULL,16),(4,NULL,'E02','2013-05-20','I020',2,'0.00','200.00','0.00','0.00','2013-05-22','A',NULL,0,'RECIBO #2 ',NULL,NULL,'A','D001',NULL,NULL,NULL,NULL,'PROD10-00003',NULL,NULL),(22,NULL,'E02','1980-01-01','I000',0,'300.00','0.00','0.00','0.00','2013-05-22','A',NULL,1,'    ',71,NULL,NULL,'D001',NULL,NULL,NULL,NULL,'PROD10-00003','00003',NULL),(25,NULL,'E02','2012-01-23','D002',5,NULL,'24000.00',NULL,NULL,'2012-02-08','A',NULL,1,'PAGO DE ENGANCHE',NULL,NULL,'A',NULL,NULL,NULL,NULL,NULL,'NUGD19-00046',NULL,NULL),(26,NULL,NULL,NULL,'D002',NULL,'24000.00',NULL,NULL,NULL,'2012-02-08',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'NUGD19-00046',NULL,NULL);
/*!40000 ALTER TABLE `mov_diversos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mov_edoscta`
--

DROP TABLE IF EXISTS `mov_edoscta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mov_edoscta` (
  `id_movedoscta` int(11) NOT NULL AUTO_INCREMENT,
  `id_benef` int(11) DEFAULT NULL,
  `capital` decimal(11,3) DEFAULT NULL,
  `interes` decimal(11,3) DEFAULT NULL,
  `admon` decimal(11,3) DEFAULT NULL,
  `seguro` decimal(11,3) DEFAULT NULL,
  `clave_mov` varchar(3) DEFAULT NULL,
  `poliza` varchar(4) DEFAULT NULL,
  `fecha_mov` date DEFAULT NULL,
  `recibo` int(11) DEFAULT NULL,
  `o_seg` decimal(11,3) DEFAULT NULL,
  `moratorios` decimal(11,3) DEFAULT NULL,
  `estatus` char(1) DEFAULT NULL,
  `otrosm` decimal(11,3) DEFAULT NULL,
  `com_fona` decimal(11,3) DEFAULT NULL,
  `com_info` decimal(11,3) DEFAULT NULL,
  `fecha_pol` date DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `prepago` char(1) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `id_bonific` int(11) DEFAULT NULL,
  `comisiones` decimal(11,3) DEFAULT NULL,
  `serie` char(1) DEFAULT NULL,
  `puntual` tinyint(4) DEFAULT NULL,
  `clave_b` varchar(12) DEFAULT NULL,
  `tit` decimal(11,3) DEFAULT NULL,
  `id_catprog` int(11) DEFAULT NULL,
  `numcontrato` varchar(5) DEFAULT NULL,
  `id_caja` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_movedoscta`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mov_edoscta`
--

LOCK TABLES `mov_edoscta` WRITE;
/*!40000 ALTER TABLE `mov_edoscta` DISABLE KEYS */;
INSERT INTO `mov_edoscta` VALUES (3,51,'1000.000','0.000','0.000','0.000','CAP','D001','2013-05-22',0,'0.000','0.000','B',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.000','A',NULL,'PROD10-00003','0.000',71,'00003',NULL),(4,51,'250.000','0.000','0.000','0.000','ENG','D001','2013-05-22',0,'0.000','0.000','A',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.000','A',NULL,'PROD10-00003','0.000',71,'00003',NULL),(8,NULL,'100.000','0.000','0.000','0.000','001','I005','2013-06-26',1,'0.000','10.000','A',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.000','A',NULL,'PROD10-00003','0.000',71,'00003',NULL),(17,52,'160000.000',NULL,NULL,NULL,'CAP','D002','2012-02-08',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'NUGD19-00046',NULL,NULL,NULL,NULL),(18,52,'-24000.000',NULL,NULL,NULL,'ENG','D002','2012-02-08',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'NUGD19-00046',NULL,NULL,NULL,NULL),(19,52,'0.000',NULL,NULL,NULL,'PAG','D002','2012-02-08',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'NUGD19-00046',NULL,NULL,NULL,NULL),(20,52,'-80000.000',NULL,NULL,NULL,'SUI','D002','2012-02-08',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'NUGD19-00046',NULL,NULL,NULL,NULL),(21,NULL,'-3111.110','-536.667','0.000','0.000','001','I014','2012-03-14',2826,'0.000','-10.080','A',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.000','A',NULL,'NUGD19-00046','0.000',76,'00046',NULL),(22,NULL,'-3111.110','-639.074','0.000','0.000','002','I012','2012-06-12',3479,'0.000','-33.247','A',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.000','A',NULL,'NUGD19-00046','0.000',76,'00046',NULL);
/*!40000 ALTER TABLE `mov_edoscta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `niveles`
--

DROP TABLE IF EXISTS `niveles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `niveles` (
  `id_nivel` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_nivel`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `niveles`
--

LOCK TABLES `niveles` WRITE;
/*!40000 ALTER TABLE `niveles` DISABLE KEYS */;
INSERT INTO `niveles` VALUES (1,'SUPER ADMINISTRADOR'),(2,'ADMINISTRADOR DE DELEGACION'),(3,'CAJERO DE DELEGACION');
/*!40000 ALTER TABLE `niveles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salmin`
--

DROP TABLE IF EXISTS `salmin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salmin` (
  `id_salmin` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL COMMENT 'Campo que almacenara la fecha en que se registrará el salario mínimo',
  `importe` decimal(10,2) DEFAULT NULL COMMENT 'Campo para almacenar el importe del salario mínimo vigente',
  PRIMARY KEY (`id_salmin`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='Tabla que almacenará lo salarios minimos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salmin`
--

LOCK TABLES `salmin` WRITE;
/*!40000 ALTER TABLE `salmin` DISABLE KEYS */;
INSERT INTO `salmin` VALUES (1,'2012-08-28','34.34'),(2,'2012-09-01','1.00'),(3,'2012-09-17','100.50');
/*!40000 ALTER TABLE `salmin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_credito`
--

DROP TABLE IF EXISTS `tipo_credito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_credito` (
  `id_tipocredito` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_tipocredito`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_credito`
--

LOCK TABLES `tipo_credito` WRITE;
/*!40000 ALTER TABLE `tipo_credito` DISABLE KEYS */;
INSERT INTO `tipo_credito` VALUES (5,'LOTES HABITACIONALES'),(17,'LOTES COMERCIALES'),(12,'CREDITO DE MATERIALES'),(14,'LOTES DE RESERVA');
/*!40000 ALTER TABLE `tipo_credito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) DEFAULT NULL,
  `id_nivel` int(11) DEFAULT NULL,
  `direccion` varchar(80) DEFAULT NULL,
  `cargo` varchar(80) DEFAULT NULL,
  `id_del` int(11) DEFAULT NULL,
  `serie` char(1) DEFAULT NULL,
  `usuario` varchar(8) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Rafael M‚ndez Asencio',3,'Calle Fco. J. Mujica Col. Sta. Mar¡a','CAJERO',1,'A','RMENDEZ','VERONICA1972'),(2,'USUARIO',3,'','CAJERO',1,'B','USUARIO','USUARIO');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-01 14:37:52
