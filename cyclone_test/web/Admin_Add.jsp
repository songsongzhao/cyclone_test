<%-- 
    Document   : Admin_Add
    Created on : Nov 19, 2012, 12:23:50 PM
    Author     : Prashanth
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />	
    <title>Iowa State Cyclones</title>
    <link rel='stylesheet' type='text/css' href='CSS/Main.css' />    
    <link rel='stylesheet' type='text/css' href='CSS/Label.css' />    
<!--[if IE]>
--> <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><!--
    <![endif]-->	
    <script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js'></script>    
    <script type='text/javascript' src='js/auth_convert_code.js'></script>
    <script type='text/javascript' src='js/jquery.ba-hashchange.min.js'></script> 
    <script type='text/javascript' src='./js/AddModifyValidation.js'>
    </script>
</head>

<body>
        <div id="page-wrap">
        <%@include file="/Admin_Head.jsp"%>
        <div id ="container-left">
        <h2>Add</h2>             
        <form action="AddUser" method ="post" onsubmit="return validateOnSubmit()">                    
            <fieldset>
                <legend>Add Information</legend>
                <div>
                <table>
                <tr>
                <td><label for="Username">Username</label></td>
                <td><input id="Username" name="Username" onChange="validatePresent(this, 'inf_username');"></td>
                <td id="inf_username" class="warn">Required</td>
                </tr>
                <tr>
                <td><label for="Password">Password</label> </td>
                <td><input id="Password" type="password" name="Password" onChange="validatePresent(this, 'inf_password');"></td>
                <td id="inf_password" class="warn">Required</td>
                </tr>
                <tr>
                <td><label for="UId">UId</label></td>
                <td><input id="UId" name="UId" onChange="validateUId(this, 'inf_uid', true)"></td>
                <td id="inf_uid" class="warn">Required</td>
                </tr>
                </table>
                <fieldset class="radio">
                <legend><span>UserType</span></legend>
                <li><input type="radio" id="Admin" name="UserType" value ="0" checked> <label for="Admin">Admin</label></li>
                <li><input type="radio" id="Teacher" name="UserType" value ="1"> <label for="Teacher">Teacher</label></li>
                <li><input type="radio" id="Student" name="UserType" value ="2"> <label for="Student">Student</label></li>
                </fieldset>
                <br>
                <table>
                <tr>
                <td><label for="First Name">First Name</label></td>
                <td><input id="Fname" name="Fname" onChange="validatePresent(this, 'inf_fname');"></td>
                <td class ="warn" id="inf_fname">Required</td>
                </tr>
                <tr>
                <td><label for="Last Name">Last Name</label></td>
                <td><input id="Lname" name="Lname" onChange="validatePresent(this, 'inf_lname');"></td>
                <td class ="warn" id="inf_lname">Required</td>
                </tr>
                <tr>
                <td><label for="Address">Address</label></td>
                <td><input id="Address" name="Address" onChange="validatePresent(this, 'inf_address');"></td>
                <td class ="warn" id="inf_address">Required</td>
                </tr>
                <tr>
                <td><label for="Email">Email</label></td>
                <td><input id="Email" name="Email" onChange="validateEmail(this, 'inf_email', true);"></td>
                <td class = "warn" id="inf_email">Required</td>
                </tr>
                </table>
                </div>                
            </fieldset>
            <BR>
            <input type="submit" value="Submit" name="submit" class="submit" />
        </form>       
        </div>
        </div>
</body>
</html>


<SCRIPT TYPE="text/javascript">
// Only script specific to this form goes here.
// General-purpose routines are in a separate file.
function validateOnSubmit() {
var elem;
var errs=0;
// execute all element validations in reverse order, so focus gets
// set to the first one in error.
if (!validatePresent (document.getElementById('Username'), 'inf_username')) errs += 1;
if (!validatePresent (document.getElementById('Password'), 'inf_password')) errs += 1;
if (!validateUId (document.getElementById('UId'), 'inf_uid', true)) errs += 1;
if (!validatePresent (document.getElementById('Fname'), 'inf_fname')) errs += 1;
if (!validatePresent (document.getElementById('Lname'), 'inf_lname')) errs += 1;
if (!validatePresent (document.getElementById('Address'), 'inf_address')) errs += 1;
if (!validateEmail (document.getElementById('Email'), 'inf_email', true)) errs += 1;

if (errs>1) alert('There are fields which need correction before sending');
if (errs==1) alert('There is a field which needs correction before sending');
return (errs==0);
};
</SCRIPT> 
