<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page import="java.util.*"%>
<%@page import="com.Design.Listname;" %>
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>

  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>ToDo</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script type="text/javascript" src="script.js"></script>
    <script type="text/javascript" src="my_script.js"></script>
    <script type="text/javascript" src="script1.js"></script>
    <link rel="stylesheet" type="type/css" href="style1.css">
      <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>    
  </head>

  <body>
  <%if(request.getSession() == null)
	  {
	  request.getSession().invalidate();
	  response.sendRedirect("login.jsp");
	  }%>
      <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
   <!--    Modal content -->
      <div class="modal-content">
        
        <form action="/list" method="post">
        <div class="modal-body">
		          <div class="form-group">
					  <label for="listName">Enter List Name:</label>
					  <input type="text" class="form-control" name="listName" id="listname" required>
					</div>
        </div>
        <div class="modal-footer">
        <button type="submit" class="btn btn-success" id="listcreate">Create List</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        </form>
      </div>
      
    </div></div>
   
  
  <div class="modal fade" id="myModal1" role="dialog">
    <div class="modal-dialog">
    
   <!--    Modal content -->
      <div class="modal-content">
        
        <form>
        <div class="modal-body">
		          <div class="form-group">
					  <label for="listcontent">Enter List Content:</label>
					  <input type="text" class="form-control" name="listcontent" id="listcontent" required>
					</div>
        </div>
        <div class="modal-footer">
        <button type="button" class="btn btn-success" id="submitcontent" data-dismiss="modal">Submit Content</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        </form>
      </div>
      
    </div></div>
  
  
  	<div id="header" align="right">
  		
  		<div id="usepto"></div>
  		
  		 <div class="usrname">
	  		 <ul>
	  		 	
	  		 	<li>
	  		 	<a href="#"><%=session.getAttribute("username") %></a>
	  		 	
	  		 		<ul>
	  		 			<li><a href="#">Profile</a></li></br>
	  		 			<li><a href="/logout">Signout</a></li>
	  		 		</ul>
	  		 	
	  		 	</li>
	  		 </ul>
  		 </div>
  		 
  	</div>
 			<div id="text">
  		 		<input type="text" value="" name="text" placeholder="Add to do..">
  		 	</div>	 
  	    	
  	    <div class="clder">	
  	    	<div id="image"><div id="click">
    		<div id="leftarrow">
    	
    		<p id="left"> < </p>
    		<!-- <p id="calendar-date"></p> -->
    		<!-- <p id="calendar-month-year"></p> -->
    		
    	</div>
  		<div class="calendar">
    	
    		<p id="calendar-day-2"></p>
    		<!-- <p id="calendar-date"></p> -->
    		<!-- <p id="calendar-month-year"></p> -->
    		
    	</div>
    	<div class="calendar">
    	
    		<p id="calendar-day-1"></p>
    		<!-- <p id="calendar-date"></p> -->
    		<!-- <p id="calendar-month-year"></p> -->
    		
    	</div>
    	<div class="calendar">
    	
    		<p id="calendar-day"></p>
    		<!-- <p id="calendar-date"></p> -->
    		<!-- <p id="calendar-month-year"></p> -->
    		
    	</div>
    	
    	<div class="calendar">
    	
    		<p id="calendar-day_1"></p>
    		<!-- <p id="calendar-date"></p> -->
    		<!-- <p id="calendar-month-year"></p> -->
    		
    	</div>
    	
    	<div class="calendar">
    	
    		<p id="calendar-day_2"></p>
    		<!-- <p id="calendar-date"></p> -->
    		<!-- <p id="calendar-month-year"></p> -->
    		
    	</div>
    	<div id="rightarrow">
    	
    		<p id="right"> > </p>
    		<!-- <p id="calendar-date"></p> -->
    		<!-- <p id="calendar-month-year"></p> -->
    		
    	</div>
    </div></div>
    </div>
    
    
  	     <!-- <div id="nf">	<div id="newfile" class="addlist"><div class="plus">+</div></div><div id="fl" class="addlist" align="center">New<br> List</div></div>  -->
  	    
  	     <div id="nf">	<div id="newfile" data-toggle="modal" data-target="#myModal"><div class="plus">+</div></div><div id="fl" data-toggle="modal" data-target="#myModal" align="center">New<br> List</div></div> 
  	    
  	    <div id="e">
  	    
  	    <%
  	    try{
  	    	
  	    List<Listname> data = (List)request.getAttribute("result_in_list");
  	  if (!data.isEmpty()) {
		    for (Listname ln : data) {
		    String name = ln.getName();
		    String footerId = name+"_footer";
		    String mainContent = name+"_content";
		    	
	     %>
	     <div id="container1"><div class="header" align="center"><%=name%></div><div id="scroll"><div class="<%=mainContent%>"><div class="inside_container"><div id="checkbox"><input type="checkbox" value="" name=""/></div><div id="tt">Spell and Grammar correction in all content</div></div></div></div><div class="footer" align="center"><img src="foot.png" data-toggle="modal" data-target="#myModal1" id="<%=name%>" class="<%=footerId%>"/></div></div>
	     <%
	     }
		  } else {
		    // Handle "no results" case
		  }
  	    }catch(Exception e){
  	    	System.out.println(e);
  	    }
  	    %>
  	    
  	    </div>
  	    
  	    
  	    
  	    
  	    
  	    
  	    
  	    
  	    
   	    <!-- <div id="main"> 
  	    	<div id="container1">
  			<div class="header" align="center">Main</div>
  			<div id="scroll">
  				<div id="Main_conten" class="main">
  					<div class="inside_container">
  						<div id="checkbox">
    						<input type="checkbox" value="" name=""/>
    					</div>
    					<div id="tt">
    					Send home page and product page mockup PSDs to suson
    					</div>
    				</div>
    				
    				<div class="inside_container">
  						<div id="checkbox">
    						<input type="checkbox" value="" name=""/>
    					</div>
    					<div id="tt">
    					RE posting of countries template
    					</div>
    				</div>
    				
    				<div class="inside_container">
  						<div id="checkbox">
    						<input type="checkbox" value="" name=""/>
    					</div>
    					<div id="tt">
						Design "About" section of benefits-added bullets with stock icon
    					</div>
    				</div>
    				
    				<div class="inside_container">
  						<div id="checkbox">
    						<input type="checkbox" value="" name=""/>
    					</div>
    					<div id="tt">
    					Research advertising options
    					</div>
    				</div>
    				</div>
    			</div>	
    				<div class="footer" align="center"><img src="foot.png" id="addContainer2" class="no" width=100%; "></div> 
    				<div class="footer" align="center"><button id="addcon1" widht="200px">Add</button></div>
    		</div>
    	</div> -->
    		
    	<!--	<div id="container1">
    		<div class="header" align="center">Starred</div>
    		<div id="scroll">
    		<div class="inside_container">
    		<div>
  						<div id="checkbox">
    						<input type="checkbox" value="" name=""/>
    					</div>
    					<div id="tt">
    					What are the possible value for backup status?
    					</div>
    				</div>
    		</div>

					<div class="inside_container">
  						<div id="checkbox">
    						<input type="checkbox" value="" name=""/>
    					</div>
    					<div id="tt">
    					Quote foe E-mail champaign+ Postcard design   
    					</div>
    				</div>
    				
    				<div class="inside_container">
  						<div id="checkbox">
    						<input type="checkbox" value="" name=""/>
    					</div>
    					<div id="tt">
    					Design 404 Error Page
    					</div>
    				</div>
    				
    				<div class="inside_container">
  						<div id="checkbox">
    						<input type="checkbox" value="" name=""/>
    					</div>
    					<div id="tt">
    					Check if Smashing conf still having ticket advertising option
    					</div>
    				</div>
    				
    				<div class="inside_container">
  						<div id="checkbox">
    						<input type="checkbox" value="" name=""/>
    					</div>
    					<div id="tt">
    					http://www.blog.weare-2190.com/post/ 3829828282329/a-readable-wikipedia/
    					</div>
    				</div>
    				
    				<div class="inside_container">
  						<div id="checkbox">
    						<input type="checkbox" value="" name=""/>
    					</div>
    					<div id="tt">
    					Enter hours for last week in Toggi
    					</div>
    				</div>
    			</div>
    				<div class="footer" align="center"><img src="foot.png" id="addContainer2" width=100%; onmouseover="this.src('footover.png');" onmouseout="this.src('foot.png');"></div>    			
    		</div>
    		
    		
    		<div id="container1">
    		<div class="header" align="center">If I Have Time</div>
    		<div id="scroll">
    				<div class="inside_container">
  						<div id="checkbox">
    						<input type="checkbox" value="" name=""/>
    					</div>
    					<div id="tt">
    					Spell and Grammar correction in all content
    					</div>
    				</div>
    				
    				<div class="inside_container">
  						<div id="checkbox">
    						<input type="checkbox" value="" name=""/>
    					</div>
    					<div id="tt">
    					Why are not my extensions accessible in Photoshop CC 2014
    					</div>
    				</div>
    				
    				<div class="inside_container">
  						<div id="checkbox">
    						<input type="checkbox" value="" name=""/>
    					</div>
    					<div id="tt">
    					Throw stuff on server / backup
    					</div>
    				</div>
    				
    				<div class="inside_container">
  						<div id="checkbox">
    						<input type="checkbox" value="" name=""/>
    					</div>
    					<div id="tt">
    					Make spreadsheet of harecoded content of translations
    					</div>
    				</div>
    				
    				<div class="inside_container">
  						<div id="checkbox">
    						<input type="checkbox" value="" name=""/>
    					</div>
    					<div id="tt">
    					Thank-you card to send to clients after a project is completed 
    					</div>
    				</div>
    			</div>
    				<div class="footer" align="center"><img src="foot.png" id="addContainer3" width=100%; onmouseover="this.src('footover.png');" onmouseout="this.src('foot.png');"></div>
    		</div> 
    		
  	    
  	    
  	    </div> -->
  	    
  	  
  	    
  	    
  </body>
</html>
