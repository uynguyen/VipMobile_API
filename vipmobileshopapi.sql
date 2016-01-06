-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2016 at 05:08 PM
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
-- Table structure for table `access_token`
--

CREATE TABLE `access_token` (
  `id` int(11) NOT NULL,
  `access_token` text,
  `scope` text,
  `user_id` int(11) DEFAULT NULL,
  `expire` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `access_token`
--

INSERT INTO `access_token` (`id`, `access_token`, `scope`, `user_id`, `expire`) VALUES
(18, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODEzNzYxODEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:02:17'),
(19, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODEzNzc1MjEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:02:17'),
(20, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODI4NTI1MjEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:04:45'),
(21, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODI4NTI3MTEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:04:45'),
(22, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODM0NTg1NTEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:05:45'),
(23, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODM0NTg2NjEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:05:45'),
(24, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODYzMzY2NTEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:10:33'),
(25, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODYzMzc1ODEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:10:33'),
(26, 'dXkxMjM0NTY3MTQ1MjA3ODc1OTc2MzEyMTI1MDUtMTIxMjUxMw==', 'None', 5, '2016-01-06 19:12:39'),
(27, 'dXkxMjM0NTY3MTQ1MjA3ODc1OTkwNzEyMTI1MDUtMTIxMjUxMw==', 'None', 5, '2016-01-06 19:12:39'),
(28, 'dXkxMjM0NTY3MTQ1MjA3ODg0MjIzMjEyMTI1MDUtMTIxMjUxMw==', 'None', 5, '2016-01-06 19:14:02'),
(29, 'dXkxMjM0NTY3MTQ1MjA3ODg3MjQ2MjEyMTI1MDUtMTIxMjUxMw==', 'None', 5, '2016-01-06 19:14:32'),
(30, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODg4MTg0MDEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:14:41'),
(31, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODg4MTg0MTEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:14:41'),
(32, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODkwMjA3NTEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:15:02'),
(33, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODkwMjA4MzEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:15:02'),
(34, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODkyNTMxMzEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:15:25'),
(35, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODkyNTM4NjEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:15:25'),
(36, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODk1NzU1NDEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:15:57'),
(37, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3ODk1NzY2NDEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:15:57'),
(38, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3OTExMjcwMjEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:18:32'),
(39, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3OTExMjcwMzEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:18:32'),
(40, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3OTI1OTAzMDEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:20:59'),
(41, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3OTI1OTA0MTEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:20:59'),
(42, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3OTI5MzI2MzEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:21:33'),
(43, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3OTI5MzI2NzEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:21:33'),
(44, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3OTM5OTEwMDEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:23:19'),
(45, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3OTM5OTEwNDEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:23:19'),
(46, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3OTQ0Mzk1MjEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:24:03'),
(47, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3OTQ0Mzk3MDEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:24:03'),
(48, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3OTU1Mjc3MTEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:25:52'),
(49, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3OTU1Mjc3NjEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:25:52'),
(50, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3OTg4NzU5MTEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:31:27'),
(51, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA3OTg4NzYwMjEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:31:27'),
(52, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA4MDAwMTcyNTEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:33:21'),
(53, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA4MDAwMTc1MjEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:33:21'),
(54, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA4MDEwMjExMDEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:35:02'),
(55, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA4MDEwMjExODEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:35:02'),
(56, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA4MDIwMTI5NTEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:36:41'),
(57, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA4MDIwMTM2NDEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 19:36:41'),
(58, 'dXkxMjM0NTY3MTQ1MjA4MDU3MzQyNzEyMTI1MDUtMTIxMjUxMw==', 'None', 5, '2016-01-06 19:42:53'),
(59, 'dXkxMjM0NTY3MTQ1MjA4MDU3MzQzMDEyMTI1MDUtMTIxMjUxMw==', 'None', 5, '2016-01-06 19:42:53'),
(60, 'dXkxMjM0NTY3MTQ1MjA4MTk0MDQ1ODEyMTI1MDUtMTIxMjUxMw==', 'None', 5, '2016-01-06 20:05:40'),
(61, 'dXkxMjM0NTY3MTQ1MjA4MTk0MDQ2ODEyMTI1MDUtMTIxMjUxMw==', 'None', 5, '2016-01-06 20:05:40'),
(62, 'dXkxMjM0NTY3MTQ1MjA4MTk0NjcyMzEyMTI1MDUtMTIxMjUxMw==', 'None', 5, '2016-01-06 20:05:46'),
(63, 'dXkxMjM0NTY3MTQ1MjA4MTk0Njg3ODEyMTI1MDUtMTIxMjUxMw==', 'None', 5, '2016-01-06 20:05:46'),
(64, 'dXkxMjM0NTY3MTQ1MjA4MTk1MTA2OTEyMTI1MDUtMTIxMjUxMw==', 'None', 5, '2016-01-06 20:05:51'),
(65, 'dXkxMjM0NTY3MTQ1MjA4MjMzMzcwNjEyMTI1MDUtMTIxMjUxMw==', 'None', 5, '2016-01-06 20:12:13'),
(66, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA5NDYwNzEzNDEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 23:36:47'),
(67, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA5NDYwNzE2NTEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 23:36:47'),
(68, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA5NDYzNjM2MTEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 23:37:16'),
(69, 'NzA1Nzc2MzA5NTU3NzE5MTQ1MjA5NDYzNjM5MzEyMTI1MDUtMTIxMjUxMw==', 'None', 9, '2016-01-06 23:37:16'),
(70, 'dXkxMjM0NTY3MTQ1MjA5NTA0MjEwODEyMTI1MDUtMTIxMjUxMw==', 'None', 5, '2016-01-06 23:44:02');

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `full_name` text,
  `address` text,
  `birthday` date DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `avatar` text,
  `visa_code` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `full_name`, `address`, `birthday`, `gender`, `avatar`, `visa_code`) VALUES
(1, '23456', '222', '2016-01-29', 1, 'Default', '115622'),
(3, 'uynguyen', NULL, '2016-01-06', 1, 'Default', NULL),
(4, NULL, NULL, '2016-01-06', 1, 'Default', NULL),
(5, NULL, NULL, '2016-01-06', 1, 'Default', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `arguments`
--

CREATE TABLE `arguments` (
  `id` int(11) NOT NULL,
  `name` text,
  `data_type` text,
  `description` text,
  `value` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `arguments`
--

INSERT INTO `arguments` (`id`, `name`, `data_type`, `description`, `value`) VALUES
(1, 'VAT', 'Double', 'Thue', '10');

-- --------------------------------------------------------

--
-- Table structure for table `bill_detail`
--

CREATE TABLE `bill_detail` (
  `id` int(11) NOT NULL,
  `id_product` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `id_bill` int(11) DEFAULT NULL,
  `id_select_color` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill_detail`
--

INSERT INTO `bill_detail` (`id`, `id_product`, `amount`, `total_price`, `id_bill`, `id_select_color`) VALUES
(4, 3, 3, 30000000, 18, NULL),
(5, 11, 1, 13290000, 19, NULL),
(6, 3, 2, 20000000, 19, NULL),
(7, 3, 2, 20000000, 20, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `bill_state_code`
--

CREATE TABLE `bill_state_code` (
  `id` int(11) NOT NULL,
  `value` text,
  `description` text CHARACTER SET latin1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bill_state_code`
--

INSERT INTO `bill_state_code` (`id`, `value`, `description`) VALUES
(1, 'Đã thanh toán', NULL),
(2, 'Chưa thanh toán', NULL),
(3, 'Tạm hoãn giao dịch', NULL),
(4, 'Đang chờ xử lý', NULL),
(5, 'Đã hủy', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `color_category`
--

CREATE TABLE `color_category` (
  `id` int(11) NOT NULL,
  `value` text,
  `color_code` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `color_category`
--

INSERT INTO `color_category` (`id`, `value`, `color_code`) VALUES
(1, 'Black', '#000000'),
(2, 'White', '#FFFFFF'),
(3, 'Yellow', '#FFFF00'),
(4, 'Blue', '#3366FF'),
(5, 'Green', '#33FF00'),
(6, 'Sliver', '#DDDDDD'),
(7, 'Gray', '#666666'),
(8, 'Gold', '#FFFF00');

-- --------------------------------------------------------

--
-- Table structure for table `producer_category`
--

CREATE TABLE `producer_category` (
  `id` int(11) NOT NULL,
  `value` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `producer_category`
--

INSERT INTO `producer_category` (`id`, `value`) VALUES
(1, 'Apple'),
(2, 'HTC'),
(3, 'Oppo'),
(4, 'Samsung'),
(5, 'Motolora'),
(6, 'Nokia'),
(7, 'Microsoft'),
(8, 'Lenovo'),
(9, 'Viettel'),
(10, 'Sony'),
(11, 'LG'),
(12, 'Asus');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `code` text,
  `image` text,
  `price` double DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `name` text,
  `import_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `description` text CHARACTER SET utf8
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `code`, `image`, `price`, `amount`, `name`, `import_date`, `description`) VALUES
(1, 'IP0001', '/Resources/ProductImages/IP0001.jpg', 18550000, 100, 'iPhone 6S 16GB Rose Gold', '2016-01-04 18:36:36', 'Có th? nói, th??ng hi?u LG ?ã n? l?c mang ??n nh?ng c?i ti?n v??t tr?i trên chi?c LG V10, giúp ng??i dùng tr?i nghi?m ?a ph??ng ti?n. Siêu ph?m này ???c trang b? màn hình chính công ngh? IPS v?i kích th??c lên ??n 5.7 inches, ?? phân gi?i 1440 x 2560 pixels và m?t ?? ?i?m ?nh 513 ppi, cho phép hi?n th? hình ?nh s?c nét, chi ti?t, màu s?c s?ng ??ng, trung th?c, ??ng th?i, siêu ph?m này còn có góc nhìn r?ng và ?? t??ng ph?n t??ng ??i t?t, giúp hi?n th? ???c rõ ràng và d? th?y h?n khi s? d?ng d??i ánh n?ng m?t tr?i.\r\n\r\nLG V10 màn hình 5.7 inches'),
(3, 'IP0002', '/Resources/ProductImages/IP0002.jpg', 10000000, 100, 'iPhone 6S 16GB Rose Gold', '2016-01-05 13:38:15', NULL),
(4, 'SS0003', '/Resources/ProductImages/SS0003.jpg', 111111111, 120, 'Samsung Galaxy S6 Edge', '2016-01-05 13:39:31', 'Có thể nói, thương hiệu LG đã nỗ lực mang đến những cải tiến vượt trội trên chiếc LG V10, giúp người dùng trải nghiệm đa phương tiện. Siêu phẩm này được trang bị màn hình chính công nghệ IPS với kích thước lên đến 5.7 inches, độ phân giải 1440 x 2560 pixels và mật độ điểm ảnh 513 ppi, cho phép hiển thị hình ảnh sắc nét, chi tiết, màu sắc sống động, trung thực, đồng thời, siêu phẩm này còn có góc nhìn rộng và độ tương phản tương đối tốt, giúp hiển thị được rõ ràng và dễ thấy hơn khi sử dụng dưới ánh nắng mặt trời.\r\n\r\nLG V10 màn hình 5.7 inches'),
(5, 'SN0004', '/Resources/ProductImages/SN0004.jpg', 19990000, 200, 'Sony Xpreria Z5 Premium', '2016-01-05 13:39:31', 'Có thể nói, thương hiệu LG đã nỗ lực mang đến những cải tiến vượt trội trên chiếc LG V10, giúp người dùng trải nghiệm đa phương tiện. Siêu phẩm này được trang bị màn hình chính công nghệ IPS với kích thước lên đến 5.7 inches, độ phân giải 1440 x 2560 pixels và mật độ điểm ảnh 513 ppi, cho phép hiển thị hình ảnh sắc nét, chi tiết, màu sắc sống động, trung thực, đồng thời, siêu phẩm này còn có góc nhìn rộng và độ tương phản tương đối tốt, giúp hiển thị được rõ ràng và dễ thấy hơn khi sử dụng dưới ánh nắng mặt trời.\r\n\r\nLG V10 màn hình 5.7 inches'),
(6, 'SN0005', '/Resources/ProductImages/SN0005.jpg', 15000000, 500, 'Sony Xperia Z5 Dual', '2016-01-05 13:40:26', 'Có thể nói, thương hiệu LG đã nỗ lực mang đến những cải tiến vượt trội trên chiếc LG V10, giúp người dùng trải nghiệm đa phương tiện. Siêu phẩm này được trang bị màn hình chính công nghệ IPS với kích thước lên đến 5.7 inches, độ phân giải 1440 x 2560 pixels và mật độ điểm ảnh 513 ppi, cho phép hiển thị hình ảnh sắc nét, chi tiết, màu sắc sống động, trung thực, đồng thời, siêu phẩm này còn có góc nhìn rộng và độ tương phản tương đối tốt, giúp hiển thị được rõ ràng và dễ thấy hơn khi sử dụng dưới ánh nắng mặt trời.\r\n\r\nLG V10 màn hình 5.7 inches'),
(7, 'LG0006', '/Resources/ProductImages/LG0006.jpg', 15990000, 100, 'LG V10', '2016-01-05 13:40:26', 'Có thể nói, thương hiệu LG đã nỗ lực mang đến những cải tiến vượt trội trên chiếc LG V10, giúp người dùng trải nghiệm đa phương tiện. Siêu phẩm này được trang bị màn hình chính công nghệ IPS với kích thước lên đến 5.7 inches, độ phân giải 1440 x 2560 pixels và mật độ điểm ảnh 513 ppi, cho phép hiển thị hình ảnh sắc nét, chi tiết, màu sắc sống động, trung thực, đồng thời, siêu phẩm này còn có góc nhìn rộng và độ tương phản tương đối tốt, giúp hiển thị được rõ ràng và dễ thấy hơn khi sử dụng dưới ánh nắng mặt trời.\r\n\r\nLG V10 màn hình 5.7 inches'),
(8, 'ML0007', '/Resources/ProductImages/ML0007.jpg', 15990000, 200, 'Microsoft Lumia 50 XL', '2016-01-05 13:41:30', 'Có thể nói, thương hiệu LG đã nỗ lực mang đến những cải tiến vượt trội trên chiếc LG V10, giúp người dùng trải nghiệm đa phương tiện. Siêu phẩm này được trang bị màn hình chính công nghệ IPS với kích thước lên đến 5.7 inches, độ phân giải 1440 x 2560 pixels và mật độ điểm ảnh 513 ppi, cho phép hiển thị hình ảnh sắc nét, chi tiết, màu sắc sống động, trung thực, đồng thời, siêu phẩm này còn có góc nhìn rộng và độ tương phản tương đối tốt, giúp hiển thị được rõ ràng và dễ thấy hơn khi sử dụng dưới ánh nắng mặt trời.\r\n\r\nLG V10 màn hình 5.7 inches'),
(9, 'LG0008', '/Resources/ProductImages/LG0008.jpg', 13990000, 100, 'LG G4 Leather', '2016-01-05 13:41:30', 'Có thể nói, thương hiệu LG đã nỗ lực mang đến những cải tiến vượt trội trên chiếc LG V10, giúp người dùng trải nghiệm đa phương tiện. Siêu phẩm này được trang bị màn hình chính công nghệ IPS với kích thước lên đến 5.7 inches, độ phân giải 1440 x 2560 pixels và mật độ điểm ảnh 513 ppi, cho phép hiển thị hình ảnh sắc nét, chi tiết, màu sắc sống động, trung thực, đồng thời, siêu phẩm này còn có góc nhìn rộng và độ tương phản tương đối tốt, giúp hiển thị được rõ ràng và dễ thấy hơn khi sử dụng dưới ánh nắng mặt trời.\r\n\r\nLG V10 màn hình 5.7 inches'),
(10, 'ML0009', '/Resources/ProductImages/ML0009.jpg', 13990000, 500, 'Microsoft Lumia 950', '2016-01-05 13:42:25', 'Có thể nói, thương hiệu LG đã nỗ lực mang đến những cải tiến vượt trội trên chiếc LG V10, giúp người dùng trải nghiệm đa phương tiện. Siêu phẩm này được trang bị màn hình chính công nghệ IPS với kích thước lên đến 5.7 inches, độ phân giải 1440 x 2560 pixels và mật độ điểm ảnh 513 ppi, cho phép hiển thị hình ảnh sắc nét, chi tiết, màu sắc sống động, trung thực, đồng thời, siêu phẩm này còn có góc nhìn rộng và độ tương phản tương đối tốt, giúp hiển thị được rõ ràng và dễ thấy hơn khi sử dụng dưới ánh nắng mặt trời.\r\n\r\nLG V10 màn hình 5.7 inches'),
(11, 'MT0010', '/Resources/ProductImages/MT0010.jpg', 13290000, 500, 'Motorola Moto X style', '2016-01-05 13:42:25', 'Có thể nói, thương hiệu LG đã nỗ lực mang đến những cải tiến vượt trội trên chiếc LG V10, giúp người dùng trải nghiệm đa phương tiện. Siêu phẩm này được trang bị màn hình chính công nghệ IPS với kích thước lên đến 5.7 inches, độ phân giải 1440 x 2560 pixels và mật độ điểm ảnh 513 ppi, cho phép hiển thị hình ảnh sắc nét, chi tiết, màu sắc sống động, trung thực, đồng thời, siêu phẩm này còn có góc nhìn rộng và độ tương phản tương đối tốt, giúp hiển thị được rõ ràng và dễ thấy hơn khi sử dụng dưới ánh nắng mặt trời.\r\n\r\nLG V10 màn hình 5.7 inches');

-- --------------------------------------------------------

--
-- Table structure for table `product_color_detail`
--

CREATE TABLE `product_color_detail` (
  `id` int(11) NOT NULL,
  `id_product` int(11) DEFAULT NULL,
  `id_color` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_color_detail`
--

INSERT INTO `product_color_detail` (`id`, `id_product`, `id_color`) VALUES
(1, 1, 1),
(2, 3, 2),
(3, 4, 4),
(4, 5, 4),
(5, 6, 8),
(6, 7, 3),
(7, 8, 4),
(8, 9, 3),
(9, 10, 7),
(10, 11, 4);

-- --------------------------------------------------------

--
-- Table structure for table `product_detail`
--

CREATE TABLE `product_detail` (
  `id` int(11) NOT NULL,
  `screen_size` double DEFAULT NULL,
  `ram` int(11) DEFAULT NULL,
  `capacity_pin` int(11) DEFAULT NULL,
  `sim_amount` int(11) DEFAULT NULL,
  `screen` text,
  `cpu` text,
  `weight` double DEFAULT NULL,
  `usb` double DEFAULT NULL,
  `bluetooth` text,
  `main_camera` double DEFAULT NULL,
  `vice_camera` double DEFAULT NULL,
  `gpu` text,
  `guarantee` int(11) DEFAULT NULL,
  `id_producer` int(11) DEFAULT NULL,
  `id_product` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_detail`
--

INSERT INTO `product_detail` (`id`, `screen_size`, `ram`, `capacity_pin`, `sim_amount`, `screen`, `cpu`, `weight`, `usb`, `bluetooth`, `main_camera`, `vice_camera`, `gpu`, `guarantee`, `id_producer`, `id_product`) VALUES
(1, 5.5, 4, 2750, 2, NULL, '1.8 GHz', 200, 2, 'v4.0, A2DP', 13, 5, NULL, 12, 1, 1),
(2, 5.5, 2, 2750, 2, NULL, '1.5 GHz', 200, 2, 'v4.0, A2DP', 10, 2, NULL, 12, 11, 3),
(3, 5.5, 2, 2750, 2, NULL, '1.5 GHz', 200, 2, 'v4.0, A2DP', 10, 2, NULL, 12, 11, 4),
(4, 5.5, 2, 2750, 2, NULL, '1.5 GHz', 200, 2, 'v4.0, A2DP', 10, 2, NULL, 12, 3, 5),
(5, 5.5, 2, 2750, 2, NULL, '1.5 GHz', 200, 2, 'v4.0, A2DP', 10, 2, NULL, 12, 4, 6),
(6, 5.5, 2, 2750, 2, NULL, '1.5 GHz', 200, 2, 'v4.0, A2DP', 10, 2, NULL, 12, 2, 7),
(7, 5.5, 2, 2750, 2, NULL, '1.5 GHz', 200, 2, 'v4.0, A2DP', 10, 2, NULL, 12, 2, 8),
(8, 5.5, 2, 2750, 2, NULL, '1.5 GHz', 200, 2, 'v4.0, A2DP', 10, 2, NULL, 12, 5, 9),
(9, 5.5, 2, 2750, 2, NULL, '1.5 GHz', 200, 2, 'v4.0, A2DP', 10, 2, NULL, 12, 8, 10),
(10, 5.5, 2, 2750, 2, NULL, '1.5 GHz', 200, 2, 'v4.0, A2DP', 10, 2, NULL, 12, 8, 11);

-- --------------------------------------------------------

--
-- Table structure for table `register_token`
--

CREATE TABLE `register_token` (
  `id` int(11) NOT NULL,
  `access_token` text,
  `expise` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `register_token`
--

INSERT INTO `register_token` (`id`, `access_token`, `expise`, `id_user`) VALUES
(1, 'dXkxMjMxNDUxOTc2NDc2OTY1MTIxMjUwNS0xMjEyNTEz', '2016-01-05 14:47:57', 1),
(2, 'dXkxMjM0MTQ1MTk3NjUxNTQxMzEyMTI1MDUtMTIxMjUxMw==', '2016-01-05 14:48:35', 2),
(3, 'dXkxMjM0NTE0NTE5NzY1OTgzODUxMjEyNTA1LTEyMTI1MTM=', '2016-01-05 14:49:58', 3),
(4, 'dXkxMjM0NTYxNDUxOTc2ODIxODgzMTIxMjUwNS0xMjEyNTEz', '2016-01-05 14:53:42', 4),
(5, 'dXkxMjM0NTY3MTQ1MTk3NzQxMzg1MDEyMTI1MDUtMTIxMjUxMw==', '2016-01-05 15:03:34', 5);

-- --------------------------------------------------------

--
-- Table structure for table `resetpass_token`
--

CREATE TABLE `resetpass_token` (
  `id` int(11) NOT NULL,
  `access_token` text,
  `expire` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resetpass_token`
--

INSERT INTO `resetpass_token` (`id`, `access_token`, `expire`, `id_user`) VALUES
(1, 'dXkxMjM0NTY3MTQ1MjA5NDI3MzgwNTEyMTI1MDUtMTIxMjUxMw==', '2016-01-06 23:31:13', 5),
(2, '', '2016-01-06 23:33:45', 5);

-- --------------------------------------------------------

--
-- Table structure for table `sale_product`
--

CREATE TABLE `sale_product` (
  `id` int(11) NOT NULL,
  `id_product` int(11) DEFAULT NULL,
  `sale_percent` double DEFAULT NULL,
  `valid_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale_product`
--

INSERT INTO `sale_product` (`id`, `id_product`, `sale_percent`, `valid_date`) VALUES
(1, 1, 20, '2016-01-05 12:49:44'),
(2, 6, 20, '2016-01-06 18:38:48'),
(3, 11, 15, '2016-01-06 18:38:56'),
(4, 8, 10, '2016-01-06 18:39:07');

-- --------------------------------------------------------

--
-- Table structure for table `transport_fee`
--

CREATE TABLE `transport_fee` (
  `id` int(11) NOT NULL,
  `area` text CHARACTER SET utf8,
  `fee` double DEFAULT NULL,
  `desciption` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transport_fee`
--

INSERT INTO `transport_fee` (`id`, `area`, `fee`, `desciption`) VALUES
(1, 'Qu?n 1', 100000, NULL),
(2, 'Quận 1', 50000, NULL),
(3, 'Quận 2', 1000000, NULL),
(4, 'Quận 5', 70000, NULL),
(5, 'Quận 7', 30000, NULL),
(6, 'Quận 8', 100000, NULL),
(7, 'Quận 10', 90000, NULL),
(8, 'Quận 12', 75000, NULL),
(9, 'Quận Tân Bình', 55000, NULL);

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

-- --------------------------------------------------------

--
-- Table structure for table `user_bill`
--

CREATE TABLE `user_bill` (
  `id` int(11) NOT NULL,
  `code` text,
  `book_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `total` double DEFAULT NULL,
  `vat` double DEFAULT NULL,
  `sale` double DEFAULT NULL,
  `address` text,
  `phone` text,
  `stranport_fee` double DEFAULT NULL,
  `id_user` int(11) NOT NULL,
  `state` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_bill`
--

INSERT INTO `user_bill` (`id`, `code`, `book_date`, `total`, `vat`, `sale`, `address`, `phone`, `stranport_fee`, `id_user`, `state`) VALUES
(18, 'UY123456719373564106012016', '2016-01-06 19:37:35', 30050010, 3000000, NULL, '22, Qu?n 1, Tp H? Chí Minh', '22', 50000, 5, 3),
(19, 'UY123456719384171606012016', '2016-01-06 19:38:41', 33320010, 3329000, NULL, '111, Qu?n 7, Tp H? Chí Minh', '222', 30000, 5, 5),
(20, '70577630955771922370345506012016', '2016-01-06 22:37:03', 21000010, 2000000, NULL, '222, Qu?n 2, Tp H? Chí Minh', '22', 1000000, 9, 5);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL,
  `role` text,
  `description` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`id`, `role`, `description`) VALUES
(1, 'admin', NULL),
(2, 'mod', NULL),
(3, 'user', NULL),
(4, 'superadmin', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `access_token`
--
ALTER TABLE `access_token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `arguments`
--
ALTER TABLE `arguments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_product` (`id_product`),
  ADD KEY `id_bill` (`id_bill`);

--
-- Indexes for table `bill_state_code`
--
ALTER TABLE `bill_state_code`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `color_category`
--
ALTER TABLE `color_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `producer_category`
--
ALTER TABLE `producer_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product_color_detail`
--
ALTER TABLE `product_color_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_color` (`id_color`),
  ADD KEY `id_product` (`id_product`),
  ADD KEY `id_color_2` (`id_color`);

--
-- Indexes for table `product_detail`
--
ALTER TABLE `product_detail`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_product` (`id_product`),
  ADD KEY `id_producer` (`id_producer`);

--
-- Indexes for table `register_token`
--
ALTER TABLE `register_token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `resetpass_token`
--
ALTER TABLE `resetpass_token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `sale_product`
--
ALTER TABLE `sale_product`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_product` (`id_product`);

--
-- Indexes for table `transport_fee`
--
ALTER TABLE `transport_fee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_account` (`id_account`),
  ADD KEY `id_role` (`id_role`);

--
-- Indexes for table `user_bill`
--
ALTER TABLE `user_bill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `state` (`state`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `access_token`
--
ALTER TABLE `access_token`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;
--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `arguments`
--
ALTER TABLE `arguments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `bill_detail`
--
ALTER TABLE `bill_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `bill_state_code`
--
ALTER TABLE `bill_state_code`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `color_category`
--
ALTER TABLE `color_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `producer_category`
--
ALTER TABLE `producer_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `product_color_detail`
--
ALTER TABLE `product_color_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `product_detail`
--
ALTER TABLE `product_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `register_token`
--
ALTER TABLE `register_token`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `resetpass_token`
--
ALTER TABLE `resetpass_token`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `sale_product`
--
ALTER TABLE `sale_product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `transport_fee`
--
ALTER TABLE `transport_fee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `user_bill`
--
ALTER TABLE `user_bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `access_token`
--
ALTER TABLE `access_token`
  ADD CONSTRAINT `access_token_id_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD CONSTRAINT `bill_detail_id_bill_fk` FOREIGN KEY (`id_bill`) REFERENCES `user_bill` (`id`),
  ADD CONSTRAINT `bill_detail_id_product_fk` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Constraints for table `product_color_detail`
--
ALTER TABLE `product_color_detail`
  ADD CONSTRAINT `product_color_detail_id_color_fk` FOREIGN KEY (`id_color`) REFERENCES `color_category` (`id`),
  ADD CONSTRAINT `product_color_detail_id_product_fk` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Constraints for table `product_detail`
--
ALTER TABLE `product_detail`
  ADD CONSTRAINT `product_detail_id_producer_fk` FOREIGN KEY (`id_producer`) REFERENCES `producer_category` (`id`),
  ADD CONSTRAINT `product_detail_id_product_fk` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Constraints for table `register_token`
--
ALTER TABLE `register_token`
  ADD CONSTRAINT `register_token_id_user_fk` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Constraints for table `resetpass_token`
--
ALTER TABLE `resetpass_token`
  ADD CONSTRAINT `resetpass_token_id_user_fk` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Constraints for table `sale_product`
--
ALTER TABLE `sale_product`
  ADD CONSTRAINT `sale_product_id_product_fk` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `uer_id_role_fk` FOREIGN KEY (`id_role`) REFERENCES `user_role` (`id`),
  ADD CONSTRAINT `user_id_account_fk` FOREIGN KEY (`id_account`) REFERENCES `account` (`id`);

--
-- Constraints for table `user_bill`
--
ALTER TABLE `user_bill`
  ADD CONSTRAINT `id_state_fk` FOREIGN KEY (`state`) REFERENCES `bill_state_code` (`id`),
  ADD CONSTRAINT `user_bill_id_user_fk` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
