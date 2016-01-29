package com.Design;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class ListnameRetriveServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp) 
			throws IOException,ServletException{
			   this.doPost(req,resp);

	}
			
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		System.out.println("in other servlet");
		
		/*if(req.getSession() == null)
		  {
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			HttpSession session = req.getSession();
			session.setAttribute("username", name);
			session.setAttribute("emailid", email);
		  }*/
		
		Date hiredate = new Date();
		 String date = hiredate.toString().substring(0, 10) + hiredate.toString().substring(23,28);
		HttpSession session = req.getSession();
		PersistenceManager p = PMF.get().getPersistenceManager();
		
		Query q = p.newQuery(Listname.class);
		q.setFilter("email == '"+session.getAttribute("emailid")+"'");
		q.setOrdering("name asc");
		
		List<Listname> results = (List<Listname>) q.execute();
		
		Query q1 = p.newQuery(Schedule.class);
		q1.setFilter("email == '"+session.getAttribute("emailid")+"' && date == '"+date+"'");
		q1.setOrdering("listName asc");
		
		List<Schedule> schedule = (List<Schedule>) q1.execute();
		try {
			req.setAttribute("result_in_list", results);
			req.setAttribute("contents_in_list", schedule);
			req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			  q.closeAll();
			 p.close();
			}

	}
}
