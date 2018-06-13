<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body onload="getGroup();">

	<jsp:include page="parts/navigation.jsp" />

	<main>
	<div class="welcomeBlock">
		<h1>Group</h1>
		<button class="buttonRound" onclick="toggleHide('helpPopup', false)">?</button>
		<button class="buttonRound"
			onclick="window.location.href='new_group.jsp'">+</button>
	</div>

	<div class="block">
       	<div id="mainLoader" class="loaderBlock">
       		<div class="loader"></div>
       	</div>
		<div id="GroupTable">
			<table id='contractstable' class='contracts_table'>
				<tr class="desktop">
					<th>Name</th>
					<th>Amount</th>
					<th>Progress</th>
					<th>Time Remaining</th>
					<th>Status</th>
				</tr>
			</table>
		</div>
	</div>

	<jsp:include page="parts/footer.jsp" />

	<div id="helpPopup" class="popup" style="display: none;">
		<div>
			<h2>Contracts explained</h2>
			<button class="buttonRound" onclick="toggleHide('helpPopup', true)">X</button>
			<p>Lorem ipsum dolor sit amet, pretium leo sed, ac leo aenean
				tellus, orci amet maxime amet sed nunc pharetra, scelerisque
				tristique pretium morbi scelerisque mollis sed, vivamus pede irure
				ac lacus. Diam ante sit amet, blandit laoreet interdum sem
				pellentesque. Sit turpis ligula non, iaculis viverra. Lorem ipsum
				dolor sit amet, pretium leo sed, ac leo aenean tellus, orci amet
				maxime amet sed nunc pharetra, scelerisque tristique pretium morbi
				scelerisque mollis sed, vivamus pede irure ac lacus. Diam ante sit
				amet, blandit laoreet interdum sem pellentesque. Sit turpis ligula
				non, iaculis viverra.</p>
		</div>
	</div>
	</main>

	<script>
		function getGroup() {
			var hr = new XMLHttpRequest();
			if(getParameterByName("id") === null) {
				id = getCookie("groupid");
				$('#mainLoader').fadeOut('fast');
				addNotification("No group specified, try again from the groups page...");
			} else {
				id = getParameterByName("id");
				hr.open("GET", "/restservices/loangroup/" +id ,
						true);

				hr.onreadystatechange = function() {
					if (hr.readyState == 4 && hr.status == 200) {
						var data = JSON.parse(hr.responseText);
						var datalength = data.length;

						for (var i = 0; i < datalength; i++) {
							console.log(data[i].loaninformation);
							var id = data[i].loaninformation[0].useridfk.toString();
							console.log(id);

							var amount = data[i].loaninformation[0].amount;
							var paidamount = data[i].loaninformation[0].paidamount;
							var duration = data[i].loaninformation[0].duration;
							var status = data[i].loaninformation[0].status;
							var loanid = data[i].loaninformation[0].loanId;
							done = createCode(id, name, amount, paidamount, duration, status, loanid);

						}
						$('#mainLoader').fadeOut('fast');
					} else if (hr.readyState == 4) {
						addNotification('Retrieving data failed with status '
								+ hr.status + '. Try again later.');
					}
				}
				hr.send(null);

			}

			function createCode(id, name, amount, paidamount, duration, status,
					loanid) {

				$
						.ajax({
							url : "/restservices/user/" + id,
							type : "get",

							success : function(response) {

								console.log(response + "binnenste loop");
								console.log(response[0]);
								var data2 = response;
								var name = data2[0].firstName + " "
										+ data2[0].lastName;
								console.log(id + name);

								var table = document
										.getElementById('contractstable');
								var tr = document.createElement('tr');
								tr.innerHTML = '<td class="name" id="name" data-label="Name">'
										+ name
										+ '</td>'
										+ '<td id ="amount" data-label="Amount">'
										+ amount
										+ '</td>'
										+ '<td id ="progress" data-label="Progress">'
										+ '<progress class="inlineProgress" value=' +paidamount+' max= '+  amount+ '> </progress></td>'
										+ '<td id = "duration" data-label="Time Remaining">'
										+ duration
										+ " months"
										+ '</td>'
										+ '<td id="status" data-label="Status">'
										+ status
										+ '</td>'
										+ "<td class='tdHide'>  <button class='small' onclick='toViewLoan("+ loanid + ");'>View</button></td> "
										+ "<td class='tdHide'>  <button class='small' onclick='toEditLoan("
										+ loanid + ");'>Edit</button> </td>";
								table.appendChild(tr);
								return true;
							},
							error : function(response, textStatus, errorThrown) {
								console.log("Failed.");
								console.log("textStatus: " + textStatus);
								console.log("errorThrown: " + errorThrown);
								console.log("status: " + response.status);

							}
						});

			}
			}

	</script>
</body>
</html>
