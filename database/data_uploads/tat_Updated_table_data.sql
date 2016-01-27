-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 20, 2015 at 07:14 PM
-- Server version: 5.6.24
-- PHP Version: 5.5.24

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='Course details';

--
-- Dumping data for table `tat_course`
--

INSERT INTO `tat_course` (`Id`, `Code`, `Title`, `Short_Description`, `Long_Description`) VALUES
(1, 'CPT110', 'Introduction to Information Technology', 'Introductory theory required to understand the components and operations of computer systems', 'This unit aims to provide you with the introductory theory required to understand the components and operations of computer systems, and wider issues surrounding the use of information technology in modern society. A major component of the unit is the practical application of the knowledge gained from the theoretical content. The material covers a broad range of introductory information technology concepts.'),
(2, 'CPT120', 'Introduction to Programming', 'In this introductory unit, you will learn to think in a step-wise algorithmic fashion and relate those steps to programs that will materialise your solution on a computer system.', 'Programming is now acknowledged as an important skill that can be used across a range of varied disciplines. It can be thought of as computer enabled and assisted problem solving. In this introductory unit, you will learn to think in a step-wise algorithmic fashion and relate those steps to programs that will materialise your solution on a computer system.\n\nWe are going to learn the basics of programming: Sequence, Selection and iteration through an exciting multimedia programming environment (the Python programming language). As a result, you will also gain some knowledge and understanding of the elements of picture manipulation in the course of using the basic programming constructs. The computer science aspects are the same as any introduction to programming style unit; the difference is that the medium of discourse and experience will be through the prism of image manipulation.'),
(3, 'CPT121', 'Programming 1', 'Object-oriented programming using the Java programming language', 'This unit introduces object-oriented programming using the Java programming language. This unit covers algorithm development using standard control structures, design methods such as stepwise refinement, the object-oriented programming framework, the use of standard Java classes and interfaces, the use of container classes, disk file processing, the Java Collection Framework (JCF), techniques for code reuse and basic strategies for software testing.'),
(4, 'CPT999', 'No Course Instance', 'Hope this works', 'Testing display for no course instance');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 COMMENT='specific instance of a course';

--
-- Dumping data for table `tat_course_instance`
--

INSERT INTO `tat_course_instance` (`Id`, `Course_Id`, `Year`, `Study_Period`, `Status`, `Facilitator`, `Projects_Created`, `Location`) VALUES
(1, 1, 2015, 'SP3', 'Active', 14, 'No', 'Online'),
(2, 1, 2015, 'SP1', 'Finished', 14, 'No', 'Online'),
(3, 1, 2016, 'SP1', 'Inactive', 14, 'No', 'Online'),
(4, 2, 2015, 'SP3', 'Active', 14, 'No', 'Online'),
(5, 2, 2015, 'Sem3', 'Active', 13, 'No', 'OnCampus'),
(6, 2, 2015, 'Sem4', 'Inactive', 13, 'No', 'OnCampus'),
(7, 3, 2015, 'Sem3', 'Active', 13, 'No', 'OnCampus');

-- --------------------------------------------------------

--
-- Table structure for table `tat_course_project`
--

CREATE TABLE IF NOT EXISTS `tat_course_project` (
  `Course_Instance_Id` int(11) NOT NULL,
  `Project_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Course Project Matrix';

--
-- Dumping data for table `tat_course_project`
--

INSERT INTO `tat_course_project` (`Course_Instance_Id`, `Project_Id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(4, 4),
(4, 5);

-- --------------------------------------------------------

--
-- Table structure for table `tat_course_student`
--

CREATE TABLE IF NOT EXISTS `tat_course_student` (
  `User_Id` int(11) NOT NULL,
  `Course_Instance_Id` int(11) NOT NULL,
  `Skills_Updated` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Course Student matrix';

--
-- Dumping data for table `tat_course_student`
--

INSERT INTO `tat_course_student` (`User_Id`, `Course_Instance_Id`, `Skills_Updated`) VALUES
(1, 1, 'No'),
(1, 4, 'Yes'),
(2, 4, 'No'),
(3, 4, 'Yes'),
(3, 5, 'No'),
(4, 4, 'No'),
(5, 5, 'No'),
(6, 7, 'No');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COMMENT='Project definition';

--
-- Dumping data for table `tat_project`
--

INSERT INTO `tat_project` (`Id`, `Title`, `Type`, `Short_Description`, `Long_Description`, `Manager_Id`, `Status`, `Size_Min`, `Size_Max`) VALUES
(1, 'Project 1', 'Development', 'Having a go', '', 0, '', 3, 4),
(2, 'Project 2', 'Development', 'Beach', '', 0, '', 3, 3),
(3, 'Project 3', 'Development', 'Sky Diving', '', 0, '', 3, 5),
(4, 'Project 4', 'Development', 'Running Away', '', 0, '', 4, 6),
(5, 'Project 5', 'Development', 'Jumping Sideways', '', 0, '', 4, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tat_project_requirements`
--

CREATE TABLE IF NOT EXISTS `tat_project_requirements` (
  `Skill_Id` int(11) NOT NULL,
  `Project_Id` int(11) NOT NULL,
  `Skill_Level` varchar(15) NOT NULL,
  `Weight` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Project skills requirements';

--
-- Dumping data for table `tat_project_requirements`
--

INSERT INTO `tat_project_requirements` (`Skill_Id`, `Project_Id`, `Skill_Level`, `Weight`) VALUES
(1, 1, 'Expert', 5),
(3, 1, 'Beginner', 1),
(8, 2, 'Beginner', 2),
(10, 3, 'Expert', 4),
(7, 4, 'Expert', 3),
(8, 4, 'Beginner', 3),
(10, 5, 'Beginner', 2),
(11, 5, 'Beginner', 3);

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COMMENT='Skill details';

--
-- Dumping data for table `tat_skill`
--

INSERT INTO `tat_skill` (`Id`, `Name`, `Short_Description`, `Long_Description`) VALUES
(1, 'PHP', '', ''),
(2, 'HTML & CSS', '', ''),
(3, 'Java', '', ''),
(4, 'Objective C', '', ''),
(5, 'Python', '', ''),
(6, 'Go Lang', '', ''),
(7, 'Ruby/Rails', '', ''),
(8, 'Javascript', '', ''),
(9, 'C#', '', ''),
(10, 'C', '', ''),
(11, 'C++', '', '');

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

--
-- Dumping data for table `tat_user`
--

INSERT INTO `tat_user` (`Id`, `First_Name`, `Last_Name`, `Email`, `Phone_Number`, `GPA`, `Gender`, `Password`, `Access_Level`, `Failed_Count`, `Failed_First_Time`) VALUES
(1, 'Stephen', 'Nicolas', 's3395568@student.rmit.edu.au', '9999 1111', '2.000', 'Male', '$1$T7FxzKN3$UpBv07qB4Mdg51gCiR./q1', 'student', NULL, NULL),
(2, 'Stephen', 'Maynard', 's3397906@student.rmit.edu.au', '1234 1111', '2.000', 'Male', '$1$Qj/94yBq$NcT132uMS4s9Z069HOb7o1', 'student', NULL, NULL),
(3, 'Arash', 'Rostami', 's3203792student.rmit.edu.au', '1111 9876', '2.000', 'Male', '$1$gV7.PPiB$/LoOydWUUzw/ytH2DMH7d0', 'student', NULL, NULL),
(4, 'Jakub', 'Romanak', 's3413331@student.rmit.edu.au', '9999 6525', '2.000', 'Male', '$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1', 'student', NULL, NULL),
(5, 'Shannan', 'Galbraith', 's3288053@student.rmit.edu.au', '', '2.000', 'Male', '$1$AV/p4CnE$fYWsQuHydi8/o0QLmd/Dg.', 'student', NULL, NULL),
(6, 'Bradley', 'Davis', 's3390039@student.rmit.edu.au', '1122 3344', '2.000', 'Male', '$1$IY9ZG8Kc$29MHxDJ0Wgq77YtX9gL2g.', 'student', NULL, NULL),
(7, 'Stephen', 'Johnson', 'make@gmail.com', '9999 9999', '4.000', 'Male', '$1$wWnRaL9H$WKOGWl/y/CqafaitJmgTT.', 'student', NULL, NULL),
(8, 'Michael', 'Johnson', 'zero@bigpond.com', '02 9513 4516', '2.000', 'Male', '$1$rYud09Ix$nPhboxZ1xut6OfZYgcgyl1', 'student', NULL, NULL),
(9, 'Mikaela', 'Harley', 'mk545@gmail.com', '0444 4441 0000', '3.000', 'Female', '$1$T9nS4dQE$Cx1hxhEVs/AYlhyYv7uz50', 'student', NULL, NULL),
(10, 'Jessica', 'Jamison', 'jjjjt@gmail.com', '', '3.200', 'Female', '$1$StsX18jn$ZpZF7JBf2/lCR7RHoPobb/', 'student', NULL, NULL),
(11, 'Bev', 'Lyone', 'bl23@gmail.com', '0294525439', '1.600', 'Female', '$1$.uRcvcui$7LQlF1ST11/zoGkWhKmUd.', 'student', NULL, NULL),
(12, 'Sam', 'Ginger', '', '55548876', '3.850', 'Female', '', 'student', NULL, NULL),
(13, 'Jason', 'Blake', 'jblake@rmit.edu.au', '038547 1232', '0.000', 'Male', '$1$76xdgPbc$OB8FnanB8m01KqB6YIyP7/', 'lecturer', NULL, NULL),
(14, 'The', 'Thing', 'tt@rmit.edu.au', '', '0.000', 'Female', '$1$WhfzQmRL$LeOpfpQZKEJy75QxHkVPu.', 'lecturer', NULL, NULL),
(15, 'Victoria', 'Stringer', 'vs@rmit.edu.au', '03 9959 9999', '0.000', 'Female', '$1$DCwOsu0i$1KMRHKLPKITpyFMGvHD1z/', 'admin', NULL, NULL);

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
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Course_Id` (`Course_Id`),
  ADD KEY `Facilitator` (`Facilitator`);

--
-- Indexes for table `tat_course_project`
--
ALTER TABLE `tat_course_project`
  ADD KEY `Project_Id` (`Project_Id`),
  ADD KEY `Course_Instance_Id` (`Course_Instance_Id`);

--
-- Indexes for table `tat_course_student`
--
ALTER TABLE `tat_course_student`
  ADD KEY `User_Id` (`User_Id`),
  ADD KEY `Course_Instance_Id` (`Course_Instance_Id`);

--
-- Indexes for table `tat_project`
--
ALTER TABLE `tat_project`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `tat_project_requirements`
--
ALTER TABLE `tat_project_requirements`
  ADD KEY `Skill_Id` (`Skill_Id`),
  ADD KEY `Project_Id` (`Project_Id`);

--
-- Indexes for table `tat_project_user`
--
ALTER TABLE `tat_project_user`
  ADD KEY `User_Id` (`User_Id`),
  ADD KEY `Project_Id` (`Project_Id`);

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
  ADD PRIMARY KEY (`Id`),
  ADD KEY `User_Id` (`User_Id`),
  ADD KEY `Project_Id` (`Project_Id`);

--
-- Indexes for table `tat_user_skill`
--
ALTER TABLE `tat_user_skill`
  ADD KEY `User_Id` (`User_Id`),
  ADD KEY `Skill_Id` (`Skill_Id`);

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
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tat_course_instance`
--
ALTER TABLE `tat_course_instance`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tat_project`
--
ALTER TABLE `tat_project`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tat_skill`
--
ALTER TABLE `tat_skill`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `tat_user`
--
ALTER TABLE `tat_user`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
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
