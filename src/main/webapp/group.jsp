<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body>

    <jsp:include page="parts/navigation.jsp" />

	<main>
    <h1>Group</h1>
    <button class="buttonRound" onclick="toggleHide('helpPopup', false)">?</button>
    <button class="buttonRound" onclick="window.location.href='new_contract.jsp'">+</button>


    <div class="block">



    <div id="GroupTable"">
      <table id='contractstable' class='contracts_table'>
        <thead>
          <tr class="desktop">
            <th>Name</th>
            <th>Amount ($)</th>
            <th>Progress</th>
            <th>Time Remaining</th>
            <th>Status</th>
            <th>View</th>
            <th>Edit</th>
          </tr>
        </thead>
        <tbody>
        <tbody>
      </table>
    </div>
    </div>
    </main>

    <jsp:include page="parts/footer.jsp" />

    <div id="helpPopup" class="popup" style="display: none;">
    <div>
      <h2>Contracts explained</h2>
      <button class="buttonRound" onclick="toggleHide('helpPopup', true)">X</button>
      <p>
        Lorem ipsum dolor sit amet, pretium leo sed, ac leo aenean tellus, orci amet maxime amet sed nunc pharetra, scelerisque tristique pretium morbi scelerisque mollis sed, vivamus pede irure ac lacus. Diam ante sit amet, blandit laoreet interdum sem pellentesque. Sit turpis ligula non, iaculis viverra.
        Lorem ipsum dolor sit amet, pretium leo sed, ac leo aenean tellus, orci amet maxime amet sed nunc pharetra, scelerisque tristique pretium morbi scelerisque mollis sed, vivamus pede irure ac lacus. Diam ante sit amet, blandit laoreet interdum sem pellentesque. Sit turpis ligula non, iaculis viverra.
      </p>
    </div>
    </div>


  </main>

  <jsp:include page="parts/footer.jsp" />
<script>
  function getGroup() {
    var hr = new XMLHttpRequest();
    hr.open("GET", "/bundlePWABackend/restservices/loangroup/"+1, true);

    hr.onreadystatechange = function() {
      if (hr.readyState == 4 && hr.status == 200) {
        var data = JSON.parse(hr.responseText);

        var datalength = data.length;
        $('#mainLoader').fadeOut('fast');
        var table = document.getElementById('GroupTable');
        data.forEach(function(object) {

          var hr2 = new XMLHttpRequest();
          hr2.open("GET", "/bundlePWABackend/restservices/user/"+1, true);

          hr2.onreadystatechange = function() {
             if (hr.readyState == 4 && hr.status == 200) {
                var data2 = JSON.parse(hr2.responseText);
          var tr = document.createElement('tr');

          tr.innerHTML = '<td class="name" id="name" data-label="Name">'
              + data2.firstName+data2.lastName + '</td>'
              + '<td id ="amount" data-label="Amount">'
              + object.amount + '</td>'
              + '<td id = "duration" data-label="Time Remaining">'
              + object.duration + " months" + '</td>'
              +'<td id = "duration" data-label="Time Remaining">'
              + '<progress value= '+object.paidamount.toString()+ ' max= '+object.amount.toString()+'></progress>'
              + '<td id = "closingdate" data-label="End Date">'
              + object.closingdate + '</td>'
              + '<td id="status" data-label="Status">'
              + object.status + '</td>'
              + '<td id = "loantype" data-label="Loan Type">'
              + object.loantype + '</td>'
              + "<td class='tdHide'>  <button class='small' onclick='toViewContract("
              + object.loanId + ");'>View</button> " +
                  "<button class='small' onclick='toEditContract("
              + object.loanId + ");'>Edit</button> </td>";
          table.appendChild(tr);
        }});
      } else if (hr.readyState == 4) {
        addNotification('Retrieving data failed with status ' + hr.status
            + '. Try again later.');
      }
    }
    hr.send(null);
  }
</script>
</body>
</html>
