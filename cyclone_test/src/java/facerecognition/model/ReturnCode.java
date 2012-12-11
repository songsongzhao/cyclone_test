/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facerecognition.model;

/**
 *
 * @author Sneha Bankar
 */
public class ReturnCode {
    
    public String sendMessage(String code)
    {
        String msg;
        if (code.compareTo("100") == 0)            
        msg = "Successful";
        else if (code.compareTo("401") == 0)            
        msg = "Invalid Credentials";
        else if (code.compareTo("500") == 0)            
        msg = "Unexpected error";
        else if (code.compareTo("501") == 0)            
        msg = "Invalid parameters";
        else if (code.compareTo("502") == 0)            
        msg = "Invalid identifier";
        else if (code.compareTo("601") == 0)            
        msg = "Too many faces";
        else if (code.compareTo("602") == 0)            
        msg = "No face detected";
        else if(code.compareTo("900") == 0)            
        msg = "Not yet implemented";
        else
        msg = "Unknown Error";
        
        return msg;
    }
}
