-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: bbdd
-- Tiempo de generación: 17-05-2022 a las 16:52:14
-- Versión del servidor: 8.0.27
-- Versión de PHP: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `clinica_db`
--

CREATE TABLE `Paciente` (
  `id` int NOT NULL PRIMARY KEY,
  `nombre` varchar(32) NOT NULL,
  `apellidos` varchar(64) NOT NULL,
  `telefono` varchar(13) NOT NULL,
  `email` varchar(128) NOT NULL,
  `dni` varchar(15) NOT NULL,
  `sFNac` DATE NOT NULL,

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Tratamiento` (
  `id_tratamiento` int NOT NULL PRIMARY KEY,
  `id_paciente` int NOT NULL,
  `fecha` DATE NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `coste` DECIMAL(13, 2) NOT NULL,
  
    FOREIGN KEY (id_paciente) REFERENCES Paciente(id)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `Implante` (
  `id_implante` int NOT NULL PRIMARY KEY,
  `id_paciente` int NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `fecha` DATE NOT NULL,
  `tipo_implante` varchar(50) NOT NULL,
  `coste` DECIMAL(13, 2) NOT NULL,
  `bcobrado` BOOLEAN,

    FOREIGN KEY (id_paciente) REFERENCES Paciente(id)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `Clinica` (
  `id_clinica` int NOT NULL PRIMARY KEY,
  `nombre` VARCHAR(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` int NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `tipo_implante` varchar(50) NOT NULL,
  `cif` varchar(9) NOT NULL,

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



INSERT INTO `Paciente` (`id`, `nombre`, `apellidos`, `telefono`, `email`, `dni`, `sFNac`) VALUES
(1, 'Raul', 'Alvarez Valero', '+34 999999999', 'Raul@example.com', '99999999J', 'NoSeQueEs-sFNac'),
(2, 'Jose', 'Alvarez', '+34 888888888', 'Jose@example.com', '88888888J', 'NoSeQueEs-sFNac'),
(3, 'Adrian', 'No me acuerdo', '+34 777777777', 'Adrian@example.com', '77777777I', 'NoSeQueEs-sFNac');

INSERT INTO `Tratamiento` (`id_tratamiento`, `id_paciente`, `fecha`, `descripcion`, `coste` ) VALUES
(1, 1, '2023-04-27', 'Limpieza dental', 50.00),
(2, 2, '2023-02-15', 'Empaste dental', 160.00),
(3, 3, '2022-11-08', 'Ortodoncia', 2000.00);

INSERT INTO `Implante` ( `id_implante`, `id_paciente`, `descripcion`, `fecha`, `coste`, `bcobrado`) VALUES
(1, 1, 'Implante de molar', '2023-05-15', 1500.00, 0),
(2, 2, 'Implante de incisivo', '2023-06-20', 2000.00, 1),
(3, 3, 'Implante de premolar', '2023-07-10', 1800.00, 0);

INSERT INTO `Clinica` (`id_clinica`, `nombre`, `direccion`, `telefono`, `email`, `tipo_implante`, `cif`) VALUES 
(1, 'Clínica Umbrella', 'Calle Principal 123', 123456789, 'clinicadentalabc@example.com', 'Implantes Dentales', 'B12345678'),
(2, 'Clínica Juan Manuel Dominguez', 'Avenida Central 456', 987654321, 'clinicadentalxyz@example.com', 'Ortodoncia', 'A98765432'),
(3, 'Clínica Awooga', 'Plaza Principal 789', 555555555, 'clinicadental123@example.com', 'Implantes Dentales', 'C54321098');


--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `proveedores`
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

