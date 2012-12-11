/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facerecognition.model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 *
 * @author Sneha Bankar
 */
public class FaceRecInit {
    
    public FaceRecInit(ServletConfig config) throws ServletException {
                
        String urlAddface = config.getInitParameter("urlAddFace");        
        String urlTrainface = config.getInitParameter("urlTrainFace");        
        String urlRecface = config.getInitParameter("urlRecFace");        
        
        ServletContext sc = config.getServletContext();
        // set in application scope of web application to access in future        
        FaceRecognitionService faceSer = FaceRecognitionService.getInstance();
        faceSer.setUrlAddFace(urlAddface);
        faceSer.setUrlRecFace(urlRecface);
        faceSer.setUrlTrainFace(urlTrainface);
    }    
}
