package com.saveDataFun;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.dao.*;
import com.getterSetter.*;
public class NewStudent extends HttpServlet {
	
	public NewStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
    
        String name=			request.getParameter("name");  
        String email=			request.getParameter("email");  
        String country=			request.getParameter("country");  
        String gender=			request.getParameter("gender");  
        String mobileNumber=	request.getParameter("mobileNumber");  
        String studAddress=		request.getParameter("studAddress");  
        String StudCources=		request.getParameter("StudCources");  
        String studSection=		request.getParameter("studSection");  
          
        StudentGS e=new StudentGS();  
        e.setName(name);
        e.setEmail(email); 
        e.setCountry(country); 
        e.setGender(gender);
        e.setMobileNumber(mobileNumber); 
        e.setStudAddress(studAddress); 
        e.setStudCources(StudCources);
        e.setStudSection(studSection); 
        
        int status=Student.save(e);  
        if(status>0){  
            //out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("viewStudent.jsp").include(request, response);  
        }else{  
            //out.println("Sorry! unable to save record");  
            request.getRequestDispatcher("viewStudent.jsp").include(request, response);  
        }  
          
        out.close();  
	}

}
