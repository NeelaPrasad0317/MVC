
function validation(frm){
	alert("js");
	let ename=frm.ename.value;
	let	job=frm.job.value;
	let sal=frm.sal.value;
	let flag=true;
	
	
	if(ename==""){
		flag=false;
		document.getElementById("enameid").innerHTML="employee name is required(js)";
	}else if(ename.length<3 || ename.length>10){
		flag=false;
		document.getElementById("enameid").innerHTML="employee name length must inbetween 3-10 characters(js)";
	}
	if(job==""){
		flag=false;
		document.getElementById("jobid").innerHTML="employee job is required(js)";
	}else if(job.length<3 || job.length>9){
		flag=false;
		document.getElementById("jobid").innerHTML="employee job length must inbetween 3-9 characters(js)";
	}

	if(sal==""){
		flag=false;
		document.getElementById("salid").innerHTML="employee sal is required(js)";
	}else if(isNaN(sal)){
		flag=false;
		document.getElementById("salid").innerHTML="employee sal must numeric (js)";
	}	
	else if(sal<10000 || sal>=100000){
		flag=false;
		document.getElementById("salid").innerHTML="employee sal must be in between 10000-100000 (js)";
	}
	
	frm.valid.value="yes";
	return flag;
}




