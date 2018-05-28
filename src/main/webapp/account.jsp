<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body>
    
    <jsp:include page="parts/navigation.jsp" />

	<main>
        <div class="welcomeBlock">
            <h1>Account</h1>
        </div>
        
        <div class="block">
	        <div class="blockHalf">
	        	<h2>Personal information</h2>
				<br>
				
				<div>
					<label for="picture"> <b>Picture</b>
					</label>
					<br>
					<img id="picture" class="userPicture" alt="User Picture" src="img/nopf.png"">
				</div>
				
				<div>
					<label for="username"> <b>Username</b>
					</label>
					<h3 id="username">Tim Hoogeland</h3>
				</div>
				
				<div>
					<label for="firstname"> <b>First name</b>
					</label>
					<h3 id="firstname">Tim</h3>
				</div>
	
				<div>
					<label for="lastname"> <b>Last name</b>
					</label>
					<h3 id="lastname">Hoogeland</h3>
				</div>
					
				<div>
					<label for="birthdate"> <b>Date of birth</b>
					</label>
					<h3 id="birthdate">18-11-1985</h3>
				</div>
		
				<div>
					<label for="phone"> <b>Phone number</b>
					</label>
					<h3 id="phone">00456658483</h3>
				</div>
				
				<div>
					<label for="role"> <b>Role</b>
					</label>
					<h3 id="role">Loan Applicant</h3>
				</div>
				
				<div>
					<label for="status"> <b>Status</b>
					</label>
					<h3 id="status">Active</h3>
				</div>
			</div>
				
			<div class="blockHalf">
				<h2>Adres</h2>
				<br>
		
				<div>
					<label for="street"> <b>Street</b>
					</label>
					<h3 id="street">Mudway, 221</h3>
				</div>
		
				<div>
					<label for="postal"> <b>Postal code</b>
					</label>
					<h3 id="postal">5626 EM</h3>
				</div>
		
				<div>
					<label for="country"> <b>Country</b>
					</label>
					<h3 id="country">Zimbabwe</h3>
				</div>
				
				<div>
					<label for="description"> <b>Description</b>
					</label>
					<h3 id="description">Derde boom rechts</h3>
				</div>
				
				<div>
					<label for="coordinates"> <b>Coordinates</b>
					</label>
					<h3 id="coordinates">LA 40.741895, LO -73.989308</h3>
				</div>
				
				<h2>Group</h2>
				<br>
				
				<div>
					<label for="loanofficer"> 
						<b>Loan Officer</b>
						<button class="buttonRound">&#8618;</button>
					</label>
					<h3 id="loanofficer">Michiel Diederen</h3>
					
				</div>
				
				<div>
					<label for="groupnumber"> 
						<b>Group number </b> 
						<button class="buttonRound">&#8618;</button>
					</label>
					<h3 id="groupnumber">6234</h3>
				</div>
				
				<div>
					<label for="loanstatus"> <b>Status</b>
					</label>
					<h3 id="loanstatus">Open</h3>
				</div>
				
			</div>
		</div>
    </main>
	
    <jsp:include page="parts/footer.jsp" />

</body>
</html>