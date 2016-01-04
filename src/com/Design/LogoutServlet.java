package com.Design;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		this.doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		try {
			resp.setHeader("Cache-Control","no-cache");
			resp.setHeader("Cache-Control","no-store");
			resp.setHeader("Pragma","no-cache");
			resp.setDateHeader ("Expires", 0);
			req.getSession().invalidate();
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			//req.getRequestDispatcher("login.html").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
