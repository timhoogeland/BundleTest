<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body onload="getContracts()">

	<jsp:include page="parts/navigation.jsp" />

	<main>
	<div class="welcomeBlock">
		<h1>Contracts</h1>
		<button class="buttonRound" onclick="toggleHide('helpPopup', false)">?</button>
		<button class="buttonRound" onclick="window.location.href='new_contract.jsp'">+</button>
	</div>

	<div class="block">

		<div id="mainLoader" class="loaderBlock">
        		<div class="loader"></div>
        </div>

		<div id="contracts"">
			<table id='contractstable' class='contracts_table'>
				<thead>
					<tr class="desktop">
						<th>ID</th>
						<th>Amount ($)</th>
						<th>Duration</th>
						<th>End Date</th>
						<th>Status</th>
						<th>Loan Type</th>
					</tr>
				</thead>
				<tbody>
				<tbody>
			</table>
		</div>
	</div>
	</main>

	<jsp:include page="parts/footer.jsp" />
	<script> function getContracts() {
		var hr = new XMLHttpRequest();
		hr.open("GET", "/bundlePWABackend/restservices/loan", true);

		hr.onreadystatechange = function() {
			if (hr.readyState == 4 && hr.status == 200) {
				var data = JSON.parse(hr.responseText);
				$('#mainLoader').fadeOut('fast');
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
	}</script>

	<div id="helpPopup" class="popup" style="display: none;">
		<div>
			<h2>Contracts explained</h2>
			<button class="buttonRound" onclick="toggleHide('helpPopup', true)">X</button>
			<p>
				Lorem ipsum dolor sit amet, pretium leo sed, ac leo aenean tellus, orci amet maxime amet sed nunc pharetra, scelerisque tristique pretium morbi scelerisque mollis sed, vivamus pede irure ac lacus. Diam ante sit amet, blandit laoreet interdum sem pellentesque. Sit turpis ligula non, iaculis viverra.
				Lorem ipsum dolor sit amet, pretium leo sed, ac leo aenean tellus, orci amet maxime amet sed nunc pharetra, scelerisque tristique pretium morbi scelerisque mollis sed, vivamus pede irure ac lacus. Diam ante sit amet, blandit laoreet interdum sem pellentesque. Sit turpis ligula non, iaculis viverra.
			</p>
		</div>
	</div>

</body>
</html>
