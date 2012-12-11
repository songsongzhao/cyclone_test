/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientdb.controller;
import clientdb.model.UserJdbcDAO;
import clientdb.model.UserObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import viewtracker.model.ViewTracker;
/**
 *
 * @author Sneha Bankar
 */
public class ModifyUser extends HttpServlet {
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
        UserJdbcDAO user = UserJdbcDAO.getInstance(); 
        ArrayList<UserObj> listUsers = user.listtUsers();
        //Calling ViewTracker module
        ViewTracker viewTracker = ViewTracker.getInstance();
        viewTracker.adminNavigation(2,listUsers, request, response, getServletContext());                
    }                                          
}
