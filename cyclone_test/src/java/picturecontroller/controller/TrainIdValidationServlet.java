/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package picturecontroller.controller;

import clientdb.model.UserJdbcDAO;
import clientdb.model.UserObj;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sneha Bankar
 */
public class TrainIdValidationServlet extends HttpServlet {
    
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
    
        String Username = request.getParameter("Username");
        String caller = request.getParameter("Caller"); 
        int ret_val=0;
        String msg="";
        System.out.println(caller);
        
        UserJdbcDAO user = UserJdbcDAO.getInstance();
        UserObj userObj= null;
        try {                                          
            userObj = user.getUserbyName(Username);
        } catch (SQLException ex) {
            Logger.getLogger(TrainIdValidationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (userObj.getuId()==null)      
        {
          ret_val =0;
          msg = "Invalid Student UserName";          
        }
        else
        {
           ret_val=1; 
        }
        
        HttpSession session = request.getSession();            
        //setting the attribute UID
        session.setAttribute("Train_Id",userObj.getUserName());  
        session.setAttribute("Caller",caller);
        
        //Calling ViewTracker module        
        viewtracker.model.ViewTracker viewTracker = viewtracker.model.ViewTracker.getInstance();
        viewTracker.trainfaceNavigation(ret_val,msg,request, response, getServletContext());
        
    }

}
