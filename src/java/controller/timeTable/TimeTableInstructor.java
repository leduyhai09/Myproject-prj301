/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.timeTable;

import dal.InstructorDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Account;
import model.Session;
import model.TimeSlot;
import util.DateTimeHelper;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "TimeTableInstructor", urlPatterns = {"/instructor"})
public class TimeTableInstructor extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("id");
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
         Date today = new Date();
        java.sql.Date from = null; 
        java.sql.Date to = null;
        
        if(raw_from ==null)
        {
            from = DateTimeHelper.convertUtilDateToSqlDate(DateTimeHelper.getWeekStart(today));
        }
        else
        {
            from = java.sql.Date.valueOf(raw_from);
        }
        
        if(raw_to == null)
        {
            to = DateTimeHelper.convertUtilDateToSqlDate(DateTimeHelper.
                    addDaysToDate(DateTimeHelper.getWeekStart(today),6));
        }
        else
        {
            to = java.sql.Date.valueOf(raw_to);
        }
        
        ArrayList<java.sql.Date> dates = DateTimeHelper.getDatesBetween(from, to);
        
        HttpSession sesion = request.getSession();
        Account account = (Account) sesion.getAttribute("account");

        InstructorDBContext idbc = new InstructorDBContext();
        List<TimeSlot> timeSlots = idbc.getListTimeSlots();
        ArrayList<Session> listSession = (ArrayList<Session>) idbc.getSessions(account.getUserName(), from,  to);
        request.setAttribute("test", listSession.size());
        request.setAttribute("username", userName);
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("sessions", listSession); 
        request.setAttribute("dates", dates);
        request.setAttribute("timeSlots", timeSlots);
        request.getRequestDispatcher("viewInstructor/timeofinstructor.jsp").forward(request, response);
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
