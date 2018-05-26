<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body>
    
    <jsp:include page="parts/navigation.jsp" />

	<main>
        <div class="welcomeBlock">
            <h1>My Account</h1>
        </div>
        
        <div class="block">
        	<p>- When no other id is supplied see own data and option to edit it</p>
        	<p>- With other id supplied see other users data (if you are allowed)</p>
        	<p>- Depending on your role you can set a user inactive/active or change data</p>
        </div>
    </main>
	
    <jsp:include page="parts/footer.jsp" />

</body>
</html>