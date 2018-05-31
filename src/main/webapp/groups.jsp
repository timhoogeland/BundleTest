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

</body>
</html>
