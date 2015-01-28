<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/img" var="imageURL" />
<h5 class="text-info">PRIVATE MESSAGE</h5>
<p>
	<em>Send message to specific student/parent of a specific class</em>
</p>
<div id="body-private-message" class="neuron-div">
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label for="className" class="col-md-5 control-label">Class
					Name</label>
				<div class="col-md-7">
					<select class="form-control" id="messageClassName"
						style="border-radius: 10px; background: #e9eaec; height: 25px; font-size: 11px;">
						<option id="0">- Select Class -</option>
					<c:forEach items="${classSubjectTeachers}" var ="classSubjectTeacher">
								<option id="${classSubjectTeacher.classesByClassId.id}">${classSubjectTeacher.classesBySubjectId.subjectName} - ${classSubjectTeacher.classesByClassId.className}</option>
							</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label for="student" class="col-md-4 control-label">Student</label>
				<div class="col-md-8">
					<select class="form-control" id="messageStudent"
						style="border-radius: 10px; background: #e9eaec; height: 25px; font-size: 11px;">
						<option>- Select Student -</option>
					</select>
				</div>
			</div>
		</div>
	</div>
	</br>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="form-group">
				<label for="parentName" class="col-md-5 control-label">Parent
					Name</label>
				<div class="col-md-7">
					<input type="text" class="form-control"
						style="background: #e9eaec; border-radius: 10px; border: none; height: 25px; font-size: 11px;"
						id="parentName" disabled="disabled"/>
						<input type="hidden" id="parentId" name="parentId"/>
				</div>
			</div>
		</div>
		<div class="col-md-3"></div>
	</div>
	<hr>
	<div class="row">
		<div class="form-group">
			<div class="col-md-12" style="margin-top: 1px; margin-bottom: 1px;">
				<input type="text" class="form-control" placeholder="To"
					style="background: #e9eaec; border-radius: 10px; border: none; height: 25px; font-size: 11px;"
					id="toEmail">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-12" style="margin-top: 1px; margin-bottom: 1px;">
				<input type="text" class="form-control" placeholder="Subject"
					style="background: #e9eaec; border-radius: 10px; border: none; height: 25px; font-size: 11px;"
					id="messageSubject">
			</div>
		</div>
		<div class="form-group">

			<div class="col-md-12" style="margin-top: 1px; margin-bottom: 1px;">
				<textarea rows="3" class="form-control" id="messageText"
					style="background: #e9eaec;" placeholder="Message"></textarea>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-1 col-md-1">
				<span class="btn btn-default btn-file"> <img
					src="${imageURL}/attachment.png" class="img-rounded" width="20"
					height="20" /><input name="updateAtachment" id="updateAtachment"
					type="file">
				</span>
			</div>
			<div class="col-sm-8 col-md-8"></div>
			<div class="col-sm-3 col-md-3">
				<button type="button" class="btn neuron-btn btn-block btn-sm" id="sendMessage">Send</button>
			</div>
		</div>
	</div>
</div>
