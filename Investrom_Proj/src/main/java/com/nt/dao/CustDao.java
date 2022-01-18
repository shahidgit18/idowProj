package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.nt.model.Customer;

public class CustDao {

	 public static Connection getConnection(){ 
	Connection con=null;  
    try{  
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");  
    }catch(Exception e){System.out.println(e);
    }  
    return con;  
	 }
	 
	 public static int save(Customer e){  
	        int status=0;  
	        try{  
	            Connection con=CustDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into emp205(empno,ename,email,pwd,phno,country) values (ENO1_SEQ.NEXTVAL,?,?,?,?,?)");  
	            ps.setString(1,e.getFname());  
	            ps.setString(2,e.getEmail());  
	            ps.setString(3,e.getPwd());  
	            ps.setString(4,e.getPhno());  
	            ps.setString(5,e.getCountry());  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
}  

