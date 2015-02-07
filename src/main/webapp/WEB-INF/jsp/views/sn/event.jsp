<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/img" var="imageURL" />
<h5 class="text-info">EVENTS</h5>

<c:choose>
		<c:when test="${fn:length(posts) gt 0}">
			<c:forEach var="post" begin="0" end="${fn:length(posts)-1}"
				items="${posts}">
				<div id="body-assignment" class="neuron-div" style="padding: 10px;">
	<div>
		<img src="${imageURL}/${post.usersByCreatedBy.profilePic}" class="img-circle"
			alt="Cinque Terre" width="30" height="30"> <span><b>${post.usersByCreatedBy.role}
									${post.usersByCreatedBy.firstName}
									${post.usersByCreatedBy.lastName}</b></span>&nbsp;&nbsp;
									<c:set var="calendar" value="${post.createdDate}" />
		<span>Created an event on - </span><span><fmt:formatDate pattern="MMM dd" type="date"
									value="${calendar.time}" />, <fmt:formatDate type="time"
									value="${calendar.time}" /></span>
	</div>
	<div>
		<div id="event_name">
			<h4>${post.eventTitle}</h4>
		</div>
		<div id="eventDesc">
			<span>${post.eventDesc}</span>
		</div>
		<div id="eventDate">
		<c:set var="eventDate" value="${post.eventDate}" />
			<span>on </span><span><fmt:formatDate pattern="MMM dd" type="date"
									value="${eventDate.time}" />, <fmt:formatDate type="time"
									value="${eventDate.time}" /></span>
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
	<br/>
	</c:forEach>
	</c:when>
	</c:choose>
