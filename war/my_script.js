$(document).ready(function(){
	
	$('#create').click(function(){
		var name = $("#name").val();
		var email = $("#email").val();
		var password = $("#pwd").val();
		var repassword = $("#repwd").val();
		var emailFormat = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		
		if(!isNaN(name))
			{
			$("#name").css("border-color","red");
			$("#name").val("");
			$("#name").attr("placeholder", "Enter Valid Name").placeholder();
			$("#name").focus();
			return false;
			}
		if(emailFormat.test(email) == false)
			{
			$("#email").css("border-color","red");
			$("#email").val("");
			$("#email").attr("placeholder", "Enter Valid Email Id").placeholder();
			$("#email").focus();
			return false;
			}
		if(password != repassword )
			{
			$("#pwd").css("border-color","red");
			$("#repwd").css("border-color","red");
			$("#pwd").val("");
			$("#repwd").val("");
			$("#pwd").attr("placeholder", "Password does not match").placeholder();
			$("#repwd").attr("placeholder", "Password does not match").placeholder();
			$("#pwd").focus();
			return false;
			}
	});
	
	$('#signinval').click(function(){
		
		var signinemail = $("#signinemail").val();
		var signinpassword = $("#signinpwd").val();
		
		var emailFormat = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		
		
		if(emailFormat.test(signinemail) == false)
			{
			$("#signinemail").css("border-color","red");
			$("#signinemail").val("");
			$("#signinemail").attr("placeholder", "Enter Valid Email Id").placeholder();
			$("#signinemail").focus();
			return false;
			}
		if(signinpassword == "" )
			{
			$("#signinpwd").css("border-color","red");
			$("#signinpwd").val("");
			$("#signinpwd").attr("placeholder", "Enter Vaild Password").placeholder();
			$("#signinpwd").focus();
			return false;
			}
	});
	
$('#listcreate').click(function(){
		
		var listname = $("#listname").val();
		
		if(!isNaN(listname))
			{
			$("#listname").css("border-color","red");
			$("#listname").val("");
			$("#listname").attr("placeholder", "Enter Vaild List Name").placeholder();
			$("#listname").focus();
			return false;
			}
	});
	
	//alert($('#Main_content').attr('id'));
	/*$("#nf").click(function(){               //Making new list
		var name = prompt("Enter List Name");
		if(name != "")
			{
		$.ajax({
		    url: '/list',
		    data: {
		        postVariableName: name
		    },
		    type: 'POST'
		});​ 
		
			}else{
				alert("Enter Valid Name");
				continue;
			}*/
		
		
		/*var name = document.getElementById("listName").value;
		//var name = prompt("Enter List Name ");
		alert("Value :"+name)
		var footerId = name+"_footer";
		var mainContent = name+"_content";
		//window.alert(footerId);
		//$("ol").append("<li>adwd</li>");
		$('#e').append($('<div id="container1"><div class="header" align="center">'+name+'</div><div id="scroll"><div class="'+mainContent+'"><div class="inside_container"><div id="checkbox"><input type="checkbox" value="" name=""/></div><div id="tt">Spell and Grammar correction in all content</div></div></div></div><div class="footer" align="center"><img src="foot.png" id="'+name+'" class="'+footerId+'"/></div></div></div>'));*/ 
		
	/*	});
	
$("#addContainer2").click(function(){
		
		//$("ol").append("<li>adwd</li>");
		$('#Main_content').append($('<div class="inside_container"><div id="checkbox"><input type="checkbox" value="" name=""/></div><div id="tt">Send home page and product page mockup PSDs to suson</div></div>')); 
		
	});*/

/*$("img").click(function(){*/
	
	
	 //alret($("Main_content").attr('class'));
	$("").click(function(){			//inserting details
		//var details= prompt("Enter the Details");
		/*$('#listcontent').val()="";*/
		var ids = $(this).attr('id');
		alert(ids);
		var cls = $(this).attr('class');
		alert(cls);
		var con = "."+ids+"_content";
		alert(con);
		$("#submitcontent").click(function(){
			var listcontent = $('#listcontent').val();
			alert(listcontent);
			$.ajax({
				//alert("after ajax");
				/*type : "POST",*/
				url : "content",
				data : { listContent : listcontent, Ids : ids },
				
				success : function(result){
				$(con).append($('<div class="inside_container"><div id="checkbox"><input type="checkbox" value="" name=""/></div><div id="tt">'+result+'</div></div>')); 
				}
			}); 
		});	
		
	});
	
/*});*/

	
	/*$('body').on('click','.Main_footer', function(){
	//var x = $("#main").createElement("$scroll");
		//$("ol").append("<li>adwd</li>");
		$('.Main_content').append($('<div class="inside_container"><div id="checkbox"><input type="checkbox" value="" name=""/></div><div id="tt">Send home page and product page mockup PSDs to suson</div></div>')); 
		
	});*/
	
	
	
	/*	$("#addContainer3").click(function(){
		
		//$("ol").append("<li>adwd</li>");
		$('#scroll').append($('<div class="inside_container"><div id="checkbox"><input type="checkbox" value="" name=""/></div><div id="tt">Send home page and product page mockup PSDs to suson</div></div>')); 
		
	});*/
	
	
$("li").hover(function(){
	
	$(this).find('ul>li').stop().fadeToggle(100);
});
	
});