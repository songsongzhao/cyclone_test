/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
<%--         
    Author     : Sneha Bankar
--%>
 * */

function check_empty() {
        var id = document.LogIn.username;
	for (i = 0; i < document.LogIn.elements.length; i++) {
	var f = document.LogIn.elements[i];        
	if (f.value == "" && f.type !="hidden") {
	alert("Please enter a value for " + f.name);	
        f.style.borderColor="#FF0000";
	f.focus();
	return false;
	}        
	}                                        
	return true;        
}
function checkAll() {
 
 check_empty();                 // Checks if all the required fields are entered
 validate_id();                 // Checks if ID value is numeric
 check_entry();
 
}

function check_empty()
{
    for (i = 0; i < document.LogIn.elements.length; i++) {
    var f = document.LogIn.elements[i];
    if (f.value == "") {
    alert("Please enter a value for " + f.name);
    f.style.borderColor="#FF0000";
    f.focus();
    return false;
    }
    }
    return true;    
    

}

function validate_id()
{
    var id = document.LogIn.username;
    var numbers = /^[0-9]+$/;  
    if(id.value.match(numbers))  
    {  
    return true;  
    }  
    else  
    {  
    alert('ID must have numeric characters only');  
    id.focus();  
    return false;  
    }      
}

