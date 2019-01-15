package simpleServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ella
 */
@WebServlet(name = "FirstServlet", urlPatterns = {"/response"})
public class FirstServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String name = "someText";
        String text = request.getParameter(name);
        String pattern = "([-+]?\\d+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(text);
        String content = "";
        if (text == null || text.trim().isEmpty()) {
            request.getRequestDispatcher("again.html").forward(request, response);
        } else if (m.find()) {
            content = getRandomDigit(m);
        } else {
            content = getCountWords(text);
        }
        print(response, content);
    }

    private String getRandomDigit(Matcher m) {
        int digit = Integer.parseInt(m.group(0));
        Random rnd = new Random();
        int maxDigit = Math.abs(digit + rnd.nextInt());
        int randomDigit = rnd.nextInt((maxDigit + 1) - digit) + digit;
        String content = "<h1>В строке содержится число: " + digit + "</h1>";
        return content += "<h2>Случайное число, больше Вашего: " + randomDigit + "</h2>";
    }

    private String getCountWords(String text) {
        StringTokenizer st = new StringTokenizer(text, ",.;!? \n\t");
        int count = 0;
        while (st.hasMoreTokens()) {
            ++count;
            st.nextToken();
        }
        String content = "<h1>Вы ввели: " + text + "</h1>";
        return content += "<h2>Количество слов: " + count + "</h2>";
    }

    private void print(HttpServletResponse response, Object content) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Response from server</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Лабораторная работа №1</h1>"
                    + "<p>Введите произвольный текст</p>"
                    + "<form method='GET' action='response'>"
                    + "<input type='text' name='someText'  size='80'>"
                    + "<button type='submit' style='margin-left: 10px'>Отправить</button>"
                    + "</form>");
            out.println(content);
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
