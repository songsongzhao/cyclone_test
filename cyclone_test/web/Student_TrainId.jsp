<%-- 
    Document   : Student_TrainId
    Created on : Nov 6, 2012, 11:28:01 AM
    Author     : Sneha Bankar
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />	
    <title>Iowa State Cyclones</title>
    <link rel='stylesheet' type='text/css' href='CSS/Main.css' />    
<!--[if IE]>
--> <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><!--
    <![endif]-->	
    <script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js'></script>           
    <script type="text/javascript" src="js/Train_Validation.js"></script>
    <script type='text/javascript' src='js/jquery.ba-hashchange.min.js'></script>        
</head>

<body>
	<div id="page-wrap">

        <%@include file="/Student_Head.jsp"%>
        
        <h2>Train Face</h2>   
            
            <div id="C">
            <form name ="train" action="TrainIdValidationServlet" method ="get" style="display:inline;margin-left: 0em" onsubmit="javascript: return check_empty();">
                    <legend>User Information</legend>
                    <div>
                        <label for="Username">UserName for Training:</label><input id="DUsername" name="DUsername" value="${SigninUser}" disabled="disabled"><br><br>                           
                    </div>
            <BR>
            <input type ="hidden" name ="Caller" value ="Student">      
            <input type="hidden" name="Username" value="${SigninUser}">
            <input type="submit" value="Submit" name="submit" class="submit" />
            </form> 
            <p>${train_message}</p>
            <c:remove var="train_message" scope="session" /> 
            </div>                                                
        </div>                   
</body>
</html>