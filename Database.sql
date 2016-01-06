-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2016 at 04:47 PM
-- Server version: 10.0.17-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vipmobileshopapi`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` text,
  `password` text,
  `id_account` int(11) DEFAULT NULL,
  `email` text,
  `id_role` int(11) DEFAULT '3',
  `is_active` tinyint(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `id_account`, `email`, `id_role`, `is_active`, `create_date`) VALUES
(1, 'uy123', 'ERjFwICcjeDVRA9ddlrNZQ==', NULL, 'uynguyen.itus@gmail.com', NULL, 0, '2016-01-05 13:47:56'),
(2, 'uy1234', 'VEaz4MNh3NjoYXrOsKa5hg==', NULL, 'uynguyen.itus@gmail.com', NULL, 0, '2016-01-05 13:48:35'),
(3, 'uy12345', 'YKxAkj6Y8sf3XwAiHDt6ZQ==', NULL, 'uynguyen.itus@gmail.com', NULL, 0, '2016-01-05 13:49:58'),
(4, 'uy123456', '7irnCjI/OhKxRNFHAcJYiw==', NULL, 'uynguyen.itus@gmail.com', NULL, 0, '2016-01-05 13:53:41'),
(5, 'uy1234567', 'l5RR6mzYljmqFEpsxJvqaQ==', 1, 'uynguyen.itus@gmail.com', 1, 1, '2016-01-06 22:40:57'),
(7, '70577630955772219', '8ihXyyH9IprXxbb1zJZC7A==', 3, NULL, NULL, 1, '2016-01-06 17:45:10'),
(8, '!@3', 'Dn03oCvLaZHfnPfJwbhkdQ==', 4, NULL, NULL, 1, '2016-01-06 17:51:56'),
(9, '705776309557719', 'q0St7/Jy+oifz6NQtUrEOA==', 5, NULL, NULL, 1, '2016-01-06 17:54:02');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_account` (`id_account`),
  ADD KEY `id_role` (`id_role`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `uer_id_role_fk` FOREIGN KEY (`id_role`) REFERENCES `user_role` (`id`),
  ADD CONSTRAINT `user_id_account_fk` FOREIGN KEY (`id_account`) REFERENCES `account` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
