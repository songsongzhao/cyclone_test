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
import javax.servlet.http.HttpSession;
import viewtracker.model.ViewTracker;

/**
 *
 * @author Sneha Bankar
 */
public class CaptureImageServlet extends HttpServlet {
        
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //added this line then it worked    
        CamInit cam = new CamInit(config);
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
                                      
        String callAction = request.getParameter("caller");        
        CameraService camSer = CameraService.getInstance();
        
        if (callAction.equals("Capture_Train"))
        {
        camSer.TakeImg(getServletContext(),"Train.jpg");        
        }
        else if (callAction.equals("Capture_Attend"))
        {
        camSer.TakeImg(getServletContext(),"QuickAttend.jpg");        
        }
        String url = camSer.getUrlCap();
        System.out.println(url);        
        URL urlCap = new URL(url);                
        
        ViewTracker viewTracker = ViewTracker.getInstance();
        viewTracker.cameraNavigation(urlCap,"capture", request, response, getServletContext());
    }

   
}
