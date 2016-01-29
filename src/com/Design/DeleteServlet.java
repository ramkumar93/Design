package com.Design;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String ss = req.getParameter("Id");
		long Id = Long.parseLong(ss);
		PersistenceManager p = PMF.get().getPersistenceManager();
		System.out.println(Id);
		Schedule s = p.getObjectById(Schedule.class, Id);
		try{
			System.out.println("inside try");
			p.deletePersistent(s);
			
			resp.getWriter().write("deleted");
		}catch(Exception e){
			
		}
	}
}
