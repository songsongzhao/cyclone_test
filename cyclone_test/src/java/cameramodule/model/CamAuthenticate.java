/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cameramodule.model;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
/**
 *
 * @author Sneha Bankar
 */
public class CamAuthenticate extends Authenticator 
{
  private String username, password;

    public CamAuthenticate(String user, String pass) {
        
        username = user;
        password = pass;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
      return new PasswordAuthentication(username, password.toCharArray());
    }
    
    
}
