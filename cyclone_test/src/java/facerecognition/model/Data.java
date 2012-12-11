/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facerecognition.model;

/**
 *
 * @author Sneha Bankar
 */
public class Data {
    
    private String id;
    private String code;
    private String originalFileName;
    private boolean isTrained;

//Getters and Setters below

    public String getId() {
        return id;
    }
    
    public String getCode() {
        return code;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public boolean isIsTrained() {
        return isTrained;
    }
        
    public void setId(String id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public void setIsTrained(boolean isTrained) {
        this.isTrained = isTrained;
    }                    
       
}
