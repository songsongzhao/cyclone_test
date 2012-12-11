/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientdb.model;

import java.util.Date;

/**
 *
 * @author Sneha Bankar
 */
public class AttendanceObj {
    
    private int uId;
    private Date date;
    private int schdId;
    private int present;
    private int absent;

    public int getuId() {
        return uId;
    }

    public Date getDate() {
        return date;
    }

    public int getSchdId() {
        return schdId;
    }

    public int getPresent() {
        return present;
    }

    public int getAbsent() {
        return absent;
    }        

    public void setuId(int uId) {
        this.uId = uId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSchdId(int schdId) {
        this.schdId = schdId;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }
        
}
