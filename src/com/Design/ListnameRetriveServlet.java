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
public class ListnameRetriveServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws IOException,ServletException{
			    this.doPost(request,response);
			}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		System.out.println("in other servlet");
		HttpSession session = req.getSession();
		PersistenceManager p = PMF.get().getPersistenceManager();
		
		Query q = p.newQuery(Listname.class);
		q.setFilter("email == '"+session.getAttribute("emailid")+"'");
		q.setOrdering("name asc");
		
		List<Listname> results = (List<Listname>) q.execute();
		try {
			req.setAttribute("result_in_list", results);
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
