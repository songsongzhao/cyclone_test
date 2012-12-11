<%-- 
    Document   : Admin_Modify
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
    <script type='text/javascript' src='js/Admin.js'></script>
</head>

<body>
        <div id="page-wrap">
        <%@include file="/Admin_Head.jsp"%>
        <div id ="container-left">   
        <p></p>
        <form name="ModForm" action="EditUserInfo" method="get">
        <input type="hidden" name="user">
        <table border="2" id='EditTable'>
        <th colspan="2">UserName</th>
        <th>UserType</th>
        <th colspan="2">UId</th>
        <th colspan="2">FirstName</th>
        <th colspan="2">LastName</th>
        <th colspan="2">Address</th>
        <th colspan="2">Email</th>
        <th colspan="4">Action</th>
        <c:forEach var="iterator" items="${data}">          
        <tr>
            <td><c:out value="${iterator.userName}" /><td>
            <td><c:out value="${iterator.userType}" /><td>
            <td><c:out value="${iterator.uId}" /><td>   
            <td><c:out value="${iterator.firstName}" /><td>     
            <td><c:out value="${iterator.lastName}" /><td>
            <td><c:out value="${iterator.address}" /><td>
            <td><c:out value="${iterator.email}" /><td>            
            <td><button type="button" onclick="javascript: return editUser('${iterator.userName}');">Edit</button></td>
        </tr>
        </c:forEach>
        </table>
        <input type ="hidden" name ="modaction" value ="display">
        </form>
        </div>
        </div>
</body>
</html>
