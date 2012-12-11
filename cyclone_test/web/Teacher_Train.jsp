<%-- 
    Document   : Teacher_Train
    Created on : Nov 5, 2012, 7:32:49 PM
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
    <script type="text/javascript" src="js/Train_Validation.js"></script>
    <script type='text/javascript' src='js/jquery.ba-hashchange.min.js'></script>        
</head>

<body>	
        <div id="page-wrap">
        <%@include file="/Teacher_Head.jsp"%>
        
        <h2>Train Face</h2>                                           
        <div>        
        <fieldset class="radio">
        <legend><span>Select Mode of Training:</span></legend>
        <ul>
        <input type="radio" id="Up_Img" onchange="hideA(this)" name="Option"> <label for="Up_Img">Upload Image</label>
        <input type="radio" id="Cam_Img " onchange="hideB(this)" name="Option"> <label for="Cam_Img">Capture Image from Camera</label>
        </ul>
        </fieldset>           
        </div>            
        <p>${opt_msg}</p>              
        <c:remove var="opt_msg" scope="session" />                                                               
        <div id="A">

        <div id ="container-left">
        <h2>Get Picture</h2>            

        <form action="StreamVideoServlet" method ="get" style="display:inline;margin-left: 0em">
        <input type ="submit" value ="Get Picture">
        <input type ="hidden" name ="caller" value ="Stream_Video">
        </form> 

        <form action="CaptureImageServlet" method ="get" style="display:inline;margin-left: 0em">
        <input type ="submit" value ="Capture" />
        <input type ="hidden" name ="caller" value ="Capture_Train">
        </form>                                         

        <br></br>
        <iframe id="frm" scrolling="yes" style="position: absolute ;overflow:auto ;border: 0; height:60%; width:40%" src=${url_stream}> </iframe>          
        <c:remove var="url_stream" scope="session" /> 

        </div>
        <div id ="container-right" >              
        <h2>Captured Image</h2>
        <div>
<!--        <form action="addPicServlet" method ="get" style="display:inline;margin-left: 0em">-->
        <form action="SendImageServlet" method ="get" style="display:inline;margin-left: 0em">
        <input type ="hidden" name ="action" value ="AddImage">
        <input type ="submit" value ="Add Face">            
        </form>           

        <form action="SendImageServlet" method ="get" style="display:inline;margin-left: 2em">
        <input type ="hidden" name ="action" value ="Train">
        <input type ="submit" value ="Train Picture">            
        </form>           

        </div>                     
        <iframe id="frm" scrolling="yes" style="position: absolute ;overflow:auto ;border: 0; height:60%; width:40%" src=${url_cap}> </iframe>                                          
        <c:remove var="url_cap" scope="session" /> 
        </div>
           
        </div>
            
        <div id="B" style="visibility:hidden">                        
        
        <form action="SendImageServlet" method="post" enctype="multipart/form-data" accept="jpg">
	<input type ="hidden" name ="action" value ="Upload">
        <input type ="hidden" name ="caller" value ="Capture_Train">
        <input type="text" name="code" value="000">
        <input type="file" name="image">
        <input type="submit" value="submit">
	</form>                        
            
        <form action="SendImageServlet" method ="get" style="display:inline;margin-left: 0em">
        <input type ="hidden" name ="action" value ="AddImage">
        <input type ="submit" value ="Add Face">            
        </form>           

        <form action="SendImageServlet" method ="get" style="display:inline;margin-left: 2em">
        <input type ="hidden" name ="action" value ="Train">
        <input type ="submit" value ="Train Picture">            
        </form>                   
    
        </div>                    
       <footer>
	
       </footer>				
</body>
</html>