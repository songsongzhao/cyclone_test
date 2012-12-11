/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classregistration.model;

import clientdb.model.AttendanceJdbcDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Sneha Bankar
 */
public class ClassRegistrationService {
    
    private int schId;
    private Date date;
    private static final ClassRegistrationService instance = new ClassRegistrationService();
    
    public static ClassRegistrationService getInstance() {      
       return instance;
    }
    
    public void init(int schId)
    {
        date = new Date();
        this.schId =  schId;
    }

    public void writeAttendance(ArrayList<String> uNames)
    {
        AttendanceJdbcDAO attendance = AttendanceJdbcDAO.getInstance(); 
        attendance.registerAttendance(uNames, schId, date);
                
    }
    public Integer getSchId() {
        return schId;
    }

    public Date getDate() {
        return date;
    }

    public void setSchId(Integer schId) {
        this.schId = schId;
    }

    public void setDate(Date date) {
        this.date = date;
    }            
    
}
