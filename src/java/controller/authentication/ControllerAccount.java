/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.authentication;

import dal.AccountDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ControllerAccount", urlPatterns = {"/login"})
public class ControllerAccount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("authentication/login.jsp").forward(request, response);
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
        String userNameString_raw = request.getParameter("username");
        String PassWord_Raw = request.getParameter("password");
        AccountDBContext adbc = new AccountDBContext();
        Account account = adbc.getAccount(userNameString_raw, PassWord_Raw);
        HttpSession sesion = request.getSession();
        if (account != null) {
            sesion.setAttribute("account", account);
            if (account.getRole() == 1) {
                request.getRequestDispatcher("view/student.jsp").forward(request, response);
            } else if (account.getRole() == 2) {
                request.getRequestDispatcher("viewInstructor/instructor.jsp").forward(request, response);
            }
        } else {
            sesion.setAttribute("error", "Login failed!! Please check your username and password");
            response.sendRedirect("authentication/login.jsp");
        }
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
