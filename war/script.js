function calendar(){	
	/*var day = ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'];
	var month = ['January','Febuary','March','April','May','June','July','August','September','October','November','December'];
	var d = new Date();
	setText('calendar-day', day[d.getDay()]);
	//setText('calendar-date', d.getDay());
	var yes = d.getDate()-1;
	setText('calendar-month-year', month[d.getMonth()-1]+' '+yes);*/
	getYesterdaysDate();
};
function getYesterdaysDate() {
	var day = ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'];
	var month = ['January','Febuary','March','April','May','June','July','August','September','October','November','December'];
    var date = new Date();
    date.setDate(date.getDate());
    var date_1 = new Date();
    date_1.setDate(date.getDate()-1);
    var date_2 = new Date(); 
    date_2.setDate(date.getDate()-2);
    var date1_1 = new Date();
    date1_1.setDate(date.getDate()+1);
    var date1_2 = new Date(); 
    date1_2.setDate(date.getDate()+2);
    document.getElementById("calendar-day-2").innerHTML = day[date_2.getDay()] + '<br><span style="font-size:15px;">' + month[(date_2.getMonth())] + ' ' + date_2.getDate()+'</span>';
    document.getElementById("calendar-day-1").innerHTML = day[date_1.getDay()] + '<br><span style="font-size:15px;">' + month[(date_1.getMonth())] + ' ' + date_1.getDate()+'</span>';
    document.getElementById("calendar-day").innerHTML = day[date.getDay()] + '<br><span style="font-size:15px;">' + month[(date.getMonth())] + ' ' + date.getDate()+'</span>';
    document.getElementById("calendar-day_2").innerHTML = day[date1_2.getDay()] + '<br><span style="font-size:15px;">' + month[(date1_2.getMonth())] + ' ' + date1_2.getDate()+'</span>';
    document.getElementById("calendar-day_1").innerHTML = day[date1_1.getDay()] + '<br><span style="font-size:15px;">' + month[(date1_1.getMonth())] + ' ' + date1_1.getDate()+'</span>';
}

/*function setText(id, val){

	if(val < 10)
		{
		val = '0'+val;
		}
	document.getElementById(id).innerHTML = val;
	
};*/

window.onload = calendar;

