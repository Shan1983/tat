<?php
/*
 * This page  is used as the landing page for new students, once a new student receives there email and follows the
 * provided link, they will land here.
 *
 * Once here a few things will happen
 * 1. the database will be accessed and matched with the temp password.
 * 2. token will be checked if it equals 1. if it does then token will be returned to null and the user sent to the
 * change password page.
 * 3. if token is anything other then 1 the user is sent to the login page.
 */

require_once( 'controller/user-db-config.php' );

$p = $_GET['p'];

if(empty($p)){
    header('Location: login.php');
}

try {
    $stmt = $DB_con->prepare( "SELECT Token FROM tat_user WHERE Token = '$p'" );
    $stmt->execute();
    $stmt->fetch();

    if ( $stmt->rowCount() > 0 ) {
        $stmt = $DB_con->prepare("UPDATE tat_user SET Token = 'NULL' WHERE Password = '$p'");
        $stmt->execute();
        header('Location: change_password.php');
    }else{
        // no token
        header('Location: login.php');
    }
}catch ( PDOException $e ) {
    echo $e->getMessage();

}
