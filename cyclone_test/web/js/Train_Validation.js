/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
<%--         
    Author     : Sneha Bankar
--%> 
 */

function check_empty()
{
    
    var f = document.train.UId;
    if (f.value == "") {
    alert("Please enter a value for UId");
    f.style.borderColor="#FF0000";
    f.focus();
    return false;
    }            
    return true;    
    

}

function hideA(x)
{
    if (x.checked)
    {             
    document.getElementById("A").style.visibility="hidden";
    document.getElementById("B").style.visibility="visible";    
    }
}

function hideB(x)
{
    if (x.checked)
    {
    
    document.getElementById("B").style.visibility="hidden";
    document.getElementById("A").style.visibility="visible";
    }
}
