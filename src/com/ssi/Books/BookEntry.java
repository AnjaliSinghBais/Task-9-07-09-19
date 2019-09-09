package com.ssi.Books;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookEntry")
public class BookEntry extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Connection con;
	private PreparedStatement ps;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			PrintWriter out = response.getWriter();
			int id = Integer.parseInt(request.getParameter("id"));
			String b_name = request.getParameter("b_name");
			String b_subject = request.getParameter("b_subject");
			int b_price = Integer.parseInt(request.getParameter("b_price"));
			String b_author = request.getParameter("b_author");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "root");
			String sql = "insert into booksentry values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, b_name);
			ps.setString(3, b_subject);
			ps.setInt(4, b_price);
			ps.setString(5, b_author);
			int n = ps.executeUpdate();
			if (n > 0)
				out.println("BOOK ADDED...");
			else
				out.println("NOT BOOK ADDED...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
