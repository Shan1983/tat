<?php
 class ChangePassword {

     private $db;

     function __construct( $DB_con ) {
         $this->db = $DB_con;

     }

     public function change_password($old,$new){
         $stmt = $this->db->prepare("UPDATE tat_user SET Password = '$new' WHERE Password = '$old'");
         $stmt->execute();
         header('Location: login.php');
     }

     public function verifyPassword($pass){
         $stmt = $this->db->prepare("SELECT Password FROM tat_user WHERE Password = '$pass'");
         //echo "SELECT Password FROM tat_user WHERE Password = '$pass'";
         $stmt->execute();
         $result = $stmt->fetch();

         return $result;
     }
 }