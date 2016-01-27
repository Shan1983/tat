<?php
class EditUser {

    private $db;

    function __construct( $DB_con ) {
        $this->db = $DB_con;

    }

    public function searchForUser($query){
        $stmt = $this->db->prepare("SELECT Id, employee_number, First_Name, Last_Name
                                    FROM tat_user
                                    WHERE employee_number
                                    LIKE :query
                                    ORDER BY employee_number");


        $stmt->execute(array(':query' => '%'.$query.'%'));;

        $results = $stmt->fetchAll();

        return $results;
    }


    // this requires testing asmy database is full of garbage!!
    public function selectCourse($id){
        $stmt = $this->db->prepare("SELECT *
    FROM tat_course_student
    INNER JOIN tat_course_instance
         ON tat_course_instance.Id = tat_course_student.Course_Instance_Id
    INNER JOIN tat_course
         ON tat_course.Id = :id
   ");

        $stmt->execute(array(':id' => $id));

        $results = $stmt->fetchAll();

        return $results;
    }

    public function assignUserCourse($sid,$cid){
        $stmt = $this->db->prepare("INSERT INTO tat_course_student (User_Id, Course_Instance_Id, Skills_Updated ) VALUES('$sid', '$cid', 'No')");
        $stmt->execute();
        $_SESSION['user_edited'] = 1;
        unset($_SESSION['results_instance']);
        unset($_SESSION['users_from_search']);

    }
}