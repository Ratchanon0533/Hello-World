-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 13, 2024 at 04:59 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `login_info`
--

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE `userinfo` (
  `User_ID` int(20) NOT NULL,
  `FName` varchar(20) NOT NULL,
  `LName` varchar(20) NOT NULL,
  `Personal_Email` varchar(30) NOT NULL,
  `Coordinates` varchar(20) DEFAULT NULL,
  `Address` varchar(30) NOT NULL,
  `Password` int(20) NOT NULL,
  `Device_IP` varchar(30) NOT NULL,
  `Device_Name` varchar(20) NOT NULL,
  `Join_Date` date NOT NULL,
  `Region` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`User_ID`, `FName`, `LName`, `Personal_Email`, `Coordinates`, `Address`, `Password`, `Device_IP`, `Device_Name`, `Join_Date`, `Region`) VALUES
(111555999, 'White', 'Smith', 'lksddd@gmail.com', '531654.1564.4945', 'Bristol, England', 1651125498, '126554.164652', 'Iphone', '2019-04-25', 'Europe'),
(123456789, 'John', 'Jud', 'john@gmail.com', '154.2651.156', 'Manhattan, New York', 65412398, '21564321.15665', 'Iphone', '2024-08-01', 'North America'),
(159846720, 'Tori', 'Amaya', 'wasd@gmail.com', '458451.134545.168784', 'Arakawa-ku, Tokyo', 2156572, '654518.165154', 'Samsung', '2020-05-05', 'Asia'),
(357864291, 'Kaew', 'Mai', 'glass@gmail.com', '654126.9871.35456', 'Huahin, Prachuap khiri khan', 123546544, '1587541.13253564', 'Samsung', '2024-07-08', 'Asia'),
(741852963, 'Grim', 'Donial', 'ddaeaa@gmail.com', '65451.65645.1564', 'San Francisco, U.S.', 84512368, '4512.6454312', 'Iphone', '2016-02-24', 'North America'),
(748512369, 'Wang', 'Zhang', 'leeahdf@gmail.com', '654987.161566.49848', 'Sha Tin, Hong Kong', 1235647, '21654.21656942', 'Huawei', '2018-05-15', 'Asia'),
(777888999, 'Joenatan', 'Joestar', 'stand@gmail.com', '321654.54564.1264', 'London, England', 4456121, '32651.156156', 'Iphone', '2020-06-16', 'Europe');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `userinfo`
--
ALTER TABLE `userinfo`
  ADD PRIMARY KEY (`User_ID`),
  ADD KEY `Device_IP` (`Device_IP`),
  ADD KEY `Personal_Email` (`Personal_Email`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `userinfo`
--
ALTER TABLE `userinfo`
  ADD CONSTRAINT `userinfo_ibfk_1` FOREIGN KEY (`Device_IP`) REFERENCES `other_info` (`IP`),
  ADD CONSTRAINT `userinfo_ibfk_2` FOREIGN KEY (`Personal_Email`) REFERENCES `userstats` (`Gmail`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
