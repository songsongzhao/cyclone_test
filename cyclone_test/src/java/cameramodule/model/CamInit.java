/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cameramodule.model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Sneha Bankar
 */
public class CamInit {
   
        
    public CamInit(ServletConfig config) throws ServletException {
        
        String urlStream = config.getInitParameter("urlStream");
        String urlCap = config.getInitParameter("urlCap");
        String urlSave = config.getInitParameter("urlSave");
        String camName = config.getInitParameter("camName");
        String camPassword = config.getInitParameter("camPassword");
        
        ServletContext sc = config.getServletContext();
        // set in application scope of web application to access in future        
        CameraService camSer = CameraService.getInstance();
        camSer.setUrlStream(urlStream);
        camSer.setUrlCap(urlCap);
        camSer.setUrlSave(urlSave);
        camSer.setCamName(camName);
        camSer.setCamPassword(camPassword);                
        
    }
}                 