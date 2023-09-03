package com.shikha;

import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
// this logout is coming from href of jsp pages
@WebServlet("/logout")
public class logout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest myreq, HttpServletResponse myResp) 
			throws ServletException, IOException {
		// after calling logout it will delete session object
		HttpSession mySession = myreq.getSession();
		mySession.invalidate();
		// redirect the page in index
		RequestDispatcher reqdspt = myreq.getRequestDispatcher("/login.jsp");
		reqdspt.forward(myreq, myResp);

	}
}
