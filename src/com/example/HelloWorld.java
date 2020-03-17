package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private int a;
    private String msg;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public void init(ServletConfig config) throws ServletException {
        msg = config.getInitParameter("my");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        /*
         * writer.println("result of getMethod: " + request.getMethod()); writer.println("result of getRemoteAddr: " +
         * request.getRemoteAddr()); writer.println("result of getServerName: " + request.getServerName());
         * writer.println("result of getHeader - accept" + request.getHeader("Accept"));
         * writer.println("result of getHeader - Accpet-language" + request.getHeader("Accept-Language"));
         * writer.println("result of getHeader - Accpet-Encoding" + request.getHeader("Accept-Encoding"));
         * writer.println("result of getHeader - User-agent" + request.getHeader("User-Agent")); a++; writer.println(a);
         * writer.println(msg);
         */
        // ServletConfig cfg = getServletConfig();
        // ServletContext ctx = getServletContext();
        // writer.println(cfg.getInitParameter("myParam") + ctx.getInitParameter("myParam"));
        HttpSession session = request.getSession(true);
        String action = request.getParameter("akcja");
        if (action != null) {
            if (action.equals("wyloguj")) {
                Boolean wartosc = false;
                System.out.println("wylogujINN");
                session.setAttribute("zalogowany", wartosc);
            }
        }
        Boolean loggedIn = (Boolean) session.getAttribute("zalogowany");
        if (loggedIn == null) {
            loggedIn = false;
            System.out.println("nulled");
        }
        if (loggedIn == true) {
            writer.println("<html>");
            writer.println("<h1>ZALOGOWANY</h1>");
            writer.println("<form method=\"get\">");
            writer.println("<input type=\"hidden\" name=\"akcja\" value=\"wyloguj\" \\>");
            writer.println("<input type=\"submit\" value=\"Wyloguj\" \\>");
            writer.println("</form>");
            writer.println("</html>");
        } else {
            String user;
            String pass;
            user = request.getParameter("user");
            pass = request.getParameter("pass");
            System.out.println("loged1");
            if (user != null && pass != null) {
                if (user.equals("radek") && pass.equals("haslo")) {
                    loggedIn = true;
                    session.setAttribute("zalogowany", loggedIn);
                    System.out.println("loged2");
                    response.setHeader("Refresh", "1");
                } else {
                    System.out.println("not loged");
                    writer.println("<html>");
                    writer.println("<form method=\"get\">");
                    writer.println("<input type=\"text\" name=\"user\" \\>");
                    writer.println("<input type=\"password\" name=\"pass\" \\>");
                    writer.println("<input type=\"submit\" value=\"zaloguj\" \\>");
                    writer.println("</form>");
                    writer.println("</html>");
                }
            } else {
                System.out.println("not loged");
                writer.println("<html>");
                writer.println("<form method=\"get\">");
                writer.println("<input type=\"text\" name=\"user\" \\>");
                writer.println("<input type=\"password\" name=\"pass\" \\>");
                writer.println("<input type=\"submit\" value=\"zaloguj\" \\>");
                writer.println("</form>");
                writer.println("</html>");
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
