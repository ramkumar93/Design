package com.Design;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;


@SuppressWarnings("serial")
public class CronServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		this.doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		Date hiredate = new Date();
		String TodayDate = hiredate.toString().substring(0, 10) + hiredate.toString().substring(23,28);
		String gmtdate = hiredate.toGMTString();
		
		PersistenceManager p = PMF.get().getPersistenceManager();
		
		Query q = p.newQuery(Schedule.class);
		q.setFilter("date == '"+TodayDate+"'");
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
		    mail.cron(name, email, date, details, time);

		}
		
	}else{
		System.out.println("no jobs are there");
	}
}
}
