package org.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Sample extends HttpServlet{
	
	int a = 100;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String firstName = req.getParameter("firstName");
		String dept = req.getParameter("dept");
		String salary = req.getParameter("salary");
		String year = req.getParameter("doj");
		
		int salaryInt = Integer.parseInt(salary);
		int yearInt = Integer.parseInt(year);
		
		if(yearInt< 2000) {
			//resp.sendRedirect("sq?k="+year); - Session Management using URL Rewriting
//			HttpSession session = req.getSession();//Session Management using HttpSession
//			session.setAttribute("k", year);
//			resp.sendRedirect("sq");
			
			Cookie cookie = new Cookie("k", year);
			resp.addCookie(cookie);
			
			Cookie cookie2 = new Cookie("m", salary);
			resp.addCookie(cookie2);
			System.out.println("QA");
			System.out.println("Dev");

			

			
			
			resp.sendRedirect("sq");
		}
		
		
	}
	
	
}
