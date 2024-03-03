/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class StudentInClass {
    private Student studentId;
    private Classs classId;

    public StudentInClass() {
    }

    public StudentInClass(Student studentId, Classs classId) {
        this.studentId = studentId;
        this.classId = classId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Classs getClassId() {
        return classId;
    }

    public void setClassId(Classs classId) {
        this.classId = classId;
    }

    
    
    
}
