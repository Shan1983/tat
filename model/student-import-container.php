<?php
require_once('./controller/user-db-config.php');
require_once('./controller/class_student_import.php');
require_once('./controller/class-user-db-config.php');

//unset($_SESSION['none_adds']);
$import = new StudentImport($DB_con);

if(isset($_POST['do_import'])){
    // get the extension of the file
    $extension = end(explode('.', $_FILES['file']['name']));
    $name       = $_FILES['file']['name'];
    $temp_name  = $_FILES['file']['tmp_name'];
    // test which method to call
    if ($_POST['select-assoc'] == 0) {
        $error = "Please choose a course to associate students to.";
    } else if ($extension == 'xls' || $extension == 'xlsx') {
        if(isset($name)){
            if(!empty($name)){
                $location = 'uploads/';
                if(move_uploaded_file($temp_name, $location.$name)){
                    $import->importExcelData($_POST['select-assoc']);
                    $success = "All data has been uploaded!";
                }
            }
        }
    } else if($extension == 'csv') {
    // prepare to upload CSV file
        if(isset($name)){
            if(!empty($name)){
                $location = 'uploads/';
                if(move_uploaded_file($temp_name, $location.$name)){
                    $import->importCsvData($_POST['select-assoc']);
                    $success = "All data has been uploaded!";
                }
            }
        }

    }else{
        $error = "Only Excel and CSV formats accepted! Please only upload one of these formats";
    }
}
?>
<div id="page-wrapper">
    <div class="row">
        <div class="col-sm-12">
            <h1 class="page-header">Import Students Data</h1>
        </div>
    </div><!-- /.row -->

    <div class="row">

            <div class="col-lg-9">
                <form role="form" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-lg-9">
                            <div class="form-group">
                                <?php if ( isset( $error ) ) : ?>
                                    <div class="alert alert-danger">
                                        <i class="glyphicon glyphicon-warning-sign"></i> &nbsp; <?php echo $error; ?>
                                    </div> <?php
                                endif; ?>
                                <?php if ( isset( $_SESSION['none_adds'] ) ) : ?>
                                    <div class="alert alert-warning">
                                        <i class="glyphicon glyphicon-warning-sign"></i> &nbsp; Not all students have been added!
                                    </div> <?php
                                endif; ?>
                                <?php if ( isset( $success ) ) { ?>
                                    <div class="alert alert-success">
                                        <i class="glyphicon glyphicon-ok"></i> &nbsp; <?php echo $success; ?>
                                    </div> <?php
                                }else{ ?>
                                    <div class="alert alert-info">
                                    <strong>Attention!</strong> This process can take some time to complete! Please do not close this browser window
                                    until you have received a success message!
                                </div>
                               <?php } ?>
                                <div class="form-group">
                                    <label>Please choose a course to associate students to.</label>
                                    <select class="form-control" name="select-assoc">
                                        <option value="0">Please Select A Course</option>
                                        <?php foreach($user->tat_get_course_data() as $data) {
                                            //echo "<pre>" . var_dump($data) . "</pre>";

                                            echo "<option value=" . $data[0] . ">" . $data['Code'] . " " . $data['Title']
                                                . " " . "(" . $data['Year'] . ")" . " - " . $data['Study_Period']. "</option>";

                                        }?>
                                    </select>
                                </div>
                                <hr/>
                                <label>Please import your students data file, this file can be in both csv and excel formats</label>
                                <p>If you are importing by CSV file, please make sure no titles are present in the CSV data.</p>
                                <label>Excel Template: </label><a href="assets/Docs/template.xlsx" target="_blank"> Download</a>
                                <input type="file" class="form-control"  name="file">
                                <br />
                                <input type="submit" class="btn btn-outline btn-primary" name="do_import" value="Import Data">
                            </div>
                            <?php if(isset($_SESSION['none_adds'])) {?>
                            <div class="form-group">
                                <label>These students were not added to due already belonging to the selected course instance.</label>
                                <table class="table table-striped">
                                    <?php foreach($_SESSION['none_adds'] as $results) { ?>
                                    <tr>

                                        <td><?php echo $results;  ?></td>


                                    </tr>
                                    <?php } ?>
                                </table>
                            </div>
                            <?php } unset($_SESSION['none_adds']); ?>
                        </div>
                    </div>


                                    <!-- /.table-responsive -->
                                </div>
                                <!-- /.panel-body -->
                            </div>
                            <!-- /.panel -->
                        </div>
                        <!-- /.col-lg-6 -->
                    </div>

                </form>
            </div>

        <!-- /.row (nested) -->
    </div><!-- /.page-wrapper -->

