<?php
require_once('./controller/user-db-config.php');
require_once('./controller/class_student_import.php');

$import = new StudentImport($DB_con);


if(isset($_POST['do_import'])){
    // get the extension of the file
    $extension = end(explode('.', $_FILES['file']['name']));
    $name       = $_FILES['file']['name'];
    $temp_name  = $_FILES['file']['tmp_name'];
    // test which method to call
    if($extension == 'xls' || $extension == 'xlsx'){
        if(isset($name)){
            if(!empty($name)){
                $location = 'uploads/';
                if(move_uploaded_file($temp_name, $location.$name)){
                    $import->importExcelDataGPA();
                    $success = "All data has been uploaded!";
                }
            }
        }
    }else if($extension == 'csv'){
        // prepare to upload CSV file
        if(isset($name)){
            if(!empty($name)){
                $location = 'uploads/';
                if(move_uploaded_file($temp_name, $location.$name)){
                    $import->importCsvDataGPA();
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
            <h1 class="page-header">Import GPA Data</h1>
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
                            <?php if ( isset( $success ) ) : ?>
                                <div class="alert alert-success">
                                    <i class="glyphicon glyphicon-ok"></i> &nbsp; <?php echo $success; ?>
                                </div> <?php
                            endif; ?>
                            <label>Please import your GPA data file, this file can be in both csv and excel formats</label>
                            <p>If you are importing by CSV file, please make sure no titles are present in the CSV data.</p>
                            <label>Excel Template: </label><a href="assets/Docs/template_GPA.xlsx" target="_blank"> Download</a>
                            <input type="file" class="form-control"  name="file">
                            <br />
                            <input type="submit" class="btn btn-outline btn-primary" name="do_import" value="Import Data">
                        </div>


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

