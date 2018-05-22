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
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
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
    document.cookie = name+'=; Max-Age=-99999999;';
}

// function checkLogin(){
// 		if( getCookie("username")!=null &&  getCookie("password")!=null){
//       var password = getCookie("password");
//       var username = getCookie("username");
//       console.log(username);
//       console.log(password);
//       namelabel.innerhtml = username;
//     }

//     else{
//         window.location.replace("login.html");
//     }}


	function logOut(){
    console.log("werkt");
		eraseCookie("username");
		eraseCookie("password");
    eraseCookie("loanofficerid");

	}


function validateLogin(){
var logRequest;
            try{
          	  console.log("he");
              var pass = document.getElementById('pass').value;
              var username = document.getElementById('username').value;

          	  logRequest = new XMLHttpRequest();
          	  logRequest.open('GET', "http://localhost:4711/bundlePWABackend/restservices/login", true);
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
         window.location.replace("index.html");
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
hr.open("GET", "http://localhost:4711/bundlePWABackend/restservices/loan", true);

hr.onreadystatechange = function() {
    if (hr.readyState == 4 && hr.status == 200) {
        var data = JSON.parse(hr.responseText);
        console.log(data);
        var table = document.getElementById('contractstable');
        data.forEach(function(object) {
          var tr = document.createElement('tr');
          tr.innerHTML = '<td>' + object.loanId + '</td>' +
          '<td>' + object.amount + '</td>' +
          '<td>' + object.duration +" months" + '</td>' +
          '<td>' + object.closingdate + '</td>' +
          '<td>' + object.status + '</td>' +
          '<td>' + object.loantype + '</td>' +
          "<td>  <button onclick='toLoan();'>View</button> </td>" +
              "<td>  <button onclick='toEdit();'>Edit</button> </td>";
          table.appendChild(tr);
});
    }
}
hr.send(null);
}
function toLoan(){
  window.location.replace("/loan.html");
}
function toEdit(){
  window.location.replace("/edit_contract.html");
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