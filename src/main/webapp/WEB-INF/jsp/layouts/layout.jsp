<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<c:url value="/resources/js" var="jsURL" />
<c:url value="/resources/css" var="cssURL" />
<c:url value="/resources/img" var="imageURL" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>School Neuron</title>
    <link href="${cssURL}/bootstrap.min.css" rel="stylesheet">
	<link href="${cssURL}/neuron.css" rel="stylesheet">
  </head>
  <body>
	<div class="container-fluid" style="background:#e9eaec;">
		<tiles:insertAttribute name="header" />
		<div class="row">
			<div class="col-sm-1 col-md-1">
			</div>
			<div id="bodyContainer" class="col-sm-10 col-md-10">
				</br>
				
				</br>
				<div class="row">
					<div class="col-sm-3 col-md-3">
						<div class="left-section-2">
							<div id="myProfile-div">
								<div class="left-panel-neuron-div" style="height:95px;">
									<div class="row" style="padding:12px;">
										<div class="col-sm-4 col-md-4">
											<img src="${imageURL}/${user.profilePic}" class="img-rounded" alt="Cinque Terre" width="60px;" height="60px;">
										</div>
										<div class="col-sm-8 col-md-8" style="line-height: 20px;">
											<p>${user.firstName} ${user.lastName}</br> ${user.role} <br/>${school.name}</p>
										</div>
									</div>
								</div>
							</div>
							<input type="hidden" id="parentOrStuendClassId" value="${user.classId}"/>
							<security:authorize access="hasAnyRole('Principal,Teacher')">
							
							<div id="myClassRoosm-div" class="leftPanelSubHeader">
								<div class="text-center padding5">
									<span class="text-info" style="padding: 5px">MY CLASSROOMS
									</span>
								</div>
								<c:forEach var ="classSubjectTeacher" items="${classSubjectTeachers}">
								<div class="left-panel-neuron-div">
									<a href="myClassRoom?classId=${classSubjectTeacher.classesByClassId.id}">${classSubjectTeacher.classesBySubjectId.subjectName} - ${classSubjectTeacher.classesByClassId.className}</a>
								</div>
								</c:forEach>
							</div>
							</security:authorize>
							
							<div id="actions-div"  class="leftPanelSubHeader">
							<div class="text-center padding5">
							<span class="text-info" style="padding: 5px">ACTIONS</span>
								</div>
								<div class="neuron-div">
									 <security:authorize access="hasAnyRole('Principal,Teacher')">
									<div class="left-panel-neuron-div">
										<a href="classRoom">Create Classroom</a>
									</div>
									</security:authorize>
									<div class="left-panel-neuron-div">
									<a href="messages">Private Messages</a>
									</div>
								</div>
							</div>
							<div id="noticeBoard-div"  class="leftPanelSubHeader">
							<div class="text-center padding5">
								<span class="text-info" style="padding: 5px">NOTICEBOARD</span>
								</div>
								<div class="neuron-div">
									<div class="left-panel-neuron-div"><a href="events">Events</a></div>
									<div class="left-panel-neuron-div"><a href="assignments">Assignments</a></div>
									<div class="left-panel-neuron-div"><a href="polls">Polls</a></div>
								</div>
							</div>
						</div>
					</div>
					<div id="body-home" class="col-sm-9 col-md-9">
						<security:authorize access="hasAnyRole('Principal,Teacher,Student')">
						<tiles:insertAttribute name="postTab"/>
						</security:authorize>
						<tiles:insertAttribute name="body" />
					</div>
					
				</div>
			</div>
			<div class="col-sm-1 col-md-1">
			</div>
		</div>
	</div>
    <script src="${jsURL}/jquery.js"></script>
	<script src="${jsURL}/bootstrap.min.js"></script>
	<script src="${jsURL}/sn.js"></script>
  </body>
</html>