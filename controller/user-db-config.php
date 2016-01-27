<?php
session_start();
$DB_host = 'localhost';
$DB_user = 'tat';
$DB_pass = 't7=8%evH5D1E';
$DB_name = 'tat';

try {
	$DB_con = new PDO( "mysql:host={$DB_host};dbname={$DB_name}", $DB_user, $DB_pass);
	$DB_con->setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION );
}
catch( PDOException $e ) {
  echo $e->getMessage();
}
include_once( 'class-user-db-config.php' );
$user = new USER_DB_CONFIG( $DB_con );
