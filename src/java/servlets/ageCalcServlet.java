/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 846582
 */
public class ageCalcServlet extends HttpServlet {

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
        //this will display the requested JSP as a view
        getServletContext().getRequestDispatcher("/WEB-INF/ageCalc.jsp").forward(request, response);
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
        //capture the params from the post request (the form)
        String userAgeString = request.getParameter("age");
        if (userAgeString == null || userAgeString.equals("")) {
            request.setAttribute("message", "You must give your current age");
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalc.jsp").forward(request, response);
            return;
        }

        try {
            int userAge = Integer.parseInt(userAgeString);
            int userNextAge = userAge + 1;

            request.setAttribute("message", userNextAge);

            //validation: if the params dont exist or if are empty show the form again
            //display the ageCalc JSP
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalc.jsp").forward(request, response);
            return;
        } catch (NumberFormatException e) {
            request.setAttribute("message", "You must enter a number");
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalc.jsp").forward(request, response);
            return;
        }

    }

}
