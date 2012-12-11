/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientdb.model;

import clientdb.model.DBConnection;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Prashanth
 */

public class DBInit extends HttpServlet {
      
    @Override
    public void init(ServletConfig config) throws ServletException {

        String sshUser = config.getInitParameter("SSHUser");
        String sshPassword = config.getInitParameter("SSHPassword");
        String sshHost = config.getInitParameter("SSHHost");
        String sshPort = config.getInitParameter("SSHPort");
        String remotePort = config.getInitParameter("RemotePort");
        String dbUser = config.getInitParameter("DBUser");
        String dbPassword = config.getInitParameter("DBPassword");
        String driverName = config.getInitParameter("DriverName");
        String schemaName = config.getInitParameter("SchemaName");
        String remoteHost = config.getInitParameter("RemoteHost");
        String localPort = config.getInitParameter("LocalPort");

        ServletContext sc = config.getServletContext();
        // set in application scope of web application to access in future


        try{
            DBConnection dbConn = DBConnection.getInstance();

            dbConn.setSshUser(sshUser);
            dbConn.setSshPassword(sshPassword);
            dbConn.setSshHost(sshHost);
            dbConn.setSshPort(sshPort);
            dbConn.setRemoteHost(remoteHost);
            dbConn.setRemotePort(remotePort);
            dbConn.setDbUser(dbUser);
            dbConn.setDbPassword(dbPassword);
            dbConn.setDriverName(driverName);
            dbConn.setSchemaName(schemaName);
            dbConn.setLocalPort(localPort);
            sc.setAttribute("dbConn", dbConn);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

}
