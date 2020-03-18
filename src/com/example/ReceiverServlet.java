package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReceiverServlet
 */
@WebServlet("/ReceiverServlet")
public class ReceiverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Collection<String> tab = Collections.synchronizedCollection(new Vector<String>());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    PrintWriter writer = response.getWriter();
	    String name;
	    writer.println("<html>");
        writer.println("<META HTTP-EQUIV=Refresh CONTENT='10'>");
        writer.println("<body>");
        writer.println("<form action='HelloWorld' method=\"post\">");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
