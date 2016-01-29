package com.Design;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		this.doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
			HttpSession session = req.getSession();
			PersistenceManager p = PMF.get().getPersistenceManager();
			
			
			String uname = req.getParameter("username");
			String passwd = req.getParameter("password");
			Query q = p.newQuery(Users.class);
            q.setFilter("email == '"+uname+"' && password =='"+passwd+"'");
			try{
					//	q.setFilter("email == '"+uname+"' && password == '"+passwd+"'");
			
			List<Users> results = (List<Users>) q.execute();
			  if (!results.isEmpty()) {
			    for (Users user : results) {
			      // Process result user
			    	String email = user.getEmail();
			    	System.out.println("Retrived : "+email);
			    	System.out.println("Uesr Entry : "+uname);
			    	String name = user.getName();
			    	String password = user.getPassword();
			    	System.out.println("Retrived : "+password);
			    	System.out.println("User Entry : "+passwd);
				    	if(email.equals(uname) && password.equals(passwd))
				    	{
				    	session.setAttribute("username", name);
				    	session.setAttribute("emailid", email);
				    	System.out.println("above redirect");
				    	resp.sendRedirect("/listnameretrive");
				    	//req.getRequestDispatcher("/listnameretrive").forward(req, resp);
				    	//System.out.println("below redirect");
				    	}
				    	/*else
				    	{
				    		req.setAttribute("error", "Not a Valid User.");
				    		req.getRequestDispatcher("login.jsp").forward(req, resp);
				    	}*/
			    }
			  } else {
			    // Handle "no results" case
				  req.setAttribute("error", "Not a Valid User.");
		    		req.getRequestDispatcher("/loginfirst").include(req, resp);
				  System.out.println("Please Enter Valid Username and Password..");
			  }
		}catch(Exception e)
		{
			System.out.println(e);
		}finally {
			q.closeAll();
			p.close();	 
			}
			
	}
}
