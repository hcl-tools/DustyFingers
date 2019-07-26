-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 26, 2019 at 05:16 AM
-- Server version: 5.7.26-0ubuntu0.18.04.1
-- PHP Version: 7.2.19-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `car_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `audit`
--

CREATE TABLE `audit` (
  `audit_id` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `date_created` date DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `car_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `audit`
--

INSERT INTO `audit` (`audit_id`, `created_by`, `date_created`, `deleted`, `description`, `car_id`) VALUES
(1, 'admin', '2019-06-03', NULL, 'good condition', 1),
(2, 'admin', '2019-06-03', NULL, 'good condition', 2),
(3, 'admin', '2019-07-24', NULL, 'Health Check', 1),
(4, 'admin', '2019-07-21', NULL, 'Health Check', 2);

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `car_id` int(11) NOT NULL,
  `car_type` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `engine_type` varchar(255) DEFAULT NULL,
  `license_plate` varchar(255) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `seat_count` int(11) DEFAULT NULL,
  `transmission` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`car_id`, `car_type`, `color`, `engine_type`, `license_plate`, `manufacturer`, `model`, `rating`, `seat_count`, `transmission`) VALUES
(1, 'Hatchback', 'White', 'SOHC', 'A123', 'Audi', 'A4', 5, 5, b'0'),
(2, 'Sedan', 'Red', 'IC', 'B123', 'BMW', 'X3', 5, 5, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `audit`
--
ALTER TABLE `audit`
  ADD PRIMARY KEY (`audit_id`),
  ADD KEY `FKglmu2mb8xlu63y3i30a3tf7ir` (`car_id`);

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`car_id`),
  ADD UNIQUE KEY `UK_7ew84l68jbcgm9uvsqtbfr1xm` (`license_plate`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `car`
--
ALTER TABLE `car`
  MODIFY `car_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
