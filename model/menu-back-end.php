<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/dashboard.php">Team Allocation Tool</a>
    </div><!-- /navbar-header -->
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logout.php">Logout</a></li>
      </ul>
    </div><!-- /navbar-collapse -->
    <div class="navbar-default sidebar" role="navigation">
      <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu"><?php

          if ( $_SESSION['users_type'] == "admin" || $_SESSION['users_type'] == "lecturer") :
            require_once( 'partials/menu-admin-sidebar.php' );
          else :
            require_once( 'partials/menu-student-sidebar.php' );
          endif; ?>

        </ul>
      </div><!-- /.sidebar-collapse -->
    </div><!-- /.sidebar-nav -->
  </div><!-- /container-fluid -->
</nav>