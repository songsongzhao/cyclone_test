/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package picturecontroller.controller;
import classregistration.model.ClassRegistrationService;
import facerecognition.model.FaceRecInit;
import facerecognition.model.FaceRecognitionService;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import picturecontroller.model.ImageUpload;
import viewtracker.model.ViewTracker;
/**
 *
 * @author Sneha Bankar
 */
public class SendImageServlet extends HttpServlet {    

    public void init(ServletConfig config) throws ServletException {
        super.init(config); //added this line then it worked    
        FaceRecInit facerec = new FaceRecInit(config);
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
        
       String action = request.getParameter("action");
       if(action.compareTo("AddImage") == 0)
       {
                  
       HttpSession session = request.getSession();            
       String UId = (String) session.getAttribute("Train_Id");  
        
       FaceRecognitionService faceRec = FaceRecognitionService.getInstance();        
       String message = faceRec.sendImage(UId,getServletContext()); 
       
       ViewTracker viewTracker = ViewTracker.getInstance();
       viewTracker.redirectBack("opt_msg",message,request, response, getServletContext());        
        
       }
       else if(action.compareTo("Train") == 0)
       {

       FaceRecognitionService faceRec = FaceRecognitionService.getInstance();        
       String message = faceRec.train();
       
       viewtracker.model.ViewTracker viewTracker = viewtracker.model.ViewTracker.getInstance();
       viewTracker.trainfaceNavigation(1,message,request, response, getServletContext());         
       
       }
       else if(action.compareTo("QuickAttend") == 0)
       {

       FaceRecognitionService faceRec = FaceRecognitionService.getInstance();        
       String message = faceRec.recognize(getServletContext());

       if(faceRec.getCode().compareTo("100")==0)
       {
       HttpSession session = request.getSession(true);        
       String Sch_id =(String)session.getAttribute("SelSchId");                                                               

       ClassRegistrationService classSer = ClassRegistrationService.getInstance();                          
       classSer.init(Integer.parseInt(Sch_id));
       classSer.writeAttendance(faceRec.getRecFaces());
       }
       
       viewtracker.model.ViewTracker viewTracker = viewtracker.model.ViewTracker.getInstance();       
       viewTracker.redirectBack("opt_msg",message,request, response, getServletContext());        
       
       }
              
   }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fileName = null;
        String message ="File Uploaded Sucessfully!!";
        ImageUpload imageUpd = ImageUpload.getInstance();        
        imageUpd.UploadImage(request, response, getServletContext());
       
        ViewTracker viewTracker = ViewTracker.getInstance();
        viewTracker.redirectBack("opt_msg",message,request, response, getServletContext());                                         
    }
    
}

   