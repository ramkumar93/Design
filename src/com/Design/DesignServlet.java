package com.Design;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.*;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.oauth.OAuthService;
import com.google.appengine.api.oauth.OAuthServiceFactory;
import com.google.appengine.api.oauth.OAuthServiceFailureException;
import com.google.appengine.api.users.User;

@SuppressWarnings("serial")
public class DesignServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		resp.getWriter().println("connected aaaaaa");
		try{
		OAuthService oauth = OAuthServiceFactory.getOAuthService();
		String scope = "https://www.googleapis.com/auth/userinfo.email";
		Set<String> allowedClients = new HashSet<>();
		allowedClients.add("1083639089486-6hp7iokf2tp6n52m5dg571gh85ihnkqf.apps.googleusercontent.com"); // list your client ids here
		resp.getWriter().println("connected asasa");
		try {
			resp.getWriter().println(scope);
		  User user = oauth.getCurrentUser(scope);
		  resp.getWriter().println("User : "+user.toString());
		  String tokenAudience = oauth.getClientId(scope);
		  resp.getWriter().println("Nick Name is : "+user.getEmail());
		  resp.getWriter().println("Token : "+tokenAudience.toString());
		  
		  if (!allowedClients.contains(tokenAudience)) {
		    throw new OAuthRequestException("audience of token '" + tokenAudience
		        + "' is not in allowed list " + allowedClients);
		  }
		  resp.getWriter().println("Nick Name is : "+user.getEmail());
		} catch (OAuthRequestException ex) {
			resp.getWriter().println("error in if");
		  // handle auth error
		  // ...
		} catch (OAuthServiceFailureException ex) {
			resp.getWriter().println("error in oauth service");
		  // optionally, handle an oauth service failure
		  // ...
		}
		
		resp.getWriter().println("connected lllll");
		}catch(Exception e)
		{
			resp.getWriter().println(e);
		}
	}
}
