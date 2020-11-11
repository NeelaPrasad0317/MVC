

function confirmation(no){
//		alert(no);
		if (confirm('Do you want delete emp::'+no+' ?')){
			alert("Deleted");
			return true;
		}else{
			alert("Cancelled");
			event.stopPropagation(); 
			event.preventDefault();};
	}

	function doPrint(){
		frames.focus();
		frames.print();
	}