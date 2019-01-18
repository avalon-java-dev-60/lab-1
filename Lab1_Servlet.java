/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mi
 */
public class Lab1_Servlet extends HttpServlet {

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
            throws ServletException, IOException
    {
        String strIn=request.getParameter("text");
        strIn=strIn.trim();
        String strOut;
        int intIn;
        int intOut;
        Random rand = new Random();
        if (strIn.isEmpty())
        {
            response.sendRedirect("index.html");
        }
        else
        {
            try {intIn=Integer.parseInt(strIn);}
            catch (NumberFormatException e) {intIn=-1;}
            if(intIn!=-1)
            {
                intOut=intIn+rand.nextInt(3000);
                strOut="Old number: "+intIn+"<br>New number: "+intOut;
            }
            else
            {
                String[]tmp=strIn.split("\\s+");
                strOut="String: "+strIn+"<br>Amount of words: "+tmp.length;
            }
            try (PrintWriter out = response.getWriter())
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                //out.println("<meta charset=\"windows-1251\">");
                out.println("<h1>Servlet: Lab1_Servlet at " + request.getContextPath() + "</h1><br><br>");           
                out.println("</head>");
                out.println("<body>");
                out.println("<h2> " + strOut + "</h2>");
                out.println("</body>");
                out.println("</html>");
                out.close();
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
