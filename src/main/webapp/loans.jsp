<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body onload = "getLoans();" >
    
    <jsp:include page="parts/navigation.jsp" />

	<main class="main">
        <div id="welcome_text">
            <h1>Loans</h1>
            <label id="namelabel"></label>
        </div>

        <center>
        <div id="contracts" style="overflow-x:auto;overflow-y: auto;">

            <table id = "loanstable" class='contracts_table'>
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
    </center>
    </main>
	
    <jsp:include page="parts/footer.jsp" />

</body>
</html>