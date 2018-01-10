package com.luv2code.testdb;

import oracle.jdbc.driver.OracleDriver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String jdbcUrl = "jdbc:oracle:thin:@xdvl:1521:xdvl";
		String user = "train_sorin";
		String password = "sorin";
		
		try {
			response.getWriter().println("\nConnecting to "+jdbcUrl);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);			
			response.getWriter().println("\nConnected!");
			
		}catch(Exception e){
			response.getWriter().println("\n"+e.getMessage());
			e.printStackTrace();
		}
	}

}
