/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientdb.controller;

import clientdb.model.UserJdbcDAO;
import clientdb.model.UserObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Naanu
 */
public class AddUser extends HttpServlet {        
    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        UserJdbcDAO user = UserJdbcDAO.getInstance(); 
        String userName  = request.getParameter("Username");
        try {
            if(user.userexistswithusername(userName)){
               response.setContentType( "text/html" );
      
                // Always set the Content Type before data is printed
                PrintWriter out = response.getWriter();
                out.println( "<html>" );
                out.println( "<head>" );
                out.println( "<title>Error</title>" );
                out.println( "</head>" );
                out.println( "<body>" );
                out.println( "<h1>Username exists</h1>" );
                out.println( "</body>" );
                out.println( "</html>" );
                out.close();
            }
            else
            {
            String password  = request.getParameter("Password");
            String uId       = request.getParameter("UId");
            String userType  = request.getParameter("UserType");
            String fName     = request.getParameter("Fname");
            String lName     = request.getParameter("Lname");
            String address   = request.getParameter("Address");
            String email     = request.getParameter("Email");
            
            UserObj userObj = new UserObj(userName,password,userType,uId,fName,lName,address,email);               
            user.add(userObj);   
               // Always set the Content Type before data is printed
                PrintWriter out = response.getWriter();
                out.println( "<html>" );
                out.println( "<head>" );
                out.println( "<title>Success</title>" );
                out.println( "</head>" );
                out.println( "<body>" );
                out.println( "<h1>User added</h1>" );
                out.println( "</body>" );
                out.println( "</html>" );
                out.close(); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }   
    
    
}
