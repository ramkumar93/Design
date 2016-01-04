$(document).ready(function(){
	var i=1;
	$('#rightarrow').click( function(){               //Making new list
		
		
			var day = ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'];
			var month = ['January','Febuary','March','April','May','June','July','August','September','October','November','December'];
		    var date = new Date();
		    date.setDate(date.getDate()+i);
		    var date_1 = new Date();
		    date_1.setDate(date.getDate()-1);
		    var date_2 = new Date(); 
		    date_2.setDate(date.getDate()-2);
		    var date1_1 = new Date();
		    date1_1.setDate(date.getDate()+1);
		    var date1_2 = new Date(); 
		    date1_2.setDate(date.getDate()+2);
		    
		    //var iii = "day[date_2.getDay()] + '<br><span style="font-size:15px;">' + month[(date_2.getMonth())] + ' ' + date_2.getDate()+'</span>'";
		   // console.log(day[date_2.getDay()] + '<br><span style="font-size:15px;">' + month[(date_2.getMonth())] + ' ' + date_2.getDate()+'</span>');
		    document.getElementById("calendar-day-2").innerHTML =day[date_2.getDay()] + '<br><span style="font-size:15px;">' + month[(date_2.getMonth())] + ' ' + date_2.getDate()+'</span>';
		    document.getElementById("calendar-day-1").innerHTML = day[date_1.getDay()] + '<br><span style="font-size:15px;">' + month[(date_1.getMonth())] + ' ' + date_1.getDate()+'</span>';
		    document.getElementById("calendar-day").innerHTML = day[date.getDay()] + '<br><span style="font-size:15px;">' + month[(date.getMonth())] + ' ' + date.getDate()+'</span>';
		    document.getElementById("calendar-day_2").innerHTML = day[date1_2.getDay()] + '<br><span style="font-size:15px;">' + month[(date1_2.getMonth())] + ' ' + date1_2.getDate()+'</span>';
		    document.getElementById("calendar-day_1").innerHTML = day[date1_1.getDay()] + '<br><span style="font-size:15px;">' + month[(date1_1.getMonth())] + ' ' + date1_1.getDate()+'</span>';
	i = i + 1;
		
	});

	//var i=1;
	$('#leftarrow').click( function(){               //Making new list
		
		
			var day = ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'];
			var month = ['January','Febuary','March','April','May','June','July','August','September','October','November','December'];
		    var date = new Date();
		    date.setDate(date.getDate()-i);
		    var date_1 = new Date();
		    date_1.setDate(date.getDate()-1);
		    var date_2 = new Date(); 
		    date_2.setDate(date.getDate()-2);
		    var date1_1 = new Date();
		    date1_1.setDate(date.getDate()+1);
		    var date1_2 = new Date(); 
		    date1_2.setDate(date.getDate()+2);
		    
		    //var iii = "day[date_2.getDay()] + '<br><span style="font-size:15px;">' + month[(date_2.getMonth())] + ' ' + date_2.getDate()+'</span>'";
		   // console.log(day[date_2.getDay()] + '<br><span style="font-size:15px;">' + month[(date_2.getMonth())] + ' ' + date_2.getDate()+'</span>');
		    document.getElementById("calendar-day-2").innerHTML =day[date_2.getDay()] + '<br><span style="font-size:15px;">' + month[(date_2.getMonth())] + ' ' + date_2.getDate()+'</span>';
		    document.getElementById("calendar-day-1").innerHTML = day[date_1.getDay()] + '<br><span style="font-size:15px;">' + month[(date_1.getMonth())] + ' ' + date_1.getDate()+'</span>';
		    document.getElementById("calendar-day").innerHTML = day[date.getDay()] + '<br><span style="font-size:15px;">' + month[(date.getMonth())] + ' ' + date.getDate()+'</span>';
		    document.getElementById("calendar-day_2").innerHTML = day[date1_2.getDay()] + '<br><span style="font-size:15px;">' + month[(date1_2.getMonth())] + ' ' + date1_2.getDate()+'</span>';
		    document.getElementById("calendar-day_1").innerHTML = day[date1_1.getDay()] + '<br><span style="font-size:15px;">' + month[(date1_1.getMonth())] + ' ' + date1_1.getDate()+'</span>';
	i = i + 1;
		
	});
	//window.onload = calendar;
	
	/*$('body').on('click','img', function(){			//inserting details
		var details= prompt("Enter the Details");
		var ids = $(this).attr('id');
		//alert(ids);
		var cls = $(this).attr('class');
		//alert(cls);
		var con = "."+ids+"_content";
		//alert(con);
			$(con).append($('<div class="inside_container"><div id="checkbox"><input type="checkbox" value="" name=""/></div><div id="tt">'+details+'</div></div>')); 
			
		});*/
	
	

	
});