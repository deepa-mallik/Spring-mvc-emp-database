package com.javatpoint;

import java.util.*;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpDB 
{
	@RequestMapping("/empdb")
	public ModelAndView Calc(HttpServletRequest request, HttpServletResponse res) {
		String a =  request.getParameter("t1");
		String b = request.getParameter("t2");
		String c = request.getParameter("t3");
		String button = request.getParameter("b1");
		int n1 = Integer.parseInt(a);
		
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
		
		
		if(button.equals("insert")) {
			PreparedStatement ps=con.prepareStatement("insert into users(id,name,address) values (?,?,?)");
			ps.setInt(1,n1);
			ps.setString(2,b);
			ps.setString(3,c);
			ps.execute();
			
			return new ModelAndView("resultpage","message","row inserted");
		}
		
		if(button.equals("update")) {
			PreparedStatement ps=con.prepareStatement("update users set name=?, address=? where id=?");
			ps.setString(1,b);
			ps.setString(2,c);
			ps.setInt(3,n1);
			ps.execute();
			
			return new ModelAndView("resultpage","message","row updated");
		}
		
		if(button.equals("delete")) {
			PreparedStatement ps=con.prepareStatement("delete from users where id = ?");
			ps.setInt(1,n1);
			ps.execute();
			return new ModelAndView("resultpage","message","row deleted");
		}
		
		if(button.equals("select")) {
			PreparedStatement ps=con.prepareStatement("select * from users");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" " + rs.getString(2)+ " " + rs.getString(3));
			}

		}

		
	
		}
		catch(Exception e){
			System.out.println(e);
		}
		return null;
		
	}
}