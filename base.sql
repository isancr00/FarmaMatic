/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `farmacia` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `farmacia`;

CREATE TABLE IF NOT EXISTS `clientes` (
  `IdCLiente` int NOT NULL AUTO_INCREMENT,
  `NombreCliente` varchar(300) NOT NULL,
  `IdCopago` int NOT NULL,
  PRIMARY KEY (`IdCLiente`),
  KEY `FK_Copago` (`IdCopago`),
  CONSTRAINT `FK_Copago` FOREIGN KEY (`IdCopago`) REFERENCES `copagos` (`IdCopago`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`IdCLiente`, `NombreCliente`, `IdCopago`) VALUES
	(2, 'Paco Merme Lada', 1),
	(3, 'Jorge Iglesias ', 3),
	(4, 'Marta Salas Perez', 4),
	(5, 'Marta Diaz Toledo', 5);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `copagos` (
  `IdCopago` int NOT NULL AUTO_INCREMENT,
  `Porcentaje` int NOT NULL,
  PRIMARY KEY (`IdCopago`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40000 ALTER TABLE `copagos` DISABLE KEYS */;
INSERT INTO `copagos` (`IdCopago`, `Porcentaje`) VALUES
	(1, 100),
	(2, 50),
	(3, 15),
	(4, 0),
	(5, 0),
	(6, 100),
	(7, 50);
/*!40000 ALTER TABLE `copagos` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `empleados` (
  `IdEmpleado` int NOT NULL AUTO_INCREMENT,
  `NombreEmpleado` varchar(300) NOT NULL,
  `Usuario` varchar(100) NOT NULL,
  `Contrasenia` varchar(100) NOT NULL,
  `Telefono` int NOT NULL,
  `IdRol` int NOT NULL,
  PRIMARY KEY (`IdEmpleado`),
  KEY `FK_Rol2` (`IdRol`),
  CONSTRAINT `FK_Rol2` FOREIGN KEY (`IdRol`) REFERENCES `roles` (`IdRol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` (`IdEmpleado`, `NombreEmpleado`, `Usuario`, `Contrasenia`, `Telefono`, `IdRol`) VALUES
	(1, 'Manolo Diaz Perez', 'mdiazP', 'Manolo73', 654321234, 1),
	(2, 'Administrador', 'admin', 'admin', 123456789, 3),
	(3, 'Rosaura Gonzalez Marcos', 'rosauraGM', 'RosauraG00', 643214567, 2),
	(4, 'Maria Lo Perez', 'mlop', 'lalo', 654248725, 2);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `menus` (
  `idMenu` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `url` varchar(100) NOT NULL,
  `idRol` int NOT NULL,
  PRIMARY KEY (`idMenu`),
  KEY `idRol` (`idRol`),
  CONSTRAINT `FK__roles` FOREIGN KEY (`idRol`) REFERENCES `roles` (`IdRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40000 ALTER TABLE `menus` DISABLE KEYS */;
INSERT INTO `menus` (`idMenu`, `nombre`, `url`, `idRol`) VALUES
	(1, 'Empleados', '/privado/administrador/empleados.xhtml', 3),
	(2, 'Clientes', '/privado/clientes.xhtml', 3),
	(3, 'Productos', '/privado/productos.xhtml', 3),
	(4, 'Clientes', '/privado/clientes.xhtml', 1),
	(5, 'Productos', '/privado/productos.xhtml', 1),
	(6, 'Dispensación', '/privado/dispensacion.xhtml', 1),
	(8, 'Clientes', '/privado/clientes.xhtml', 2),
	(9, 'Productos', '/privado/trabajador/productos.xhtml', 2),
	(10, 'Dispensación', '/privado/dispensacion.xhtml', 2);
/*!40000 ALTER TABLE `menus` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `productos` (
  `IdProducto` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Caducidad` date NOT NULL,
  `Descripcion` varchar(300) NOT NULL,
  `PVP` float NOT NULL DEFAULT '0',
  `IVA` int NOT NULL,
  `Subvencionada` bit(1) NOT NULL,
  `IdProoveedor` int NOT NULL,
  `IdVenta` int DEFAULT NULL,
  PRIMARY KEY (`IdProducto`),
  KEY `FK_Prooveedor2` (`IdProoveedor`),
  KEY `Índice 3` (`IdProducto`),
  KEY `FK_productos_ventas` (`IdVenta`),
  CONSTRAINT `FK_productos_ventas` FOREIGN KEY (`IdVenta`) REFERENCES `ventas` (`IdVenta`),
  CONSTRAINT `FK_Prooveedor2` FOREIGN KEY (`IdProoveedor`) REFERENCES `prooveedores` (`IdProoveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` (`IdProducto`, `Nombre`, `Caducidad`, `Descripcion`, `PVP`, `IVA`, `Subvencionada`, `IdProoveedor`, `IdVenta`) VALUES
	(2, 'Dalsy', '2022-11-11', 'Dalsy naranja', 3.5, 5, b'1', 7, NULL),
	(4, 'Dalsy', '2022-11-11', 'Dalsy naranja', 3.5, 5, b'1', 9, NULL);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `prooveedores` (
  `IdProoveedor` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`IdProoveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40000 ALTER TABLE `prooveedores` DISABLE KEYS */;
INSERT INTO `prooveedores` (`IdProoveedor`, `Nombre`) VALUES
	(1, 'FarmaNorte'),
	(2, 'FarmaPlus Distribuidor'),
	(6, 'FarmaNorte'),
	(7, 'FarmaPlus Distribuidor'),
	(8, 'FarmaPlus Distribuidor'),
	(9, 'FarmaPlus Distribuidor');
/*!40000 ALTER TABLE `prooveedores` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `roles` (
  `IdRol` int NOT NULL AUTO_INCREMENT,
  `NombreRol` varchar(100) NOT NULL,
  PRIMARY KEY (`IdRol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`IdRol`, `NombreRol`) VALUES
	(1, 'Farmaceutico'),
	(2, 'Trabajador'),
	(3, 'Admin');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `ventas` (
  `IdVenta` int NOT NULL AUTO_INCREMENT,
  `FechaVenta` datetime NOT NULL,
  `Importe` float NOT NULL,
  `IdEmpleado` int NOT NULL,
  `IdCliente` int NOT NULL,
  PRIMARY KEY (`IdVenta`),
  KEY `FK_Empleado` (`IdEmpleado`),
  KEY `FK_Cliente` (`IdCliente`),
  CONSTRAINT `FK_Cliente` FOREIGN KEY (`IdCliente`) REFERENCES `clientes` (`IdCLiente`),
  CONSTRAINT `FK_Empleado` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleados` (`IdEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
