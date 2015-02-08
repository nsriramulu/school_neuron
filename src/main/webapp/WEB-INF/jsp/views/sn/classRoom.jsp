<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h5>CREATE CLASSROOM</h5>
<div id="body-create-classroom" class="neuron-div">
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label for="className" class="col-md-5 control-label">Class Name</label>
				<div class="col-md-7">
					<input type="text" class="form-control neuron-text"
						id="className">
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label for="grade" class="col-md-4 control-label">Grade</label>
				<div class="col-md-8">
					<select class="form-control neuron-select" id="grade">
						<option>- Select Grade -</option>
						<option>Physics - 6A</option>
						<option>Mathematics - 8C</option>
					</select>
				</div>
			</div>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<div class="col-md-12">Invite By Email</div>
				<div class="col-md-12" style="margin-top: 1px; margin-bottom: 1px;">
					<textarea rows="3" class="form-control"
						style="background: #e9eaec; border: none; font-size: 11px;"
						placeholder="Enter Email Addresses to invite"></textarea>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<div class="col-md-12">Share Classroom Code</div>
				<div class="col-md-12" style="margin-top: 1px; margin-bottom: 1px;">
					<textarea readonly rows="3" class="form-control"
						style="background: #e9eaec; border: none; font-size: 11px;">Click on Generate Code to dynamically allocate a specific code to this classroom and share it with the students/parents</textarea>
				</div>
			</div>
		</div>
	</div>
	</br>
	<div class="row">
		<div class="col-sm-1 col-md-1">&nbsp;</div>
		<div class="col-sm-4 col-md-4">
			<button type="button" class="btn neuron-btn btn-sm">Send
				Invite</button>
		</div>
		<div class="col-sm-1 col-md-1">&nbsp;</div>
		<div class="col-sm-1 col-md-1">&nbsp;</div>
		<div class="col-sm-4 col-md-4">
			<button type="button" class="btn neuron-btn btn-sm">Generate
				Code</button>
		</div>
		<div class="col-sm-1 col-md-1">&nbsp;</div>
	</div>
</div>