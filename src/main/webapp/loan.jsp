<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body >
    
    <jsp:include page="parts/navigation.jsp" />

	<main>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		
		
		      <button id="myBtn">View Loan</button>
		<!-- The Modal -->
		<div id="myModal" class="modal">
		
		  <div class="modal-content">
		    <div class="modal-header">
		      <span class="close">&times;</span>
		      <h2>View Loan - Person A</h2>
		    </div>
		    <div class="modal-body">
		      <div class = "applicantinfo-loan">
		        <h2> Applicant information </h2>
		
		  <div class = "formdiv">
		    <div class = "leftline">
		  <label for="firstname"><b>First name</b></label>
		
		</div>
		<div class ="rightline">
		  <label for="lastname"><b>Last name</b></label>
		
		</div>
		  </div>
		  <div class = "formdiv">
		    <div class ="leftline">
		    <label for="birthdate"><b>Date of birth</b></label>
		
		</div>
		<div class="rightline">
		    <label for="phone"><b>Phone number</b></label>
		
		</div>
		  </div>
		
		  <div class = "formdiv">
		    <div class ="leftline">
		    <label for="street"><b>Street</b></label>
		
		</div>
		<div class="rightline">
		    <label for="postal"><b>Postal code</b></label>
		
		</div></div>
		<div class = "formdiv">
		<label for="country"><b>Country</b></label>
		    </div></div>
		
		
		    <div class ="loan_progress">
		      <h2>Loan progress</h2>
		      <label for="status"><b>Status</b></label>
		
		
		      <label for="remaining"><b>Remaining amount</b></label>
		      <p>Remaing amount..</p>
		      <progress id ="remaining" value="55" max="100">
		      </progress>
		
		    <!--  <div id="myProgress">
		        <div id="myBar"></div>
		      </div> -->
		    </div>
		
		
		    <div class ="loaninfo_loan">
		      <h2> Loan information </h2>
		      <div class = "formdiv">
		          <div class="leftline">
		        <label for="loantype"><b>Loan type</b></label>
		
		
		      </div>
		      <div class = "rightline">
		        <label for="sector"><b>Sector</b></label>
		
		      </div>
		      </div>
		
		      <div class = "formdiv">
		      <div class = "leftline">
		
		        <label for="amount"><b>Amount</b></label>
		
		      </div>
		
		      <div class = "rightline">
		        <label for="duration"><b>Duration(months)</b></label>
		
		      </div>
		      </div>
		
		    </div>
		
		  </div>
		    <div class="modal-footer">
		      <button id="done"></button>
		      <h3>Modal Footer</h3>
		    </div>
		  </div>
		</div>
		
		</body>
		<script>
		var modal = document.getElementById('myModal');
		
		// Get the button that opens the modal
		var btn = document.getElementById("myBtn");
		
		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];
		
		// When the user clicks on the button, open the modal
		btn.onclick = function() {
		    modal.style.display = "block";
		}
		
		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
		    modal.style.display = "none";
		}
		
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		    if (event.target == modal) {
		        modal.style.display = "none";
		    }
		}
		</script>
	</main>
    
    <jsp:include page="parts/footer.jsp" />

</body>
</html>