package com.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  response.setContentType("text/html");
		  
	        // Get the print writer object to write into the response
	        PrintWriter out = response.getWriter();
	  
	        // Get the session object
	        HttpSession session = request.getSession();
	  
	        // Get User entered details from the request using request parameter.
	        String user = request.getParameter("usName");
	        String password = request.getParameter("usPass");
	  
	        // Validate the password - If password is correct, 
	        // set the user in this session
	        // and redirect to welcome page
	        if (password.equals("admin")) {
	        	
	            session.setAttribute("admin", user);
	            response.sendRedirect("viewStudent.jsp?name=" + user);
	        }
	        // If the password is wrong, display the error message on the login page.
	        else {
	        	
	            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	            out.println("<font color=red>Password is wrong.</font>");
	            rd.include(request, response);
	        }
	        // Close the print writer object.
	        out.close();
	}

}
