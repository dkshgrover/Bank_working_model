-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 06, 2020 at 07:07 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

CREATE DATABASE bank_account;
USE bank_account;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bank_account`
--

-- --------------------------------------------------------

--
-- Table structure for table `accountant`
--

CREATE TABLE IF NOT EXISTS `accountant` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salaryStatus` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accountant`
--

INSERT INTO `accountant` (`id`, `name`, `password`, `salaryStatus`) VALUES
(1, 'Daman Arora', '$2a$12$VWZVgdT7Nzs9t5wi3dgQ8eh/AKj1ja7kxKn58hxKxvHzFnveh0n/C', 'Paid'),
(3, 'Aadi Madaan', '$2a$12$BAXZRNu6N/wLJZJw3fFLdeDQIEvyEQlW5V7v9LqJIwqvyvYnCHx0y', 'Paid');

-- --------------------------------------------------------

--
-- Table structure for table `accounts_in_bank`
--

CREATE TABLE IF NOT EXISTS `accounts_in_bank` (
  `Ac_no` int(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Balance` int(255) unsigned NOT NULL,
  `Pin` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts_in_bank`
--

INSERT INTO `accounts_in_bank` (`Ac_no`, `Name`, `Balance`, `Pin`) VALUES
(986667844, 'Daksh Grover', 4000, '$2a$12$PtMSseOnqUkVbPjGgU91iuqU3mau5k1zOG4cXXGfyAg5hExPfpoou'),
(840227256, 'Somnath Grover', 5000, '$2a$12$wpveme7bL204/UNv2cSnOOoY0s3tY/0cAj5TE5tG6t2j8MCDWSbwm'),
(91879248, 'Ankush Grover', 10000, '$2a$12$OsNteXGhF8UukigIRz2hs.0FTyt5sKxr13NByw2DnOeK7U5Ebs1wK'),
(528148348, 'Arsh Arora', 1000, '$2a$12$8o1jXtpfkm8P1M2svemjC.H8kANaJLCWGdx.tiJb9rGoKbVfJtQmm');

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE IF NOT EXISTS `administrator` (
  `name` varchar(255) NOT NULL,
  `id` int(10) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`name`, `id`, `password`) VALUES
('Daksh Grover', 1, 'DakshGrover6497'),
('Rahul Ahuja', 2, 'RahulAhuja12');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
