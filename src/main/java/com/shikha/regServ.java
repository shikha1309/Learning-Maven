 package com.shikha;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;


import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/RegForm")
public class regServ  extends HttpServlet 
     
{
@Override
protected void doPost(HttpServletRequest myreq, HttpServletResponse myRes) 
		throws ServletException, IOException 
{
	String myEmail = myreq.getParameter("email"); 
    String myPassword = myreq.getParameter("password");  
    PrintWriter out = myRes.getWriter();
   
   if(myEmail.equals("shikhayadav1309@gmail.com") && myPassword.equals("123456")) 
   { 
     // set name and Email in Session
     myRes.setContentType("text/html");
     HttpSession mySession = myreq.getSession();
    mySession.setAttribute("name_key", "Shikha Yadav");
    mySession.setAttribute("email_key","shikhayadav1309@gmail.com");
     
     out.print("<h3 style='color:red'>Correct email id and password </h3>"); 
     // with myreq object data will send to home page
     
      RequestDispatcher reqdspth = myreq.getRequestDispatcher("/home.jsp");
     reqdspth.forward(myreq, myRes);
}                
   
   else{
    myRes.setContentType("text/html");
    out.print("<h3 style='color:red'>Wrong email id and password </h3>");
     RequestDispatcher reqdspth = myreq.getRequestDispatcher("index.html");
     reqdspth.include(myreq, myRes);

   
}
}
}