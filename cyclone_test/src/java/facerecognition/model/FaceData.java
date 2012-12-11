/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facerecognition.model;

/**
 *
 * @author Sneha Bankar
 */
public class FaceData {
    
     private String id;     
     private String confidence;
     private Position position;
     private Face face;

    public String getId() {
        return id;
    }   

    public String getConfidence() {
        return confidence;
    }

    public Position getPosition() {
        return position;
    }

    public Face getFace() {
        return face;
    }
    
    
    public void setId(String id) {
        this.id = id;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setFace(Face face) {
        this.face = face;
    }
        
}
