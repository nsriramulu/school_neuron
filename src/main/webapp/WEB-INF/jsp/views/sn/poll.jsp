<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/img" var="imageURL" />
<h5>POLL RESULTS</h5>
<div id="body-pollResults" class="neuron-div" style="padding: 10px;">
	<div class="row">
		<div class="col-sm-1 col-md-1">
			<img src="${imageURL}/${user.profilePic}" class="img-rounded" alt="Cinque Terre" width="100%" height="100%">
			<span>${post.usersByCreatedBy.firstName}</span>
			<span>${post.usersByCreatedBy.lastName}</span>
		</div>
		<div class="col-sm-11 col-md-11">
			<div class="commentSectionBorder">
				<div id="pollQue">
					<span class="label label-info" style="float:right;margin-top:-2px;font-size:12px;">Poll</span>
					<p style="padding:5px;">Is Shakesphere a good author for English literature?</p>
				</div>
				<div class="row" style="padding:5px;">
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
				<div class="row" style="padding:5px;">
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
				<hr class="neuron-Hline">
				<div class="row">
					<div class="col-sm-7 col-md-7">&nbsp;</div>
					<div class="col-sm-5 col-md-5">
						<c:set var="calendar" value="${post.createdDate}" />
							<span> Updated on - <fmt:formatDate pattern="MMM dd" type="date" value="${calendar.time}" />, <fmt:formatDate type="time" value="${calendar.time}" />
							</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>