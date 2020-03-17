package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("result of getMethod: " + request.getMethod());
        writer.println("result of getRemoteAddr: " + request.getRemoteAddr());
        writer.println("result of getServerName: " + request.getServerName());
        writer.println("result of getHeader - accept" + request.getHeader("Accept"));
        writer.println("result of getHeader - Accpet-language" + request.getHeader("Accept-Language"));
        writer.println("result of getHeader - Accpet-Encoding" + request.getHeader("Accept-Encoding"));
        writer.println("result of getHeader - User-agent" + request.getHeader("User-Agent"));
        if(!(request.getParameter("int1") == null)) {
            int a = Integer.parseInt(request.getParameter("int2"));
            int b = Integer.parseInt(request.getParameter("int1"));
            writer.println(b + "+" + a + "=" + (a+b));
        }
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        
    }

}
