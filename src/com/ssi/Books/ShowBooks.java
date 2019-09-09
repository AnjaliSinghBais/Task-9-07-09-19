package com.ssi.Books;

import java.io.*;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowBooks")
public class ShowBooks extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String c = request.getParameter("ch");
		if (c.equals("show")) {
			out.println("x");
		} else {
			out.println("Give the name of file");
			response.setContentType("application/msword");
			FileInputStream fis = new FileInputStream("H:/Files/books2.doc");
			byte b[] = new byte[50];
			while (true) {
				int n = fis.read();
				out.write((char) n);
				if (n == -1) {
					break;
				}
			}

		}

	}
}
