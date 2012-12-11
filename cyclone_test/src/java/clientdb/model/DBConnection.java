/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientdb.model;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Prashanth
 */

public class DBConnection {

    public String sshUser = null;
    public String sshPassword = null;
    public String sshPort = null;
    public String sshHost = null;
    public String remotePort = null;
    public String remoteHost = null;
    public String dbUser = null;
    public String dbPassword = null;
    public String driverName = null;
    public String schemaName = null;
    public Connection dbConn = null;
    public String localPort = null;
    
    private static final DBConnection instance = new DBConnection();
    
    public static DBConnection getInstance() {
      
       return instance;
    }
    
    public Connection getDbConn() throws InstantiationException, ClassNotFoundException,
            IllegalAccessException {
        if (this.dbConn == null)
        {
                Connection conn = null;
            try{
                
                DBConnection.doSshTunnel(sshUser, sshPassword, sshHost, sshPort,
                        remoteHost, localPort, remotePort);
            }
            catch( Exception e )
            {
                System.out.println( e ) ;
            }
        
        
            try{
                Class.forName(driverName).newInstance();
                String url = "jdbc:mysql://"+remoteHost+":"+localPort+"/"+schemaName;
                Connection con = DriverManager.getConnection( url, dbUser, dbPassword);
                this.dbConn =  con;
            
            }
            catch( SQLException se )
            {
                System.out.println( "SQL Exception:" ) ;

                // Loop through the SQL Exceptions
                while( se != null )
                {
                    System.out.println( "State  : " + se.getSQLState()  ) ;
                    System.out.println( "Message: " + se.getMessage()   ) ;
                    System.out.println( "Error  : " + se.getErrorCode() ) ;

                    se = se.getNextException() ;
                }
            }
        }
        return this.dbConn;
    }

 
    public String getSshUser() {
        return sshUser;
    }

    public void setSshUser(String sshUser) {
        this.sshUser = sshUser;
    }

    public String getSshPassword() {
        return sshPassword;
    }

    public void setSshPassword(String sshPassword) {
        this.sshPassword = sshPassword;
    }

    public String getSshPort() {
        return sshPort;
    }

    public void setSshPort(String sshPort) {
        this.sshPort = sshPort;
    }

    public String getSshHost() {
        return sshHost;
    }

    public void setSshHost(String sshHost) {
        this.sshHost = sshHost;
    }

    public String getRemotePort() {
        return remotePort;
    }

    public void setRemotePort(String remotePort) {
        this.remotePort = remotePort;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getLocalPort() {
        return localPort;
    }

    public void setLocalPort(String localPort) {
        this.localPort = localPort;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }
    
    
   private static void doSshTunnel( String sshUser, String sshPassword, String sshHost,
           String sshPort, String remoteHost, String localPort, String remotePort )
           throws JSchException
   {
    final JSch jsch = new JSch();
    Session session = jsch.getSession( sshUser, sshHost, Integer.parseInt(sshPort) );
    session.setPassword( sshPassword );
    
    final Properties config = new Properties();
    config.put( "StrictHostKeyChecking", "no" );
    session.setConfig( config );
    
    session.connect();
    session.setPortForwardingL(Integer.parseInt(localPort), remoteHost, Integer.parseInt(remotePort));
    }

    
}
