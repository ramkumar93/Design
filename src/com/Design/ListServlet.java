package com.Design;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Design.Listname;

@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		HttpSession session = req.getSession();
	String listName = req.getParameter("listName");
	String Email = (String) session.getAttribute("emailid");
	System.out.println(Email);
	PersistenceManager p = PMF.get().getPersistenceManager();
	
	Listname lst = new Listname();
	lst.setName(listName);
	lst.setEmail(Email);
	p.makePersistent(lst);
	
	
	/*Query q = p.newQuery(Listname.class);
	
	List<Listname> results = (List<Listname>) q.execute();*/
	try {
		/*req.setAttribute("result_in_list", results);*/
		req.getRequestDispatcher("/listname/retrive").forward(req, resp);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		 /* q.closeAll();
*/		}
	}
}
