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
        
        <div id ="container-left">
            <h2>Quick Attendance</h2>            
            <p>${opt_msg}</p>              
             <c:remove var="opt_msg" scope="session" />                                                       
            <form action="Teacher_Upload.jsp" method ="get" style="display:inline;margin-left: 0em">
            <input type ="submit" value ="Upload">            
            </form>            
            
            <form action="StreamVideoServlet" method ="get" style="display:inline;margin-left: 0em">
            <input type ="submit" value ="Get Picture">
            <input type ="hidden" name ="caller" value ="Stream_Video">
            </form> 
   
            <form action="CaptureImageServlet" method ="get" style="display:inline;margin-left: 0em">
            <input type ="submit" value ="Capture" />
            <input type ="hidden" name ="caller" value ="Capture_Attend">
            </form>                                         
            
            <br></br>
            <iframe id="frm" scrolling="yes" style="position: absolute ;overflow:auto ;border: 0; height:60%; width:40%" src=${url_stream}> </iframe>          
            <c:remove var="url_stream" scope="session" /> 
         </div>
         <div id ="container-right" >                                 
            <h2>Captured Image</h2>
            <div>
            <form action="SendImageServlet" method ="get" style="display:inline;margin-left: 0em">
            <input type ="hidden" name ="action" value ="QuickAttend">            
            <input type ="submit" value ="Send Picture">            
            </form>                                       
            <br></br>
            <iframe id="frm" scrolling="yes" style="position: absolute ;overflow:auto ;border: 0; height:60%; width:40% " src=${url_cap}> </iframe>                                          
            <c:remove var="url_cap" scope="session" /> 
         </div>               
        </div>             
      
       <footer>
	
       </footer>				
</body>
</html>