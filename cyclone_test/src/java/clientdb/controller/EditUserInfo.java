/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientdb.controller;

import clientdb.model.UserJdbcDAO;
import clientdb.model.UserObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import viewtracker.model.ViewTracker;

/**
 *
 * @author Sneha Bankar
 */
public class EditUserInfo extends HttpServlet {    

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
        String action = request.getParameter("modaction");
        if(action.compareTo("display")==0) 
        {
        String Uname = request.getParameter("user");
        UserJdbcDAO user = UserJdbcDAO.getInstance(); 
        UserObj userobj = new UserObj();
        try {            
            userobj = user.getUserbyName(Uname);
        } catch (SQLException ex) {
            Logger.getLogger(EditUserInfo.class.getName()).log(Level.SEVERE, null, ex);
        }        
         //Calling ViewTracker module
        ViewTracker viewTracker = ViewTracker.getInstance();
        viewTracker.edituserNavigation(userobj, request, response, getServletContext());                        
        }     
        else if(action.compareTo("edit")==0) 
        {
            UserJdbcDAO user = UserJdbcDAO.getInstance(); 
            String userName  = request.getParameter("Username");
            String password  = request.getParameter("Password");
            String uId       = request.getParameter("UId");
            String userType  = request.getParameter("UserType");
            String fName     = request.getParameter("Fname");
            String lName     = request.getParameter("Lname");
            String address   = request.getParameter("Address");
            String email     = request.getParameter("Email");

            UserObj userObj = new UserObj(userName,password,userType,uId,fName,lName,address,email);                        
            user.update(userObj);                        
            
            String url = "ModifyUser";
            response.sendRedirect(url);        
            
        }
    }

}
