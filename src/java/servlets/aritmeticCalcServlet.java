/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 846582
 */
public class aritmeticCalcServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet aritmeticCalcServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet aritmeticCalcServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalc.jsp").forward(request, response);
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
        String firstString = request.getParameter("first");
               String secondString = request.getParameter("second");
        if (firstString == null || firstString.equals("") || secondString == null || secondString.equals("")) {
            request.setAttribute("message", "Invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalc.jsp").forward(request, response);
            return;
        }

        try {
            int firstInt = Integer.parseInt(firstString);
            int secondInt = Integer.parseInt(secondString);
            
            String calcButt = request.getParameter("calcButton");
            int result;
            switch(calcButt){
                case "+": result = (firstInt + secondInt); break;
                case "-": result = (firstInt - secondInt); break;
                case "*": result = (firstInt * secondInt); break;
                case "%": result = (firstInt % secondInt); break;
                default: System.out.println("error");
            }
            request.setAttribute("message", secondString);

            //validation: if the params dont exist or if are empty show the form again
            //display the ageCalc JSP
            getServletContext().getRequestDispatcher("aritmetic").forward(request, response);
            return;
        } catch (NumberFormatException e) {
            request.setAttribute("message", "You must enter a number");
            getServletContext().getRequestDispatcher("aritmetic").forward(request, response);
            return;
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
