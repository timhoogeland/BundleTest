<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body onload = "getContracts()">
    
    <jsp:include page="parts/navigation.jsp" />

    <main>
        <div class="welcomeBlock">
            <h1>Contracts</h1>
        </div>
        
        <div class="buttonBlock">
        	<button class="topButton" onclick="window.location.href='new_contract.jsp'">New Contract</button>
        </div>

		<div class="block">
		    <div class="centerTable" id="contracts" style="overflow-x:auto;overflow-y: auto;">
	            <table id='contractstable' class='contracts_table'>
	                <thead>
	                    <tr>
	                        <th>ID</th>
	                        <th>Amount ($)</th>
	                        <th>Duration</th>
	                        <th>End Date</th>
	                        <th>Status</th>
	                        <th>View</th>
	                        <th>Edit</th>
	                    </tr>
	                </thead>
	                <tbody>
	                  
	                    <tbody>
	            </table>
	        </div>
		</div>

    </main>

    <jsp:include page="parts/footer.jsp" />

</body>
</html>