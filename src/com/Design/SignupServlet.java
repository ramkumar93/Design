package com.Design;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Design.PMF;

@SuppressWarnings("serial")
public class SignupServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		/*resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");*/
		
		String usrname = req.getParameter("name");
		String usremail = req.getParameter("email");
		String usrpwd = req.getParameter("pwd");
		String usrrepwd = req.getParameter("repwd");
		
		PersistenceManager p = PMF.get().getPersistenceManager();
		/*resp.getWriter().println(usrname);
		resp.getWriter().println(usremail);
		resp.getWriter().println(usrpwd);
		resp.getWriter().println(usrrepwd);*/
		
		Users user = new Users();
		user.setName(usrname);
		user.setEmail(usremail);
		user.setPassword(usrpwd);
		
		p.makePersistent(user);
		
		try {
			System.out.println("1");
			HttpSession session = req.getSession();
			System.out.println("2");
			session.setAttribute("username", usrname);
			session.setAttribute("emailid", usremail);
			System.out.println("3");
			//resp.sendRedirect("welcome.jsp");
			System.out.println("4");
			req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
