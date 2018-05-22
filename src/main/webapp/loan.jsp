<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body >
    
    <jsp:include page="parts/navigation.jsp" />

	<main>
    <h2>View Loan - Person A</h2>
    <div class="applicantinfo-loan">
      <h2> Applicant information </h2>

      <div class="formdiv">
        <div class="leftline">
          <label for="firstname">
            <b>First name</b>
          </label>

        </div>
        <div class="rightline">
          <label for="lastname">
            <b>Last name</b>
          </label>

        </div>
      </div>
      <div class="formdiv">
        <div class="leftline">
          <label for="birthdate">
            <b>Date of birth</b>
          </label>

        </div>
        <div class="rightline">
          <label for="phone">
            <b>Phone number</b>
          </label>

        </div>
      </div>

      
          <label for="street">
            <b>Street</b>
          </label>


          <label for="postal">
            <b>Postal code</b>
          </label>
          <h3 id="postal">5626 EM</h3>

        <label for="country">
          <b>Country</b>
        </label>
        <h3 id="country">Zimbabwe</h3>


    <div class="loan_progress">
      <h2>Loan progress</h2>
      <label for="status">
        <b>Status</b>
      </label>


      <label for="remaining">
        <b>Remaining amount</b>
      </label>
      <h3 id="remaining">$950.00</h3>
      <progress id="remaining" value="55" max="100">
      </progress>
    </div>


    <div class="loaninfo_loan">
      <h2> Loan information </h2>
      <label for="loantype">
        <b>Loan type</b>
      </label>

      <label for="sector">
        <b>Sector</b>
      </label>
      <h3>Farming</h3>
      <label for="amount">
        <b>Amount</b>
      </label>

      <h3 id="amount">1000</h3>
      <label for="duration">
        <b>Duration(months)</b>
      </label>
      <h3 id="duration">12</h3>


    </div>

    </div>

    </div>
    </div>
  </main>
    
    <jsp:include page="parts/footer.jsp" />

</body>
</html>