package com.saveDataFun;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.dao.teacher;
import com.getterSetter.TeacherGS;

public class NewTeacher extends HttpServlet {
	public NewTeacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
    
        String name=			request.getParameter("name");  
        String email=			request.getParameter("email");  
        String subject=			request.getParameter("subject");  
        String schoolClass=			request.getParameter("schoolClass");  
       
          
        TeacherGS e=new TeacherGS();  
        e.setName(name);
        e.setEmail(email); 
        e.setSubject(subject); 
        e.setSchoolClass(schoolClass);
       
        
        int status=teacher.save(e);  
        if(status>0){  
            //out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("viewTeacher.jsp").include(request, response);  
        }else{  
            //out.println("Sorry! unable to save record");  
            request.getRequestDispatcher("viewTeacher.jsp").include(request, response);  
        }  
          
        out.close();  
	}

}
