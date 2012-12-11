/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancereport.model;

import java.util.Date;

/**
 *
 * @author Sneha
 */
public class AttendanceReportObj {
    
    private String userName;
    private String uId;
    private String firstName;
    private String lastName;
    private String date;
    private String schdId;
    private String present;
    private String absent;
    
    public AttendanceReportObj(String userName,String uId,String date,String schId,String present,String absent)
    {
        this.userName = userName;
        this.uId      = uId;
        this.date     = date;
        this.schdId   = schId;
        this.present  = present;
        this.absent   = absent;
    }

    public AttendanceReportObj() {
        
    }

    public String getUserName() {
        return userName;
    }
    
    public String getuId() {
        return uId;
    }
    
    public String getDate() {
        return date;
    }

    public String getSchdId() {
        return schdId;
    }
    
    public String getPresent() {
        return present;
    }

    public String getAbsent() {
        return absent;
    }        

    public String getFirstName() {
        return firstName;
    }        

    public String getLastName() {
        return lastName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSchdId(String schdId) {
        this.schdId = schdId;
    }
    
    public void setuId(String uId) {
        this.uId = uId;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public void setAbsent(String absent) {
        this.absent = absent;
    }

    public void setDate(String date) {
        this.date = date;
    }       

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
        
}
