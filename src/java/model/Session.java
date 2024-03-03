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
public class Session {

    private int sessionId;
    private Date date;
    private Room roomId;
    private Classs classId;
    private Attendance attentId;
    private Instructor instructorId;
    private TimeSlot slotId;

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public Classs getClassId() {
        return classId;
    }

    public void setClassId(Classs classId) {
        this.classId = classId;
    }

    public Attendance getAttentId() {
        return attentId;
    }

    public void setAttentId(Attendance attentId) {
        this.attentId = attentId;
    }

    public Instructor getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Instructor instructorId) {
        this.instructorId = instructorId;
    }

    public TimeSlot getSlotId() {
        return slotId;
    }

    public void setSlotId(TimeSlot slotId) {
        this.slotId = slotId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
