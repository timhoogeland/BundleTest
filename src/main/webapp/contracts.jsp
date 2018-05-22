<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body onload = "getLoans()">
    
    <jsp:include page="parts/navigation.jsp" />

    <main class="main">
        <div id="welcome_text">
            <h1>Contracts</h1>
            <label id="namelabel"></label>
        </div>

        <button class="addContract" onclick="window.location.href='new_contract.jsp'">New Contract</button>

        <center>
        <div id="contracts" style="overflow-x:auto;overflow-y: auto;">

            <table id='contractstable' class='contracts_table'>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Amount ($)</th>
                        <th>Duration</th>
                        <th>End Date</th>
                        <th>Status</th>
                        <th>View</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td data-label='ID'>1</td>
                        <td data-label='Amount'>1000</td>
                        <td data-label='Duration'>12 months</td>
                        <td data-label='End Date'>17-05-2020</td>
                        <td data-label='Status'>Submited</td>
                        <td data-label=''>
                            <button onclick="window.location.href='contract.jsp'">View</button>
                        </td>
                        <td data-label=''>
                            <button onclick="window.location.href='edit_contract.jsp'">Edit</button>
                        </td>
                    </tr>
                    <tr>
                        <td data-label='ID'>2</td>
                        <td data-label='Amount'>1500</td>
                        <td data-label='Duration'>24 months</td>
                        <td data-label='End Date'>17-05-2021</td>
                        <td data-label='Status'>Submited</td>
                        <td data-label=''>
                            <button onclick="window.location.href='contract.jsp'">View</button>
                        </td>
                        <td data-label=''>
                            <button onclick="window.location.href='edit_contract.jsp'">Edit</button>
                        </td>
                    </tr>
                    <tr>
                        <td data-label='ID'>3</td>
                        <td data-label='Amount'>1000</td>
                        <td data-label='Duration'>12 months</td>
                        <td data-label='End Date'>17-05-2020</td>
                        <td data-label='Status'>Submited</td>
                        <td data-label=''>
                            <button onclick="window.location.href='contract.jsp'">View</button>
                        </td>
                        <td data-label=''>
                            <button onclick="window.location.href='edit_contract.jsp'">Edit</button>
                        </td>
                    </tr>
                    <tr>
                        <td data-label='ID'>4</td>
                        <td data-label='Amount'>1500</td>
                        <td data-label='Duration'>24 months</td>
                        <td data-label='End Date'>17-05-2021</td>
                        <td data-label='Status'>Submited</td>
                        <td data-label=''>
                            <button onclick="window.location.href='contract.jsp'">View</button>
                        </td>
                        <td data-label=''>
                            <button onclick="window.location.href='edit_contract.jsp'">Edit</button>
                        </td>
                    </tr>
                    <tr>
                        <td data-label='ID'>5</td>
                        <td data-label='Amount'>1000</td>
                        <td data-label='Duration'>12 months</td>
                        <td data-label='End Date'>17-05-2020</td>
                        <td data-label='Status'>Submited</td>
                        <td data-label=''>
                            <button onclick="window.location.href='contract.jsp'">View</button>
                        </td>
                        <td data-label=''>
                            <button onclick="window.location.href='edit_contract.jsp'">Edit</button>
                        </td>
                    </tr>
                    <tr>
                        <td data-label='ID'>6</td>
                        <td data-label='Amount'>1500</td>
                        <td data-label='Duration'>24 months</td>
                        <td data-label='End Date'>17-05-2021</td>
                        <td data-label='Status'>Submited</td>
                        <td data-label=''>
                            <button onclick="window.location.href='contract.jsp'">View</button>
                        </td>
                        <td data-label=''>
                            <button onclick="window.location.href='edit_contract.jsp'">Edit</button>
                        </td>
                    </tr>
                    <tbody>
            </table>
        </div>
    </center>
    </main>

    <jsp:include page="parts/footer.jsp" />

</body>
</html>