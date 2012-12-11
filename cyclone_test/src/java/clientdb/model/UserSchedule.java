/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientdb.model;

/**
 *
 * @author Sneha Bankar
 */
public class UserSchedule {
    
    private int Sch_id;
    private int UId;

    public UserSchedule(int Sch_id, int UId) {
        this.Sch_id = Sch_id;
        this.UId = UId;
    }

    public UserSchedule() {
    }

    public int getUId() {
        return UId;
    }

    public int getSch_id() {
        return Sch_id;
    }

    public void setSch_id(int Sch_id) {
        this.Sch_id = Sch_id;
    }

    public void setUId(int UId) {
        this.UId = UId;
    }    
    
}
