function myFunction(){
    
    var frstname=document.getElementById("frstname");
    var lstname=document.getElementById("lstname");
    var Address=document.getElementById("address");
    var Email=document.getElementById("Email");
    var phnum=document.getElementById("phnum");
    frstname.innerHTML=document.getElementById("form3Example1").value;
    lstname.innerHTML=document.getElementById("form3Example2").value;
    Address.innerHTML=document.getElementById("form3Example5").value;
    Email.innerHTML=document.getElementById("form3Example3").value;
    phnum.innerHTML=document.getElementById("form3Example4").value;
    
    
    
        $("#myModal").modal("show");

       

    
    return false;
    
       
   
}







