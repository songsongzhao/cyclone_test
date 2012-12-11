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
public class UserScheduleJDBCDAO {
    
    Connection con=null;
    PreparedStatement pStmt=null;
    ResultSet rs=null;
    private static final UserScheduleJDBCDAO instance = new UserScheduleJDBCDAO();
    
    public static UserScheduleJDBCDAO getInstance() {      
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
   
  public ArrayList<Integer> getUIdbySchId (int Sch_id) 
  {
      ArrayList<Integer> UId=new ArrayList<Integer>();     
      try
      {      
      String query = "SELECT * FROM UserSchedule WHERE Sch_id=?";
      con = getConnection();
      pStmt=con.prepareStatement(query);
      pStmt.setInt(1,Sch_id);      
      rs = pStmt.executeQuery();
      while (rs.next()){         
         UId.add(rs.getInt("UId"));        
        }   // end while loop                                      
      }
      catch (SQLException e) {
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
      return UId;                          
  }        
  
  public ArrayList<String> getSchId(int uId)
   {
       ArrayList<String> schIds = new ArrayList<String>(); 
       try {                                                 
            String queryString = "SELECT Sch_id FROM UserSchedule where UId=?";
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
