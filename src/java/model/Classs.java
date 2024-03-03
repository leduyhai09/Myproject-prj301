/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Classs {
    private int classId;
    private String className;
    private Course courseId ;

    public Classs() {
    }

    public Classs(int classId, String className, Course courseId) {
        this.classId = classId;
        this.className = className;
        this.courseId = courseId;
    }
    
    
    public int getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    
}
