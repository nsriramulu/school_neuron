<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/img" var="imageURL" />
  
  
  <div id="headerDiv" class="row" style="background:#1f4c5e;">
     <div class="col-xs-3 col-sm-3 col-md-3" style="color:white;">
      <h4><b>SCHOOL</b>NEURON</h4>
     </div>
     <div class="col-xs-4 col-sm-4 col-md-6" >
      <input type="text" id="search" placeholder="&nbsp;&nbsp;Search..." style="margin-top:7px;">
     </div>
     <div class="col-xs-5 col-sm-5 col-md-3" >
      <a href="home.do">
		<img src="${imageURL}/home.png" width="34" height="30" style="margin-top:5px;">
	  </a> &nbsp;&nbsp;
	  <img src="${imageURL}/mail.png" width="34" height="30" style="margin-top:5px;"><span id="messageCount" class="badge header-badge">5</span>&nbsp;&nbsp; 
	  <img src="${imageURL}/notification.png" width="30" height="30" style="margin-top:5px;"><span id="notificationCount" class="badge header-badge"></span>&nbsp;&nbsp;
      <a href="../logout.do"><img src="${imageURL}/${user.profilePic}" class="img-circle" alt="Cinque Terre" width="30" height="30" style="margin-top:5px;" title="Logout"></a>
     </div>
    </div>