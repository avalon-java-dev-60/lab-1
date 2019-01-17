/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ulll
 */
public class servlet_lab1 extends HttpServlet {

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
        String text = request.getParameter("someText");
        String answer = null;
        if (text.isEmpty()) {
            request.getRequestDispatcher("redirect.html").forward(request, response);
        } else if (text.matches("[-+]?\\d+")) {
            answer = getnumeric(text);
        } else {

            answer = countWords(text);

        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servlet_lab1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(answer);
            out.println("</body>");
            out.println("</html>");
        }
    }
//private String digits(int ){
//    
//}

    private String countWords(String text) {
        StringTokenizer ins = new StringTokenizer(text);
        int cnt = 0;
        while (ins.hasMoreTokens()) {
            cnt++;
            ins.nextToken();
        }
        String answer ="<h1>Великое изречение " + "\"" +text +"\"" + "содержит" + "\"" + cnt +"\"" + "слов(а)" + "</h1>";
        return answer;
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

    private String getnumeric(String text) {
        int digits = Integer.parseInt(text);
        int c = (int)Math.log10(digits)+1; //узнаем количество цифр в веденном числе
        Random random = new Random();
        int rnd =digits +1+ random.nextInt((int)Math.pow(10, c)-digits);
        text = "Мое число " + "\"" + rnd +"\""+ " больше чем твое " + "\"" + digits +"\"";
        return text;
    }

}
