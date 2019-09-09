package com.ssi.Books;

import java.io.*;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AllBooks")
public class AllBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		File f = new File("H:\\Files");
		if (f.exists()) {
			out.println("<html>");
			out.println("<body>");
			for (String s : f.list()) {
				out.println("<a href='ShowBooks?ch=show" + s + "'>" + s + "</a></br>");
			}
			out.println("</body>");
			out.println("</html>");
		} else
			System.out.println("file not found");
	}
}
