/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancereport.controller;

import attendancereport.model.AttendanceReportObj;
import attendancereport.model.AttendanceReportService;
import java.io.IOException;
import java.io.PrintWriter;
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
public class DateSchedule extends HttpServlet {    
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
     
        String date = request.getParameter("date");        
        HttpSession session = request.getSession(true);                
        String Sch_id =(String)session.getAttribute("SelSchId");                                                               
        
        ViewTracker viewTracker = ViewTracker.getInstance();
        
        AttendanceReportService attendSer = AttendanceReportService.getInstance();          
        ArrayList<AttendanceReportObj> reportObjects = new ArrayList<AttendanceReportObj>();                
        
        reportObjects = attendSer.prepareDateSchedule(date,Sch_id);
        
        viewTracker.teacherNavigation("DateSchedule",reportObjects, request, response, getServletContext());                
        
    }    
}
