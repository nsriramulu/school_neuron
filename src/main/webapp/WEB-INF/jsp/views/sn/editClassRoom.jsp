<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/img" var="imageURL" />
<div id="myClassRoomDiv" class="neuron-div" style="margin-left: 10px; margin-right: 10px;padding: 10px;">
	<div class="table-responsive">
		<div class="row">
			<div class="col-md-7">
				<div class="form-group">
					<label for="className" class="col-md-5 control-label">Class Name</label>
					<div class="col-md-7">
						<input type="text" class="form-control neuron-text"
							id="className">
					</div>
				</div>
			</div>
			<div class="col-md-5">
				&nbsp;
			</div>
		</div>
		</br>
		<div class="row">
			<div class="col-md-7">
				<div class="form-group">
					<label for="className" class="col-md-5 control-label">Class Code</label>
					<div class="col-md-7">
						<input type="text" class="form-control neuron-text" id="classCode" readonly>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<a id="refresh-code-btn" href="#">Refresh code</a>
			</div>
			<div class="col-md-2">
				&nbsp;
			</div>
		</div>
		</br>
		<div class="row">
			<div class="col-md-7">
				<div class="form-group">
					<label for="className" class="col-md-5 control-label">Class Strength</label>
					<span for="className" class="col-md-3">Students <span class="badge">10</span></span>
					<span for="className" class="col-md-3">Parents <span class="badge">10</span></span>
				</div>
			</div>
			<div class="col-md-5">
				<a href="myClassRoom?classId=${classId}">See Details</a>
			</div>
		</div>
		</br>
		<div class="row">
			<div class="col-md-8 checkbox">
				<label class="col-md-8" >Click to lock the classroom to stop others joining
				</label>
				<button type="button" id="lock-btn" class="col-md-4 btn neuron-btn btn-sm">Lock Classroom</button>
			</div>
			<div class="col-md-5">
				
			</div>
		</div>
		<div class="row">
			<div class="col-md-10">
				
			</div>
			<div class="col-md-2">
					<button type="button" id="submit-post-btn" class="btn neuron-btn btn-sm">Save</button>
			</div>
		</div>
	</div>
</div>