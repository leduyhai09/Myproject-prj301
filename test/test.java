

import dal.AccountDBContext;
import dal.InstructorDBContext;
import java.util.List;
import model.Account;
import model.Attendance;
import model.Classs;
import model.Course;
import model.Course_Grade;
import model.Grade;
import model.Instructor;
import model.Room;
import model.Session;
import model.Term;
import model.Term_Course;
import model.TimeSlot;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class test {

    public static void main(String[] args) {
//        AccountDBContext adbc = new AccountDBContext();
        InstructorDBContext idbc = new InstructorDBContext();
//        TimeSlot s = idbc.getSlotById(1);
//        System.out.println(s.getTname());
//        Classs s  = idbc.getClassById(1);
//        System.out.println(s.getClassName());
//
//       List<Attendance> a = idbc.getListSessionStudent("leduyhai", java.sql.Date.valueOf("2024-01-15"),  java.sql.Date.valueOf("2024-03-30"));
//        for (Attendance attendance : a) {
//            System.out.println(attendance.getSessionId().getClassId().getClassName());
//        }
        
//    }
        List<Attendance> a = idbc.getListSessionStudent("leduyhai",  java.sql.Date.valueOf("2024-01-15"),  java.sql.Date.valueOf("2024-03-30"));
        for (Attendance attendance : a) {
            System.out.println(attendance.getSessionId().getDate());
        }

        Term t = idbc.getTermById(4);
        List<Course_Grade> c = idbc.getListCourse_Grades(3);
        for (Course_Grade course_Grade : c) {
            System.out.println(course_Grade.getGradeId().getGradeName());
        }
    }
}

