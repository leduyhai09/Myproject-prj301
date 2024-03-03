/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.awt.AlphaComposite;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.List;
import model.TimeSlot;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Attendance;
import model.Classs;
import model.Course;
import model.Instructor;
import model.Room;
import model.Session;
import model.Student;

/**
 *
 * @author ADMIN
 */
public class InstructorDBContext extends DBContext {

    public List<TimeSlot> getListTimeSlots() {
        List<TimeSlot> listSlots = new ArrayList<>();
        try {
            String sql = "select t.tid, t.tname, t.Time  from TimeSlot as t";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                TimeSlot ts = new TimeSlot();
                ts.setTid(rs.getInt("tid"));
                ts.setTname(rs.getString("tname"));
                ts.setTime(rs.getString("Time"));
                listSlots.add(ts);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSlots;
    }

    public Course getCourseById(int id) {
        try {
            String sql = "select * from Course\n"
                    + "where Course.CourseId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Course c = new Course();
                c.setCourseId(rs.getInt("CourseId"));
                c.setCourseName(rs.getString("CourseName"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Room getRoomById(int id) {
        try {
            String sql = "select * from Room\n"
                    + "where Room.RoomId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Room r = new Room();
                r.setRoomId(rs.getInt("RoomId"));
                r.setRoomName(rs.getString("RoomName"));
                return r;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public TimeSlot getSlotById(int id) {
        try {
            String sql = "select * from TimeSlot\n"
                    + "where TimeSlot.tid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                TimeSlot ts = new TimeSlot();
                ts.setTid(rs.getInt("tid"));
                ts.setTname(rs.getString("tname"));
                ts.setTime(rs.getString("Time"));
                return ts;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Classs getClassById(int classId) {
        try {
            String sql = "select * from Classs\n"
                    + "where ClassId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, classId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Classs s = new Classs();
                s.setClassId(rs.getInt("ClassId"));
                s.setClassName(rs.getString("ClassName"));
                s.setCourseId(getCourseById(rs.getInt("courseId")));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Attendance getAttendanceById(int id) {
        try {
            String sql = "select * from Attendance\n"
                    + "where Attendance.ID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Attendance a = new Attendance();
                a.setAttentId(rs.getInt("ID"));
                a.setStatus(rs.getNString("Status"));
                a.setComment(rs.getString("Comment"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Account getAccountById(String userName) {
        String sql = "select * from Account where userName = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, userName);
            ResultSet s = stm.executeQuery();
            if (s.next()) {
                Account a = new Account();
                a.setUserName(s.getString("userName"));
                a.setPassWord(s.getString("passWord"));
                a.setRole(s.getInt("role")); // Assuming the column name is "role"
                return a;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Log the exception for debugging purposes
        }
        return null;
    }

    public Instructor getInstructorById(int id) {
        String sql = "select * from instructor where instructorId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Instructor i = new Instructor();
                i.setInstructorId(rs.getInt("instructorId"));
                i.setInstructorName(rs.getString("instructorName"));
                i.setDob(rs.getDate("dob"));
                i.setGender(rs.getBoolean("Gender"));
                i.setUserName(getAccountById(rs.getString("userName")));
                i.setAttentId(getAttendanceById(rs.getInt("AttentID")));
                return i;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Student getStudentById(String id) {
        String sql = "select * from Student\n"
                + "where StudentId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getString("StudentId"));
                s.setStudentName(rs.getString("StudentName"));
                s.setGender(rs.getBoolean("Gender"));
                s.setDob(rs.getDate("Dob"));
                s.setAccount(getAccountById("username"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Session> getSessions(String username, Date from, Date to) {
        List<Session> sessions = new ArrayList<>();
        String sql = "select session.date,Classs.ClassId, Session.RoomId, Session.AttentID , Session.instructorId,Session.SlotId  from Session\n"
                + "join Attendance\n"
                + "on Session.AttentID = Attendance.ID\n"
                + "join Classs\n"
                + "on Session.ClassId = Classs.ClassId\n"
                + "join instructor\n"
                + "on Session.instructorId = instructor.instructorId\n"
                + "join Student\n"
                + "on Student.StudentId = Attendance.StudentId\n"
                + "where instructor.userName = ? and Session.date >= ? and Session.date <= ? ";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setDate(2, from);
            stm.setDate(3, to);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setDate(rs.getDate("date"));
                s.setInstructorId(getInstructorById(rs.getInt("instructorId")));
                s.setClassId(getClassById(rs.getInt("ClassId")));
                s.setRoomId(getRoomById(rs.getInt("RoomId")));
                s.setAttentId(getAttendanceById(rs.getInt("AttentID")));
                s.setSlotId(getSlotById(rs.getInt("SlotId")));
                sessions.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }

    public List<Session> getListSessionStudent(String account, Date from, Date to) {
        List<Session> listTimeStudent = new ArrayList<>();
        String sql = "select  Session.date, Session.RoomId,Session.AttentID,Session.SlotId, Session.ClassId from Session\n"
                + "join Attendance\n"
                + "on Session.AttentID = Attendance.ID\n"
                + "join Student\n"
                + "on Student.StudentId = Attendance.StudentId\n"
                + "join Classs\n"
                + "on Session.ClassId = Classs.ClassId\n"
                + "join Course\n"
                + "on Course.CourseId = Classs.CourseId\n"
                + "where Student.userName = ? and Session.date >=? and Session.date <= ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, account);
            stm.setDate(2, from);
            stm.setDate(3, to);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setDate(rs.getDate("date"));
                s.setClassId(getClassById(rs.getInt("ClassId")));
                s.setAttentId(getAttendanceById(rs.getInt("AttentID")));
                s.setSlotId(getSlotById(rs.getInt("SlotId")));
                s.setRoomId(getRoomById(rs.getInt("RoomId")));
                listTimeStudent.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTimeStudent;
    }

    public List<Session> getListAttendance() {
            List<Session> listAttendance = new ArrayList<>();
            String sql = "select Session.ClassId,Session.AttentID from instructor\n"
                    + "join Session\n"
                    + "on instructor.instructorId = Session.instructorId\n"
                    + "join Attendance\n"
                    + "on Session.AttentID = Attendance.ID\n"
                    + "join Student\n"
                    + "on Student.StudentId = Attendance.StudentId\n"
                    + "where instructor.instructorId = ? and Session.SlotId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Session s = new Session();
                s.setClassId(getClassById(rs.getInt("ClassId")));
                s.setAttentId(getAttendanceById(rs.getInt("AttentID")));
                listAttendance.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
            return listAttendance;
    }

}
