<%-- 
    Document   : Student_Review
    Created on : Nov 24, 2012, 11:18:52 AM
    Author     : Sneha  Bankar
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
    <script type='text/javascript' src='js/auth_convert_code.js'></script>    
    <script type='text/javascript' src='js/jquery.ba-hashchange.min.js'></script>                
</head>

<body>
        <div id="page-wrap">        
        <%@include file="/Student_Head.jsp"%>
        <h2>Review Attendance</h2>   
        <div id ="container-left">   
        <p></p>   
        <table border="1" cellpaddig="10" id='EditTable'>
        <tr>
        <td><font size="3"><b>UserName</b></font></td>
        <td><font size="3"><b>University ID</b></font></td>
        <td><font size="3"><b>Present</b></font></td>
        <td><font size="3"><b>Absent</b></font></td> 
        </tr>
        <tr>
            <td><font size="2"><c:out value="${data.userName}" /></font></td>            
            <td><font size="2"><c:out value="${data.uId}" /></font></td>               
            <td><font size="2"><c:out value="${data.present}" /></font></td>            
            <td><font size="2"><c:out value="${data.absent}" /></font></td>
        </tr>        
        </table>        
        </div>
        </div>
</body>
</html>






