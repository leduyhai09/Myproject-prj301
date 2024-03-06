/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.attendance;

import dal.InstructorDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Attendance;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "Attendance", urlPatterns = {"/att"})
public class Attendances extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InstructorDBContext idbc = new InstructorDBContext();
        String slotId = request.getParameter("slotid");
        String date = request.getParameter("date");
        String sessionid= request.getParameter("sessionid");
        request.setAttribute("slotid", slotId);
        request.setAttribute("date", date);
        request.setAttribute("sessionid", sessionid);
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if(slotId!=null){
            
            ArrayList<Attendance> lista = (ArrayList<Attendance>) idbc.getAttendancesList(account.getUserName(), Integer.parseInt(slotId), date);
            request.setAttribute("lista", lista);
        }
        request.getRequestDispatcher("viewInstructor/attendance.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InstructorDBContext idbc = new InstructorDBContext();

        String slotId = request.getParameter("slotid");
        String date = request.getParameter("date");
        String sessionid = request.getParameter("sessionid");
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        ArrayList<Attendance> lista = (ArrayList<Attendance>) idbc.getAttendancesList(account.getUserName(), Integer.parseInt(slotId), date);
        for (Attendance attendance : lista) {
            String attstt = request.getParameter("att" + attendance.getStudentId().getStudentId());
            String comment = request.getParameter("comment" + attendance.getStudentId().getStudentId());
            idbc.updateAtt(attstt,comment, attendance.getStudentId().getStudentId(),Integer.parseInt(sessionid));
            System.out.print(attstt +" "+ attendance.getStudentId().getStudentId());
            System.out.print(comment);
        }
        idbc.updateStatusSession(Integer.parseInt(sessionid));
        response.sendRedirect("instructor"); 
//       request.setAttribute("t", lista.size());
//       request.getRequestDispatcher("test.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
