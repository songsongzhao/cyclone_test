/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancereport.model;

import clientdb.model.AttendanceJdbcDAO;
import java.util.ArrayList;

/**
 *
 * @author Sneha Bankar
 */
public class AttendanceReportService {
    
    private static final AttendanceReportService instance = new AttendanceReportService();
    
    public static AttendanceReportService getInstance() {
      
       return instance;
    }
    
    public ArrayList<AttendanceReportObj> prepareAttendanceReportForTeacher(int Sch_id)
    {
        AttendanceJdbcDAO attendDAO = AttendanceJdbcDAO.getInstance();
        ArrayList<AttendanceReportObj> reportObjects = attendDAO.returnAllAttendance(Sch_id);
        return reportObjects;
    }
    
    public AttendanceReportObj prepareAttendanceReportForStudent(int Sch_id,String uName)
    {
        AttendanceJdbcDAO attendDAO = AttendanceJdbcDAO.getInstance();
        AttendanceReportObj reportObject = attendDAO.returnAttendance(Sch_id,uName);
        return reportObject;
    }
    
    public ArrayList<AttendanceReportObj> prepareScheduleTeacher(int Sch_id)
    {
        AttendanceJdbcDAO attendDAO = AttendanceJdbcDAO.getInstance();
        ArrayList<AttendanceReportObj> reportObjects = attendDAO.returnAllSchedule(Sch_id);
        return reportObjects;
    }

    public ArrayList<AttendanceReportObj> prepareScheduleStudent(int Sch_id, int uId) 
    {
        AttendanceJdbcDAO attendDAO = AttendanceJdbcDAO.getInstance();
        ArrayList<AttendanceReportObj> reportObjects = attendDAO.returnSchedule(Sch_id,uId);
        return reportObjects; 
    }

    public ArrayList<AttendanceReportObj> prepareDateSchedule(String date, String Sch_id) {
        
        AttendanceJdbcDAO attendDAO = AttendanceJdbcDAO.getInstance();
        ArrayList<AttendanceReportObj> reportObjects = attendDAO.returnDateSchedule(date,Sch_id);
        return reportObjects; 
    }
}
