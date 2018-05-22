<!DOCTYPE html>
<html lang="en">

<jsp:include page="parts/head.jsp" />

<body >
    
    <jsp:include page="parts/navigation.jsp" />

	<main class="main">
        <div id="welcome_text">
            <h1>Edit Loan</h1>
            <form>
                <ul class="flex-outer">

                    
                    <li>
                        <label for="loan-type">Loan type</label>
                        <select name="loan-type" id="loan-type">
                            <option value="ST">Short-term</option>
                            <option value="MT">Mid-term</option>
                            <option value="LT">Long-term</option>
                        </select>
                    </li>
                    <li>
                        <label for="loan-status">Loan status</label>
                        <select name="loan-status" id="loan-status">
                            <option value="ACTIVE">Active</option>
                            <option value="DEFAULTED">Defaulted</option>
                            <option value="TERMINATED">Terminated</option>
                        </select>
                    </li>
                    <li>
                        <label for="amount">Remaining Amount</label>
                        <input id="amount" placeholder="Enter the loan-amount here"></input>
                    </li>
                    <li>
                        <label for="duration">Duration</label>
                        <input type="number" duration" min="1" max="36" placeholder="Enter the loan-duration here"></input>
                    </li>
                    <li>
                        <button type="submit">Submit</button>
                    </li>
                </ul>
            </form>
        </div>
    </main>
	
    <jsp:include page="parts/footer.jsp" />

</body>
</html>