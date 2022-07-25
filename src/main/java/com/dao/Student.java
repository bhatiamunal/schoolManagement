package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.getterSetter.*;
public class Student {
	  public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	        	
	            Class.forName("com.mysql.cj.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?useSSL=false","root","1234");  
	            
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	    public static int save(StudentGS e){  
	        int status=0;  
	        try{  
	            Connection con=Student.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	         "insert into studentDetails(name,email,country,gender,mobileNumber,studAddress,StudCources,studSection) values (?,?,?,?,?,?,?,?)");  
	       
	            ps.setString(8,e.getStudSection());  
	            ps.setString(7,e.getStudCources());  
	            ps.setString(6,e.getStudAddress());  
	            ps.setString(5,e.getMobileNumber());  
	            ps.setString(4,e.getGender());  
	            ps.setString(3,e.getCountry());  
	            ps.setString(2,e.getEmail());  
	            ps.setString(1,e.getName());  
	              
	            status=ps.executeUpdate();  
	             
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int update(StudentGS e){  
	        int status=0;  
	        try{  
	            Connection con=Student.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update studentDetails set name=?,email=?,country=?,gender=?,mobileNumber=?,studAddress=?,StudCources=?,studSection=? where id=?");  
	            ps.setString(1,e.getStudSection());  
	            ps.setString(2,e.getStudCources());  
	            ps.setString(3,e.getStudAddress());  
	            ps.setString(4,e.getMobileNumber());  
	            ps.setString(5,e.getGender());  
	            ps.setString(6,e.getCountry());  
	            ps.setString(7,e.getEmail());  
	            ps.setString(8,e.getName());   
	            ps.setInt(9,e.getId());   
	            status=ps.executeUpdate();  
	          
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=Student.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from studentDetails where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static StudentGS getStudentById(int id){  
	    	StudentGS e=new StudentGS();  
	          
	        try{  
	            Connection con=Student.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from studentDetails where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	            	
	               
	                e.setName(rs.getString(1));  
	                e.setEmail(rs.getString(2));  
	                e.setCountry(rs.getString(3));  
	                e.setGender(rs.getString(4));  
	                e.setMobileNumber(rs.getString(5));  
	                e.setStudAddress(rs.getString(6));  
	                e.setStudCources(rs.getString(7));  
	                e.setStudSection(rs.getString(8));  
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }  
	    public static List<StudentGS> getAllStudent(){  
	        List<StudentGS> list=new ArrayList<StudentGS>();  
	          
	        try{  
	            Connection con=Student.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from studentDetails");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	StudentGS e=new StudentGS();  
	            	 e.setId(Integer.parseInt(rs.getString(1)));
	            	  e.setName(rs.getString(2));  
	                  e.setEmail(rs.getString(3));  
	                  e.setCountry(rs.getString(4));  
	                  e.setGender(rs.getString(5));  
	                  e.setMobileNumber(rs.getString(6));  
	                  e.setStudAddress(rs.getString(7));  
	                  e.setStudCources(rs.getString(8));  
	                  e.setStudSection(rs.getString(9));   
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
}
