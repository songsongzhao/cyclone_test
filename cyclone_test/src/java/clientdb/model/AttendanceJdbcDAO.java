/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientdb.model;

import attendancereport.model.AttendanceReportObj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sneha Bankar
 */
public class AttendanceJdbcDAO {
    
   Connection con=null;
   PreparedStatement pStmt=null;
   ResultSet rs=null;
   
   private static final AttendanceJdbcDAO instance = new AttendanceJdbcDAO();
    
    public static AttendanceJdbcDAO getInstance() {      
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
   
  public void registerAttendance(ArrayList<String> uName,int schId,Date date)
  {
   try {   
    Set uNameset = new HashSet(uName);  
    String uNamest = null;
    ArrayList<UserObj> users = new ArrayList<UserObj>();
    AttendanceObj attendObj = null;
    int uIdint;
    
    UserScheduleJDBCDAO userSchDAO = UserScheduleJDBCDAO.getInstance(); 
    ArrayList<Integer> UIdForReg = userSchDAO.getUIdbySchId(schId);                                    
    
    UserJdbcDAO userDAO = UserJdbcDAO.getInstance(); 
    users = userDAO.listtUsers();                    
    
    for (int i = 0; i < UIdForReg.size(); i++) 
    {
        UserObj userObj = userDAO.getUserbyId(Integer.toString(UIdForReg.get(i)));
        attendObj = new AttendanceObj();
        attendObj.setuId(UIdForReg.get(i));        
        attendObj.setSchdId(schId);
        attendObj.setDate(date);     
        
        uNamest = userObj.getUserName();
        if (uNameset.contains(uNamest))
        {
          attendObj.setPresent(1);        
          attendObj.setAbsent(0);        
        }
        else
        {
          attendObj.setPresent(0);        
          attendObj.setAbsent(1);          
        }           
        this.addAttendance(attendObj);
    }  
         
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
   }

    private void addAttendance(AttendanceObj attendObj) 
    {              
       try {
            String queryString = "INSERT INTO Attendance(UId, Date, Sch_id, Present, Absent) VALUES(?,?,?,?,?)";
            con = getConnection();
            pStmt = con.prepareStatement(queryString);
            pStmt.setInt(1, attendObj.getuId());            
            java.sql.Date date = new java.sql.Date(attendObj.getDate().getTime());
            pStmt.setDate(2, date);            
            pStmt.setInt(3, attendObj.getSchdId());
            pStmt.setInt(4, attendObj.getPresent());
            pStmt.setInt(5, attendObj.getAbsent());
            pStmt.executeUpdate();
            System.out.println("Data Added Successfully");
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
    }
      
    public AttendanceReportObj returnAttendance(int Sch_id,String uName) 
    {   
        AttendanceReportObj repObj = new AttendanceReportObj();                
        try {            
                                     
            UserJdbcDAO user = UserJdbcDAO.getInstance();             
            UserObj userObj = new UserObj();            
            userObj = user.getUserbyName(uName);            
            int intUId = Integer.parseInt(userObj.getuId());                        
            
            String queryString = "SELECT UId,Sch_id,SUM(Present),SUM(Absent)FROM Attendance WHERE Sch_id =? AND UId=? GROUP BY UId";
            con = getConnection();
            pStmt = con.prepareStatement(queryString);
            pStmt.setInt(1, Sch_id);                                                
            pStmt.setInt(2, intUId); 
            rs = pStmt.executeQuery();
            if (rs.next())
            {                                                      
                repObj.setUserName(userObj.getFirstName());
                repObj.setuId(rs.getString(1));                           
                repObj.setSchdId(rs.getString(2));
                repObj.setPresent(rs.getString(3));
                repObj.setAbsent(rs.getString(4));                                                              
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
            return repObj;        
    }
    
    public ArrayList<AttendanceReportObj> returnAllAttendance(int Sch_id) 
    {  
       ArrayList<AttendanceReportObj> reportObjects = new ArrayList<AttendanceReportObj>(); 
       try {            
                                     
            UserJdbcDAO user = UserJdbcDAO.getInstance(); 
//            ArrayList<UserObj> listUsers = user.listtUsers();            
            UserObj userobj = new UserObj();            
            String queryString = "SELECT UId,Sch_id,SUM(Present),SUM(Absent)FROM Attendance WHERE Sch_id =? GROUP BY UId";
            con = getConnection();
            pStmt = con.prepareStatement(queryString);
            pStmt.setInt(1, Sch_id);                                                
            rs = pStmt.executeQuery();
            while (rs.next()){                                      
                AttendanceReportObj repObj = new AttendanceReportObj();
                userobj = user.getUserbyId(rs.getString("UId"));
                repObj.setUserName(userobj.getFirstName());
                repObj.setuId(rs.getString(1));                           
                repObj.setSchdId(rs.getString(2));
                repObj.setPresent(rs.getString(3));
                repObj.setAbsent(rs.getString(4));                
                reportObjects.add(repObj);                                
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
            return reportObjects;
          }
    
    public ArrayList<AttendanceReportObj> returnAllSchedule(int Sch_id) 
    {  
       ArrayList<AttendanceReportObj> reportObjects = new ArrayList<AttendanceReportObj>(); 
       try {            
                                     
            String queryString = " select Date,SUM(Present),SUM(Absent)FROM Attendance WHERE Sch_id=? GROUP BY Date";
            con = getConnection();
            pStmt = con.prepareStatement(queryString);
            pStmt.setInt(1, Sch_id);                                                
            rs = pStmt.executeQuery();
            while (rs.next()){                                      
                AttendanceReportObj repObj = new AttendanceReportObj();                
                repObj.setDate(rs.getString(1));
                repObj.setPresent(rs.getString(2));
                repObj.setAbsent(rs.getString(3));
                reportObjects.add(repObj);                                
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
            return reportObjects;
          }    
    
    public ArrayList<AttendanceReportObj> returnSchedule(int Sch_id,int uId) 
    {  
       ArrayList<AttendanceReportObj> reportObjects = new ArrayList<AttendanceReportObj>(); 
       try {            
                                     
            String queryString = "SELECT Date,Present FROM Attendance WHERE Sch_id=? AND UId=?";
            con = getConnection();
            pStmt = con.prepareStatement(queryString);
            pStmt.setInt(1, Sch_id);                                                
            pStmt.setInt(2, uId);
            rs = pStmt.executeQuery();
            while (rs.next()){                                      
                AttendanceReportObj repObj = new AttendanceReportObj();                
                repObj.setDate(rs.getString(1));
                if(rs.getString(2).compareTo("1")==0)
                {
                 repObj.setPresent("Present");                
                }
                else
                {
                  repObj.setPresent("Absent");                 
                }
                reportObjects.add(repObj);                                
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
            return reportObjects;            
    }

    public ArrayList<AttendanceReportObj> returnDateSchedule(String date, String Sch_id) {
        
        ArrayList<AttendanceReportObj> reportObjects = new ArrayList<AttendanceReportObj>(); 
        UserJdbcDAO user = UserJdbcDAO.getInstance(); 
        UserObj userobj = new UserObj();            
        try {                                                 
            String queryString = "SELECT UId,Date,Present FROM Attendance WHERE Sch_id=? AND Date=?";
            con = getConnection();
            pStmt = con.prepareStatement(queryString);
            pStmt.setInt(1, Integer.parseInt(Sch_id));                                                
            pStmt.setString(2, date);
            rs = pStmt.executeQuery();
            while (rs.next()){                                      
                AttendanceReportObj repObj = new AttendanceReportObj();                
                userobj = user.getUserbyId(rs.getString(1));
                repObj.setuId(userobj.getuId());
                repObj.setFirstName(userobj.getFirstName());
                repObj.setLastName(userobj.getLastName());
                repObj.setDate(rs.getString(2));
                if(rs.getString(3).compareTo("1")==0)
                {
                 repObj.setPresent("Present");                   
                }                
                else
                {
                 repObj.setPresent("Absent");                   
                }
                reportObjects.add(repObj);                                
                }  // end while loop                                                 
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
            return reportObjects;            
    }
}
