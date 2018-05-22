<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body onload = "getLoans();" >
    
    <jsp:include page="parts/navigation.jsp" />

	<main>
        <div class="welcomeBlock">
            <h1>Loans</h1>
        </div>
        
        <div class="buttonBlock">
        </div>

        <div class="block">
	        <div class="centerTable" id="contracts" style="overflow-x:auto;overflow-y: auto;">
	
	            <table id="loanstable" class='contracts_table'>
	                <thead>
	                    <tr>
	                        <th>ID</th>
	                        <th>Amount ($)</th>
	                        <th>Duration</th>
	                        <th>End Date</th>
	                        <th>Status</th>
	                        <th>Loan Type</th>
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