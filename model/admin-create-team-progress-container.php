<script type="text/javascript">
var es;

startProgressMonitor();

// starts the javascript progress monitor and event listener
// calls the allocation_progress.php
function startProgressMonitor() {
    es = new EventSource('controller/allocation_progress.php');

    //a message is received
    es.addEventListener('message', function(e) {
        var result = JSON.parse( e.data );

        if(result.message) {
            addLog(result.message);
        }

        if(e.lastEventId == 'COMPLETE') {
            addLog('Balanced team algorithm has successfully completed.');
            es.close();
            window.location = "allocated-teams-gui.php?cid=<?php echo $_SESSION['create-team-cid'];?>";
        } else if(e.lastEventId == 'CLOSE') {
            es.close();
            cdpause();
        }
    });

    es.addEventListener('error', function(e) {
        addLog('Error occurred' + e.detail.stack);
        es.close();
    });
}

// stops the javascript event listener and goes to the previous page
function cancelAndStop() {
    es.close();
    cdpause();
    window.location = "create-balanced-teams-gui.php";
}

// writes a message to the alert div
function addLog(message) {
    var r = document.getElementById('results');
    r.innerHTML = message;
    //r.innerHTML += message + '<br>';
}

var t, count;

// starts the countdown timer, needs to happen in onload function
window.onload = function () {
    cdreset();

    // allow time for algorithm to initialise
    addLog('Please wait, balanced team algorithm is initialising.');

    setTimeout(function () {
        countdown();
        // sends the initial message to indicate the progress monitor has started
        addLog('Balanced team algorithm has started. You will be directed to the results page when it is complete.');
    }, 10000);
};

// starts countdown
function countdown() {

    var pBar = document.getElementById('progressor');
    //pBar.value = result.progress;

    cddisplay();
    if (count === 0) {
        // time is up
        addLog('Max runtime limit has been reached and the algorithm did not generate results. Click <b>Cancel</b> to create a new balanced team.');
    } else {
        count--;
        t = setTimeout(countdown, 1000);
        pBar.setAttribute("aria-valuenow",(((<?php echo $_SESSION['create-team-runtime']; ?>-count)/<?php echo $_SESSION['create-team-runtime']; ?>)*100) );
        pBar.style.width = (((<?php echo $_SESSION['create-team-runtime']; ?>-count)/<?php echo $_SESSION['create-team-runtime']; ?>)*100) + "%";
    }
}

// pauses countdown timer
function cdpause() {
    clearTimeout(t);
}

// resets countdown
function cdreset() {
    cdpause();
    count = <?php echo $_SESSION['create-team-runtime'];?>;
    cddisplay();
}

// updates element display
function cddisplay() {
    document.getElementById('time').innerHTML = count;
}
</script>

<div id="page-wrapper">
    <div class="row">
        <div class="col-sm-12">
            <h1 class="page-header">Creating Teams...</h1>
        </div>
    </div>
    <!-- /.row -->
    <div class="alert alert-info">
        <div id="results"></div>
    </div>
    <?php
    // used to help debug what exec command is called
    //echo $_SESSION['create_team_exec_path'];
    ?>
    <div class="row">
        <div class="col-lg-12">
            <div class="row">
                <div class="col-lg-4">
                    Runtime monitor (<span id="time">time</span> seconds remaining)<br/>
                    <div class="progress">
                        <div class="progress-bar progress-bar-success" id="progressor" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%"></div>
                    </div>
                    <br/>
                    <input type="button" class="btn btn-outline btn-primary" onclick="cancelAndStop();"  value="Cancel" />
                </div>
            </div>
        </div>
    </div>
    <!-- /.row -->
</div>
<!-- /.page-wrapper -->