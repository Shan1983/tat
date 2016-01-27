-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 26, 2015 at 12:55 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tat`
--

-- --------------------------------------------------------

--
-- Table structure for table `tat_audit`
--

CREATE TABLE IF NOT EXISTS `tat_audit` (
  `Id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL,
  `action` tinytext NOT NULL,
  `Time_Date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Log of changes';

-- --------------------------------------------------------

--
-- Table structure for table `tat_course`
--

CREATE TABLE IF NOT EXISTS `tat_course` (
  `Id` int(11) NOT NULL,
  `Code` tinytext NOT NULL,
  `Title` tinytext NOT NULL,
  `Short_Description` text NOT NULL,
  `Long_Description` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Course details';

-- --------------------------------------------------------

--
-- Table structure for table `tat_course_instance`
--

CREATE TABLE IF NOT EXISTS `tat_course_instance` (
  `Id` int(11) NOT NULL,
  `Course_Id` int(11) NOT NULL,
  `Year` year(4) NOT NULL,
  `Study_Period` text NOT NULL,
  `Status` tinytext NOT NULL,
  `Facilitator` int(11) NOT NULL,
  `Projects_Created` tinytext NOT NULL,
  `Location` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='specific instance of a course';

-- --------------------------------------------------------

--
-- Table structure for table `tat_course_project`
--

CREATE TABLE IF NOT EXISTS `tat_course_project` (
  `Course_Instance_Id` int(11) NOT NULL,
  `Project_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Course Project Matrix';

-- --------------------------------------------------------

--
-- Table structure for table `tat_course_student`
--

CREATE TABLE IF NOT EXISTS `tat_course_student` (
  `User_Id` int(11) NOT NULL,
  `Course_Instance_Id` int(11) NOT NULL,
  `Skills_Updated` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Course Student matrix';

-- --------------------------------------------------------

--
-- Table structure for table `tat_project`
--

CREATE TABLE IF NOT EXISTS `tat_project` (
  `Id` int(11) NOT NULL,
  `Title` tinytext NOT NULL,
  `Type` tinytext NOT NULL,
  `Short_Description` tinytext NOT NULL,
  `Long_Description` longtext NOT NULL,
  `Manager_Id` int(11) NOT NULL,
  `Status` tinytext NOT NULL,
  `Size_Min` int(11) NOT NULL,
  `Size_Max` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Project definition';

-- --------------------------------------------------------

--
-- Table structure for table `tat_project_requirements`
--

CREATE TABLE IF NOT EXISTS `tat_project_requirements` (
  `Skill_Id` int(11) NOT NULL,
  `Project_Id` int(11) NOT NULL,
  `Number` int(11) NOT NULL,
  `Weight` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Project skills requirements';

-- --------------------------------------------------------

--
-- Table structure for table `tat_project_user`
--

CREATE TABLE IF NOT EXISTS `tat_project_user` (
  `User_Id` int(11) NOT NULL,
  `Project_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Project User matrix';

-- --------------------------------------------------------

--
-- Table structure for table `tat_skill`
--

CREATE TABLE IF NOT EXISTS `tat_skill` (
  `Id` int(11) NOT NULL,
  `Name` tinytext NOT NULL,
  `Short_Description` tinytext NOT NULL,
  `Long_Description` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Skill details';

-- --------------------------------------------------------

--
-- Table structure for table `tat_user`
--

CREATE TABLE IF NOT EXISTS `tat_user` (
  `Id` int(11) NOT NULL,
  `First_Name` tinytext NOT NULL,
  `Last_Name` tinytext NOT NULL,
  `Email` text NOT NULL,
  `Phone_Number` text NOT NULL,
  `GPA` decimal(6,3) NOT NULL,
  `Gender` text NOT NULL,
  `Password` tinytext NOT NULL,
  `Token` int(11) NULL,
  `Access_Level` tinytext NOT NULL,
  `Failed_Count` int(1) NULL,
  `Failed_First_Time` int(20) NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='User definition';

-- --------------------------------------------------------

--
-- Table structure for table `tat_user_history`
--

CREATE TABLE IF NOT EXISTS `tat_user_history` (
  `Id` int(11) NOT NULL,
  `User_Id` int(11) NOT NULL,
  `Project_Id` int(11) NOT NULL,
  `Details` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Log of User history';

-- --------------------------------------------------------

--
-- Table structure for table `tat_user_skill`
--

CREATE TABLE IF NOT EXISTS `tat_user_skill` (
  `User_Id` int(11) NOT NULL,
  `Skill_Id` int(11) NOT NULL,
  `Skill_Level` varchar(15) NOT NULL,
  `Weighting` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='User skills matrix';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tat_audit`
--
ALTER TABLE `tat_audit`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `tat_course`
--
ALTER TABLE `tat_course`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `tat_course_instance`
--
ALTER TABLE `tat_course_instance`
  ADD PRIMARY KEY (`Id`), ADD KEY `Course_Id` (`Course_Id`), ADD KEY `Facilitator` (`Facilitator`);

--
-- Indexes for table `tat_course_project`
--
ALTER TABLE `tat_course_project`
  ADD KEY `Project_Id` (`Project_Id`), ADD KEY `Course_Instance_Id` (`Course_Instance_Id`);

--
-- Indexes for table `tat_course_student`
--
ALTER TABLE `tat_course_student`
  ADD KEY `User_Id` (`User_Id`), ADD KEY `Course_Instance_Id` (`Course_Instance_Id`);

--
-- Indexes for table `tat_project`
--
ALTER TABLE `tat_project`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `tat_project_requirements`
--
ALTER TABLE `tat_project_requirements`
  ADD KEY `Skill_Id` (`Skill_Id`), ADD KEY `Project_Id` (`Project_Id`);

--
-- Indexes for table `tat_project_user`
--
ALTER TABLE `tat_project_user`
  ADD KEY `User_Id` (`User_Id`), ADD KEY `Project_Id` (`Project_Id`);

--
-- Indexes for table `tat_skill`
--
ALTER TABLE `tat_skill`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `tat_user`
--
ALTER TABLE `tat_user`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `tat_user_history`
--
ALTER TABLE `tat_user_history`
  ADD PRIMARY KEY (`Id`), ADD KEY `User_Id` (`User_Id`), ADD KEY `Project_Id` (`Project_Id`);

--
-- Indexes for table `tat_user_skill`
--
ALTER TABLE `tat_user_skill`
  ADD KEY `User_Id` (`User_Id`), ADD KEY `Skill_Id` (`Skill_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tat_audit`
--
ALTER TABLE `tat_audit`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tat_course`
--
ALTER TABLE `tat_course`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tat_course_instance`
--
ALTER TABLE `tat_course_instance`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tat_project`
--
ALTER TABLE `tat_project`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tat_skill`
--
ALTER TABLE `tat_skill`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tat_user`
--
ALTER TABLE `tat_user`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tat_user_history`
--
ALTER TABLE `tat_user_history`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tat_course_instance`
--
ALTER TABLE `tat_course_instance`
ADD CONSTRAINT `tat_course_instance_ibfk_1` FOREIGN KEY (`Course_Id`) REFERENCES `tat_course` (`Id`),
ADD CONSTRAINT `tat_course_instance_ibfk_2` FOREIGN KEY (`Facilitator`) REFERENCES `tat_user` (`Id`);

--
-- Constraints for table `tat_course_project`
--
ALTER TABLE `tat_course_project`
ADD CONSTRAINT `tat_course_project_ibfk_1` FOREIGN KEY (`Project_Id`) REFERENCES `tat_project` (`Id`),
ADD CONSTRAINT `tat_course_project_ibfk_2` FOREIGN KEY (`Course_Instance_Id`) REFERENCES `tat_course_instance` (`Id`);

--
-- Constraints for table `tat_course_student`
--
ALTER TABLE `tat_course_student`
ADD CONSTRAINT `tat_course_student_ibfk_1` FOREIGN KEY (`User_Id`) REFERENCES `tat_user` (`Id`),
ADD CONSTRAINT `tat_course_student_ibfk_2` FOREIGN KEY (`Course_Instance_Id`) REFERENCES `tat_course_instance` (`Id`);

--
-- Constraints for table `tat_project_requirements`
--
ALTER TABLE `tat_project_requirements`
ADD CONSTRAINT `tat_project_requirements_ibfk_1` FOREIGN KEY (`Skill_Id`) REFERENCES `tat_skill` (`Id`),
ADD CONSTRAINT `tat_project_requirements_ibfk_2` FOREIGN KEY (`Project_Id`) REFERENCES `tat_project` (`Id`);

--
-- Constraints for table `tat_project_user`
--
ALTER TABLE `tat_project_user`
ADD CONSTRAINT `tat_project_user_ibfk_1` FOREIGN KEY (`User_Id`) REFERENCES `tat_user` (`Id`),
ADD CONSTRAINT `tat_project_user_ibfk_2` FOREIGN KEY (`Project_Id`) REFERENCES `tat_project` (`Id`);

--
-- Constraints for table `tat_user_history`
--
ALTER TABLE `tat_user_history`
ADD CONSTRAINT `tat_user_history_ibfk_1` FOREIGN KEY (`User_Id`) REFERENCES `tat_user` (`Id`),
ADD CONSTRAINT `tat_user_history_ibfk_2` FOREIGN KEY (`Project_Id`) REFERENCES `tat_project` (`Id`);

--
-- Constraints for table `tat_user_skill`
--
ALTER TABLE `tat_user_skill`
ADD CONSTRAINT `tat_user_skill_ibfk_1` FOREIGN KEY (`User_Id`) REFERENCES `tat_user` (`Id`),
ADD CONSTRAINT `tat_user_skill_ibfk_2` FOREIGN KEY (`Skill_Id`) REFERENCES `tat_skill` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
