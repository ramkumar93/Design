package com.Design;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

@SuppressWarnings("serial")
public class SaveUpdate extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
System.out.println("in saveupdate servlet");
		
		Date hiredate = new Date();
		 //String date = hiredate.toString().substring(0, 10) + hiredate.toString().substring(23,28);
		String gmtdate = hiredate.toGMTString();
		HttpSession session = req.getSession();
		
		String id = req.getParameter("Id");
		String listname = req.getParameter("listName");
		String email = req.getParameter("Email");
		String date = req.getParameter("Date");
		String details = req.getParameter("Details");
		String time = req.getParameter("Time");
		PersistenceManager p = PMF.get().getPersistenceManager();
		Query q1 = p.newQuery(Schedule.class);
		q1.setFilter("ID == "+id);
			//	q.setFilter("email == '"+uname+"' && password == '"+passwd+"'");

		List<Schedule> schedule = (List<Schedule>) q1.execute();
		
		 for (Schedule sc : schedule) {
			 sc.setListName(listname);
			 sc.setEmail(email);
			 sc.setDate(date);
			 sc.setDateGMT(gmtdate);
			 sc.setDetails(details);
			 sc.setTime(time);
			 
			 p.makePersistent(sc);
		 }
		 
		 String bgdate = req.getParameter("bgdate");
		 Query q = p.newQuery(Schedule.class);
			q.setFilter("email == '"+session.getAttribute("emailid")+"' &&date == '"+bgdate+"'");
			q.setOrdering("listName asc");
			//System.out.println(session.getAttribute("emailid"));
			List<Schedule> sched = (List<Schedule>) q.execute();
			/*String json = new Gson().toJson(contents);*/
			ObjectMapper n=new ObjectMapper();
			String json=n.writeValueAsString(sched);
			System.out.println(json);
			  resp.setContentType("application/json");
			  resp.setCharacterEncoding("UTF-8");
			  resp.getWriter().write(json.toString());
		// resp.getWriter().write(details);
	}
}
