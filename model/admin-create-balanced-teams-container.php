<?php
// clear the error and info sessions upon first run
if ( isset( $_SESSION['create_team_error'] ) && ( $_SESSION['create_team_error'] == "") ) {
    unset($_SESSION['create_team_error']);
}
if ( isset( $_SESSION['create_team_info'] ) && ( $_SESSION['create_team_info'] == "") ) {
    unset($_SESSION['create_team_info']);
}
?>
<script type="text/javascript">

// used to check for modal querystring
// source: http://stackoverflow.com/questions/3788125/jquery-querystring
function querystring(key) {
   var re=new RegExp('(?:\\?|&)'+key+'=(.*?)(?=&|$)','gi');
   var r=[], m;
   while ((m=re.exec(document.location.search)) != null) r.push(m[1]);
   return r;
}

var querystring = querystring('modal');

// display modal window depending on course instance status
if (querystring.length && querystring[0]==='interim' ) {
    $(document).ready(function(){
        $('#modalInterim').modal('show');
    });
} else if (querystring.length && querystring[0]==='approved' ) {
    $(document).ready(function(){
        $('#modalApproved').modal('show');
    });
}

// redirects to the view allocations page
function viewAllocations() {
    window.location = "allocated-teams-gui.php?cid=<?php echo $_SESSION['create-team-cid'];?>";
}

// redirects to the view allocations page
function startAllocating() {
    window.location = "create-team-progress-gui.php";
}

</script>

<!-- modal window prompt for an existing team allocation yet to be approved -->
<div class="modal fade" id="modalInterim" tabindex="-1" data-keyboard="false" data-backdrop="static" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">Team allocation exists</h4>
            </div>
            <div class="modal-body">
                A team allocation already exists for the selected course instance, but yet to be approved.
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-default" onclick="startAllocating();" data-dismiss="modal">Create New Teams</button>
                <button type="button" class="btn btn-primary" onclick="viewAllocations();" data-dismiss="modal">View Allocation</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- modal window prompt for an existing team allocation that is approved -->
<div class="modal fade" id="modalApproved" tabindex="-1" data-keyboard="false" data-backdrop="static" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">Team allocation approved</h4>
            </div>
            <div class="modal-body">
                A team allocation has been approved for this course instance. A new allocation cannot be created.
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary" onclick="viewAllocations();" data-dismiss="modal">View Allocation</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<div id="page-wrapper">
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">Create Balanced Teams</h1>
		</div>
	</div>
	<!-- /.row -->
    <?php 
    // used to display error messages
    if ( isset( $_SESSION['create_team_error'] ) || isset( $error ) ) {
        $error = $_SESSION['create_team_error'];
    ?>
    <div class="alert alert-danger">
        <i class="glyphicon glyphicon-warning-sign"></i> &nbsp; <?php echo $error; ?>
    </div>
    <?php
        unset( $_SESSION['create_team_error'] );
    }

    // used to display alert messages
    if ( isset( $_SESSION['create_team_info'] ) || isset( $info ) ) {
        $info = $_SESSION['create_team_info'];
    ?>
	<div class="alert alert-info">
		<?php echo $info; ?>
	</div>
    <?php
        unset( $_SESSION['create_team_info'] );
    }
    ?>
	<div class="row">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-4">
					<form role="form" method="post" action="controller/allocate_team.php">
						<div class="form-group">
							<label>Course to Allocate</label>
							<select class="form-control" name="txt-select-course-instance">
								<option value="0">Please Select A Course</option>
								<?php
								// loop through all course instances
								foreach($user->tat_get_course_data() as $data) {
									// maintain the selection for the last selected course instance
                                    //echo "<pre>" . var_dump($data) . "</pre>";
									if ($_SESSION['create-team-cid'] ==  $data[0]) {
										$selected = " selected=true";
									} else {
										$selected = "";
									}
									// exclude inactive and incomplete courses from the dropdown as they are not ready
									if ( $data['Status'] != "Inactive" ) {
                                    	echo "<option value=" . $data[0] . $selected . ">" . $data['Code'] . " " . $data['Title']
                                        	. " " . "(" . $data['Year'] . ")" . " - " . $data['Study_Period']. "</option>";
                                    }
                                }?>
							</select>
						</div>
						<div class="form-group">
							<label>Allocation Method</label>
							<select class="form-control" name="txt-select-allocation-method">
								<option value="Project_Focus_Simple">Project Focus Simple</option>
							</select>
						</div>
						<div class="form-group">
							<label>Max. Runtime (in seconds)</label>
							<select class="form-control" name="txt-max-runtime">
								<option>10</option><option>20</option><option selected>30</option><option>40</option><option>50</option><option>60</option><option>70</option><option>80</option><option>90</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary" name="do_create_teams">Create Teams</button> <br/><br/>
						<button type="submit" class="btn btn-outline btn-primary" name="do_view_allocation">View Allocations</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.row -->
</div>
<!-- /.page-wrapper -->