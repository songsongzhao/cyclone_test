/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancereport.controller;

import attendancereport.model.AttendanceReportObj;
import attendancereport.model.AttendanceReportService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import viewtracker.model.ViewTracker;

/**
 *
 * @author Sneha Bankar
 */
public class ShowSchedule extends HttpServlet {  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        HttpSession session = request.getSession(true);        
        String userType = (String)session.getAttribute("SigninType");
        String userId = (String)session.getAttribute("SigninId");
        String Sch_id =(String)session.getAttribute("SelSchId");                                                               

        AttendanceReportService attendSer = AttendanceReportService.getInstance();        
        ViewTracker viewTracker = ViewTracker.getInstance();
        
        if (userType.compareTo("1")==0)
        {        
        ArrayList<AttendanceReportObj> reportObjects = new ArrayList<AttendanceReportObj>();                
        reportObjects = attendSer.prepareScheduleTeacher(Integer.parseInt(Sch_id));
        
        //Calling ViewTracker module        
        viewTracker.teacherNavigation("Schedule",reportObjects, request, response, getServletContext());                
        }
        else if(userType.compareTo("2")==0)
        {
        ArrayList<AttendanceReportObj> reportObjects = new ArrayList<AttendanceReportObj>(); 
        reportObjects = attendSer.prepareScheduleStudent(Integer.parseInt(Sch_id),Integer.parseInt(userId));
        
        //Calling ViewTracker module        
        viewTracker.studentSchdNavigation("Schedule",reportObjects, request, response, getServletContext());                      
            
        }
    }
    
}
