package com.Design;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import javax.activation.DataHandler;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

@SuppressWarnings("serial")
public class ContentServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		/*this.doPost(req, resp);*/
		
		 Date hiredate = new Date();
		 String date = hiredate.toString().substring(0, 10) + hiredate.toString().substring(23,28);
		String gmtdate = hiredate.toGMTString();
		HttpSession session = req.getSession();
		String listcontent = req.getParameter("listContent");
		String listname = req.getParameter("Ids");
		String email = (String) session.getAttribute("emailid");
		String name = (String) session.getAttribute("username");
		PersistenceManager p = PMF.get().getPersistenceManager();
		
		Content content = new Content();
		content.setContent(listcontent);
		content.setListname(listname);
		content.setEmail(email);
		content.setDate(date);
		content.setGmtdate(gmtdate);
		p.makePersistent(content);
		resp.getWriter().write(listcontent);
		
		
		/*ReminderMail mail = new ReminderMail();
		mail.content(name, email, listname, listcontent, date);*/
		
		System.out.println("sucess");
		/*Properties props = new Properties();
        Session session1 = Session.getDefaultInstance(props, null);
        
        String msgBody = "Hi Mr. Ramkumar. You Created a ToDo data '"+listcontent+"' on "+date;

      try {
           Message msg = new MimeMessage(session1);
            msg.setFrom(new InternetAddress("no-reply@todo-210.appspotmail.com", "ToDo Admin"));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress(email, "Mr. Ramkumar"));
            msg.setSubject("ToDo List Remainder");
            msg.setText(msgBody);
            Transport.send(msg);
            
        	
    		//resp.getWriter().write(listname);
    	
            
        } catch (AddressException e) {
            // ...
        	System.out.println(e);
        } catch (MessagingException e) {
            // ... 
        	System.out.println(e);
        }*/
		//resp.getWriter().write(listname);
}
	
	/*public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String listcontent = req.getParameter("listContent");
		String listname = req.getParameter("Ids");
		PersistenceManager p = PMF.get().getPersistenceManager();
		
		Content content = new Content();
		content.setContent(listcontent);
		content.setListname("asdf");
		content.setEmail("kmramkumar210@gmail.com");
		p.makePersistent(content);
		resp.getWriter().write(listcontent);
		resp.getWriter().write(listname);
	}*/
	}

