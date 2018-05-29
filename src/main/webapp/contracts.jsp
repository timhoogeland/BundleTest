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