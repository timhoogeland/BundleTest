<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body onload="loadLoanDetails()">
    
    <jsp:include page="parts/navigation.jsp" />

    <main>
    	<div class="welcomeBlock long">
    		<h1 id="loanName" >Loan - Loading...</h1>
    	</div>
    	
    <div class="blockHalf">
      <h2> Applicant information </h2>
	  <br>
	  
      <div>
        <label for="name">
          <b>Name</b>
        </label>
        <h3 id="name">Loading...</h3>
      </div>
      
      <div>
        <label for="dateofbirth">
          <b>Date Of Birth</b>
        </label>
        <h3 id="dateofbirth">Loading...</h3>
      </div>
      
      <div>
        <label for="userstatus">
          <b>Status</b>
        </label>
        <h3 id="userstatus">Loading...</h3>
      </div>

      <div>
        <label for="phone">
          <b>Phone number</b>
        </label>
        <h3 id="phone">Loading...</h3>
      </div>
      
      <div>
        <label for="role">
          <b>Role</b>
        </label>
        <h3 id="role">Loading...</h3>
      </div>
		
		<h2>ADRESS</h2>
		<br>
      <div>
        <label for="street">
          <b>Street</b>
        </label>
        <h3 id="street">Loading...</h3>
      </div>

      <div>
        <label for="postal">
          <b>Postal code</b>
        </label>
        <h3 id="postal">Loading...</h3>
      </div>

      <div>
        <label for="country">
          <b>Country</b>
        </label>
        <h3 id="country">Loading...</h3>
      </div>
      <div>
      </div>
      </div>
      
      	<div class="blockHalf">
          <h2>Loan progress</h2>
		  <br>
		  
          <div id='statusDiv'>
            <label for="status">
              <b>Status</b>
            </label>
            <h3 id="status">Loading...</h3>
          </div>

          <div>
            <label for="remaining">
              <b>Remaining amount</b>
            </label>
            <h3 id="remaining">Loading...</h3>
            <progress id="remainingbar">
            </progress>
          </div>
        
          <h2> Loan information </h2>
		  <br>
		  
          <div>
            <label for="loantype">
              <b>Loan type</b>
            </label>
            <h3 id="loantype">Loading...</h3>
          </div>

	      <div>
	        <label for="amount">
	          <b>Amount</b>
	        </label>
	        <h3 id="amount">Loading...</h3>
	      </div>

	      <div>
	        <label for="duration">
	          <b>Duration (months)</b>
	        </label>
	        <h3 id="duration">Loading...</h3>
	      </div>
      
	      <div>
	        <label for="duration">
	          <b>Start Date</b>
	        </label>
	        <h3 id="startdate">Loading...</h3>
	      </div>
      
	     <div>
	       <label for="duration">
	         <b>Closing Date</b>
	       </label>
	       <h3 id="closingdate">Loading...</h3>
	     </div>
	     </div>
  </main>
    
  <jsp:include page="parts/footer.jsp" />

</body>
</html>