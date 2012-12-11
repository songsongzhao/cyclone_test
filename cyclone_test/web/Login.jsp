<%-- 
    Document   : Login
    Created on : Oct 22, 2012, 6:13:13 PM
    Author     : Sneha Bankar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>        
	<meta name="description" content="">                                
        <link type="text/css" rel="stylesheet" href="CSS/Main.css" />      
        <link type="text/css" rel="stylesheet" href="CSS/Login.css" />      
        <script type="text/javascript" src="js/Login_Validation.js"></script>
        <script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js'></script>
        <title>Cyclones</title>
</head>

<body onload="load()">
<div id="page-wrap">

<header>
    <h1>Classroom Attendance - For Cyclones by Cyclones</h1>
<header>

<form name="LogIn" action="SignInServlet" method=post onsubmit="javascript: return check_empty();">	
<label>Username:</label>
<input type="text" name="uid" />
<label>Password:</label>
<input type="password" name="password"  />        
<p>${message}</p> 
<c:remove var="message" scope="session" /> 
<input type="submit" value="Submit" name="submit" class="submit" />
</form>	    
</div>
</body>
</html>
