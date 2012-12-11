/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
public class SignOutServlet extends HttpServlet {
   
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
            
            HttpSession session = request.getSession(false);
            session.invalidate();
            ViewTracker viewTracker = ViewTracker.getInstance();
            viewTracker.logoutNavigation(request, response, getServletContext());
    }   
}
