/**
 * 
 */

function validatForm(){
	var form=document.getElementById("form1");
	var x=form["year"].value;
	if(x==""){
		alert("year filed cant be empty");
		return false;
		
		var y=document.getElementById("season").value;
		alert(y);
		if(y=="UNKNOWN"||y==""){
			alert("select season");
			return false;
		}
	}
}