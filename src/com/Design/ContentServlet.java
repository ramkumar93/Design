package com.Design;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.mail.Session;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class ContentServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		/*this.doPost(req, resp);*/
		HttpSession session = req.getSession();
		String listcontent = req.getParameter("listContent");
		String listname = req.getParameter("Ids");
		String email = (String) session.getAttribute("emailid");
		PersistenceManager p = PMF.get().getPersistenceManager();
		
		Content content = new Content();
		content.setContent(listcontent);
		content.setListname(listname);
		content.setEmail(email);
		p.makePersistent(content);
		resp.getWriter().write(listcontent);
		//resp.getWriter().write(listname);
	}
	
	/*public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String listcontent = req.getParameter("listContent");
		String listname = req.getParameter("Ids");
		PersistenceManager p = PMF.get().getPersistenceManager();
		
		Content content = new Content();
		content.setContent(listcontent);
		content.setListname("asdf");
		content.setEmail("kmramkumar210@gmail.com");
		p.makePersistent(content);
		resp.getWriter().write(listcontent);
		resp.getWriter().write(listname);
	}*/
}
