package com.shikha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/logForm")

public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String myEmail = req.getParameter("email");
		String myPassword = req.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection myconn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/core2", "root", "19451945");

			PreparedStatement mystate = myconn.prepareStatement("select * from register where  email=? and password=?");
			mystate.setString(1, myEmail);
			mystate.setString(2, myPassword);
             // result set store all the data of one row
			ResultSet rs = mystate.executeQuery();

			if (rs.next()) {
				HttpSession session  = req.getSession();
				session.setAttribute("session_name",rs.getString("name"));
				RequestDispatcher myrd = req.getRequestDispatcher("/myprofile.jsp");
				myrd.include(req, resp);

			} else {
				resp.setContentType("text/html");
				out.print("<h3 style= 'color:red'>Email id and password didnt matched</h3>");
				RequestDispatcher myrd = req.getRequestDispatcher("/login.jsp");
				myrd.include(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
