<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="loginstyle.css">

<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="my_script.js"></script>
<title>Login</title>


 <script src="https://apis.google.com/js/client.js?onload=checkAuth"></script>
    <script type="text/javascript">
    function oAuth(){
    	//alert("Function is called");
    	var config = {
    		'client_id' : '1083639089486-6hp7iokf2tp6n52m5dg571gh85ihnkqf',
    		'scope' : 'https://www.googleapis.com/auth/userinfo.email'
    	};
    	gapi.auth.authorize(config, function(resp){
    		
    		console.log('login complete');
    		console.log(resp.name);
    		console.log(gapi.auth.getToken());
    		window.location.replace("http://1-dot-todo-210.appspot.com/welcome.jsp");
    		//window.location.replace("http://1-dot-todo-210.appspot.com");
    		//console.log(gapi.auth.getCurrentUser());
    		//var x = gapi.auth.getToken().toString;
    		document.getElementById("demo").innerHTML = "Connected"
    	});
    }
    </script>


</head>
<body>

<div id="content">
    <div class="oauth">
    <p class="log">Log in quick with your social login</p>
    	<!-- <form action="/design" method="post">
    	
    	<input type="submit" value="Signin with Google">
    	</form> -->
	     <img class="img" src="google.png" onclick="oAuth()"> 
	   <!--  <p id="demo">Click Google to Sign In</p> -->
	    <br>
	    <img class="img" src="facebook.png" onclick="login()">
	    <!-- <div id="status"></div> -->
	 </div>
    <div class="oauth">
    <p><%request.getAttribute("error"); %></p>
    <form action="/login" method="post">
	    <input type="text" class="input" name="username" id="signinemail" placeholder="Enter Email Id" required><br>
	    <input type="password" class="input" name="password" id="signinpwd" placeholder="Enter Password" required><br>
	    <button type="submit" class="button" id="signinval"><strong>Signin</strong></button> 
	 </form>
	    
	    <button class="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal"><strong>Signup</strong></button>
     
    </div>
    
    
    
    <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <!-- <button type="button" class="close" data-dismiss="modal">&times;</button> -->
          <h4 class="modal-title">Enter Details</h4>
        </div>
        <form action="/signup" method="post">
        <div class="modal-body">
		          <div class="form-group">
					  <label for="usr">Name:</label>
					  <input type="text" class="form-control" name="name" id="name" required>
					</div>
					<div class="form-group">
					  <label for="email">Email Id.:</label>
					  <input type="email" class="form-control" name="email" id="email" required>
					</div>
					<div class="form-group">
					  <label for="pwd">Password:</label>
					  <input type="password" class="form-control" name="pwd" id="pwd" required>
					</div>
					<div class="form-group">
					  <label for="repwd">Retype-Password:</label>
					  <input type="password" class="form-control" name="repwd" id="repwd" required>
					</div>
        </div>
        <div class="modal-footer">
        <button type="submit" class="btn btn-success" id="create">Create Account</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        </form>
      </div>
      
    </div>
    
    
</div>

</div>





<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '138734773161868',
      xfbml      : true,
      version    : 'v2.5'
    });
    
     FB.getLoginStatus(function(response){
    	
    	if(response.status === "connected")
    	  {
    		FB.api('/me','GET',{fields: 'first_name,last_name,name,id'},function(response){
    			document.getElementById("status").innerHTML = "Signin with "+ response.name +" ID :"+ response.id;
    		});
    	  
    		  
    	  }
    else if(response.status === "not_authorized"){
    	  document.getElementById("status").innerHTML = "Not Connected"
    }
    else{
    	  document.getElementById("status").innerHTML = "Not Connected to facebook Click Sign In"
    		  
    }
    	
    }); 
    
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
  
  
  function login(){
	  FB.login(function (response){
		  if(response.status === "connected")
			  {
			  FB.api('/me','GET',{fields: 'first_name,last_name,name,id'},function(response){
				  document.getElementById("status").innerHTML = "Signin with "+ response.name +" ID :"+ response.id;
	    		});
				  window.location.replace("http://1-dot-todo-210.appspot.com/welcome.jsp");
			  }
		  else if(response.status === "not_authorized"){
			  document.getElementById("status").innerHTML = "Not Connected"
		  }
		  else{
			  document.getElementById("status").innerHTML = "Not Connected to facebook Click Sign In"
			  
		  }
		 
	  });
	  
  }
</script>

</body>
</html>