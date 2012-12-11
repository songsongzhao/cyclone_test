/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package picturecontroller.model;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 *
 * @author Sneha Bankar
 */
public class ImageUpload {
    
    private static final ImageUpload instance = new ImageUpload();
    
    public static ImageUpload getInstance() {
      
       return instance;
    }
    
    public void UploadImage(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException
    {
        String tmpPath = servletContext.getRealPath("/");       
        File tmpDir;
        tmpDir = new File(tmpPath);
        
        String destPath = servletContext.getRealPath("/");       
        destPath = destPath + "Images";
        File destinationDir = new File(destPath.toString());
        destinationDir.mkdir();                        
        DiskFileItemFactory  fileItemFactory = new DiskFileItemFactory ();
        /*
        *Set the size threshold, above which content will be stored on disk.
        */
        fileItemFactory.setSizeThreshold(1*1024*1024); //1 MB
        /*
        * Set the temporary directory to store the uploaded files of size above threshold.
        */
        fileItemFactory.setRepository(tmpDir);

        ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
        try {
        /*
        * Parse the request
        */
        String fileName = null;
        List items = uploadHandler.parseRequest(request);
        Iterator itr = items.iterator();
        while(itr.hasNext()) 
        {        
            FileItem item = (FileItem) itr.next();  
            String fieldName = item.getFieldName();        
            if(item.isFormField()) 
            {                                  
                if(fieldName.compareTo("caller")==0)
                {             
                String callAction = item.getString();    
                if (callAction.equals("Capture_Train"))
                {
                fileName = "Train.jpg";
                }
                else if (callAction.equals("Capture_Attend"))
                {
                fileName = "QuickAttend.jpg";
                }                
                }                
            } 
            else
            {
               File file = new File(destinationDir,fileName);
               item.write(file);                
            }
        }        
        }catch(FileUploadException ex) {
        System.out.println("Error encountered while parsing the request"+ex);;;
        } catch(Exception ex) {
        System.out.println("Error encountered while uploading file"+ex);

        }

        }  
}
