/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientdb.model;

/**
 *
 * @author Sneha Bankar
 */
public class UserObj {
    
    public String userName;
    public String password;
    public String userType;    
    public String uId;
    public String firstName;
    public String lastName;  
    public String address; 
    public String email;

    public UserObj( String userName,String password, String userType,String uId,String firstName,
                    String lastName,String address,String email)
    {
        this.userName  = userName ;
        this.password  = password ;
        this.userType  = userType;
        this.uId       = uId;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.address   = address;    
        this.email     = email;
    }

    public UserObj() {
        
    }
    
    public String getUserName() {
        return userName;
    }

    public String getUserType() {
        return userType;
    }

    public String getuId() {
        return uId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }            

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
    
    public String retUsertype(String userVal)
    {
        String userType = null;
        if(userVal.compareTo("0")==0)
        userType = "Admin" ;
        else if (userVal.compareTo("1")==0)
        userType = "Teacher" ;
        else if (userVal.compareTo("2")==0)
        userType = "Student" ;
        
        return userType;        
        
    }         
     
    
}
