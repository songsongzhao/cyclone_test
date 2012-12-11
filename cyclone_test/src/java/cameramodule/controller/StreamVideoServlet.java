/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cameramodule.controller;

import cameramodule.model.CamInit;
import cameramodule.model.CameraService;
import java.io.IOException;
import java.net.URL;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import viewtracker.model.ViewTracker;

/**
 *
 * @author Sneha Bankar
 */
public class StreamVideoServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config); //added this line then it worked    
        CamInit cam = new CamInit(config);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
    }

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
        
        processRequest(request, response);
        CameraService camSer = CameraService.getInstance();        
       
        String url = camSer.getUrlStream();
        System.out.println(url);        
        URL urlStream = new URL(url);
                 
        ViewTracker viewTracker = ViewTracker.getInstance();
        viewTracker.cameraNavigation(urlStream,"stream", request, response, getServletContext());                        
    }    
}
