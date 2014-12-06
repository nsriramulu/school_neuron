<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/resources/scripts" var="jsURL" />
<c:url value="/resources/styles" var="cssURL" />
<c:url value="/resources/images/home" var="imgURL" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>school neuron</title>

<!-- Bootstrap -->
<link href="${cssURL}/bootstrap.min.css" rel="stylesheet">
<link href="${cssURL}/tenant.css" rel="stylesheet">
<link href="${cssURL}/bootstrap-datetimepicker.min.css" rel="stylesheet">
<link href="${cssURL}/bootstrap.icon-large.min.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="admin">
	<div class="container-fluid">

		<!-- header start -->
		<div class="row header">
			<div class="col-sm-7 col-sm-offset-1 header-left"><!-- tenant_image.png -->
				<span class="title"><img src="${imgURL}/logo.png" alt="tenant logo" /></span>
			</div>
			<div class="col-sm-2">
				<div class="row">
					<div class="col-sm-12 paddingTop10">
						<i class="icon-large icon-home"></i> 
						<i class="icon-large icon-globe"><span class="badge"></span></i>
						<i class="icon-large icon-envelope"><span class="badge">2</span></i>
						<i class="icon-large icon-settings"></i> 
						<i class="icon-large icon-off"></i>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-12 col-md-10 col-md-offset-1">
			<div class="row main-content">
				<!-- left content start -->
				<div class="col-sm-4 col-md-4 logged-user-left-container">
					<div class="col-sm-12 logged-user-left">
						<div class="row user-details">
							<div class="col-xs-4 img-container">
								<img src="${imgURL}/profile_image1.jpg" alt="profile image" />
							</div>
							<div class="col-xs-8 personDetails">
								<div>Mr George</div>
								<div>Teacher</div>
								<div>Summer School</div>
								<div>
									<a href="#" class="more">Edit Profile</a>
								</div>
							</div>
						</div>
						<!-- manage content -->
						<div class="row content-head">
							<div class="col-xs-8">Dashboard</div>
						</div>
						<div class="row notification-content last-notification-content">
							<div class="col-xs-4 paraText"><button type="button" id="Manage_Class_Btn" class="dashboard-button">Manage Class</button></div>
							<div class="col-xs-4 paraText"><button type="button" id="Quiz_Poll_Btn" class="dashboard-button">Quiz & Poll</button></div>
							<div class="col-xs-4 paraText"><button type="button" id="Scheduled_Btn" class="dashboard-button">Scheduled</button></div>
							
						</div>
						<div class="row notification-content last-notification-content">
							<div class="col-xs-4 paraText"><button type="button" id="Add_Remove_Class_Btn" class="dashboard-button">Add&nbsp;or Remove Class</button></div>
							<div class="col-xs-4 paraText"><button type="button" id="Message_Btn" class="dashboard-button">Message</button></div>
							<div class="col-xs-4 paraText"><button type="button" id="Others_Btn" class="dashboard-button">Others</button></div>
						</div>
						<!-- manage content end -->
						<!-- notice board content start -->
						<div class="row content-head">
							<div class="col-xs-8">Notice Board</div>
						</div>

						<div class="row notification-content last-notification-content">
							<div class="col-xs-3 img-container">
								<i class="icon-large icon-cup"></i>
							</div>
							<div class="col-xs-9 paraText">Ramkumar(9 th 'C') posted a
								Talent</div>
						</div>
						<div class="row notification-content last-notification-content">
							<div class="col-xs-3 img-container">
								<i class="icon-large icon-bell"></i>
							</div>
							<div class="col-xs-9 paraText">Meeting with principal
								10/12/2014</div>
						</div>
						<div class="row notification-content last-notification-content">
							<div class="col-xs-3 img-container">
								<i class="icon-large icon-question-sign"></i>
							</div>
							<div class="col-xs-9 paraText">Pradeed(6 th 'A') askeed a
								doubt.</div>
						</div>
						<div class="row notification-content last-notification-content">
							<div class="col-xs-3 img-container">
								<i class="icon-large icon-message-new"></i>
							</div>
							<div class="col-xs-9 paraText">You have 10 unread messages.</div>
						</div>
						<div class="row last-notification-content">
							<div class="col-xs-3 img-container"></div>
							<div class="col-xs-9 paraText">
								<a href="#" class="more">View More</a>
							</div>
						</div>
						<hr/>
						<!-- notice board content end -->
						
					</div>
				</div>
				<div>

					<div class="col-md-8 col-sm-8 logged-user-right">

						<div class="tabGroup">
							<!-- Nav tabs -->
							<ul class="nav nav-tabs attribute-tab-items">
								<li class="active col-md-2 text-center"><a href="#update"
									data-toggle="tab">Update</a></li>
								<li class="col-md-2 text-center"><a href="#event"
									data-toggle="tab">Event</a></li>
								<li class="col-md-2 text-center"><a href="#poll"
									data-toggle="tab">Poll</a></li>
								<li class="col-md-2 text-center"><a href="#quiz"
									data-toggle="tab">Quiz</a></li>

							</ul>
						</div>
						<div class="tab-content darkGreyBg">
						<!-- update tab start -->
							<div class="tab-pane active" id="update">
								<div>
									<textarea id="updateText" placeholder="Send an Update to Parents and Students"></textarea>
								</div>
							</div>
							<!-- update tab end -->
							<!-- event tab start -->
							<div class="tab-pane lightGreyBg divBorder" id="event">
							<div class="row need-padding-bottom need-padding-top">
							<div class="col-sm-2 paddingLeft50">Title</div>
											<div class="col-sm-5"><input type="text" id="event_title" placeholder="Title" value="" class=""></div>
											</div>
							<div class="row">
							<div class="col-sm-2 paddingLeft50">Description</div>
											<div class="col-sm-5"><input type="text" id="event_desc" placeholder="Description" value="" class=""></div>
											</div>
							<div class="row">
							<div class="col-sm-2 paddingLeft50">Type</div>
											<div class="col-sm-5"><select id="event_type" class="">
												<option>-- Select --</option>
												<option>Assignment</option>
												<option>Parents Meeting</option>
												<option>Sports</option>
												<option>Cultural</option>
												</select>
											</div>
											</div>
							<div class="row paddingBottom10">
								<div class="col-sm-2 paddingLeft50">Date</div>
								<div class="col-sm-5">
									<div class="form-group">
										<div class="input-group date" id="datetimepicker5"
											data-date-format="YYYY/MM/DD">
											<input type='text' class="form-control dateimp" /> <span
												class="input-group-addon" style="float: left;"> </span>
										</div>
									</div>
								</div>
							</div>
							</div>
							<!-- event tab end -->
							<div class="col-sm-12 paddingTop5">
										<div class="col-sm-5">
										<span class="whiteText"></span>
										<select class="dropdown_module" id="post_class">
											<option>Class</option>
											<option>6th 'D'</option>
											<option>7th 'A'</option>
											<option>10th 'C'</option>
										</select>
										<i class="icon-large icon-attach pointerCursor" id="upload_post"></i> 
										<i class="icon-large icon-alarm pointerCursor" id="schedule_post"></i> 
										<!-- <input type="file" id="post_file" class=""> -->
										</div>
										<div class="col-sm-4">
										</div>
										<div class="col-sm-3">
										<button type="button" id="submit_post" class="continue-button">Send</button>
										</div>
								</div>
							<div class="buttons_module">
								
								<!-- <div class="row need-padding-bottom need-padding-top">
												<div class="col-sm-2 stringtext">Date</div>
												<div class="col-sm-5">
													<div class="form-group">
														<div class="input-group date" id="datetimepicker5"
															data-date-format="YYYY/MM/DD">
															<input type='text' class="form-control dateimp" /> <span
																class="input-group-addon" style="float: left;"> </span>
														</div>
													</div>
												</div>
											</div> -->
							</div>
							<div class="row"></div>
						</div>
						<div class="row">
							<!--post starts-->
							<div class="col-sm-12">
								<div class="row col-sm-9 cmpinfo">
									<div class="col-sm-2">
										<img alt="pic" class="pointerCursor" src="${imgURL}/post_photo.jpg" width="50"
											height="30">
									</div>
									<div class="col-sm-10 leftPaddingZero">
										<span class="pointerWithLine"><b>Teacher Tom Hank's</b></span>
										<span class="subText">Posted an announcement</span>
									</div>
								</div>
								<div class="col-xs-12">
									<p class="navbar-text">Computers were invented to reduce
										human work * *- conditions apply, not applicable for software
										engineers</p>
									<i class="icon-large icon-certificate pointerCursor"></i><span class="pointerWithLine">Appreciate</span> <span class="badge">2</span>
									&nbsp;&nbsp;&nbsp; <i class="icon-large icon-chat pointerCursor"></i><span class="pointerWithLine">Discuss</span> <span class="badge">1</span>
								</div>
								<div class="row col-sm-9 cmpinfo">
									<div class="col-sm-2">
										<img alt="pic" src="${imgURL}/profile_image1.jpg" width="40"
											height="25">
									</div>
									<div class="col-sm-10 leftPaddingZero">
										<input type="text" id="comment" placeholder="Discuss your thoughts..."/>
									</div>
								</div>
							</div>
							<!-- post ends -->
							<hr/>
							<!--post starts-->
							<div class="col-sm-12">
								<div class="row col-sm-9 cmpinfo">
									<div class="col-sm-2">
										<img alt="pic" class="pointerCursor" src="${imgURL}/post_photo.jpg" width="50"
											height="30">
									</div>
									<div class="col-sm-10 leftPaddingZero">
										<span class="pointerWithLine"><b>Teacher Tom Hank's</b></span>
										<span class="subText">Posted an announcement</span>
									</div>
								</div>
								<div class="col-xs-12">
									<p class="navbar-text">Computers were invented to reduce
										human work * *- conditions apply, not applicable for software
										engineers</p>
									<i class="icon-large icon-certificate pointerCursor"></i><span class="pointerWithLine">Appreciate</span> <span class="badge">2</span>
									&nbsp;&nbsp;&nbsp; <i class="icon-large icon-chat pointerCursor"></i><span class="pointerWithLine">Discuss</span> <span class="badge">1</span>
								</div>
								<div class="row col-sm-9 cmpinfo">
									<div class="col-sm-2">
										<img alt="pic" src="${imgURL}/profile_image1.jpg" width="40"
											height="25">
									</div>
									<div class="col-sm-10 leftPaddingZero">
										<input type="text" id="comment" placeholder="Discuss your thoughts..."/>
									</div>
								</div>
							</div>
							<!-- post ends -->
							<hr/>
							<!--post starts-->
							<div class="col-sm-12">
								<div class="row col-sm-9 cmpinfo">
									<div class="col-sm-2">
										<img alt="pic" class="pointerCursor" src="${imgURL}/post_photo.jpg" width="50"
											height="30">
									</div>
									<div class="col-sm-10 leftPaddingZero">
										<span class="pointerWithLine"><b>Teacher Tom Hank's</b></span>
										<span class="subText">Posted an announcement</span>
									</div>
								</div>
								<div class="col-xs-12">
									<p class="navbar-text">Computers were invented to reduce
										human work * *- conditions apply, not applicable for software
										engineers</p>
									<i class="icon-large icon-certificate pointerCursor"></i><span class="pointerWithLine">Appreciate</span> <span class="badge">2</span>
									&nbsp;&nbsp;&nbsp; <i class="icon-large icon-chat pointerCursor"></i><span class="pointerWithLine">Discuss</span> <span class="badge">1</span>
								</div>
								<div class="row col-sm-9 cmpinfo">
									<div class="col-sm-2">
										<img alt="pic" src="${imgURL}/profile_image1.jpg" width="40"
											height="25">
									</div>
									<div class="col-sm-10 leftPaddingZero">
										<input type="text" id="comment" placeholder="Discuss your thoughts..."/>
									</div>
								</div>
							</div>
							<!-- post ends -->
							<!-- post ends -->
							<!--store ends-->
						</div>
						<!-- Tab panes -->

						<form action="" class="submit-form"></form>
					</div>
				</div>
			</div>
		</div>
		<!-- main content end -->
	</div>
<div class="footer col-sm-12">
  <div class="col-sm-10 col-sm-offset-1">
  <div class="col-sm-10">
  © 2014 KBros,all rights reserved</div>
  <div class="col-sm-2 footerLogo">
  <img src="${imgURL}/logo.png" width="90" height="30" alt="footer iamge"></div>
  </div>
  </div>
	<!-- <div class="footer col-sm-12">
  <div class="col-sm-10 col-sm-offset-1">
  <div class="col-sm-10">
  &copy; 2014 Cognizant,all rights reserved</div>
  <div class="col-sm-2 footerLogo">
  <img src="${imgURL}/logo.jpg" width="90" height="30"alt="logo"/>
  </div>
  </div>
  </div> -->

	<!-- footer end -->

	<script src="${jsURL}/jquery.min.js"></script>
	<script src="${jsURL}/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${jsURL}/bootstrap-datetimepicker.min.js"></script>
	<!-- <script src="${jsURL}/jquery.placeholder.js"></script>-->
	<script src="${jsURL}/sn.js"></script>
	<script type="text/javascript">
            $(function () {
                $('#datetimepicker5').datetimepicker({
                    pickTime: false
                });
            });
        </script>
	<!--  <script src="js/popups.js"></script> -->
</body>
</html>