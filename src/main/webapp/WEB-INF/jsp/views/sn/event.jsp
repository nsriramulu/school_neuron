<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/img" var="imageURL" />
<h5 class="text-info">EVENTS</h5>
<div id="body-assignment" class="neuron-div" style="padding: 10px;">
	<div>
		<img src="${imageURL}/profile-pic.jpg" class="img-circle"
			alt="Cinque Terre" width="30" height="30"> <span><b>Kuldeep</b></span>&nbsp;&nbsp;
		<span>Created an event - </span><span>5min before</span>
	</div>
	<div>
		<div id="event_name">
			<h4>8th Graduation day</h4>
		</div>
		<div id="eventDesc">
			<span>I invite you all to join my 8th Graduation Day at
				Cambridge</span>
		</div>
		<div id="eventDate">
			<span>on </span><span>13th January 2015</span>
		</div>
	</div>
	</br>
	<div class="row">
		<div class="col-sm-4 col-md-4">
			<button type="button" class="btn neuron-btn center-block btn-sm">YES</button>
		</div>
		<div class="col-sm-4 col-md-4">
			<button type="button" class="btn neuron-btn center-block btn-sm">NO</button>
		</div>
		<div class="col-sm-4 col-md-4">
			<button type="button" class="btn neuron-btn center-block btn-sm">MAYBE</button>
		</div>
	</div>
</div>