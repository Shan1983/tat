<?php
require ('random_string.php');
require ('Emailer.php');
class User {
	private $id, $first_name, $last_name, $email, $phone_number, $gpa, $gender, $access_level;
	
	/**
	 * Constructor for the User class.
	 *
	 * @param $id -
	 *        	an integer
	 * @param $first_name -
	 *        	a string
	 * @param $last_name -
	 *        	a string
	 * @param $email -
	 *        	a string
	 * @param $phone_number -
	 *        	a string
	 * @param $gpa -
	 *        	a double
	 * @param $gender -
	 *        	a string
	 * @param $access_level -
	 *        	a string
	 */
	function __construct($id, $first_name, $last_name, $email, $phone_number, $gpa, $gender, $access_level) {
		$this->id = $id;
		$this->first_name = $first_name;
		$this->last_name = $last_name;
		$this->email = $email;
		$this->phone_number = $phone_number;
		$this->gpa = $gpa;
		$this->gender = $gender;
		$this->access_level = $access_level;
	}
	
	/**
	 *
	 * @param $DB_con -
	 *        	PDO Database connection object
	 */
	public function check_user_exists($DB_con) {
		// check if user already exists, comparing email addresses
		$check_query = "SELECT * FROM `tat_user` WHERE `Email` = :email";
		$check_stmnt = $DB_con->prepare ( $check_query );
		
		$check_stmnt->bindParam ( ':email', $this->email, PDO::PARAM_STR );
		
		$check_stmnt->execute ();
		
		// statement should not have a fetch results if match not found
		if ($check_stmnt->fetch ()) {
			// set error message and redirect
			$_SESSION ['add_user_error'] = 'The user record you are trying to add already exists in the system.';
			header ( 'Location: ../add_user_gui.php' );
			die ();
		}
	}
	
	/**
	 * Adds user to the databse.
	 * Creates a temporary randomly generated password string
	 * for user, emails the user a confirmation message about account creation
	 * along with
	 * temporary password string.
	 *
	 * @param $DB_con -
	 *        	PDO Database connection object
	 */
	public function add_user($DB_con) {
		// generate random password string
		$temp_password = random_str ( 10 );
		
		// not currently needed
		// hash password
		// if (isset($password)) {
		// $password = crypt($password);
		// }
		
		// prepare and executer query to add user to database
		$add_user_query = 'INSERT INTO `tat_user` (`employee_number`, `First_Name`, `Last_Name`, `Email`, `Phone_Number`, `GPA`, `Gender`, `Password`, `Access_Level`)
VALUES (:sid, :first_name, :last_name, :email, :phone_number, :gpa, :gender, :password, :access_level)';
		
		$statement = $DB_con->prepare ( $add_user_query );
		
		// bind query parameters
		$statement->bindParam ( ':sid', $this->id, PDO::PARAM_STR );
		$statement->bindParam ( ':first_name', $this->first_name, PDO::PARAM_STR );
		$statement->bindParam ( ':last_name', $this->last_name, PDO::PARAM_STR );
		$statement->bindParam ( ':email', $this->email, PDO::PARAM_STR );
		$statement->bindParam ( ':phone_number', $this->phone_number, PDO::PARAM_STR );
		$statement->bindParam ( ':gpa', $this->gpa, PDO::PARAM_STR );
		$statement->bindParam ( ':gender', $this->gender, PDO::PARAM_STR );
		$statement->bindParam ( ':password', $temp_password, PDO::PARAM_STR );
		$statement->bindParam ( ':access_level', $this->access_level, PDO::PARAM_STR );
		
		// execute query
		if (! $statement->execute ()) {
			// set error message and redirect user
			$_SESSION ['add_user_error'] = 'An unknown error has occurred. Please contact system support and provide a detailed description of what you were trying to accomplish when this error occurred. (Error: -1)';
			header ( 'Location: ../add_user_gui.php' );
			die ();
		} else {
			// redirect to dash board
			$_SESSION ['user_added'] = 1;
			$fullName = $this->first_name . " " . $this->last_name;
			// finally send them an email
			if ($this->access_level == 'lecturer') {
				$email = new Emailer ();
				$email->sendLecturerTempEmail ( $_POST ['user_email'], $fullName, $temp_password );
				header ( 'Location: ../add_user_gui.php' );
				die ();
			} else if ($this->access_level == 'student') {
				$email = new Emailer ();
				$email->sendStudentTempEmail ( $_POST ['user_email'], $fullName, $temp_password );
				header ( 'Location: ../add_user_gui.php' );
				die ();
			}
		}
	}
}