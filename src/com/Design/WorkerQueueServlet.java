package com.Design;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class WorkerQueueServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		Date hiredate = new Date();
		String TodayDate = hiredate.toString().substring(0, 10) + hiredate.toString().substring(23,28);
		//String gmtdate = hiredate.toGMTString();
		String comparingTime = req.getParameter("ComparingTime");
		PersistenceManager p = PMF.get().getPersistenceManager();
		Query q = p.newQuery(Schedule.class);
		q.setFilter("time == '"+comparingTime+"' && date == '"+TodayDate+"'");
		q.setOrdering("name asc");
		System.out.println("before Liresult list");
		List<Schedule> results = (List<Schedule>) q.execute();
		
		if (!results.isEmpty()) {
		    for (Schedule ln : results) {
		    String name = ln.getName();
		    String email = ln.getEmail();
		    String date = ln.getDate();
		    String details = ln.getDetails();
		    String time = ln.getTime();
		    
		    ReminderMail mail = new ReminderMail();
		    mail.queue(name, email, date, details, time);

		}
		
	}else{
		System.out.println("no jobs are there");
	}
		    
		    
		
	}
}
