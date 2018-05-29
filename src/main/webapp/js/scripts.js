// BEGIN: PWA initialisation
if ('serviceWorker' in navigator) {
  console.log('CLIENT: service worker registration in progress.');
  navigator.serviceWorker.register('sw.js').then(function() {
    console.log('CLIENT: service worker registration complete.');
  }, function() {
    console.log('CLIENT: service worker registration failure.');
  });
} else {
  console.log('CLIENT: service worker is not supported.');
}
// END: PWA initialisation

// Login
function setCookie(name, value, days) {
	var expires = "";
	if (days) {
		var date = new Date();
		date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
		expires = "; expires=" + date.toUTCString();
	}
	document.cookie = name + "=" + (value || "") + expires + "; path=/";
}
function getCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ')
			c = c.substring(1, c.length);
		if (c.indexOf(nameEQ) == 0)
			return c.substring(nameEQ.length, c.length);
	}
	return null;
}

function eraseCookie(name) {
	document.cookie = name + '=; Max-Age=-99999999;path=/;';
}

function logOut() {
	eraseCookie("username");
	eraseCookie("password");
	eraseCookie("loanofficerid");
	eraseCookie("loanid");
}

function validateLogin() {
	$('#loginbutton').attr('loading', 'true');
	var pass = document.getElementById('pass').value;
	var username = document.getElementById('username').value;

	if (username == '') {
		$('#loginbutton').attr('loading', 'false');
		$('#loginbutton').text('Try again');
		addNotification('Username can not be empty');
	} else if (pass == '') {
		$('#loginbutton').attr('loading', 'false');
		$('#loginbutton').text('Try again');
		addNotification('Password can not be empty');
	} else {
		var logRequest;
		try {
			logRequest = new XMLHttpRequest();
			logRequest.open('GET', "/bundlePWABackend/restservices/login", true);
			logRequest.setRequestHeader("username", username);
			logRequest.setRequestHeader("password", pass);
			logRequest.send(null);
			logRequest.onload = function() {
				if (logRequest.readyState === logRequest.DONE && logRequest.status === 200) {
					var response = JSON.parse(logRequest.response);
					if (response[0]['userid'] !== undefined) {
						$('#loginbutton').attr('loading', 'false');
						$('#loginbutton').text('Succes');
						setCookie('username', username, 1);
						setCookie('password', pass, 1);
						setCookie('loanofficerid', response[0]['userid']);
						addNotification("Login successful", "green");
						window.location.replace("index.jsp");
					} else {
						$('#loginbutton').attr('loading', 'false');
						$('#loginbutton').text('Try again');
						addNotification(response[0]['error']);
					}
				} else {
					$('#loginbutton').attr('loading', 'false');
					$('#loginbutton').text('Try again');
					addNotification('Retrieving data failed with status '
							+ logRequest.status + '. Try again later.');
				}
			}

		} catch (exception) {
			alert("Request failed");
		}
	}
}

function checkCookie() {
	console.log(getCookie('loanofficerid'));
}

function getLoans() {
	var hr = new XMLHttpRequest();
	hr.open("GET", "/bundlePWABackend/restservices/loan", true);

	hr.onreadystatechange = function() {
		if (hr.readyState == 4 && hr.status == 200) {
			var data = JSON.parse(hr.responseText);
			var table = document.getElementById('loanstable');
			data.forEach(function(object) {
				var tr = document.createElement('tr');
				tr.innerHTML = '<td class="id" id="loanid" data-label="ID">'
						+ object.loanId + '</td>'
						+ '<td id ="amount" data-label="Amount">'
						+ object.amount + '</td>'
						+ '<td id = "duration" data-label="Duration">'
						+ object.duration + " months" + '</td>'
						+ '<td id = "closingdate" data-label="End Date">'
						+ object.closingdate + '</td>'
						+ '<td id="status" data-label="Status">'
						+ object.status + '</td>'
						+ '<td id = "loantype" data-label="Loan Type">'
						+ object.loantype + '</td>'
						+ "<td class='tdHide'>  <button class='small' onclick='toViewLoan(" + object.loanId
						+ ");'>View</button> </td>"
						+ "<td class='tdHide'>  <button class='small' onclick='toEditLoan(" + object.loanId
						+ ");'>Edit</button> </td>";
				table.appendChild(tr);
			});
		} else if (hr.readyState == 4) {
			addNotification('Retrieving data failed with status ' + hr.status
					+ '. Try again later.');
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
			var table = document.getElementById('contractstable');
			data.forEach(function(object) {
				var tr = document.createElement('tr');
				tr.innerHTML = '<td class="id" id="loanid" data-label="ID">'
						+ object.loanId + '</td>'
						+ '<td id ="amount" data-label="Amount">'
						+ object.amount + '</td>'
						+ '<td id = "duration" data-label="Duration">'
						+ object.duration + " months" + '</td>'
						+ '<td id = "closingdate" data-label="End Date">'
						+ object.closingdate + '</td>'
						+ '<td id="status" data-label="Status">'
						+ object.status + '</td>'
						+ '<td id = "loantype" data-label="Loan Type">'
						+ object.loantype + '</td>'
						+ "<td class='tdHide'>  <button class='small' onclick='toViewContract("
						+ object.loanId + ");'>View</button> " +
								"<button class='small' onclick='toEditContract("
						+ object.loanId + ");'>Edit</button> </td>";
				table.appendChild(tr);
			});
		} else if (hr.readyState == 4) {
			addNotification('Retrieving data failed with status ' + hr.status
					+ '. Try again later.');
		}
	}
	hr.send(null);
}

<<<<<<< HEAD
=======
function getUser() {
	var hr = new XMLHttpRequest();
	hr.open("GET", "/bundlePWABackend/restservices/user/1", true);

	hr.onreadystatechange = function() {
		if (hr.readyState == 4 && hr.status == 200) {
			var userData = JSON.parse(hr.responseText);
			var addressData = JSON.parse(userData[0].address);
			
			$('.call1').attr("loading","false");
			$('#picture').attr("src", userData[0].photo);
			$('#username').text(userData[0].username);
			$('#name').text(userData[0].firstName + " " + userData[0].lastName);
			$('#phone').text(userData[0].phonenumber);
			$('#birthdate').text(userData[0].dateofbirth);
			$('#role').text(userData[0].userType);
			$('#status').text(userData[0].status);
			$('#street').text(addressData[0].street + " " + addressData[0].number);
			$('#postal').text(addressData[0].postalcode);
			$('#country').text(addressData[0].country);
			$('#description').text(addressData[0].description);
			$('#coordinates').text(addressData[0].location);
		} else if (hr.readyState == 4) {
			addNotification('Retrieving data failed with status ' + hr.status + '. Try again later.');
		}
	}
	hr.send(null);
}

function checkValue(value){
	if (value === "" || value === undefined || value == null) {
		return "Not supplied";
	} 
	
	return value;
}
>>>>>>> cacb379b39eadd57b8236edde10bac275768367b

function toEditLoan(loanid) {
	window.location.replace("edit_loan.jsp?id=" + loanid);
}

function toViewLoan(loanId) {

	window.location.replace("loan.jsp?id=" + loanId);
}

function UCFirst(string) {
	return string.charAt(0).toUpperCase() + string.slice(1);
}

<<<<<<< HEAD
function loadLoanDetails() {
	var hr = new XMLHttpRequest();

	hr.open("GET", "/bundlePWABackend/restservices/loan/"
			+ getParameterByName('id'), true);

	hr.onreadystatechange = function() {
		if (hr.readyState == 4 && hr.status == 200) {
			var data = JSON.parse(hr.responseText);
			$('#status').text(UCFirst(data[0].status));
			$('#remaining').text("TODO");
			$('#loantype').text(UCFirst(data[0].loantype));
			$('#remainingbar').attr('value', 0);
			$('#remainingbar').attr('max', data[0].amount);
			$('#amount').text("$ " + data[0].amount);
			$('#duration').text(data[0].duration);
			$('#startdate').text(data[0].startdate);
			$('#closingdate').text(data[0].closingdate);

			var hr2 = new XMLHttpRequest();
			hr2.open("GET", "/bundlePWABackend/restservices/contract/"
					+ data[0].contractid, true);

			hr2.onreadystatechange = function() {
				if (hr2.readyState == 4 && hr2.status == 200) {
					var data = JSON.parse(hr2.responseText);

					var hr3 = new XMLHttpRequest();
					hr3.open("GET", "/bundlePWABackend/restservices/user/"
							+ data[0].useridfk, true);

					hr3.onreadystatechange = function() {
						if (hr3.readyState == 4 && hr3.status == 200) {
							var data = JSON.parse(hr3.responseText);
							$('#loanName').text(
									'Loan - ' + UCFirst(data[0].name));
							$('#name').text(UCFirst(data[0].name));
							;
							$('#dateofbirth').text(data[0].dateofbirth);
							$('#phone').text(data[0].phonenumber);
							$('#role').text(data[0].userType);
							$('#userstatus').text(data[0].status);

							var hr4 = new XMLHttpRequest();
							hr4.open("GET",
									"/bundlePWABackend/restservices/adress/"
											+ data[0].adresIDFK, true);

							hr4.onreadystatechange = function() {
								if (hr4.readyState == 4 && hr4.status == 200) {
									var data = JSON.parse(hr4.responseText);
									$('#street').text(
											data[0].street + " "
													+ data[0].number);
									$('#postal').text(data[0].postalcode);
									$('#country').text(data[0].country);
								} else if (hr4.readyState == 4) {
									addNotification('Retrieving data failed with status '
											+ hr4.status + '. Try again later.');
								}
							}
							hr4.send(null);
						} else if (hr3.readyState == 4) {
							addNotification('Retrieving data failed with status '
									+ hr3.status + '. Try again later.');
						}
					}
					hr3.send(null);

				} else if (hr2.readyState == 4) {
					addNotification('Retrieving data failed with status ' + hr2.status
							+ '. Try again later.');
				}

			}
			hr2.send(null);

		} else if (hr.readyState == 4) {
			addNotification('Retrieving data failed with status ' + hr.status
					+ '. Try again later.');
		}
	}
	hr.send(null);
}

function getGroups{
  var hr = new XMLHttpRequest();
  hr.open("GET", "/bundlePWABackend/restservices/loan", true);

  hr.onreadystatechange = function() {
    if (hr.readyState == 4 && hr.status == 200) {
      var data = JSON.parse(hr.responseText);
      var table = document.getElementById('groupsdiv');
      data.forEach(function(object) {
        var tr = document.createElement('div');
        tr.innerHTML = '<td class="id" id="loanid" data-label="ID">'
            + object.loanId + '</td>'
            + '<td id ="amount" data-label="Amount">'
            + object.amount + '</td>'
            + '<td id = "duration" data-label="Duration">'
            + object.duration + " months" + '</td>'
            + '<td id = "closingdate" data-label="End Date">'
            + object.closingdate + '</td>'
            + '<td id="status" data-label="Status">'
            + object.status + '</td>'
            + '<td id = "loantype" data-label="Loan Type">'
            + object.loantype + '</td>'
            + "<td class='tdHide'>  <button class='small' onclick='toViewLoan(" + object.loanId
            + ");'>View</button> </td>"
            + "<td class='tdHide'>  <button class='small' onclick='toEditLoan(" + object.loanId
            + ");'>Edit</button> </td>";
        table.innerHTML+= tr;
      });
    } else if (hr.readyState == 4) {
      addNotification('Retrieving data failed with status ' + hr.status
          + '. Try again later.');
    }
  }
  hr.send(null);
}

}

=======
>>>>>>> cacb379b39eadd57b8236edde10bac275768367b
function getParameterByName(name, url) {
	if (!url)
		url = window.location.href;
	name = name.replace(/[\[\]]/g, "\\$&");
	var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"), results = regex
			.exec(url);
	if (!results)
		return null;
	if (!results[2])
		return '';
	return decodeURIComponent(results[2].replace(/\+/g, " "));
}

function toEditContract(loanid) {

	window.location.replace("edit_contract.jsp?id=" + loanid);

}

function toViewContract() {
	var loanid = document.getElementById('loanid');
	window.location.replace("contract.jsp");

}

function toEdit() {
	window.location.replace("edit_contract.jsp");
}
function newContract() {
	var firstname = document.getElementById('firstname').value;
	if (firstname == "henk") {
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
	sendContract(firstname, lastname, birthdate, phone, street, postalcode,
			country, picture, loantype, sector, amount, duration, description)

}
function sendContract(firstname, lastname, birthdate, phone, street,
		postalcode, country, picture, loantype, sector, amount, duration,
		description) {
	console.log(firstname, lastname, birthdate, phone, street, postalcode,
			country, picture, loantype, sector, amount, duration, description);
}

function addNotification(text, color) {
	backgroundColor = "#ffffff";
	if (color != undefined && color === "green") {
		backgroundColor = "#5dbc5d";
	} else {
		backgroundColor = "#fa5858";
	}

	$('#notificationBlock').fadeIn().append(
			'<div class="notification hide" style="background-color:'+backgroundColor+'"><p id="notificationText">' + text
					+ '</div></div>');
	$('#notificationBlock .notification:last').hide().fadeIn();
	setTimeout(removeNotification, 3000);
}
function removeNotification() {
	$('#notificationBlock .notification:last').fadeOut(1000);
	setTimeout(function() {
		$('#notificationBlock .notification:last').remove();
	}, 1100)
}

function toggleHide(id, bool) {
	event.stopPropagation();
	if (bool) {
		$('#'+id).fadeOut('fast');
	} else {
		$('#'+id).fadeIn('fast');
	}
}

function loadingText(points) {
	if (points == '...') {
		points = '.  ';
	} else if (points == '.. ') {
		points = '...';
	} else if (points == '.  ') {
		points = '.. ';
	}

	$('[loading="true"]').text('Loading' + points);

	setTimeout(function() {
		loadingText(points);
	}, 1000);
}
