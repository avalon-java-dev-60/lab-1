/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class lab1Servlet extends HttpServlet {

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
        String user = request.getParameter("userText");
        int res;
       
        String[] arrs;
        if (user == null || user.trim().isEmpty()) {
            res = 0;
        }else{
            arrs=user.trim().split("[\\p{Punct}\\s]+");
            res=arrs.length;
        }
        
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lab1</title>");
            out.println("</head>");
            out.println("<body>");
            if (res==0) {
                out.println("<form name=\"test\" method=\"get\" action=\"lab1Servlet\">");
                out.println("<p>Retype text or integer :<br>");
                out.println("<input type=\"text\" size=\"40\" name=\"userText\">");
                out.println("</p>");
                out.println("<p><input type=\"submit\" value=\"Send\">");
                out.println("</p>");
                out.println("</form>");
            }else{
                if (user.trim().matches("\\d+")){
                    int newin=parseInt(user)+10;
                    out.println("<h1>New integer " + newin + "</h1>");
                }else{
                    out.println("<h1>Source line is: " + user + "</h1>");
                    out.println("<h1>Number of words per line: " + res + "</h1>");
                }
            }

            
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
