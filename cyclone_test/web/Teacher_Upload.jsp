<%-- 
    Document   : Teacher_Quick
    Created on : Nov 5, 2012, 12:47:53 PM
    Author     : Sneha Bankar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <script type='text/javascript' src='js/jquery.ba-hashchange.min.js'></script>        
</head>

<body>
	<div id="page-wrap">

        <%@include file="/Teacher_Head.jsp"%> 
                
            <h2>Quick Attendance</h2>   
             <p>${opt_msg}</p>              
             <c:remove var="opt_msg" scope="session" />                                                       
            <form action="SendImageServlet" method="post" enctype="multipart/form-data" accept="jpg">
<!--            <input type ="hidden" name ="action" value ="Upload">-->
            <input type ="hidden" name ="caller" value ="Capture_Attend">
            <input type="text" name="code" value="000">
            <input type="file" name="image">
            <input type="submit" value="submit">            
	    </form>                      
            <br></br>                                         
            
            <form action="SendImageServlet" method ="get" style="display:inline;margin-left: 0em">
            <input type ="hidden" name ="action" value ="QuickAttend">            
            <input type ="submit" value ="Send Picture">            
            </form>                                      
         
        </div>                   
</body>
</html>