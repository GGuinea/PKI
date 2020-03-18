package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
    Collection<String> tab = Collections.synchronizedCollection(new Vector<String>());

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
        Cookie licznik = null;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            System.out.println("not null cookies");
            for (int i = 0; i < cookies.length; i++) {
                System.out.println(cookies[i].getName());
                if (cookies[i].getName()
                              .equals("licznik")) {
                    System.out.println("There is our licnzik");
                    licznik = cookies[i];
                    break;
                }
            }
        }

        if (licznik == null) {
            System.out.println("Null cookie");
            licznik = new Cookie("licznik", "0");
        } else {
            System.out.println("not null - getting value");
            int v = Integer.parseInt(licznik.getValue());
            v++;
            System.out.println("printing:" + v);
            licznik.setValue(v + "");
        }

        licznik.setMaxAge(-1);
        response.addCookie(licznik);

        System.out.println(licznik.getValue());

        /*
         * if (action != null) { if (action.equals("wyloguj")) { Boolean wartosc = false;
         * System.out.println("wylogujINN"); session.setAttribute("zalogowany", wartosc); } } Boolean loggedIn =
         * (Boolean) session.getAttribute("zalogowany"); if (loggedIn == null) { loggedIn = false;
         * System.out.println("nulled"); } if (loggedIn == true) { writer.println("<html>");
         * writer.println("<h1>ZALOGOWANY</h1>"); writer.println("<form method=\"get\">");
         * writer.println("<input type=\"hidden\" name=\"akcja\" value=\"wyloguj\" \\>");
         * writer.println("<input type=\"submit\" value=\"Wyloguj\" \\>"); writer.println("</form>");
         * writer.println("</html>"); } else { String user; String pass; user = request.getParameter("user"); pass =
         * request.getParameter("pass"); System.out.println("loged1"); if (user != null && pass != null) { if
         * (user.equals("radek") && pass.equals("haslo")) { loggedIn = true; session.setAttribute("zalogowany",
         * loggedIn); System.out.println("loged2"); response.setHeader("Refresh", "1"); } else {
         * System.out.println("not loged"); writer.println("<html>"); writer.println("<form method=\"get\">");
         * writer.println("<input type=\"text\" name=\"user\" \\>");
         * writer.println("<input type=\"password\" name=\"pass\" \\>");
         * writer.println("<input type=\"submit\" value=\"zaloguj\" \\>"); writer.println("</form>");
         * writer.println("</html>"); } } else { System.out.println("not loged"); writer.println("<html>");
         * writer.println("<form method=\"get\">"); writer.println("<input type=\"text\" name=\"user\" \\>");
         * writer.println("<input type=\"password\" name=\"pass\" \\>");
         * writer.println("<input type=\"submit\" value=\"zaloguj\" \\>"); writer.println("</form>");
         * writer.println("</html>"); } }
         */
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String dateLunch = dateFormat.format(date);
        String name;
        writer.println("<html>");
        writer.println("<META HTTP-EQUIV=Refresh CONTENT='10'>");
        writer.println("<body>");
        writer.println(dateLunch);
        writer.println("<form action='ReceiverServlet' method=\"post\">");
        writer.println("<input type=\"text\" name=\"user\" \\>");
        writer.println("<input type=\"submit\" value=\"zaloguj\" \\>"); 
        writer.println("</form>");
        name = request.getParameter("user");
        if(name != null) {
            tab.add(name);
        }
        Iterator<String> it = tab.iterator();
        while(it.hasNext()) {
            writer.println(it.next() + "<br/>");
        }
        writer.println("</body>");
        writer.println("</html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
