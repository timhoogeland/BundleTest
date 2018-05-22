//Service worker initialisation
if (navigator.serviceWorker.controller) {
    console.log('[PWA Builder] active service worker found, no need to register')
  } else {
    navigator.serviceWorker.register('pwabuilder-sw.js', {
      scope: './'
    }).then(function(reg) {
      console.log('Service worker has been registered for scope:'+ reg.scope);
    });
  }


//Login
function setCookie(name,value,days) {
    var expires = "";
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days*24*60*60*1000));
        expires = "; expires=" + date.toUTCString();
    }
    document.cookie = name + "=" + (value || "")  + expires + "; path=/";
}
function getCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}
function eraseCookie(name) {   
    document.cookie = name+'=; Max-Age=-99999999;path=/;';  
}




	function logOut(){
		eraseCookie("username");
		eraseCookie("password");
    eraseCookie("loanofficerid");
    eraseCookie("loanid");

	}

	

function validateLogin(){
var logRequest;
            try{
          	  console.log("he");
              var pass = document.getElementById('pass').value;
              var username = document.getElementById('username').value;

          	  logRequest = new XMLHttpRequest();
          	  logRequest.open('GET', "/bundlePWABackend/restservices/login", true);
              logRequest.setRequestHeader("username",username);
              logRequest.setRequestHeader("password",pass);
          	  logRequest.send(null);
              logRequest.onload = function () {
    if (logRequest.readyState === logRequest.DONE) {
        if (logRequest.status === 200) {
          var response = JSON.parse(logRequest.response);
            console.log(logRequest);

            console.log(response);

            console.log(response[0]['userid']);
            setCookie('username',username,1);
            setCookie('password',pass,1);
            setCookie('loanofficerid',response[0]['userid'])
         window.location.replace("index.jsp");
        }
    }
}


  	}
    catch(exception)
        	   {
        	    alert("Request failed");
        	   }}

function checkCookie(){
  console.log(getCookie('loanofficerid'));
}




 function getLoans() {
var hr = new XMLHttpRequest();
hr.open("GET", "/bundlePWABackend/restservices/loan", true);

hr.onreadystatechange = function() {
    if (hr.readyState == 4 && hr.status == 200) {
        var data = JSON.parse(hr.responseText);
        console.log(data);
        var table = document.getElementById('loanstable');
        data.forEach(function(object) {
          var tr = document.createElement('tr');
          tr.innerHTML = '<td id="loanid" data-label="ID">' + object.loanId + '</td>' +
          '<td id ="amount" data-label="Amount">' + object.amount + '</td>' +
          '<td id = "duration" data-label="Duration">' + object.duration +" months" + '</td>' +
          '<td id = "closingdate" data-label="End Date">' + object.closingdate + '</td>' +
          '<td id="status" data-label="Status">' + object.status + '</td>' +
          '<td id = "loantype" data-label="Loan Type">' + object.loantype + '</td>' +
          "<td>  <button onclick='toViewLoan("+object.loanId+");'>View</button> </td>" +
              "<td>  <button onclick='toEditLoan("+object.loanId+");'>Edit</button> </td>";
          table.appendChild(tr);
});
    }
}
hr.send(null);
}
 function getContracts() {
	 var hr = new XMLHttpRequest();
	 hr.open("GET", "/bundlePWABackend/restservices/loan", true);

	 hr.onreadystatechange = function() {
	     if (hr.readyState == 4 && hr.status == 200) {
	         var data = JSON.parse(hr.responseText);
	         console.log(data);
	         var table = document.getElementById('contractstable');
	         data.forEach(function(object) {
	           var tr = document.createElement('tr');
	           tr.innerHTML = '<td id="loanid" data-label="ID">' + object.loanId + '</td>' +
	           '<td id ="amount" data-label="Amount">' + object.amount + '</td>' +
	           '<td id = "duration" data-label="Duration">' + object.duration +" months" + '</td>' +
	           '<td id = "closingdate" data-label="End Date">' + object.closingdate + '</td>' +
	           '<td id="status" data-label="Status">' + object.status + '</td>' +
	           '<td id = "loantype" data-label="Loan Type">' + object.loantype + '</td>' +
	           "<td>  <button onclick='toViewContract("+object.loanId+");'>View</button> </td>" +
	               "<td>  <button onclick='toEditContract("+object.loanId+");'>Edit</button> </td>";
	           table.appendChild(tr);
	 });
	     }
	 }
	 hr.send(null);
	 }
	  
 
function toEditLoan(loanid){

	window.location.replace("edit_loan.jsp?id="+loanid);


	
	
}

function toViewLoan(){
	var loanid = document.getElementById('loanid');
	
	window.location.replace("loan.jsp");
	
	
}
function toEditContract(loanid){

	
	window.location.replace("edit_contract.jsp?id="+loanid);
	
	
}

function toViewContract(){
	var loanid = document.getElementById('loanid');
	window.location.replace("contract.jsp");
	
}


function toEdit(){
  window.location.replace("edit_contract.jsp");
}
  function newContract(){
    var firstname = document.getElementById('firstname').value;
    if(firstname == "henk"){
      document.getElementById("firstname_error").innerHTML = "Henk is ongeldig";

    }
    var lastname = document.getElementById('lastname').value;
    var birthdate = document.getElementById('birthdate').value;
    var phone = document.getElementById('phone').value;
    var street = document.getElementById('street').value;
    var postalcode = document.getElementById('postal').value;
    var country = document.getElementById('country').value;
    var picture = document.getElementById('picture').value;

    var loantype = document.getElementById('loantype').value;
    var sector = document.getElementById('sector').value;
    var amount = document.getElementById('amount').value;
    var duration = document.getElementById('duration').value;
    var description = document.getElementById('description').value;
    sendContract(firstname,lastname,birthdate,phone,street,postalcode,country,picture,loantype,sector,amount,duration,description)

  }
  function sendContract(firstname,lastname,birthdate,phone,street,postalcode,country,picture,loantype,sector,amount,duration,description){
    console.log(firstname,lastname,birthdate,phone,street,postalcode,country,picture,loantype,sector,amount,duration,description);
  }