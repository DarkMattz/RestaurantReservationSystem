-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2022 at 07:12 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restaurantreservation`
--

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `ID` varchar(5) NOT NULL,
  `name` varchar(256) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`ID`, `name`, `price`) VALUES
('FO001', 'Indomie Goreng Sambal Gluduk', 25000),
('FO002', 'Satai Padang', 50000),
('FO003', 'Satai Maranggi', 55000),
('FO004', 'Lontong Gulai ', 55000),
('FO005', 'Rawon ', 35000),
('FO006', 'Gudeg', 30000),
('FO007', 'Oseng-Oseng Mercon', 30000),
('FO008', 'Nasi Timbel', 30000),
('FO009', 'Satai Kambing ', 65000),
('FO010', 'Rendang', 50000),
('FO011', 'Soto Lamongan', 25000),
('FO012', 'Bebek Betutu', 75000),
('FO013', 'Ayam Rica-Rica', 35000),
('FO014', 'Cakalang Rica-Rica', 55000),
('FO015', 'Entog Rica-Rica', 65000),
('FO016', 'Woku Belanga', 45000),
('FO017', 'Nasi Babat Gongso', 35000),
('FO018', 'Tempoyak Ikan Patin', 45000),
('FO019', 'Kerak Telor', 25000),
('FO020', 'Sup Konro', 45000);

-- --------------------------------------------------------

--
-- Table structure for table `orderedfood`
--

CREATE TABLE `orderedfood` (
  `ID` int(11) NOT NULL,
  `transactionID` varchar(5) NOT NULL,
  `foodID` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orderedfood`
--

INSERT INTO `orderedfood` (`ID`, `transactionID`, `foodID`) VALUES
(1, 'TR001', 'FO001'),
(2, 'TR001', 'FO002'),
(3, 'TR002', 'FO009'),
(4, 'TR002', 'FO017'),
(5, 'TR003', 'FO020'),
(6, 'TR003', 'FO007'),
(7, 'TR004', 'FO011'),
(8, 'TR004', 'FO011'),
(9, 'TR005', 'FO009'),
(10, 'TR005', 'FO009'),
(11, 'TR005', 'FO009'),
(12, 'TR006', 'FO012'),
(13, 'TR006', 'FO003'),
(14, 'TR006', 'FO013'),
(15, 'TR006', 'FO016'),
(16, 'TR006', 'FO019'),
(17, 'TR007', 'FO019'),
(18, 'TR007', 'FO17'),
(19, 'TR007', 'FO17'),
(20, 'TR007', 'FO015');

-- --------------------------------------------------------

--
-- Table structure for table `table`
--

CREATE TABLE `table` (
  `number` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  `isEmpty` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `table`
--

INSERT INTO `table` (`number`, `capacity`, `isEmpty`) VALUES
(1, 8, 1),
(2, 2, 0),
(3, 2, 0),
(4, 4, 1),
(5, 4, 1),
(6, 2, 0),
(7, 2, 0),
(8, 10, 1),
(9, 10, 1),
(10, 6, 0),
(11, 8, 1);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `ID` varchar(5) NOT NULL,
  `customerEmail` varchar(128) NOT NULL,
  `tableNumber` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`ID`, `customerEmail`, `tableNumber`, `date`) VALUES
('TR001', 'HUWALAHUMBA@gmail.com', 10, '2022-06-22'),
('TR002', 'aluna.kalila@gmail.com', 1, '2022-06-25'),
('TR003', 'neneng123@gmail.com', 5, '2022-06-22'),
('TR004', 'lailanur@gmail.com', 2, '2022-06-23'),
('TR005', 'ElonbukanMask@gmail.com', 4, '2022-06-23'),
('TR006', 'rahmat_effendi', 8, '2022-06-24'),
('TR007', 'delioerlangga@gmail.com', 6, '2022-06-27');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `email` varchar(128) NOT NULL,
  `password` varchar(256) NOT NULL,
  `name` varchar(256) DEFAULT NULL,
  `phone` varchar(64) DEFAULT NULL,
  `isAdmin` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`email`, `password`, `name`, `phone`, `isAdmin`) VALUES
('Admin@gmail.com', 'HUWALAHUMBA', NULL, NULL, 1),
('aluna.kalila@gmail.com', 'takadakisahtentang', 'Aluna Kalila', '08112438726', 0),
('delioerlangga@gmail.com', 'likeeverysingle13', 'Delio Erlangga', '08236714522', 0),
('ElonbukanMask@gmail.com', 'mobil456Sport', 'Elon Masking', '08999231564', 0),
('HUWALAHUMBA@gmail.com', 'HUWALAHUMBA', 'HUWALAHUMBA', 'HUWALAHUMBA', 0),
('lailanur@gmail.com', 'adakahDiriku34', 'Nur Laila ', '08135432137', 0),
('neneng123@gmail.com', 'indahWaktuny4', 'Neneng Afrianti', '08564327855', 0),
('rahmat_effendi@gmail.com', 'youbetrayedMe', 'Rahmat Jonathan Effendi ', '089567833332', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `orderedfood`
--
ALTER TABLE `orderedfood`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `table`
--
ALTER TABLE `table`
  ADD PRIMARY KEY (`number`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `customerEmail` (`customerEmail`),
  ADD KEY `tableNumber` (`tableNumber`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orderedfood`
--
ALTER TABLE `orderedfood`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`customerEmail`) REFERENCES `users` (`email`),
  ADD CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`tableNumber`) REFERENCES `table` (`number`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
