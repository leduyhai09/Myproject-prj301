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
import model.Course_Grade;
import model.Grade;
import model.Instructor;
import model.Room;
import model.Session;
import model.Student;
import model.Term;
import model.Term_Course;

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

    public Session getSessionById(int sessionId) {
        try {
            String sql = "select * from Session\n"
                    + "where Session.SessionId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sessionId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Session s = new Session();
                s.setSessionId(rs.getInt("SessionId"));
                s.setRoomId(getRoomById(rs.getInt("RoomId")));
                s.setClassId(getClassById(rs.getInt("ClassId")));
                s.setSlotId(getSlotById(rs.getInt("SlotId")));
                s.setDate(rs.getDate("date"));
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
                a.setStudentId(getStudentById(rs.getString("StudentId")));
                a.setSessionId(getSessionById(rs.getInt("sessionId")));
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

    public Term getTermById(int id) {
        String sql = "select * from Term\n"
                + "where Term.TermId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Term t = new Term();
                t.setTermId(rs.getInt("TermId"));
                t.setTermName(rs.getString("TermName"));
                return t;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Grade getGradeById(int id) {
        String sql = "select * from Grade\n"
                + "where Grade.GradeId =?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Grade g = new Grade();
                g.setGradeId(rs.getInt("GradeId"));
                g.setGradeName(rs.getString("GradeName"));
                g.setValue(rs.getDouble("value"));
                return g;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Session> getSessions(String username, Date from, Date to) {
        List<Session> attaList = new ArrayList<>();
        String sql = "  select distinct session.SessionId, session.date,Session.ClassId, Session.RoomId, Session.instructorId,Session.SlotId, Session.Status  from Session\n"
                + "                             join Classs\n"
                + "                     on Session.ClassId = Classs.ClassId\n"
                + "                               join instructor\n"
                + "                             on Session.instructorId = instructor.instructorId\n"
                + "							 join Attendance\n"
                + "							 on Attendance.sessionId = Session.SessionId\n"
                + "                              where instructor.userName = ? and Session.date >= ? and  Session.date <= ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setDate(2, from);
            stm.setDate(3, to);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session a = new Session();
                a.setSessionId(rs.getInt("SessionId"));
                a.setDate(rs.getDate("date"));
                a.setStatus(rs.getString("Status"));
                a.setClassId(getClassById(rs.getInt("ClassId")));
                a.setRoomId(getRoomById(rs.getInt("RoomId")));
                a.setInstructorId(getInstructorById(rs.getInt("instructorId")));
                a.setSlotId(getSlotById(rs.getInt("SlotId")));

                attaList.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attaList;
    }

    public List<Attendance> getListSessionStudent(String account, Date from, Date to) {
        List<Attendance> listTimeStudent = new ArrayList<>();
        String sql = "select Attendance.StudentId, Attendance.sessionId,  Attendance.status from Attendance\n"
                + "join Student\n"
                + "on Attendance.StudentId = Student.StudentId\n"
                + "join Session\n"
                + "on Session.SessionId = Attendance.sessionId\n"
                + "WHere Student.userName = ? and Session.date >= ? and Session.date <= ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, account);
            stm.setDate(2, from);
            stm.setDate(3, to);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setStatus(rs.getString("status"));
                a.setSessionId(getSessionById(rs.getInt("sessionId")));
                a.setStudentId(getStudentById(rs.getString("StudentId")));
                listTimeStudent.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTimeStudent;
    }

    public List<Attendance> getAttendancesList(String username, int slotId, String date) {
        List<Attendance> lista = new ArrayList<>();
        String sql = "select Attendance.sessionId, Attendance.ID, Attendance.Status, Attendance.comment ,Attendance.StudentId  from Attendance\n"
                + "                 join Session\n"
                + "                on Attendance.sessionId = Session.SessionId\n"
                + "                join instructor\n"
                + "                on instructor.instructorId = Session.instructorId\n"
                + "                where instructor.userName = ? and Session.SlotId=? and Session.date = ?";
        try {
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, username);
            stm.setInt(2, slotId);
            stm.setString(3, date);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setSessionId(getSessionById(rs.getInt("sessionId")));
                a.setAttentId(rs.getInt("ID"));
                a.setStatus(rs.getString("Status"));
                a.setComment(rs.getString("comment"));
                a.setStudentId(getStudentById(rs.getString("StudentId")));
                lista.add(a); // Add the Attendance object to the list
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void updateAtt(String status, String comment, String sid, int sessionid) {
        try {
            String sql = "update Attendance \n"
                    + "                    set Status = ? , Comment = ? where StudentId = ? and sessionId = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, status);
            stm.setString(2, comment);
            stm.setString(3, sid);
            stm.setInt(4, sessionid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateStatusSession(int sid) {
        try {
            String sql = "		update Session \n"
                    + "	set Status ='true'\n"
                    + "	where SessionId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Term> getTerms() {
        List<Term> listTerms = new ArrayList<>();
        try {
            String sql = "select * from Term";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Term t = new Term();
                t.setTermId(rs.getInt("TermId"));
                t.setTermName(rs.getString("TermName"));
                listTerms.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTerms;
    }

    public List<Term_Course> getTerm_Course(int termId) {
        List<Term_Course> listtCourses = new ArrayList<>();
        String sql = "select Term_Course.TermId, Term_Course.CourseId from term join \n"
                + "term_course\n"
                + "on Term.TermId = Term_Course.TermId\n"
                + "join Course\n"
                + "on Term_Course.CourseId  = Course.CourseId\n"
                + "where Term_Course.TermId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, termId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Term_Course tc = new Term_Course();
                tc.setCoureId(getCourseById(rs.getInt("CourseId")));
                tc.setTermId(getTermById(rs.getInt("TermId")));
                listtCourses.add(tc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listtCourses;
    }

    public List<Course_Grade> getListCourse_Grades(int courseId) {
        List<Course_Grade> getListCourse_Grades = new ArrayList<>();
        try {
            String sql = "select Course_Grade.GradeId, Course_Grade.CourseId,Course_Grade.[Weight],Course_Grade.Comment from Grade\n"
                    + "join Course_Grade\n"
                    + "on Grade.GradeId = Course_Grade.GradeId\n"
                    + "join Course\n"
                    + "on Course.CourseId = Course_Grade.CourseId\n"
                    + "where Course_Grade.CourseId=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, courseId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course_Grade g = new Course_Grade();
                g.setCourseId(getCourseById(rs.getInt("CourseId")));
                g.setGradeId(getGradeById(rs.getInt("GradeId")));
                g.setWeight(rs.getDouble("Weight"));
                g.setComment(rs.getString("Comment"));
                getListCourse_Grades.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getListCourse_Grades;
    }

}
