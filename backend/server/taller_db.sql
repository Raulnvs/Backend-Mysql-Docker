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
-- Base de datos: `taller_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `pacientes` (
  `id` int NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `apellidos` varchar(64) NOT NULL,
  `telefono` varchar(13) NOT NULL,
  `email` varchar(128) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `sFNac` varchar(32) NOT NULL,

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `pacientes` (`id`, `nombre`, `apellidos`, `telefono`, `email`, `dni`, `sFNac`) VALUES
(1, 'Raul', 'Alvarez Valero', '+34 999999999', 'Raul@example.com', '99999999J', 'NoSeQueEs-sFNac'),
(2, 'Jose', 'Alvarez', '+34 888888888', 'Jose@example.com', '88888888J', 'NoSeQueEs-sFNac'),
(3, 'Adrian', 'No me acuerdo', '+34 777777777', 'Adrian@example.com', '77777777I', 'NoSeQueEs-sFNac');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
