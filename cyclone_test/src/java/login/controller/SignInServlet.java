/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login.controller;

import clientdb.model.ScheduleJdbcDAO;
import clientdb.model.UserJdbcDAO;
import clientdb.model.UserObj;
import clientdb.model.UserScheduleJDBCDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import viewtracker.model.ViewTracker;

/**
 *
 * @author Prashanth
 */
public class SignInServlet extends HttpServlet {
    
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            
            int ret_val;
            ArrayList<String> schIds = new ArrayList<String>();
            //Calling Client_Db module            
            String Uname = request.getParameter("uid");
            String Pass = request.getParameter("password");            
            
            UserJdbcDAO user = UserJdbcDAO.getInstance(); 
            UserObj userObj = user.userexists(Uname, Pass);                                          
                        
            if ((userObj.getUserName().compareTo(Uname)!=0)||(userObj.getPassword().compareTo(Pass)!=0))
            {
                ret_val=3;
            }
            else
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("SigninUser", userObj.getUserName());                               
                session.setAttribute("SigninId", userObj.getuId());                                               
                session.setAttribute("SigninType", userObj.getUserType());                                               
                ret_val=Integer.parseInt(userObj.getUserType());
                
                if (ret_val==1)
                {
                ScheduleJdbcDAO schDAO = ScheduleJdbcDAO.getInstance(); 
                schIds =  schDAO.getSchId(Integer.parseInt(userObj.getuId()));                                               
                session.setAttribute("SchIds", schIds);                                                               
                session.setAttribute("SelSchId", schIds.get(0));                                                               
 
                }
                else if (ret_val==2)
                {
                 UserScheduleJDBCDAO schDAO = UserScheduleJDBCDAO.getInstance(); 
                 schIds =  schDAO.getSchId(Integer.parseInt(userObj.getuId()));                                                                   
                 session.setAttribute("SchIds", schIds);                                                               
                 session.setAttribute("SelSchId", schIds.get(0));                                                                
                }
                                                               
             }                                   
            
            //Calling ViewTracker module
            ViewTracker viewTracker = ViewTracker.getInstance();
            viewTracker.loginNavigation(ret_val, request, response, getServletContext());
        
         } catch (Exception ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }    
}
