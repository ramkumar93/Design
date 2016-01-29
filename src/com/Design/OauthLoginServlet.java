package com.Design;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class OauthLoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		HttpSession session = req.getSession();
		session.setAttribute("username", name);
		session.setAttribute("emailid", email);
		System.out.println(email);
		System.out.println(name);
		resp.getWriter().write("sucess");
	}
}
