<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<!-- <body onload=getGroups();>  -->
<body>

    <jsp:include page="parts/navigation.jsp" />

	<main>
	<div class="welcomeBlock">
		<h1>Groups</h1>
		<button class="buttonRound" onclick="toggleHide('helpPopup', false)">?</button>
	</div>

	<div class="block">
		<!-- <div id="mainLoader" class="loaderBlock">
				<div class="loader"></div>
			</div>
			 -->

		<div id="groupsdiv" class="block">
			<div class="blockHalf">
				<h2  class="groupTitle">Group 1</h2>
						<div class="groupTotal">
						<label for="picture"> <b> Group Total </b></label>
						<progress value="25" max="200"></progress>
					</div>
				<div class="blockGroup">
					<div>
						<label for="picture"> <b> Jan </b></label>
						<progress value="51" max="200"></progress>
					</div>
					<div>
						<label for="picture"> <b> Michiel </b></label>
						<progress value="0" max="150"></progress>
					</div>
				</div>
				<button class="groupButton" >View</button>
			</div>
			<div class="blockHalf">
				<h2 class="groupTitle" >Group 1</h2>
				<div class="groupTotal">
					<label for="picture"> <b> Group Total </b></label>
					<progress value="25" max="200"></progress>
				</div>
				<div class="blockGroup">
					<div>
						<label for="picture"> <b> Jan </b></label>
						<progress value="51" max="200"></progress>
					</div>
					<div>
						<label for="picture"> <b> Michiel </b></label>
						<progress value="0" max="150"></progress>
					</div>
										<div>
						<label for="picture"> <b> Jan </b></label>
						<progress value="51" max="200"></progress>
					</div>
					<div>
						<label for="picture"> <b> Michiel </b></label>
						<progress value="0" max="150"></progress>
					</div>
					<div>
						<label for="picture"> <b> Jan </b></label>
						<progress value="51" max="200"></progress>
					</div>
					<div>
						<label for="picture"> <b> Michiel </b></label>
						<progress value="0" max="150"></progress>
					</div>
				</div>
				<button  class="groupButton">View</button>
			</div>
		</div>
	</div>
	</main>

	<jsp:include page="parts/footer.jsp" />

	<div id="helpPopup" class="popup" style="display: none;">
		<div>
			<h2>Groups explained</h2>
			<button class="buttonRound" onclick="toggleHide('helpPopup', true)">X</button>
			<p>Lorem ipsum dolor sit amet, pretium leo sed, ac leo aenean
				tellus, orci amet maxime amet sed nunc pharetra, scelerisque
				tristique pretium morbi scelerisque mollis sed, vivamus pede irure
				ac lacus. Diam ante sit amet, blandit laoreet interdum sem
				pellentesque. Sit turpis ligula non, iaculis viverra. Lorem ipsum
				dolor sit amet, pretium leo sed, ac leo aenean tellus, orci amet
				maxime amet sed nunc pharetra, scelerisque tristique pretium morbi
				scelerisque mollis sed, vivamus pede irure ac lacus. Diam ante sit
				amet, blandit laoreet interdum sem pellentesque. Sit turpis ligula
				non, iaculis viverra.</p>
		</div>
	</div>
  </main>

  <jsp:include page="parts/footer.jsp" />
  
  <script> function getGroups() {

  var hr = new XMLHttpRequest();
  var loanofficerid = getCookie("userid");
  hr.open("GET", "/bundlePWABackend/restservices/loangroup/loanofficer/" + loanofficerid, true);

  hr.onreadystatechange = function() {
    if (hr.readyState == 4 && hr.status == 200) {
    	$('#mainLoader').fadeOut('fast');
      var data = JSON.parse(hr.responseText);
      var table = document.getElementById('groupsdiv');
      var datalength = data.length;

      console.log(data[0].groupinformation[1]);
      for(var i = 0; i<datalength;i++){
        var groupid = data[i].groupid;
        var innerlength = data[i].groupinformation.length;
        var groupdiv = ' <div class="group"><h2> Group ' +groupid.toString()+'</h2>';
        for(var y=0; y<innerlength; y++){

          console.log(data[i].groupinformation[y]);

          groupdiv+=  [  '<div> <label for="picture"> <b>',
            data[i].groupinformation[y].firstname,
              '</b></label>',
              '<br> <img id="picture" class="groupPicture" alt="User Picture" src="img/nopf.png" "="">',
               ' <progress value=' +data[i].groupinformation[y].paidamount+' max='+data[i].groupinformation[y].amount+'></progress></div>'
            ].join('\n')
          //    forEach
          if(y==(innerlength-1)){
            table.innerHTML+= (groupdiv+  '<button>View</button></div>');
          }
        }
      }

    } else if (hr.readyState == 4) {
      addNotification('Retrieving data failed with status ' + hr.status
          + '. Try again later.');
    }}

  	hr.send(null);
  }</script>

</body>
</html>
