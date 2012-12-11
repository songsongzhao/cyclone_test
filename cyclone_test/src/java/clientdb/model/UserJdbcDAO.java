/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientdb.model;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
public class UserJdbcDAO {
    
  Connection con=null;
  PreparedStatement pStmt=null;
  ResultSet rs=null;
  
   private static final UserJdbcDAO instance = new UserJdbcDAO();
    
    public static UserJdbcDAO getInstance() {
      
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
   
     public boolean userexistswithusername(String Uname) throws SQLException
  {    
      try
      {      
      String query = "SELECT * FROM User WHERE Username=?";
      con = getConnection();
      pStmt=con.prepareStatement(query);
      pStmt.setString(1,Uname);
      rs = pStmt.executeQuery();
      if(rs.next())            
      {                                          
          return true;
      } 
      }
      catch (SQLException e) {
     } 
        return false;
  }
  
  public UserObj userexists(String Uname, String Password) throws SQLException
  {    
      UserObj user = new UserObj();
      try
      {      
      String query = "SELECT * FROM User WHERE Username=? AND Password=?";
      con = getConnection();
      pStmt=con.prepareStatement(query);
      pStmt.setString(1,Uname);
      pStmt.setString(2,Password);
      rs = pStmt.executeQuery();
      if(rs.next())            
      {                                          
       user.setUserName(rs.getString("Username"));
       user.setPassword(rs.getString("Password"));
       user.setUserType(rs.getString("Usertype"));
       user.setuId(rs.getString("UId"));
       user.setFirstName(rs.getString("Firstname"));
       user.setLastName(rs.getString("Lastname"));
       user.setAddress(rs.getString("Address"));
       user.setEmail(rs.getString("Email"));       
      } 
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
      return user;        
  }
  
  public void add(UserObj user) {      
    try {
            String queryString = "INSERT INTO User(Username, Password, Usertype,"
                    + " UId, Firstname, Lastname,Address,Email) VALUES(?,?,?,?,?,?,?,?)";
            con = getConnection();
            pStmt = con.prepareStatement(queryString);
            pStmt.setString(1, user.getUserName());
            pStmt.setString(2, user.getPassword());
            int intUserType = Integer.parseInt(user.getUserType());                        
            pStmt.setInt(3, intUserType);           
            int intUId = Integer.parseInt(user.getuId());                        
            pStmt.setInt(4, intUId);
            pStmt.setString(5, user.getFirstName());
            pStmt.setString(6, user.getLastName());
            pStmt.setString(7, user.getAddress());
            pStmt.setString(8, user.getEmail());
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
  
  public ArrayList<UserObj> listtUsers()
  {
     ArrayList<UserObj> users = new ArrayList<UserObj>();
      try {
            String queryString = "SELECT * from User";
            con = getConnection();
            pStmt = con.prepareStatement(queryString);
            rs = pStmt.executeQuery();
            while (rs.next()){                      
                UserObj user = new UserObj();
                user.setUserName(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                if(rs.getString("Usertype").compareTo("0")==0)
                {
                    user.setUserType("Admin");
                }
                else if(rs.getString("Usertype").compareTo("1")==0)
                {
                    user.setUserType("Teacher");
                }
                else if(rs.getString("Usertype").compareTo("2")==0)
                {
                    user.setUserType("Student");
                }                
                user.setuId(rs.getString("UId"));
                user.setFirstName(rs.getString("Firstname"));
                user.setLastName(rs.getString("Lastname"));
                user.setAddress(rs.getString("Address"));
                user.setEmail(rs.getString("Email"));
                users.add(user);
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
       return users;    
  }
  
  public UserObj getUserbyName(String Uname) throws SQLException
  {
      UserObj user = new UserObj();  
      try
      {
      String query = "SELECT * FROM User WHERE Username=?";
      con = getConnection();
      pStmt=con.prepareStatement(query);
      pStmt.setString(1,Uname);      
      rs = pStmt.executeQuery();
      if(rs.next())            
      {        
        user.setUserName(rs.getString("Username"));
        user.setPassword(rs.getString("Password"));
        user.setUserType(rs.getString("Usertype"));
        user.setuId(rs.getString("UId"));
        user.setFirstName(rs.getString("Firstname"));
        user.setLastName(rs.getString("Lastname"));
        user.setAddress(rs.getString("Address"));
        user.setEmail(rs.getString("Email"));                
      }      
      }catch (SQLException e) {
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
      return user;        
  }
  
  public UserObj getUserbyId(String UId) throws SQLException
  {  
      int intUId = Integer.parseInt(UId);                        
      UserObj user = new UserObj();  
      try
      {
      String query = "SELECT * FROM User WHERE UId=?";
      con = getConnection();
      pStmt=con.prepareStatement(query);
      pStmt.setInt(1,intUId);      
      rs = pStmt.executeQuery();
      if(rs.next())            
      {        
        user.setUserName(rs.getString("Username"));
        user.setPassword(rs.getString("Password"));
        user.setUserType(rs.getString("Usertype"));
        user.setuId(rs.getString("UId"));
        user.setFirstName(rs.getString("Firstname"));
        user.setLastName(rs.getString("Lastname"));
        user.setAddress(rs.getString("Address"));
        user.setEmail(rs.getString("Email"));                
      }      
      }catch (SQLException e) {
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
      return user;        
  }
  
  
  public void update(UserObj user)
  {
      try {            
            String queryString = "UPDATE User SET Username = ?," +
                                         "UId = ?,Usertype = ?,Firstname = ?,"  +
                                         "Lastname = ?,Address = ?,"  +
                                         "Email = ?,Password = ? WHERE Username = ?";
            con = getConnection();
            pStmt = con.prepareStatement(queryString);
            pStmt.setString(1, user.getUserName());            
            int intUId = Integer.parseInt(user.getuId());                        
            pStmt.setInt(2, intUId);            
            pStmt.setInt(3, Integer.parseInt(user.getUserType()));                       
            pStmt.setString(4, user.getFirstName());
            pStmt.setString(5, user.getLastName());
            pStmt.setString(6, user.getAddress());
            pStmt.setString(7, user.getEmail());
            pStmt.setString(8, user.getPassword());
            pStmt.setString(9, user.getUserName());
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
}  
  
  

