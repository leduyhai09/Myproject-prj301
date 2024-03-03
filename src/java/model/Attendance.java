/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Attendance {
    private int attentId;
    private String status;
    private String comment;
    private Student studentId;
   
    public Attendance() {
    }

    public Attendance(int attentId, String status, String comment) {
        this.attentId = attentId;
        this.status = status;
        this.comment = comment;
    }

    public int getAttentId() {
        return attentId;
    }

    public void setAttentId(int attentId) {
        this.attentId = attentId;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    

    
}
