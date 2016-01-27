<?php
/*
 * Get user-db-config.php
 *
 * @package controller
 * @since 1.0
 */
require_once( 'controller/user-db-config.php' );

/*
 * Get login-control.php
 *
 * @package controller
 * @since 1.0
 */
require_once( 'controller/login-control.php' );

/*
 * Get header.php
 *
 * @package model
 * @since 1.0
 */
require_once( 'model/header.php' );

/*
 * Get menu-back-end.php
 *
 * @package model
 * @since 1.0
 */
require_once( 'model/menu-back-end.php' );

/*
 * Get dashboard-container.php
 *
 * @package model
 * @since 1.0
 */
// Check out user type to show the correct dashboard container
if ( $_SESSION['users_type'] == "admin" || $_SESSION['users_type'] == "lecturer") :
    require_once( 'model/admin-dashboard-container.php' );
else :   
  require_once( 'model/student-dashboard-container.php');
endif;

/*
 * Get footer.php
 * 
 * @package model
 * @since 1.0
 */
require_once( 'model/footer.php' );