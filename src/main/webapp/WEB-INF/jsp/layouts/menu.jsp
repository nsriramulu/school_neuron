<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/images" var="imageURL" />
<c:url value="/resources/styles" var="cssURL" />
<link href="${cssURL}/custom.css" rel="stylesheet">
<!-- dashboard content starts-->
<div class="row content-head">
	<div class="col-xs-8">Dashboard</div>
</div>
<div class="row notification-content last-notification-content">
	<div class="col-xs-4 paraText">
		<c:choose>
			<c:when test="${selectedMenu eq 'manageClass'}">
				<button type="button" id="Manage_Class_Btn"
					onclick=""
					class="dashboard-button-selected">Manage Class</button>
			</c:when>
			<c:otherwise>
				<button type="button" id="Manage_Class_Btn"
					onclick="" class="dashboard-button">Manage
					Class</button>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="col-xs-4 paraText">
		<button type="button" id="Quiz_Poll_Btn" class="dashboard-button">Quiz
			& Poll</button>
	</div>
	<div class="col-xs-4 paraText">
		<button type="button" id="Scheduled_Btn" class="dashboard-button">Scheduled</button>
	</div>
</div>
<div class="row notification-content last-notification-content">
	<div class="col-xs-4 paraText">
		<button type="button" id="Add_Remove_Class_Btn"
			class="dashboard-button">Add&nbsp;or Remove Class</button>
	</div>
	<div class="col-xs-4 paraText">
		<button type="button" id="Message_Btn" class="dashboard-button">Message</button>
	</div>
	<div class="col-xs-4 paraText">
		<button type="button" id="Others_Btn" class="dashboard-button">Others</button>
	</div>
</div>
<!-- dashboard content end -->
<!-- manage class modal dialog start-->
  <div class="modal fade" id="manage-class-popup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="popup-header">
        <span class="modal-title">Select Class(s)</span>
        <span class="close" data-dismiss="modal" aria-hidden="true"><img src="${imageURL}/close_icon.png"/></span>
      </div>
      <div class="modal-body container-fluid">
<div class="row">
<div class="popup-text col-sm-8  padding-bottom-required check-option">
<label class="blue"><input type="checkbox" name="characterReq"><span id="classmanagement"></span><div class="textOnImage">6th B</div></label>
<label class="blue"><input type="checkbox" name="characterReq" ><span id="classmanagement"></span><div class="textOnImage">7th A</div></label>
<label class="blue"><input type="checkbox" name="characterReq" ><span id="classmanagement"></span><div class="textOnImage">9th D</div></label>
<label class="blue"><input type="checkbox" name="characterReq" ><span id="classmanagement"></span><div class="textOnImage divVCenter divCenter">10th C</div></label>
</div>  
</div>
</div>
<div class="row">
<div class="col-sm-offset-4 col-xs-8">
<div class="col-xs-6">
<button type="button" id="manage_class_submit" class="continue-button1">Submit</button>
</div>
<div class="col-xs-6">
<button type="button" class="cancel-button2" data-dismiss="modal">Cancel</button></div>
</div>
</div>
</div>
    </div>
  </div>
<!-- manage class modal dialog end -->