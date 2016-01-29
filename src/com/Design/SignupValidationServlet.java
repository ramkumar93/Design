package com.Design;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SignupValidationServlet extends HttpServlet{
	/*public void doGet(HttpServletRequest req,HttpServletResponse resp) 
			throws IOException,ServletException{
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String repwd = req.getParameter("repwd");
		PersistenceManager p = PMF.get().getPersistenceManager();
		Query q = p.newQuery(Users.class);
        q.setFilter("email == '"+email+"'");
			//	q.setFilter("email == '"+uname+"' && password == '"+passwd+"'");
		
		List<Users> exists = (List<Users>) q.execute();
		  if (exists.isEmpty()) {
			  try{
				  System.out.println("inside try");
				  
			  req.getRequestDispatcher("/signup").forward(req, resp);
			  resp.getWriter().write("sucess");
			  }catch(Exception e){
				  System.out.println(e);
			  }
		  }else{
			  System.out.println("inside else");
			  System.out.println(email);
			  resp.getWriter().write(email);
		  }
		
			}*/
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String repwd = req.getParameter("repwd");
		PersistenceManager p = PMF.get().getPersistenceManager();
		Query q = p.newQuery(Users.class);
        q.setFilter("email == '"+email+"'");
			//	q.setFilter("email == '"+uname+"' && password == '"+passwd+"'");
		
		List<Users> exists = (List<Users>) q.execute();
		  if (exists.isEmpty()) {
			  try{
				  System.out.println("inside try");
				  
			  /*req.getRequestDispatcher("/signup").forward(req, resp);*/
			  resp.getWriter().write("sucess");
			  }catch(Exception e){
				  System.out.println(e);
			  }
		  }else{
			  System.out.println("inside else");
			  System.out.println(email);
			  resp.getWriter().write(email);
		  }
		
	}
}
