<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body onload="getUser();">
    
    <jsp:include page="parts/navigation.jsp" />

	<main>
        <div class="welcomeBlock">
            <h1>Account</h1>
            <button class="buttonRound" onclick="toggleHide('helpPopup', false)">?</button>
			<button class="buttonRound" onclick="window.location.href='edit_account.jsp'">&#9998;</button>
        </div>
        
        <div class="block">
        
        	<div class="loaderBlock">
        		<div class="loader"></div>
        	</div>
        	
	        <div class="blockHalf">
	        	<h2>Personal information</h2>
				<br>
				
				<div>
					<div class="pf">
						<button id="pfbutton" class="buttonImg hide" >Load</button>
					</div>
				</div>
				
				<div>
					<label for="username"> <b>Username</b>
					</label>
					<h3 id="username" class="call1" loading="true">Loading...</h3>
				</div>
				
				<div>
					<label for="name"> <b>Name</b>
					</label>
					<h3 id="name" class="call1" loading="true">Loading...</h3>
				</div>
					
				<div>
					<label for="birthdate"> <b>Date of birth</b>
					</label>
					<h3 id="birthdate" class="call1" loading="true">Loading...</h3>
				</div>
		
				<div>
					<label for="phone"> <b>Phone number</b>
					</label>
					<h3 id="phone" class="call1" loading="true">Loading...</h3>
				</div>
				
				<div>
					<label for="role"> <b>Role</b>
					</label>
					<h3 id="role" class="call1" loading="true">Loading...</h3>
				</div>
				
				<div>
					<label for="status"> <b>Status</b>
					</label>
					<h3 id="status" class="call1" loading="true">Loading...</h3>
				</div>
			</div>
				
			<div class="blockHalf">
				<h2>Address</h2>
				<br>
		
				<div>
					<label for="street"> <b>Street</b>
					</label>
					<h3 id="street" class="call1" loading="true">Loading...</h3>
				</div>
		
				<div>
					<label for="postal"> <b>Postal code</b>
					</label>
					<h3 id="postal" class="call1" loading="true">Loading...</h3>
				</div>
		
				<div>
					<label for="country"> <b>Country</b>
					</label>
					<h3 id="country" class="call1" loading="true">Loading...</h3>
				</div>
				
				<div>
					<label for="description"> <b>Description</b>
					</label>
					<h3 id="description" class="call1" loading="true">Loading...</h3>
				</div>
				
				<div>
					<label for="coordinates"> <b>Coordinates</b>
					</label>
					<h3 id="coordinates" class="call1" loading="true">Loading...</h3>
				</div>
				
				<div id="group" class="hide">
				
					<h2>Group</h2>
					<br>
					
					<div>
						<label for="loanofficer"> 
							<b>Loan Officer</b>
							<button id="officerButton" class="buttonRound">&#8618;</button>
						</label>
						<h3 id="loanofficer" class="call2" loading="true">Loading...</h3>
						
					</div>
					
					<div>
						<label for="groupnumber"> 
							<b>Group number </b> 
							<button id="groupButton" class="buttonRound">&#8618;</button>
						</label>
						<h3 id="groupnumber" class="call2" loading="true">Loading...</h3>
					</div>
				</div>
			</div>
		</div>
    </main>
	
    <jsp:include page="parts/footer.jsp" />
    
    <div id="helpPopup" class="popup" style="display: none;">
		<div>
			<h2>Account explained</h2>
			<button class="buttonRound" onclick="toggleHide('helpPopup', true)">X</button>
			<p>This page will give you a overview of all your account details.</p>			
		</div>
	</div>

</body>
</html>