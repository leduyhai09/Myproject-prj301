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
public class Instructor {

    private int instructorId;
    private String instructorName;
    private Date dob;
    private boolean gender;
    private Account userName;
    private Attendance attentId;

    public Instructor() {
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Account getUserName() {
        return userName;
    }

    public void setUserName(Account userName) {
        this.userName = userName;
    }

    public Attendance getAttentId() {
        return attentId;
    }

    public void setAttentId(Attendance attentId) {
        this.attentId = attentId;
    }

    
}
