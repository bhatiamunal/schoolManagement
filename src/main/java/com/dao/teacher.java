package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.getterSetter.TeacherGS;

public class teacher {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
        	
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?useSSL=false","root","1234");  
            
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(TeacherGS e){  
        int status=0;  
        try{  
            Connection con=Student.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
         "insert into teacherDetails(name,email,className,subjectName) values (?,?,?,?)");  
       
              
            ps.setString(4,e.getSubject());  
            ps.setString(3,e.getSchoolClass());  
            ps.setString(2,e.getEmail());  
            ps.setString(1,e.getName());  
              
            status=ps.executeUpdate();  
             
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(TeacherGS e){  
        int status=0;  
        try{  
            Connection con=Student.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update teacherDetails set name=?,email=?,className=?,subjectName=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getEmail());  
            ps.setString(3,e.getSchoolClass());  
            ps.setString(4,e.getSubject());  
            ps.setInt(5,e.getId());   
            status=ps.executeUpdate();  
          
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=Student.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from teacherDetails where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static TeacherGS getTeacherById(int id){  
    	TeacherGS e=new TeacherGS();  
          
        try{  
            Connection con=Student.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from teacherDetails where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
            	
               
                e.setName(rs.getString(1));  
                e.setEmail(rs.getString(2));  
                e.setSchoolClass(rs.getString(3));  
                e.setSubject(rs.getString(4));  
                  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<TeacherGS> getAllTeacher(){  
        List<TeacherGS> list=new ArrayList<TeacherGS>();  
          
        try{  
            Connection con=Student.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from teacherDetails");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	TeacherGS e=new TeacherGS();  
            	 e.setId(Integer.parseInt(rs.getString(5)));
            	  e.setName(rs.getString(1));  
                  e.setEmail(rs.getString(2));  
                  e.setSchoolClass(rs.getString(2));  
                  e.setSubject(rs.getString(4));
                  System.out.println(rs.getString(1));
                list.add(e);  
            }  
            System.out.println(list);
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}
