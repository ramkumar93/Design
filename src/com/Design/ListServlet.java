package com.Design;

import java.io.IOException;
import java.util.Date;
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
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		this.doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		 Date hiredate = new Date();
		 String date = hiredate.toString().substring(0, 10) + hiredate.toString().substring(23,28);
		String gmtdate = hiredate.toGMTString();
		
		
		HttpSession session = req.getSession();
	String listName = req.getParameter("listName");
	String Email = (String) session.getAttribute("emailid");
	String Name = (String) session.getAttribute("username");
	System.out.println(Email);
	PersistenceManager p = PMF.get().getPersistenceManager();
	
	Query q = p.newQuery(Listname.class);
	q.setFilter("email == '"+session.getAttribute("emailid")+"' && name == '"+listName+"'");
	//q.setOrdering("name asc");
	List<Listname> data = (List<Listname>) q.execute();
	if(data.isEmpty())
	{
	Listname lst = new Listname();
	lst.setName(listName);
	lst.setEmail(Email);
	p.makePersistent(lst);
	
	
	ReminderMail mail = new ReminderMail();
	mail.list(Name, Email, listName, date);
	
	
	}
	else{
		System.out.println(listName+" already exist");
	}
	/*Query q = p.newQuery(Listname.class);
	
	List<Listname> results = (List<Listname>) q.execute();*/
	try {
		/*req.setAttribute("result_in_list", results);*/
		req.getRequestDispatcher("/listnameretrive").forward(req, resp);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		 /* q.closeAll();
*/		}
	}
}
