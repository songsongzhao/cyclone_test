/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientdb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sneha Bankar
 */
public class ScheduleJdbcDAO {
    
    Connection con=null;
   PreparedStatement pStmt=null;
   ResultSet rs=null;
   
   private static final ScheduleJdbcDAO instance = new ScheduleJdbcDAO();
    
    public static ScheduleJdbcDAO getInstance() {      
       return instance;
    }
    
   private Connection getConnection() throws SQLException
  {
    DBConnection dbConn = DBConnection.getInstance(); 
    Connection conn = null;;
    try {
        conn = dbConn.getDbConn();    
    } catch (InstantiationException ex) {
        Logger.getLogger(UserJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(UserJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        Logger.getLogger(UserJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return conn;
  }
   
   public ArrayList<String> getSchId(int uId)
   {
       ArrayList<String> schIds = new ArrayList<String>(); 
       try {                                                           
            String queryString = "SELECT Sch_id FROM Schedule where InstructorId =?";
            con = getConnection();
            pStmt = con.prepareStatement(queryString);
            pStmt.setInt(1, uId);                                                
            rs = pStmt.executeQuery();
            while (rs.next()){                                      
                String schId = rs.getString("Sch_id");
                schIds.add(schId);
                }   // end while loop                                                 
    } catch (SQLException e) {
            e.printStackTrace();
    } finally {
            try {
                    if (pStmt != null)
                    pStmt.close();
            } catch (SQLException e) {
                    e.printStackTrace();
            } catch (Exception e) {
                    e.printStackTrace();
            }            
            }   
            return schIds;
   }       
}
