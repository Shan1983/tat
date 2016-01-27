<?php
require ('controller/Emailer.php');
require_once 'assets/Classes/PHPExcel/IOFactory.php';
require('controller/random_string.php');


class StudentImport
{
    private $name;
    private $db;

    function __construct($DB_con)
    {
        $this->db = $DB_con;

    }


    public function importExcelData($id)
    {

        $sql = null;
        $inputFileName = "uploads/" . $_FILES['file']['name'];
        //create random string
        $length = 10;


//  Read your Excel workbook
        $objPHPExcel = PHPExcel_IOFactory::load($inputFileName);
        PHPExcel_Calculation::getInstance($objPHPExcel)->cyclicFormulaCount = 1;
        $sheet = $objPHPExcel->getActiveSheet();
        $highR = $sheet->getHighestRow();
        $highC = $sheet->getHighestColumn();

        $sheetData = $sheet->rangeToArray('A2:' . $highC . $highR, NULL, TRUE, FALSE);
        for ($i = 0; $i < count($sheetData); $i++) {
            // assign new temp password per excel record
            $temp_password = random_str($length);
            //random_str($length);
            $temp_hash = password_hash($temp_password, PASSWORD_DEFAULT);
            $empId = $sheetData[$i][0];
            $fname = $sheetData[$i][1];
            $surname = $sheetData[$i][2];
            $email = $sheetData[$i][3];
            $phone = $sheetData[$i][4];
            $gender = $sheetData[$i][5];

            // check if employee number exists
            $stmt = $this->db->prepare("SELECT employee_number, Email FROM tat_user WHERE employee_number = '$empId'
                                        OR Email = '$email'");
            $stmt->execute();
           
            // insert student data
            if($stmt->rowCount() == 0){
                $stmt = $this->db->prepare("INSERT INTO tat_user (employee_number, First_Name, Last_Name, Email, Phone_Number, Gender, Password, Access_Level, Token)
                                            VALUES('$empId','$fname', '$surname', '$email',
                                            '$phone', '$gender','$temp_password', 'student', '$temp_password')");
                $stmt->execute();

                // insert user id and course id
                $stmt = $this->db->prepare("SELECT Id FROM tat_user WHERE employee_number = '$empId'");
                $stmt->execute();
                $result = $stmt->fetch();
                $sid = $result['Id'];
                $stmt = $this->db->prepare("INSERT INTO tat_course_student (User_Id, Course_Instance_Id, Skills_Updated)
                                            VALUES('$sid','$id', 'No')");
                $stmt->execute();

                // send the emails to inform the students
                $fullName = $fname . " " . $surname;
                $email = new Emailer();
                $email->sendStudentTempEmail($sheetData[$i][3], $fullName, $temp_password);
            }else{
                // check if student exists in course instance
                $stmt = $this->db->prepare("SELECT employee_number, Email FROM tat_course_student AS cs 
                                            LEFT JOIN tat_user AS u ON (cs.User_Id=u.id) 
                                            WHERE cs.Course_Instance_Id=$id 
                                            AND (employee_number='$empId' OR Email='$email')");
                $stmt->execute();

                if ($stmt->rowCount() == 0) {
                    // insert user id and course id
                    $stmt = $this->db->prepare("SELECT Id FROM tat_user WHERE employee_number = '$empId'");
                    $stmt->execute();
                    $result = $stmt->fetch();
                    $sid = $result['Id'];

                    $stmt = $this->db->prepare("INSERT INTO tat_course_student (User_Id, Course_Instance_Id, Skills_Updated)
                                                VALUES('$sid','$id', 'No')");
                    $stmt->execute();

                    // send the emails to inform the students
                    $fullName = $fname . " " . $surname;
                    $email = new Emailer();
                    $email->sendStudentAddedToCourseEmail($sheetData[$i][3], $fullName);

                } else {
                    $_SESSION['none_adds'][] = $empId . " " . $fname . " " . $surname . " " . $email;                    
                }
            }

        }

    }

    public function importCsvData($id)
    {
        $file = fopen("uploads/" . $_FILES['file']['name'], "r");
        $i = 0;
        while (!fof($file)) {
            $value = (fgetcsv($file, 0, ';'));
            if ($i > 0) {
                if ($value[0] != '') {
                    $empId = $value[0];
                    $fname = $value[1];
                    $surname = $value[2];
                    $email = $value[3];
                    $phone = $value[4];
                    $gender = $value[5];

                    $length = 10;
                    $temp_password = random_str($length); // generates temp password
                    $stmt = $this->db->prepare("SELECT employee_number FROM tat_user WHERE employee_number = '$empId'");
                    $stmt->execute();

                    // insert student data
                    if($stmt->rowCount() == 0){
                        $stmt = $this->db->prepare("INSERT INTO tat_user (employee_number, First_Name, Last_Name, Email, Phone_Number, Gender, Password, Access_Level, Token)
                                            VALUES('$empId','$fname', '$surname', '$email',
                                            '$phone', '$gender','$temp_password', 'student', '$temp_password')");
                        $stmt->execute();

                        // insert user id and course id
                        $stmt = $this->db->prepare("SELECT Id FROM tat_user WHERE employee_number = '$empId'");
                        $stmt->execute();
                        $result = $stmt->fetch();
                        $sid = $result['Id'];
                        $stmt = $this->db->prepare("INSERT INTO tat_course_student (User_Id, Course_Instance_Id, Skills_Updated)
                                            VALUES('$sid','$id', 'No')");
                        $stmt->execute();

                        // sebd the emails to inform the students
                        $fullName = $fname . " " . $surname;
                        $email = new Emailer();
                        $email->sendStudentTempEmail($email, $fullName, $temp_password);
                    }else{
                        $_SESSION['none_adds'][] = $empId . " " . $fname . " " . $surname . " " . $email;
                    }

                }
            }
        }
        fclose($file);


    }

    public function importExcelDataGPA(){
        $sql = null;
        $inputFileName = "uploads/" . $_FILES['file']['name'];
        //create random string
        $length = 10;


//  Read your Excel workbook
        $objPHPExcel = PHPExcel_IOFactory::load($inputFileName);
        PHPExcel_Calculation::getInstance($objPHPExcel)->cyclicFormulaCount = 1;
        $sheet = $objPHPExcel->getActiveSheet();
        $highR = $sheet->getHighestRow();
        $highC = $sheet->getHighestColumn();

        $sheetData = $sheet->rangeToArray('A2:' . $highC . $highR, NULL, TRUE, FALSE);
        for ($i = 0; $i < count($sheetData); $i++) {
            // assign new temp password per excel record
            $temp_password = random_str($length);
            //random_str($length);
            $temp_hash = password_hash($temp_password, PASSWORD_DEFAULT);
            $empId = $sheetData[$i][0];
            $gpa = $sheetData[$i][1];


//                echo "INSERT INTO tat_user (employee_number, First_Name, Last_Name, Email, Phone_Number, Gender, Password, Access_Level, Token)
//                                            VALUES('$empId','$fname', '$surname', '$email',
//                                            '$phone', '$gender','$temp_password', 'student', '$temp_password')";

            $stmt = $this->db->prepare("UPDATE tat_user SET GPA = '$gpa' WHERE employee_number = '$empId'");
            $stmt->execute();


            //echo $email;
            //$email = new Emailer();
            //$email->sendStudentTempEmail($sheetData[$i][3], $fullName, $temp_password);


        }

    }
}




