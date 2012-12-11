/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cameramodule.model;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.Authenticator;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
/**
 *
 * @author Sneha Bankar
 */
public class CameraService {        
    
    public String urlStream = null;
    public String urlCap = null;
    public String urlSave = null;
    public String camName = null;
    public String camPassword = null;
    
    private static final CameraService instance = new CameraService();
    
    public static CameraService getInstance() {
      
       return instance;
    }
    
    public void TakeImg(ServletContext servletContext,String imageName) throws IOException
    {                
        Authenticator.setDefault(new CamAuthenticate(camName, camPassword));   
        URL url = new URL(urlSave);
        BufferedImage image = null;                                                        
        image = ImageIO.read(url);
        String path = servletContext.getRealPath("/");       
        path = path + "Images";
        File file = new File(path.toString());
        file.mkdir();        
        System.out.println("path::" + path);        
        ImageIO.write(image, "jpg",new File(path + "/" + imageName));                 
    }

    public String getCamName() {
        return camName;
    }

    public String getCamPassword() {
        return camPassword;
    }

    public String getUrlCap() {
        return urlCap;
    }

    public String getUrlStream() {
        return urlStream;
    }

    public String getUrlSave() {
        return urlSave;
    }

    public void setCamName(String camName) {
        this.camName = camName;
    }

    public void setCamPassword(String camPassword) {
        this.camPassword = camPassword;
    }

    public void setUrlCap(String urlCap) {
        this.urlCap = urlCap;
    }

    public void setUrlStream(String urlStream) {
        this.urlStream = urlStream;
    }

    public void setUrlSave(String urlSave) {
        this.urlSave = urlSave;
    }
        
    
}
