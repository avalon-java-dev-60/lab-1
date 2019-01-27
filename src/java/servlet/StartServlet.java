package servlet;

import com.sun.el.lang.ELArithmetic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.runtime.JSType;

@WebServlet(name = "StartPage", urlPatterns = {"/StartPage"})
public class StartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("views/StartPage.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void processResponse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher;

        String text = request.getParameter("userText");

        if (text.isEmpty() == false) {
            if (text.matches("-?[\\d]+") == true) {
                request.setAttribute("text", text);

                int number = Integer.parseInt(text);
                int max = Integer.MAX_VALUE;
                Random rand = new Random();
                number = rand.nextInt(max - number + 1);
                request.setAttribute("number", number);
                requestDispatcher = request.getRequestDispatcher("views/NumberPage.jsp");
                requestDispatcher.forward(request, response);
            } else {
                int count = 0;
                String[] arr = text.split(" ");
                count = arr.length;
                request.setAttribute("count", count);
                requestDispatcher = request.getRequestDispatcher("views/WordsCounterPage.jsp");
                requestDispatcher.forward(request, response);
            }
        } else {
            requestDispatcher = request.getRequestDispatcher("views/ErrorPage.jsp");
            requestDispatcher.forward(request, response);
        }

    }

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

        processResponse(request, response);
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
