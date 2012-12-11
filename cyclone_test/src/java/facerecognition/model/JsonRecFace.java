/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facerecognition.model;

import java.util.List;

/**
 *
 * @author Sneha Bankar
 */
public class JsonRecFace {
    
     private String code;
     private String message;
     private List<FaceData> data;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<FaceData> getData() {
        return data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(List<FaceData> data) {
        this.data = data;
    }                             
}
