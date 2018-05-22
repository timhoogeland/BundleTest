<header class="header">
    <a href="index.jsp" class="logo">Bundle</a>
    <input class="menu-btn" type="checkbox" id="menu-btn" />
    <label class="menu-icon" for="menu-btn">
    <span class="navicon"></span>

    </label>
    <ul id = "menu" class="menu">
        <li>
            <a href="index.jsp">Home</a>
        </li>
        <li>
            <a href="loans.jsp">Loans</a>
        </li>
        <li>
            <a href="contracts.jsp">Contracts</a>
        </li>
        <li id ="login">
            
            <a  href="login.jsp">Login</a>
        </li>
    </ul>

    <script>
	    $(function(){
	        var current = location.pathname;
	        current = current.replace('/bundlePWABackend/', '');
			
	        if(getCookie("username")!=null &&  getCookie("password")!=null){
	            document.getElementById('login').innerHTML = '<span onclick = javascript:logOut();> <a href="login.jsp">Logout</a>  </span>';
			
	          }
	          if (getCookie("username")==null &&  getCookie("password")==null){

	        	  document.getElementById('menu').innerHTML = '  <li> <a href="index.jsp">Home</a></li>   <li id ="login"><a  href="login.jsp">Login</a></li>';
	              
	        	  if(window.location.pathname == "/bundlePWABackend/loans.jsp"||window.location.pathname =="/bundlePWABackend/contracts.jsp"){
	        		  window.location.replace("login.jsp");
	        	  }
	        	 
	        	  
	        	  
	          }
	        $('.menu li a').each(function(){
	            var $this = $(this);
	            // if the current path is like this link, make it active
	            if($this.attr('href').indexOf(current) !== -1){
	                $this.addClass('active');
	                
                  }
	            

	        })
	    })
    </script>
</header>

<br>
<br>

<div id="container">
