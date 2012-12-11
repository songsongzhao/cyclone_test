/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facerecognition.model;

/**
 *
 * @author Sneha Bankar
 */
public class JsonAddFace {
    
    private String code;
    private String message;
    private Data data;
    
    

    public String getCode() {
        return code;
    }

    public Data getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
