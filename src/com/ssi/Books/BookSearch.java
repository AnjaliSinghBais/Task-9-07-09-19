package com.ssi.Books;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookSearch.java")
public class BookSearch extends HttpServlet {

	private Connection con;
	private PreparedStatement ps;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			String c = request.getParameter("ch");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "root");
			String sql = "select * from booksentry where b_subject=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, c);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				out.println("BOOKID=" + rs.getString(1));
				out.println("BOOKNAME=" + rs.getString(2));
				out.println("BOOKSUBJECT=" + rs.getString(3));
				out.println("BOOKPRICE=" + rs.getString(4));
				out.println("BOOKAUTHOR=" + rs.getString(5));
				out.println("-----------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
