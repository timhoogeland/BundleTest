<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body>
    
    <jsp:include page="parts/navigation.jsp" />

	<main>
        <div class="welcomeBlock">
            <h1>Users</h1>
        </div>
        
        <div class="block">
        	<p>- This is a admin page</p>
        	<p>- You cant change your own data here or from other admins</p>
        	<p>- Button to view user (direct to account.jsp with user id)</p>
        	<p>- Maby a filter system to sort on userid, role, etc</p>
        </div>
    </main>
	
    <jsp:include page="parts/footer.jsp" />

</body>
</html>