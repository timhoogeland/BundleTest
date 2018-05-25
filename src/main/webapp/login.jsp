<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body onload="loadingText('...')">
    
    <jsp:include page="parts/navigation.jsp" />
	
    <main>
      <div class="welcomeBlock centerText">
      	<h1>Login</h1>
      </div>
      
      <div class="block">
	    <form name = "loginform" action="javascript:validateLogin();"  class = "form">
		  <ul class="flex-outer">
			  <li>	
			  	<label for="uname"><b>Username</b></label>
			  	<input id = "username" type="text" placeholder="Enter Username" name="uname" required>
			  </li>
			  
			  <li>
			 	 <label for="psw"><b>Password</b></label>
			  	<input id = "pass" type="password" placeholder="Enter Password" name="psw" required>
			  </li>
			  
			  <li>
			  	<button id="loginbutton" type="submit" >Login</button>
			  </li>
		  </ul>
		
		  
	    </form>
	</div>
   </main>

    <jsp:include page="parts/footer.jsp" />

</body>
</html>