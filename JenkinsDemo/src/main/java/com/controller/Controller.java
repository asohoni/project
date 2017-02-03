package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,IOException{
	doPost(request,response);
	}
	
	
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,IOException{
	
		String name = request.getParameter("name");
		
		String rev = new StringBuilder(name).reverse().toString();
		//rev = "REV"+rev;
		rev=rev+" and the length of your name is "+ rev.length();
//		request.setAttribute("rev", rev);
		
		//here it should catch the hard coded check.
		String Password = "MyHardcodedPassword";
		
		//check for SQL Injection Possibility.
		String SQL = "SELECT * FROM strings WHERE string_name = " + rev; 
		
		//Check hard coded Sensitive Information.
		String varSSN = "111-22-3333";
		
		request.setAttribute( "rev", rev + " " + Password + SQL + varSSN );
		
		getServletContext().getRequestDispatcher("/rev.jsp").forward(request, response);
	}

}
