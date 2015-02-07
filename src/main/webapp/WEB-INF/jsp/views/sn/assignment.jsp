<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/img" var="imageURL" /><h5 class="text-info">ASSIGNMENT</h5>
<div id="body-assignment" class="neuron-div" style="padding: 10px;">
	<div>
		<img src="${imageURL}/${user.profilePic}" class="img-circle"
			alt="Cinque Terre" width="30" height="30"> <span><b>Kuldeep</b></span>&nbsp;&nbsp;
		<span>Created an assignment - </span><span>5min before</span>
	</div>
	<div>
		<h4>Solar System Project</h4>
		<div id="assignmentDesc">
			<span>All students are supposed to create a miniature of Solar
				system. Refer attached.</span>
		</div>
		<div>
			<span>Due on </span><span>13th January 2015</span>
		</div>
	</div>
	</br>
	<div class="row">
		<div class="col-sm-5 col-md-5">
			<img src="${imageURL}/attachment.png" class="img-rounded" width="20"
				height="20" /> <a href="#">Solar System References.pdf</a>
		</div>
		<div class="col-sm-4 col-md-4">&nbsp;</div>
		<div class="col-sm-3 col-md-3">
			<button type="button" class="btn neuron-btn btn-block btn-sm">Download
				Attachment</button>
		</div>
	</div>
</div>