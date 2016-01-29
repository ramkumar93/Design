package com.Design;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.Key;
import javax.mail.Session;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

@SuppressWarnings("serial")
public class ScheduleServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		System.out.println("in schedule servlet");
		
		Date hiredate = new Date();
		 //String date = hiredate.toString().substring(0, 10) + hiredate.toString().substring(23,28);
		String gmtdate = hiredate.toGMTString();
		HttpSession session = req.getSession();
		
		PersistenceManager p = PMF.get().getPersistenceManager();
		//Key key = stringToKey(req.getParameter("Key"));
		String name = (String) session.getAttribute("username");
		String listname = req.getParameter("listName");
		String email = req.getParameter("Email");
		String date = req.getParameter("Date");
		String details = req.getParameter("Details");
		String time = req.getParameter("Time");
		
		Schedule schedule = new Schedule();
		
		schedule.setName(name);
		schedule.setListName(listname);
		schedule.setEmail(email);
		schedule.setDate(date);
		schedule.setDateGMT(gmtdate);
		schedule.setDetails(details);
		schedule.setTime(time);
		
		p.makePersistent(schedule);
		p.close();
		ReminderMail mail = new ReminderMail();
		mail.content(name, email, listname, details, date, time);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Schedule.class);
		q.setFilter("dateGMT == '"+gmtdate+"' && details == '"+details+"' && email == '"+email+"'");
			//	q.setFilter("email == '"+uname+"' && password == '"+passwd+"'");

		List<Schedule> sch = (List<Schedule>) q.execute();
		ObjectMapper n=new ObjectMapper();
		String datas=n.writeValueAsString(sch);
		System.out.println(datas);
		  resp.setContentType("application/json");
		  resp.setCharacterEncoding("UTF-8");
		  resp.getWriter().write(datas.toString());
		
		//resp.getWriter().write(details);
	}

	
}
