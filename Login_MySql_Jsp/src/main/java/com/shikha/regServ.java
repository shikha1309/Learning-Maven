package com.shikha;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RegForm")
public class regServ extends HttpServlet{  

    protected void doPost(HttpServletRequest myreq , HttpServletResponse myRes)
     throws ServletException, IOException{ 

        PrintWriter out = myRes.getWriter();
        // get value from jsp page using myreq object
        String myName = myreq.getParameter("name");  
         String myEmail = myreq.getParameter("email"); 
          String myPassword = myreq.getParameter("password"); 
           String myGender = myreq.getParameter("gender1");  
           String myCity = myreq.getParameter("city"); 

         
           
    try{ 
         Class.forName( "com.mysql.cj.jdbc.Driver");
         Connection myconn= DriverManager.getConnection
         ("jdbc:mysql://127.0.0.1:3306/core2", "root", "19451945") ;
          
        
          PreparedStatement mystate = myconn.prepareStatement
          ("insert into register values(?,?,?,?,?)") ;
          mystate.setString(1, myName);
          mystate.setString(2, myEmail);
          mystate.setString(3, myPassword);
          mystate.setString(4, myGender);
          mystate.setString(5, myCity);


        int countRow = mystate.executeUpdate(); // return value in Integer

       if(countRow>0)
       { 
          myRes.setContentType("text/html") ;  
         out.print("<h3 style= 'color:green'>User Register Successfully</h3>");
         RequestDispatcher myrd = myreq.getRequestDispatcher("/Registration.jsp");  // again redirect register Page
         myrd.include(myreq, myRes);
       } 
       else
       { 
         myRes.setContentType("text/html") ;  
         out.print("<h3 style= 'color:red'>User Not registered due to some error</h3>");
         RequestDispatcher myrd = myreq.getRequestDispatcher("/index.jsp"); 
         myrd.include(myreq, myRes);
         
       }
  
     
    } catch (Exception e){   
         myRes.setContentType("text/html") ;  
         out.print("<h3 style= 'color:red'>Exception  Occured "  + e.getMessage()+"</h3>");
         RequestDispatcher myrd = myreq.getRequestDispatcher("/index.jsp"); 
         myrd.include(myreq, myRes);
       
        
    }

 }
    
}
