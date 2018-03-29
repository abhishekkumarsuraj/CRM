package com.suraj.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		//setup connection variable 
		
		String user="root";
		String password="password";
		String url="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver="com.mysql.jdbc.Driver";
	
	   //get Connection to database
		
		try {
			
			PrintWriter out= response.getWriter();
			out.println("Hey i am Going to connect with DATA-BASE : "+url);
			
			Class.forName(driver);
			Connection myCon= DriverManager.getConnection(url,user,password);
			
			out.println("Connected To DATA-BASE with Conection : "+myCon );
			out.println("Successful !!!");
			myCon.close();
			
			
		} catch (Exception e) {
		 e.printStackTrace();
		 throw new ServletException(e);			
		}
		
		
	}

}
