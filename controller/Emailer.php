<?php
require('assets/PHPMailer/PHPMailerAutoload.php');

unset($_SESSION['none_adds']);

class Emailer
{
    public function sendStudentTempEmail($email, $fullName, $pss)
    {
        //$mail->SMTPDebug = 2;


        $mail = new PHPMailer(true);

        $mail->SMTPOptions = array(
            'ssl' => array(
                'verify_peer' => false,
                'verify_peer_name' => false,
                'allow_self_signed' => true
            )
        );

        // set it to use SMTP
        $mail->isSMTP();
        $mail->Host = gethostbyname("smtp.gmail.com");
        // gets authentication actions
        $mail->SMTPAuth = true;
        $mail->Mailer = "smtp";
        //auth data
        $mail->Username = "team.allocation.tool@gmail.com";
        $mail->Password = "ChocolateMilkIsDelicious2015";

        $mail->Port = 587;
        $mail->SMTPSecure = 'tls';

        $mail->From = "team.allocation.tool@gmail.com";
        $mail->FromName = "Team Allocation Tool Team";

        $mail->addAddress($email, $fullName);

        $mail->isHTML(true);

        $mail->Subject = "Temporary Password - Team Allocation Tool";
        $mail->Body = "Hello, $fullName<br/>
                        You are receiving this email as you have recently been added to the team allocation tool
                        for a unit this study period.<br/>
                        Please use the following as your temporary password for your first time login: $pss<br/>
                        Please ensure that you carefully follow these instructions:<br/>
                        <ul>
                        <li>1) Goto the <a href='http://team-allocation-tool.bitnamiapp.com/no_parking.php?p=$pss'>Team Allocation Tool</a></li>
                        <li>2) Change your temporary password</li>
                        <li>3) Login with your new password</li>
                        <li>4) Carefully fill out the questionare and submit the form</li>
                        </ul>
                        <br/><br/>
                        If you require any further assistance please contact your lecturer.
                        <br/><br/>
                        Regards,<br/><br/>
                        The Team Allocation Tool Team";


        if (!$mail->send()) {
            return $error = "Mailing Error " . $mail->ErrorInfo();
        }


    }

    public function sendStudentAddedToCourseEmail($email, $fullName)
    {
        //$mail->SMTPDebug = 2;

        $mail = new PHPMailer(true);

        $mail->SMTPOptions = array(
            'ssl' => array(
                'verify_peer' => false,
                'verify_peer_name' => false,
                'allow_self_signed' => true
            )
        );

        // set it to use SMTP
        $mail->isSMTP();
        $mail->Host = gethostbyname("smtp.gmail.com");
        // gets authentication actions
        $mail->SMTPAuth = true;
        $mail->Mailer = "smtp";
        //auth data
        $mail->Username = "team.allocation.tool@gmail.com";
        $mail->Password = "ChocolateMilkIsDelicious2015";

        $mail->Port = 587;
        $mail->SMTPSecure = 'tls';

        $mail->From = "team.allocation.tool@gmail.com";
        $mail->FromName = "Team Allocation Tool Team";

        $mail->addAddress($email, $fullName);

        $mail->isHTML(true);

        $mail->Subject = "Assigned to New Course - Team Allocation Tool";
        $mail->Body = "Hello, $fullName<br/>
                        You are receiving this email as you have recently been assigned to a new course in the team allocation tool.<br/><br/>
                        Please follow these instructions to update your skills:<br/>
                        <ul>
                        <li>1) Goto the <a href='http://team-allocation-tool.bitnamiapp.com/'>Team Allocation Tool</a></li>
                        <li>2) Login with your account details (click the Reset password link to retrieve your password)</li>
                        <li>3) Update your skill levels for each of the existing skills</li>
                        <li>4) Add an appropriate skill level for each new skill</li>
                        </ul>
                        <br/><br/>
                        If you require any further assistance please contact your lecturer.
                        <br/><br/>
                        Regards,<br/><br/>
                        The Team Allocation Tool Team";

        if (!$mail->send()) {
            return $error = "Mailing Error " . $mail->ErrorInfo();
        }


    }

    //this is sent if access level is lecturer on add user page
    public function sendLecturerTempEmail($email, $fullName, $pss){
        //$mail->SMTPDebug = 2;


        $mail = new PHPMailer(true);

        $mail->SMTPOptions = array(
            'ssl' => array(
                'verify_peer' => false,
                'verify_peer_name' => false,
                'allow_self_signed' => true
            )
        );

        // set it to use SMTP
        $mail->isSMTP();
        $mail->Host = gethostbyname("smtp.gmail.com");
        // gets authentication actions
        $mail->SMTPAuth = true;
        $mail->Mailer = "smtp";
        //auth data
        $mail->Username = "team.allocation.tool@gmail.com";
        $mail->Password = "ChocolateMilkIsDelicious2015";

        $mail->Port = 587;
        $mail->SMTPSecure = 'tls';

        $mail->From = "team.allocation.tool@gmail.com";
        $mail->FromName = "Team Allocation Tool Team";

        $mail->addAddress($email, $fullName);

        $mail->isHTML(true);

        $mail->Subject = "Temporary Password - Team Allocation Tool";
        $mail->Body = "Hello, $fullName<br/>
                        You are receiving this email as you have recently been added to the team allocation tool
                        for a unit this study period.<br/>
                        Please use the following as your temporary password for your first time login: $pss<br/>
                        Please ensure that you carefully follow these instructions:<br/>
                        <ul>
                        <li>1) Goto the <a href='http://team-allocation-tool.bitnamiapp.com/no_parking.php?p=$pss'>Team Allocation Tool</a></li>
                        <li>2) Change your temporary password</li>
                        <li>3) Login with your new password</li>
                        <li>4) Set up a new project, and select required project skills</li>
                        <li>5) Finally import or add new students to your project</li>
                        </ul>
                        <br/><br/>
                        If you require any further assistance please contact your administrator.
                        <br/><br/>
                        Regards,<br/><br/>
                        The Team Allocation Tool Team";


        if (!$mail->send()) {
            return $error = "Mailing Error " . $mail->ErrorInfo();
        }

    }

    // send recover password
    public function sendRecoverEmail($email, $pss){
        //$mail->SMTPDebug = 2;


        $mail = new PHPMailer(true);

        $mail->SMTPOptions = array(
            'ssl' => array(
                'verify_peer' => false,
                'verify_peer_name' => false,
                'allow_self_signed' => true
            )
        );

        // set it to use SMTP
        $mail->isSMTP();
        $mail->Host = gethostbyname("smtp.gmail.com");
        // gets authentication actions
        $mail->SMTPAuth = true;
        $mail->Mailer = "smtp";
        //auth data
        $mail->Username = "team.allocation.tool@gmail.com";
        $mail->Password = "ChocolateMilkIsDelicious2015";

        $mail->Port = 587;
        $mail->SMTPSecure = 'tls';

        $mail->From = "team.allocation.tool@gmail.com";
        $mail->FromName = "Team Allocation Tool Team";

        $mail->addAddress($email);

        $mail->isHTML(true);

        $mail->Subject = "Temporary Password - Team Allocation Tool";
        $mail->Body = "Hello, <br/>
                        You are receiving this email as you have recently requested to reset your password <br/>
                        Please use the following as your temporary password: $pss<br/>
                        Please ensure that you carefully follow these instructions:<br/>
                        <ul>
                        <li>1) Goto the <a href='http://team-allocation-tool.bitnamiapp.com/no_parking.php?p=$pss'>Team Allocation Tool</a></li>
                        <li>2) Change your temporary password</li>
                        <li>3) Login with your new password</li>
                        </ul>
                        <br/><br/>
                        If you require any further assistance please contact your administrator.
                        <br/><br/>
                        Regards,<br/><br/>
                        The Team Allocation Tool Team";


        if (!$mail->send()) {
            return $error = "Mailing Error " . $mail->ErrorInfo();
        }

    }
}

