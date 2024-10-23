package org.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Promotion extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//String parameter = req.getParameter("k");
//		HttpSession session = req.getSession();
//		Object attribute = session.getAttribute("k");
		String value = "";
		Cookie[] cookies = req.getCookies();
		for(Cookie c1:cookies) {
			if(c1.getName().equals("m")) {
				 value = c1.getValue();
			}
		}
		
		
	
		
		PrintWriter writer = resp.getWriter();
		writer.println("Promoted"+ value);
	}

}
