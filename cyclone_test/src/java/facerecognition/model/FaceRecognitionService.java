/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * @author Sneha Bankar
 */
package facerecognition.model;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletContext;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Sneha Bankar
 */
public class FaceRecognitionService {
    
    public String urlAddFace = null;    
    public String urlRecFace = null;
    public String urlTrainFace = null;    
    private ArrayList<String> recFaces = null;
    private String code =null;
    
    private static final FaceRecognitionService instance = new FaceRecognitionService();
    public static FaceRecognitionService getInstance() {
      
       return instance;
    }
    
    public String sendImage(String UId,ServletContext servletContext) throws UnsupportedEncodingException, IOException 
    {
        String path = servletContext.getRealPath("/Images");
        File f = new File(path + "/Train.jpg");            
        if(!f.exists())
        {
           String message = "Please Capture/Upload Image First" ;
           return message;
        }        

        FileBody fileBody = new FileBody(f);
        HttpClient client = new DefaultHttpClient();
        client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

        HttpPost post   = new HttpPost(urlAddFace);
        
        MultipartEntity entity = new MultipartEntity( HttpMultipartMode.BROWSER_COMPATIBLE );

        // For File parameters
        entity.addPart( "image", fileBody);

        // For usual String parameters
        entity.addPart( "code", new StringBody( UId, "text/plain", 
                                           Charset.forName( "UTF-8" )));

        post.setEntity( entity );
        
        String serverresponse = EntityUtils.toString( client.execute( post ).getEntity(), "UTF-8" );        
        client.getConnectionManager().shutdown();
        System.out.println("resp:"+serverresponse);   
        String ret_code = getJsonAddFace(serverresponse);
        this.code = ret_code;
        ReturnCode rc = new ReturnCode();
        String message = "Add Face Operation:" + rc.sendMessage(ret_code);        
        return message;
    }
    
    
    private static String getJsonAddFace(String serverresponse)
    {
     
     Gson gson = new Gson();
     JsonAddFace obj = gson.fromJson(serverresponse, JsonAddFace.class);
     return obj.getCode();          
     
    }  
    
    
    public String train() throws UnsupportedEncodingException, IOException 
    {
                
        HttpClient client = new DefaultHttpClient();
        client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

        HttpGet get   = new HttpGet(urlTrainFace);
        MultipartEntity entity = new MultipartEntity( HttpMultipartMode.BROWSER_COMPATIBLE );
               
        String serverresponse = EntityUtils.toString( client.execute( get ).getEntity(), "UTF-8" );        
        client.getConnectionManager().shutdown();
        System.out.println(serverresponse);   
        String ret_code = getJsonTrainFaceVal(serverresponse);
        this.code = ret_code;
        ReturnCode rc = new ReturnCode();
        String message = "Training Operation:" + rc.sendMessage(ret_code);        
        return message;
    }

    private static String getJsonTrainFaceVal(String serverresponse)
    {
     
     Gson gson = new Gson();
     JsonTrainFace obj = gson.fromJson(serverresponse, JsonTrainFace.class);
     return obj.getCode();          
     
    } 
    
    public String recognize(ServletContext servletContext) throws UnsupportedEncodingException, IOException 
    {
        String path = servletContext.getRealPath("/Images");
        File f = new File(path + "/QuickAttend.jpg");            
        if(!f.exists())
        {
           String message = "Please Capture/Upload Image First" ;
           return message;
        }        
        FileBody fileBody = new FileBody(f);
        HttpClient client = new DefaultHttpClient();
        client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

        HttpPost post   = new HttpPost(urlRecFace);        
        MultipartEntity entity = new MultipartEntity( HttpMultipartMode.BROWSER_COMPATIBLE );

        // For File parameters
        entity.addPart( "image", fileBody);
        post.setEntity( entity );
        
        String serverresponse = EntityUtils.toString( client.execute( post ).getEntity(), "UTF-8" );        
        client.getConnectionManager().shutdown();
        System.out.println("resp:"+serverresponse);   
        
        String verify_code= getJsonVerify(serverresponse);
        
        if (verify_code.compareTo("100")!=0)
        {          
        ReturnCode rc1 = new ReturnCode();
        this.code = verify_code;
        String errmessage = "Recognition Operation:" + rc1.sendMessage(verify_code);                
        return errmessage;        
        }
        String ret_code = getJsonRecFace(serverresponse);
        ReturnCode rc = new ReturnCode();
        this.code = ret_code;
        String message = "Recognition Operation:" + rc.sendMessage(ret_code);        
        return message;               
    }
    
    private String getJsonRecFace(String serverresponse)
    {
       Gson gson = new Gson();
       JsonRecFace recFaceObj = gson.fromJson(serverresponse, JsonRecFace.class);
       List<FaceData> faces = new ArrayList<FaceData>();
       faces = recFaceObj.getData();
       
       ArrayList<String> recFaces = new ArrayList<String>();
       Set set = new HashSet(); //To Care of Duplicates
       
       for(int i=0; i< faces.size();i++ )
       {
           FaceData faceObj = faces.get(i);
           if ((faceObj.getFace())!= null && set.add(faceObj.getFace().getCode()))
           recFaces.add(faceObj.getFace().getCode());
       }                             
       setRecFaces(recFaces);
       return recFaceObj.getCode();          
       
    }            
       
    private String getJsonVerify(String serverresponse)
    {
       Gson gson = new Gson();
       JsonVerify verifyObj = gson.fromJson(serverresponse, JsonVerify.class);
       return verifyObj.getCode();
       
    }
            
    public String getUrlAddFace() {
        return urlAddFace;
    }

    public String getUrlRecFace() {
        return urlRecFace;
    }

    public String getUrlTrainFace() {
        return urlTrainFace;
    }

    public String getCode() {
        return code;
    }        
        
    public void setUrlAddFace(String urlAddFace) {
        this.urlAddFace = urlAddFace;
    }

    public void setUrlRecFace(String urlRecFace) {
        this.urlRecFace = urlRecFace;
    }

    public void setUrlTrainFace(String urlTrainFace) {
        this.urlTrainFace = urlTrainFace;
    }

    public ArrayList<String> getRecFaces() {
        return recFaces;
    }

    public void setRecFaces(ArrayList<String> recFaces) {
        this.recFaces = recFaces;
    }

    public void setCode(String code) {
        this.code = code;
    }        
    
}
