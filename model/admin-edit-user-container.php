<?php
require('controller/EditUser.php');
require_once('controller/user-db-config.php');
$edit = new EditUser($DB_con);
//unset($_SESSION['results']);
//unset($_SESSION['results_instance']);
//unset($_SESSION['users_from_search']);
 //first we try and find the entered student via employee number or name.
if(isset($_POST['do_search_user'])){
    unset($_SESSION['users_from_search']);
    if(empty($_POST['search_sid']) || $_POST['search_sid'] == ''){
        unset($_SESSION['users_from_search']);
    }else{
        $_SESSION['users_from_search'] = $edit->searchForUser($_POST['search_sid']);
    }
    //echo "POST = " . $_POST['search_sid'];
 //search for the users query, and return any found records

}

if(isset($_POST['do_select_course_instance'])){
    $sid = 0;
    //unset($_SESSION['results_instance']);
    //echo "POST = " . $_POST['search_sid'];
    //search for the users query, and return any found records
    $_SESSION['results_instance'] = $edit->selectCourse($_POST['txt-select-assoc']);
    //echo "user id = " . $_POST['user'] . "course instance id = " . $_SESSION['results_instance'];
    foreach($_POST['user'] as $u){
        $sid = $u;
    }

        $cid = $_POST['txt-select-assoc'];

   if(isset($_POST['user'])){
       $edit->assignUserCourse($sid, $cid);
   }else{
       echo "no instance";
   }
}

//if(isset($_POST['do_add_user_list']) && isset($_POST['list_students'])){
//
//    $_SESSION['results_instance'][] = $_POST['list_students'];
//    $_SESSION['results_added'] = $_SESSION['results_instance'];
//}

?>
<div id="page-wrapper">
    <div class="row">
        <div class="col-sm-12">
            <h1 class="page-header">Edit User</h1>
        </div>
    </div><!-- /.row -->

    <?php
    // used to display a message if a user has been successfully added
    if ( isset($_SESSION['user_edited']) ) {
        if ($_SESSION['user_edited'] == 1) { ?>
            <div class="row">
                <div class="col-lg-12">
                    <div class="alert alert-success">
                        <i class="glyphicon glyphicon-ok"></i> &nbsp; <p>User added successfully!<p>
                    </div>
                </div>                 <!-- /.col-lg-12 -->
            </div>
            <?php
            // unset $_SESSION['course_added']
            unset($_SESSION['user_edited']);
        }
    } ?>

    <?php
    // used to display error to user
    // if value is set, show message for adding user errors
    if ( isset( $_SESSION['edit_user_error'] ) ) {
        $error = $_SESSION['edit_user_error'];
        ?>
        <div class="row">
            <div class="col-lg-12">
                <div class="alert alert-danger">
                    <p>
                        <i class="glyphicon glyphicon-warning-sign"></i> &nbsp; <?php echo $error; ?>
                    </p>
                </div>
            </div>                 <!-- /.col-lg-12 -->
        </div>
        <?php unset( $_SESSION['edit_user_error']);
    } ?>

    <div class="row">
        <div class="col-lg-9">
            <form role="form" method="post"  >
                <div class="row">
                    <div class="col-lg-9">
                        <div class="form-group">
                            <label>Search student number</label>
                            <input type="text" name="search_sid" class="form-control" placeholder="Enter users student/employee number" >
                            <br/>
                            <button type="submit" name="do_search_user" class="btn btn-outline btn-primary pull-right">Search User</button>
                            <br/>
                            <hr/>
                            <?php if(isset($_SESSION['users_from_search'])) { ?>
                                <label>Select user(s) to assign to a course</label>
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th>Id</th>
                                    <th>First name</th>
                                    <th>Suname</th>
                                    <!--										<th>Action</th>-->
                                </tr>
                                </thead>

                                <tbody>
                                <?php foreach($_SESSION['users_from_search'] as $result) { ?>
                                <tr>
                                    <td><input type="checkbox" name="user[]" value="<?php echo $result[0]; ?>"></td>
                                    <td><?php echo $result['employee_number']; ?></td>
                                    <td><?php echo $result['First_Name']; ?></td>
                                    <td><?php echo $result['Last_Name']; ?></td>
                                </tr>
                                <?php } ?>

                                </tbody>
                                </table>
                                <hr/>


                        </div>
                        <div class="form-group">
                            <label>Choose a course to associate user to.</label>
                            <select class="form-control" name="txt-select-assoc">
                                <option value="0">Please Select A Course</option>
                                <?php
                                foreach($user->tat_get_course_data() as $data) {
                                    //echo "<pre>" . var_dump($data) . "</pre>";

                                    $_SESSION['courses'] =  "<option value=" . $data[0] . ">" . $data['Code'] . " " . $data['Title']
                                        . " " . "(" . $data['Year'] . ")" . " - " . $data['Study_Period']. "</option>";
                                    echo "<option value=" . $data[0] . ">" . $data['Code'] . " " . $data['Title']
                                        . " " . "(" . $data['Year'] . ")" . " - " . $data['Study_Period']. "</option>";
                                }
                                ?>
                            </select>
                            <br/>
                            <button type="submit" name="do_select_course_instance" class="btn btn-outline btn-primary pull-right">Assign user to course</button>
                            <br/>
                            <hr/>
                            <?php } ?>
                        </div>
<!--                        <div class="form-group">-->
<!--                            <label>Select user and add/remove from student list in selected course.</label>-->
<!---->
<!--                            <select size="7" style="width: 195px; height: 200px;font-size:11px;" name="list_students" class="list-group">-->
<!--                                --><?php
//                                // check if search is set if it is than.. carry on..
//
//                                foreach($_SESSION['results'] as $result) {  ?>
<!--                                <option class="list-group-item" value="--><?php //echo $result['employee_number'] .
//                                    " " . $result['First_Name'] . " " . $result['Last_Name']; ?>
<!--                                "><small>--><?php //echo $result['employee_number'] .
//                                    " " . $result['First_Name'] . " " . $result['Last_Name']; ?><!--</small>-->
<!--                                --><?php //}  ?>
<!--                            </select>-->
<!--                            <button type="submit" name="do_remove_user_list" class="btn btn-outline btn-primary "><<</button>-->
<!--                            <button type="submit" name="do_add_user_list" class="btn btn-outline btn-primary ">>></button>-->
<!--                            <select size="7" style="width: 195px; height: 200px;font-size:11px;" name="list_instances" class="list-group">-->
<!---->
<!--                                --><?php //if(isset($_SESSION['results_added'])) { ?>
<!--                                --><?php //foreach($_SESSION['results_added'] as $r) { ?>
<!--                                <option class="list-group-item" value="--><?php //echo $r ?><!--"><small>-->
<!--                                        --><?php //echo  $r; ?><!--</small>-->
<!--                                    --><?php //break;} } ?>
<!---->
<!--                                --><?php
//                                // check if search is set if it is than.. carry on..
//
//                                foreach($_SESSION['results_instance'] as $result_i) {
//
//                                ?>
<!---->
<!--                                <option class="list-group-item" value="--><?php //echo $result_i['employee_number'] .
//                                    " " . $result_i['First_Name'] . " " . $result_i['Last_Name']; ?><!--"><small>--><?php //echo  $result_i['employee_number'] .
//                                            " " . $result_i['First_Name'] . " " . $result_i['Last_Name']; ?><!--</small>-->
<!--                                    --><?php //  } ?>
<!--                            </select>-->
<!--                            <button type="submit" name="do_commit_instance" class="btn btn-outline btn-primary ">Add to course</button>-->
<!--                            <hr/>-->
<!--                        </div>-->
<!---->
<!---->
<!--                        <div class="form-group">-->
<!--                            <label>Student Number</label>-->
<!--                            <input type="text" name="sid" class="form-control" placeholder="Enter new user's student number" >-->
<!--                        </div>-->
<!--                        <div class="form-group">-->
<!--                            <label>First Name</label>-->
<!--                            <input type="text" name="first_name" class="form-control" placeholder="Enter new user's first name" >-->
<!--                        </div>-->
<!---->
<!--                        <div class="form-group">-->
<!--                            <label>Last Name</label>-->
<!--                            <input type="text" name="last_name" class="form-control" placeholder="Enter new user's last name" >-->
<!--                        </div>-->
<!---->
<!--                        <div class="form-group">-->
<!--                            <label>E-mail</label>-->
<!--                            <input type="email" name="user_email" class="form-control" placeholder="Enter a valid e-mail address" >-->
<!--                        </div>-->
<!---->
<!--                        <div class="form-group">-->
<!--                            <label>Phone number</label>-->
<!--                            <input type="text" name="phone_number" class="form-control" placeholder="Enter users contact phone number" >-->
<!--                        </div>-->
<!---->
<!--                    </div>-->
<!--                </div>-->
<!---->
<!--                <div class="row">-->
<!--                    <div class="col-lg-3">-->
<!--                        <div class="form-group">-->
<!--                            <label>Gender</label>-->
<!--                            <select name="gender" class="form-control" >-->
<!--                                <option name="gender" value="">--Please select a gender--</option>-->
<!--                                <option name="gender" value="male">Male</option>-->
<!--                                <option name="gender" value="female">Female</option>-->
<!--                            </select>-->
<!--                        </div>-->
<!--                    </div>-->
<!---->
<!--                    <div class="col-lg-3">-->
<!--                        <div class="form-group">-->
<!--                            <label>User Type</label>-->
<!--                            <select name="user_type" class="form-control" >-->
<!--                                <option name="user_type" value="">--Please select a user type--</option>-->
<!--                                <option name="user_type" value="student">Student</option>-->
<!--                                <option name="user_type" value="lecturer">Lecturer</option>-->
<!--                                <option name="user_type" value="admin">Administrator</option>-->
<!--                            </select>-->
<!--                        </div>-->
<!--                    </div>-->
<!---->
<!--                    <div class="col-lg-3">-->
<!--                        <div class="form-group">-->
<!--                            <label>Student GPA</label>-->
<!--                            <input type="text" name="student_gpa" class="form-control" placeholder="Leave blank for lecturers/admins">-->
<!--                        </div>-->
<!--                    </div>-->
<!--                </div>-->
<!---->
<!---->
<!--                <div class="row">-->
<!--                    <div class="col-lg-9">-->
<!---->
<!--                        <!-- DO NOT USE THIS AT THIS TIME-->
<!--                            <div class="form-group">-->
<!--                                <label>Password</label>-->
<!--                                <input type="password" name="password" class="form-control" placeholder="Enter a password" required>-->
<!--                            </div>-->
<!---->
<!--                            <div class="form-group">-->
<!--                                <label>Confirm Password</label>-->
<!--                                <input type="password" name="password_confirm" class="form-control" placeholder="Re-enter the exact password" required>-->
<!--                            </div>-->
<!--                        -->
<!---->
<!--                        <button type="submit" name="do_edit_user" class="btn btn-outline btn-primary">Edit User</button>-->
<!--                       -->
                    </div>

                </div>

            </form> <!-- end of self submit form -->
        </div>

    </div><!-- /.row (nested) -->
</div><!-- /.page-wrapper -->