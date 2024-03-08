/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.mark;

import dal.InstructorDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Course;
import model.Course_Grade;
import model.Term;
import model.Term_Course;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="MarkReport", urlPatterns={"/mark"})
public class MarkReport extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        InstructorDBContext idbc = new InstructorDBContext();
        List<Term> listTerms = idbc.getTerms();
        
        String termId = request.getParameter("termId");
        if(termId != null){
        List<Term_Course> tc = idbc.getTerm_Course(Integer.parseInt(termId));
        request.setAttribute("tc", tc);
        }
        String courseId = request.getParameter("courseId");
        if(courseId != null){
        List<Course_Grade> cgs = idbc.getListCourse_Grades(Integer.parseInt(courseId));
        request.setAttribute("cgs", cgs);
        }
        request.setAttribute("listterm", listTerms);
        request.getRequestDispatcher("viewInstructor/mark.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
