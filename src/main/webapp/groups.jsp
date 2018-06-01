<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body onload=getGroups();>

    <jsp:include page="parts/navigation.jsp" />

	<main>

      <div class="welcomeBlock">
		<h1>Groups</h1>
  </div>
    <div id="groupsdiv"  class="block">

        </div>



    </main>

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
