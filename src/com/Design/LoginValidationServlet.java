package com.Design;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.Key;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService.KeyRangeState;

@SuppressWarnings("serial")
public class LoginValidationServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
			
PersistenceManager p = PMF.get().getPersistenceManager();
			
/*String sss = "5183097813336064";
Query q1 = p.newQuery(Schedule.class);
q1.setFilter("ID == "+sss);
	//	q.setFilter("email == '"+uname+"' && password == '"+passwd+"'");

List<Schedule> sche = (List<Schedule>) q1.execute();
  
    for (Schedule sc : sche) {
      // Process result user    	
    	System.out.println("foe each schedule");
	    	//long key = sc.getID().getId();
	    	//String test=String.valueOf(key);
	    	
	    	if(test.equals(sss))
		    	{
	    		//System.out.println("inside if");
		    		sc.setDetails("Balallllllllllllll");
		    		System.out.println(sc.getName());
		    		System.out.println(sc.getDate());
		    		System.out.println(sc.getEmail());
		    		System.out.println(sc.getTime());
		    		p.makePersistent(sc);
		    		
		    	}
	 	    }*/
/*String newDetails = "aaaaaaaaaa";
Query q1 = p.newQuery(Schedule.class);
List<Schedule> sche = (List<Schedule>) q1.execute();
for (Schedule sc : sche) {
try {
    Schedule e = p.getObjectById(Schedule.class, sc.getID());
    System.out.println(e);
    if (titleChangeIsAuthorized(e, newDetails)) {
        e.setDetails(newDetails);
    } else {
        //throw new UnauthorizedTitleChangeException(e, newDetails);
    	System.out.println("some problem");
    }
} finally {
  //  p.close();
}    
}*/


    
			String uname = req.getParameter("email");
			String passwd = req.getParameter("pwd");
			Query q = p.newQuery(Users.class);
            q.setFilter("email == '"+uname+"' && password =='"+passwd+"'");
			try{
					//	q.setFilter("email == '"+uname+"' && password == '"+passwd+"'");
			
			List<Users> results = (List<Users>) q.execute();
			  if (!results.isEmpty()) {
			    for (Users user : results) {
			      // Process result user    	
				    	resp.getWriter().write("sucess");
				 	    }
			  } else {
			    // Handle "no results" case
			  resp.getWriter().write("no");
			  }
			
			 
				 
			  
		}catch(Exception e)
		{
			
		}
	}

	private boolean titleChangeIsAuthorized(Schedule e, String newDetails) {
		// TODO Auto-generated method stub
		return false;
	}
}
