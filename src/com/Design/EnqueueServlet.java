package com.Design;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



import java.util.TimeZone;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

@SuppressWarnings("serial")
public class EnqueueServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		this.doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	//	Logger log = Logger.getLogger(Schedule.class.getName());
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

		TimeZone timeZone=TimeZone.getTimeZone("IST");
		sdf.setTimeZone(timeZone);
		String t = "";
		Date date1 = null;
		
			date1 = new Date();
		
		String formattedDate=sdf.format(date1);
		int hour = Integer.parseInt(formattedDate.substring(0, 2));
		int minute = Integer.parseInt(formattedDate.substring(3, 5))+05;
		//int minute = 10;
		if( minute<10 || minute>=60 ){
		switch(minute)
		{
		case 60:
			hour +=1;
			minute = 0;
			break;
		case 61:
			hour +=1;
			minute = 1;
			break;
		case 62:
			hour +=1;
			minute = 2;
			break;
		case 63:
			hour +=1;
			minute = 3;
			break;
		case 64:
			hour +=1;
			minute = 4;
			break;
		/*case 65:
			minute = 5;
			break;*/
		}
		if(minute<10)
		{
			String m = "0"+String.valueOf(minute);
			System.out.println(m);
			t = String.valueOf(hour)+":"+String.valueOf(m);
			System.out.println("XYZ ==============>"+t);
		}
		}
		else{
		t = String.valueOf(hour)+":"+String.valueOf(minute);
		System.out.println("XYZ ==============>"+t);
		
		}
		
		/*Date d = new Date();
		int h = Integer.parseInt(d.toString().substring(11, 13));
		int min = (Integer.parseInt(d.toString().substring(14, 16)))+5;
		System.out.println("Time"+h+":"+min);
		log.info("Current time is = "+h+":"+min);
		String time = String.valueOf(h)+":"+String.valueOf(min);
		System.out.println(" old time :"+time);*/
        // Add the task to the default queue.
        Queue queue = QueueFactory.getDefaultQueue();
        queue.add(TaskOptions.Builder.withUrl("/workerqueue").param("ComparingTime", t));
		
	}
}
