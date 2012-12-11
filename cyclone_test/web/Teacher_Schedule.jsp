<%-- 
    Document   : Teacher_Schedule
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
    <script type='text/javascript' src='js/Teacher.js'></script>
</head>

<body>
        <div id="page-wrap">        
        <%@include file="/Teacher_Head.jsp"%>
        <h2>Class Schedule</h2>   
        <div id ="container-left">   
        <p></p>  
        <form name="SchForm" action="DateSchedule" method="get">
        <input type ="hidden" name="date">
        <table border="1" cellpaddig="10" id='EditTable'>
        <tr>
        <td><font size="3"><b>Date</b></font></td>        
        <td><font size="3"><b>Present</b></font></td>                
        <td><font size="3"><b>Absent</b></font></td>        
        <td><font size="3"><b>Action</b></font></td>        
        </tr>
        <c:forEach var="iterator" items="${data}">          
        <tr>
            <td><font size="2"><c:out value="${iterator.date}" /></font></td>                        
            <td><font size="2"><c:out value="${iterator.present}" /></font></td>            
            <td><font size="2"><c:out value="${iterator.absent}" /></font></td>
            <td><button type="button" onclick="javascript: return dispSchedule('${iterator.date}');">Details</button></td>
        </tr>
        </c:forEach>
        </table> 
        </form>
        </div>
        </div>
</body>
</html>






