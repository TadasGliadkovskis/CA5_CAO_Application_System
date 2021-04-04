-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 04, 2021 at 01:29 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oop_ca5_tadas_gliadkovskis`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `course_id` varchar(10) NOT NULL,
  `level` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `institution` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`course_id`, `level`, `title`, `institution`) VALUES
('D247', 8, 'Computer Analytics', 'Dublin City University'),
('D875', 7, 'Nursing', 'Dublin City University'),
('D908', 8, 'Phsycology', 'Dublin City University'),
('DK123', 7, 'Accounting and Finance', 'Dundalk Institute of Technoloy'),
('DK246', 8, 'Business', 'Dundalk Institute of Technoloy'),
('DK821', 8, 'Computing in Software Development', 'Dundalk Institute of Technoloy'),
('MU345', 8, 'Maths', 'Maynooth university'),
('MU567', 7, 'Physics', 'Maynooth university'),
('MU789', 8, 'Biomedical Science', 'Maynooth university');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `cao_number` int(8) NOT NULL,
  `date_of_birth` varchar(10) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`cao_number`, `date_of_birth`, `password`) VALUES
(10000001, '2001-09-04', 'Password1'),
(10000002, '2000-07-12', 'Password2'),
(10000003, '2001-04-17', 'Password3'),
(10000004, '2000-08-25', 'Password4'),
(10000005, '1999-10-27', 'Password5'),
(20034067, 'example', 'example');

-- --------------------------------------------------------

--
-- Table structure for table `student_courses`
--

CREATE TABLE `student_courses` (
  `cao_number` int(8) DEFAULT NULL,
  `course_id` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_courses`
--

INSERT INTO `student_courses` (`cao_number`, `course_id`) VALUES
(10000002, 'MU789'),
(10000003, 'MU567'),
(10000004, 'D908'),
(10000005, 'DK246'),
(10000001, 'D908'),
(10000001, 'D247'),
(9842, 'DK246'),
(9842, 'DK821'),
(9842, 'MU345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`course_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`cao_number`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
