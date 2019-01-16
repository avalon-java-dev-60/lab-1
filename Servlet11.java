/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ArgoNesK
 */
@WebServlet(name = "Servlet11", urlPatterns = {"/Servlet11"})
public class Servlet11 extends HttpServlet {

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
        String user = request.getParameter("userName");

        try (PrintWriter out = response.getWriter()) {
            if (user == null || user.trim().isEmpty()) {
                user = "This field couldn't be empty, please add some symbols ";
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Servlet11</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<form method='post'>");
                out.println("<p> Input Your name: <br>");
                out.println("<input type=\"text\" name=\"userName\" size=\"45\"/>");
                out.println("<input type=\"submit\" value=\"Go!\"/>");
                out.println("</p>");
                out.println("</form>");
                out.println("<h3>" + user + "</h3>");
                out.println("</body>");
                out.println("</html>");

            } else {
                if (user.matches("[-+]?\\d+")) {
                    int user1 = Integer.parseInt(user) + 1;
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet Servlet11</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h4>pararam, " + user1 + "</h4>");
                    out.println("</body>");
                    out.println("</html>");
                    out.close();

                } else {
                    if (!user.matches("[-+]?\\d+")) {
                        int user1 = user.split(" ").length;
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet Servlet11</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h4>Исходная строка: " + user + "</h4>");
                        out.println("<h4>Количество слов в строке: " + user1 + "</h4>");
                        out.println("</body>");
                        out.println("</html>");
                        out.close();

                    }
                }
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
