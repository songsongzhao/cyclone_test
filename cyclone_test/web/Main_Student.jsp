<%-- 
    Document   : Main_Student
    Created on : Oct 12, 2012, 2:18:28 AM
    Author     : Sneha Bankar
--%>
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
    <script type="text/javascript" src="js/Container.js"></script>
    <script type='text/javascript' src='js/jquery.ba-hashchange.min.js'></script>        
</head>

<body>
    <div id="page-wrap">
    <%@include file="/Student_Head.jsp"%>

    <div id ="container-left">
    <h2>Home</h2>    
    <br>
    <form name="CourseSel" action="CourseSelServlet" method=get>	
    <h3>Course Selected:${SelSchId}</h3> 
    <br>
    <h3>Select Course</h3>
    <select name="Course">
    <c:forEach var="iterator" items="${SchIds}">
        <option value="${iterator}">${iterator}</option>
    </c:forEach>            
    </select>
    <br>
    <br>
    <input type="submit" value="Submit" name="submit" class="submit" />
    </form>
        
    </div>
    </div>                  
</body>
</html>
