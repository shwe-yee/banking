/*
SQLyog Community v9.63 
MySQL - 5.1.41 : Database - bankinfo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bankinfo` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bankinfo`;

/*Table structure for table `customeraccount` */

DROP TABLE IF EXISTS `customeraccount`;

CREATE TABLE `customeraccount` (
  `AccNo` int(11) DEFAULT NULL,
  `AccName` tinytext,
  `NRC` tinytext,
  `Address` tinytext,
  `AccType` tinytext,
  `SavingType` tinytext,
  `InitialAmount` int(11) DEFAULT NULL,
  KEY `AccNo` (`AccNo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `customeraccount` */

insert  into `customeraccount`(`AccNo`,`AccName`,`NRC`,`Address`,`AccType`,`SavingType`,`InitialAmount`) values (1,'U Mya','12/SaKhaNa(N)212121','No.12\nMingalar Street,\nSanchaung Tsp, Yangon	','Individual','Current',150000),(2,'U Hla','14/PaKha(N)123789','Bago Road,\nBago	','Individual','Current',280000),(3,'Daw Aye','7/PhaMaNa(N)456789','No.4, Main Road\nTaungGyi','Joint','Fixed',3000000),(4,'Ma Ma','7/MLM(N)654789','100,20th street,\nMawLaMyaing	','Individual','Fixed',300000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
