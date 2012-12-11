/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientdb.model;

/**
 *
 * @author Sneha Bankar
 */
public class ScheduleObj {
    
    private int schId;
    private String courseName;
    private String intsructor;

    public ScheduleObj(int schId, String courseName, String intsructor) {
        this.schId = schId;
        this.courseName = courseName;
        this.intsructor = intsructor;
    }

    public ScheduleObj() {
    }

    public int getSchId() {
        return schId;
    }

    public String getIntsructor() {
        return intsructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setSchId(int schId) {
        this.schId = schId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setIntsructor(String intsructor) {
        this.intsructor = intsructor;
    }                
}
