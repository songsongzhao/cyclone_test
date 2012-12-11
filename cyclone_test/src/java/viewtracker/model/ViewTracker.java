/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * @author Prashanth
 */
package viewtracker.model;

import attendancereport.model.AttendanceReportObj;
import clientdb.model.UserObj;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ViewTracker {
    
    private static final ViewTracker instance = new ViewTracker();
    String url;
    
    public static ViewTracker getInstance() {
      
       return instance;
    }

    
    public void loginNavigation(int userType, HttpServletRequest request, 
            HttpServletResponse response, ServletContext servletContext) 
            throws ServletException, IOException{
       
        if (userType == 3)
        {            
            url = "Login.jsp";                     
            HttpSession session = request.getSession(true);
            session.setAttribute("message", "Invalid Username or Password");            
        }
        
        else if (userType == 0) {
            url = "Main_Admin.jsp";                             
        }                             
         else if (userType == 1) {
            url = "Main_Teacher.jsp";                       
        }                       
         else if (userType == 2) {
            url = "Main_Student.jsp";
        }          
         else {
            url = "Login.jsp";
        }
         
          response.sendRedirect(url);
//        RequestDispatcher dispatch = servletContext.getRequestDispatcher(url);         
//        dispatch.forward(request, response);
    }
    
    public void cameraNavigation(URL in_url,String Action,HttpServletRequest request,
            HttpServletResponse response, ServletContext servletContext) 
            throws ServletException, IOException
    {    
        if (Action == "stream")
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("url_stream",in_url);            
        }
        else if (Action == "capture")
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("url_cap", in_url);            
        }
        url = request.getHeader("referer");
        response.sendRedirect(url);            
    }
    
    public void trainfaceNavigation(int ret_val, String message,HttpServletRequest request, 
            HttpServletResponse response, ServletContext servletContext) 
            throws ServletException, IOException{
       
        if (ret_val == 0)
        {            
            url = request.getHeader("referer");
            HttpSession session = request.getSession(true);
            session.setAttribute("train_message", message);            
        }
        
        else if (ret_val == 1) {
           
            HttpSession session = request.getSession(true);
            session.setAttribute("opt_msg", message);            
            String caller = session.getAttribute("Caller").toString();
            if(caller.compareTo("Teacher") == 0)
            {
                url = "Teacher_Train.jsp";
            }
            else if (caller.compareTo("Admin") == 0)
            {
                url = "Admin_Train.jsp";
            }            
            else if (caller.compareTo("Student") == 0)
            {
                url = "Student_Train.jsp";
            }            
        }                                                       
        response.sendRedirect(url);
//        RequestDispatcher dispatch = servletContext.getRequestDispatcher(url);         
//        dispatch.forward(request, response);
    }
    
    public void redirectBack(String msgNme,String msg,HttpServletRequest request, 
            HttpServletResponse response, ServletContext servletContext) 
            throws ServletException, IOException{
        
      url = request.getHeader("referer");
      HttpSession session = request.getSession(true);
      session.setAttribute(msgNme,msg);  
      response.sendRedirect(url);  
    }
    
    public void adminNavigation(int action,ArrayList<UserObj> users,HttpServletRequest request, 
            HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException{
       
        if(action==1)
        {
        HttpSession session = request.getSession(true);
        session.setAttribute("data",users);  
        url = "Admin_Modify.jsp";
        response.sendRedirect(url);        
        }
        else if(action==2)
        {
        HttpSession session = request.getSession(true);
        session.setAttribute("data",users);  
        url = "Admin_Modify.jsp";
        response.sendRedirect(url);          
        }
    }
    
    public void edituserNavigation(UserObj user,HttpServletRequest request, 
            HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException{
       
//        request.setAttribute("data", users);
        String usertype = user.retUsertype(user.getUserType());
        HttpSession session = request.getSession(true);
        session.setAttribute("Username",user.getUserName());  
        session.setAttribute("UId",user.getuId());  
        session.setAttribute("Usertype",usertype);  
        session.setAttribute("Fname",user.getFirstName());  
        session.setAttribute("Lname",user.getLastName());  
        session.setAttribute("Address",user.getAddress());  
        session.setAttribute("Email",user.getEmail());  
        url = "Admin_Edit.jsp";
        response.sendRedirect(url);        
    }
    
    public void teacherNavigation(String action,ArrayList<AttendanceReportObj> reportObjects,HttpServletRequest request, 
            HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException
    {       
//        request.setAttribute("data", users);
        if (action.compareTo("Check")==0)            
        {
        HttpSession session = request.getSession(true);
        session.setAttribute("data", reportObjects);  
        url = "Teacher_Check.jsp";
        response.sendRedirect(url);        
        }
        else if (action.compareTo("Schedule")==0)            
        {
        HttpSession session = request.getSession(true);
        session.setAttribute("data", reportObjects);  
        url = "Teacher_Schedule.jsp";
        response.sendRedirect(url);        
        }
        else if (action.compareTo("DateSchedule")==0)            
        {
        HttpSession session = request.getSession(true);
        session.setAttribute("data", reportObjects);  
        url = "Teacher_DateSchedule.jsp";
        response.sendRedirect(url);        
        }
    }
    
    public void studentNavigation(String action,AttendanceReportObj reportObject,HttpServletRequest request, 
            HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException
    {       
//        request.setAttribute("data", users);
        if (action.compareTo("Review")==0)            
        {
        HttpSession session = request.getSession(true);
        session.setAttribute("data", reportObject);  
        url = "Student_Review.jsp";
        response.sendRedirect(url);        
        }
    }

    public void studentSchdNavigation(String schedule, ArrayList<AttendanceReportObj> reportObjects, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws IOException 
    {
        HttpSession session = request.getSession(true);
        session.setAttribute("data", reportObjects);  
        url = "Student_Schedule.jsp";
        response.sendRedirect(url);        
    }

    public void logoutNavigation(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws IOException {        
        
        url = "Login.jsp";
        response.sendRedirect(url);        
    }
    
}

