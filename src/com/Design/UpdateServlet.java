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
public class UpdateServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		System.out.println("in update servlet");
		
		Date hiredate = new Date();
		 //String date = hiredate.toString().substring(0, 10) + hiredate.toString().substring(23,28);
		String gmtdate = hiredate.toGMTString();
		HttpSession session = req.getSession();
		
		String id = req.getParameter("Id");
		PersistenceManager p = PMF.get().getPersistenceManager();
		Query q1 = p.newQuery(Schedule.class);
		q1.setFilter("ID == "+id);
			//	q.setFilter("email == '"+uname+"' && password == '"+passwd+"'");

		List<Schedule> schedule = (List<Schedule>) q1.execute();
		ObjectMapper n=new ObjectMapper();
		String jsondata=n.writeValueAsString(schedule);
		System.out.println(jsondata);
		  resp.setContentType("application/json");
		  resp.setCharacterEncoding("UTF-8");
		  resp.getWriter().write(jsondata.toString());
		
		/*resp.getWriter().write(details);*/
	}
}
