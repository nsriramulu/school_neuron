<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/img" var="imageURL" />
<h5 class="text-info">POLL RESULTS</h5>
<div id="body-pollResults" class="neuron-div" style="padding: 10px;">
	<div>
		<img src="${imageURL}/profile-pic.jpg" class="img-circle"
			alt="Cinque Terre" width="30" height="30"> <span><b>Kuldeep</b></span>&nbsp;&nbsp;
		<span>Created an event - </span><span>5min before</span>
	</div>
	<div>
		<div id="question">
			<span>Is Shakesphere a good author for English literature? </span>
		</div>
	</div>
	</br>
	<div class="row">
		<div class="col-md-1">YES</div>
		<div class="col-md-10">
			<div class="progress" style="border-radius: 10px;">
				<div class="progress-bar progress-bar-success" role="progressbar"
					aria-valuenow="87" aria-valuemin="0" aria-valuemax="100"
					style="width: 87%; border-radius: 10px;">
					<span class="sr-only">87</span>
				</div>
			</div>
		</div>
		<div class="col-md-1">87</div>
	</div>
	<div class="row">
		<div class="col-md-1">NO</div>
		<div class="col-md-10">
			<div class="progress" style="border-radius: 10px;">
				<div class="progress-bar progress-bar-info" role="progressbar"
					aria-valuenow="9" aria-valuemin="0" aria-valuemax="100"
					style="width: 9%; border-radius: 10px;">
					<span class="sr-only">9</span>
				</div>
			</div>
		</div>
		<div class="col-md-1">9</div>
	</div>
</div>