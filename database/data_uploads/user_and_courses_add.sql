DELETE FROM tat_course_student;
DELETE FROM tat_course_project;
DELETE FROM tat_course_instance;
DELETE FROM tat_user;
DELETE FROM tat_course;
DELETE FROM tat_project;
ALTER TABLE tat_user AUTO_INCREMENT = 1;
INSERT INTO tat_user (First_Name, Last_Name, Email, Phone_Number, GPA, Gender, Password, Access_Level) VALUES
("Stephen", "Nicolas", "s3395568@student.rmit.edu.au", "9999 1111", 2, "Male", "$1$T7FxzKN3$UpBv07qB4Mdg51gCiR./q1", "student"),
("Stephen", "Maynard", "s3397906@student.rmit.edu.au", "1234 1111", 2, "Male", "$1$Qj/94yBq$NcT132uMS4s9Z069HOb7o1", "student"),
("Arash", "Rostami", "s3203792student.rmit.edu.au", "1111 9876", 2, "Male", "$1$gV7.PPiB$/LoOydWUUzw/ytH2DMH7d0", "student"),
("Jakub", "Romanak", "s3413331@student.rmit.edu.au", "9999 6525", 2, "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student"),
("Shannan", "Galbraith", "s3288053@student.rmit.edu.au", "", 2, "Male", "$1$AV/p4CnE$fYWsQuHydi8/o0QLmd/Dg.", "student"),
("Bradley", "Davis", "s3390039@student.rmit.edu.au", "1122 3344", 2, "Male", "$1$IY9ZG8Kc$29MHxDJ0Wgq77YtX9gL2g.", "student"),
("Stephen", "Johnson", "make@gmail.com", "9999 9999", 4, "Male", "$1$wWnRaL9H$WKOGWl/y/CqafaitJmgTT.", "student"),
("Michael", "Johnson", "zero@bigpond.com", "02 9513 4516", 2, "Male", "$1$rYud09Ix$nPhboxZ1xut6OfZYgcgyl1", "student"),
("Mikaela", "Harley", "mk545@gmail.com", "0444 4441 0000", 3, "Female", "$1$T9nS4dQE$Cx1hxhEVs/AYlhyYv7uz50", "student"),
("Jessica", "Jamison", "jjjjt@gmail.com","", 3.2, "Female", "$1$StsX18jn$ZpZF7JBf2/lCR7RHoPobb/", "student"),
("Bev", "Lyone", "bl23@gmail.com", "0294525439", 1.6, "Female", "$1$.uRcvcui$7LQlF1ST11/zoGkWhKmUd.", "student"),
("Sam", "Ginger", "", "55548876", 3.85, "Female", "", "student"),
("Jason", "Blake", "jblake@rmit.edu.au", "038547 1232", 0, "Male", "$1$76xdgPbc$OB8FnanB8m01KqB6YIyP7/", "lecturer"),
("The", "Thing", "tt@rmit.edu.au", "", 0, "Female", "$1$WhfzQmRL$LeOpfpQZKEJy75QxHkVPu.", "lecturer"),
("Victoria", "Stringer", "vs@rmit.edu.au", "03 9959 9999", 0, "Female", "$1$DCwOsu0i$1KMRHKLPKITpyFMGvHD1z/", "admin");
ALTER TABLE tat_course AUTO_INCREMENT = 1;
INSERT INTO tat_course (Code, Title, Long_Description, Short_Description) VALUES
("CPT110", "Introduction to Information Technology", "This unit aims to provide you with the introductory theory required to understand the components and operations of computer systems, and wider issues surrounding the use of information technology in modern society. A major component of the unit is the practical application of the knowledge gained from the theoretical content. The material covers a broad range of introductory information technology concepts.", "Introductory theory required to understand the components and operations of computer systems"),
("CPT120", "Introduction to Programming", "Programming is now acknowledged as an important skill that can be used across a range of varied disciplines. It can be thought of as computer enabled and assisted problem solving. In this introductory unit, you will learn to think in a step-wise algorithmic fashion and relate those steps to programs that will materialise your solution on a computer system.

We are going to learn the basics of programming: Sequence, Selection and iteration through an exciting multimedia programming environment (the Python programming language). As a result, you will also gain some knowledge and understanding of the elements of picture manipulation in the course of using the basic programming constructs. The computer science aspects are the same as any introduction to programming style unit; the difference is that the medium of discourse and experience will be through the prism of image manipulation.", "In this introductory unit, you will learn to think in a step-wise algorithmic fashion and relate those steps to programs that will materialise your solution on a computer system."),
("CPT121", "Programming 1", "This unit introduces object-oriented programming using the Java programming language. This unit covers algorithm development using standard control structures, design methods such as stepwise refinement, the object-oriented programming framework, the use of standard Java classes and interfaces, the use of container classes, disk file processing, the Java Collection Framework (JCF), techniques for code reuse and basic strategies for software testing.", "Object-oriented programming using the Java programming language"),
("CPT999", "No Course Instance", "Testing display for no course instance", "Hope this works");
ALTER TABLE tat_course_instance AUTO_INCREMENT = 1;
INSERT INTO tat_course_instance (Course_Id, Year, Study_Period, Status, Facilitator, Projects_Created, Location) VALUES
(1, 2015, "SP3", "Active", 14, "No", "Online"),
(1, 2015, "SP1", "Finished", 14, "No", "Online"),
(1, 2016, "SP1", "Inactive", 14, "No", "Online"),
(2, 2015, "SP3", "Active", 14, "No", "Online"),
(2, 2015, "Sem3", "Active", 13, "No", "OnCampus"),
(2, 2015, "Sem4", "Inactive", 13, "No", "OnCampus"),
(3, 2015, "Sem3", "Active", 13, "No", "OnCampus");
ALTER TABLE tat_project AUTO_INCREMENT = 1;
INSERT INTO tat_project (Title, Type, Short_Description, Size_Min, Size_Max) VALUES
("Project 1", "Development", "Having a go", 3, 4),
("Project 2", "Development", "Beach", 3, 3),
("Project 3", "Development", "Sky Diving", 3, 5),
("Project 4", "Development", "Running Away", 4, 6),
("Project 5", "Development", "Jumping Sideways", 4, 4);
INSERT INTO tat_course_project (Course_Instance_Id, Project_Id) VALUES
(1, 1),
(1, 2),
(1, 3),
(4, 4),
(4, 5);
INSERT INTO tat_course_student (User_Id, Course_Instance_Id, Skills_Updated) VALUES
(1, 1, "No"),
(1, 4, "Yes"),
(2, 4, "No"),
(3, 4, "Yes"),
(3, 5, "No"),
(4, 4, "No"),
(5, 5, "No"),
(6, 7, "No")

