<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body >
    
    <jsp:include page="parts/navigation.jsp" />

    <main>
      <div>
      <h1>Login</h1>
    <form name = "loginform" action="javascript:validateLogin();"  class = "form">
  <div class="imgcontainer">

  </div>

  <div class="container">
  <label for="uname"><b>Username</b></label>
  <input id = "username" type="text" placeholder="Enter Username" name="uname" required>

  <label for="psw"><b>Password</b></label>
  <input id = "pass" type="password" placeholder="Enter Password" name="psw" required>

  <button type="submit">Login</button>
  <label>
  <input type="checkbox" checked="checked" name="remember"> Remember me
  </label>
  <div class="container" style="background-color:#f1f1f1">
  <button type="button" class="cancelbtn">Cancel</button>
  <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
     </form>
</div>
    </main>

    <jsp:include page="parts/footer.jsp" />

</body>
</html>