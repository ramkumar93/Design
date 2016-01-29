package com.Design;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

@SuppressWarnings("serial")
public class DateViewServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		HttpSession session = req.getSession();
		PersistenceManager p = PMF.get().getPersistenceManager();
		String date = req.getParameter("Value");
		Query q1 = p.newQuery(Schedule.class);
		q1.setFilter("email == '"+session.getAttribute("emailid")+"' &&date == '"+date+"'");
		q1.setOrdering("listName asc");
		//System.out.println(session.getAttribute("emailid"));
		List<Schedule> schedule = (List<Schedule>) q1.execute();
		/*String json = new Gson().toJson(contents);*/
		ObjectMapper n=new ObjectMapper();
		String json=n.writeValueAsString(schedule);
		System.out.println(json);
		  resp.setContentType("application/json");
		  resp.setCharacterEncoding("UTF-8");
		  resp.getWriter().write(json.toString());
		/*resp.getWriter().write(contents.toString());*/
		/*if (!contents.isEmpty()) {
		    for (Content cont : contents) {
			    String listname = cont.getListname();
			    String listcontent = cont.getContent(); 
			    String listdate = cont.getDate();
			    resp.getWriter().write(listname);
			    resp.getWriter().write(listcontent);
		    }
		}*/
	}
}