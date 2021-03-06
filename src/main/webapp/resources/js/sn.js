$(document).ready(function(){
	
	var brHeight = $(window).height();
	var bodyContainerHeight = $('#bodyContainer').height();
	if(bodyContainerHeight<brHeight)
		$('#bodyContainer').height(brHeight);
	
	$('.neuron-tab').click(function(){
		var divId = $(this).attr('id');
		$('.neuron-tab').removeClass('neuron-div-active');
		$(this).addClass('neuron-div-active');
		$('.neuron-tab-content').hide();
		$('#'+divId+'-content').show();
	});
	
	$('body').on('click', 'a.add_que_ans', function() {
		var ans = $(this).closest('div.row').prev().find('input').val();
		if(ans.length > 0){
			$(this).closest('div.row').before('<div class="form-group"><label class="col-sm-2 control-label" for="inputDesc">Answer: </label><div class="col-sm-8"><input type="text" class="form-control neuron-text" id="inputDesc" placeholder="Enter your answer..."></div></div>');
		} else {
			alert("Please enter some answer.");
		}
	});
	
	$('body').on('click', '#add_more_que', function() {
		addQuestion();
	});
	
	function addQuestion(){
		var queCount = $('#quizQuestionsDiv').find('div.questionDiv').size();
		var queType = $('#queType').val();
		
		var que = $('#quizQuestionsDiv').find('div.questionDiv:last').find('div.form-group').find('input').val();
		if(que.length>0){
			var fldset = '';
			if(queType === 'multiple'){
			 fldset = '<div class="questionDiv">'+
				'<div class="form-group">'+
					'<label class="col-sm-2 control-label" for="inputTitle"><span class="label label-info" style="float:left;font-size:11px;">'+
					(queCount+1)+'</span>Question</label>'+
					'<div class="col-sm-10">'+
						'<input type="text" class="form-control neuron-text" id="inputTitle" placeholder="Enter your question here...">'+
					'</div>'+
				'</div>'+
				'<div class="form-group">'+
					'<label class="col-sm-2 control-label" for="inputDesc">Answer: </label>'+
					'<div class="col-sm-8">'+
						'<input type="text" class="form-control neuron-text" id="inputDesc" placeholder="Enter your answer...">'+
					'</div>'+
				'</div>'+
				'<div class="row">'+
					'<div class="col-sm-8 col-md-8">'+
					'</div>'+
					'<div class="col-sm-2 col-md-2 text-right">'+
						'<a class="add_que_ans" href="#">Add more ans.</a>'+
					'</div>'+
					'<div class="col-sm-2 col-md-2">'+
					'</div>'+
				'</div>'+
				'</div>'+
				'</br>';
			}else{
				fldset = '<fieldset>'+
				'<legend>Que'+(queCount+1)+': </legend>'+
				'<div class="form-group">'+
					'<label class="col-sm-2 control-label" for="inputTitle">Question</label>'+
					'<div class="col-sm-10">'+
						'<input type="text" class="form-control neuron-text" id="inputTitle" placeholder="Enter your question here...">'+
					'</div>'+
				'</div>'+
				'<div class="radio">'+
				  '<div class="col-sm-2"></div>'+
				  '<label class="col-sm-3" ><input type="radio" name="ans'+(queCount+1)+'" value="true" checked>True</label>'+
				'</div>'+
				'<div class="radio">'+
				  '<div class="col-sm-2"></div>'+
				  '<label class="col-sm-3"><input type="radio" name="ans'+(queCount+1)+'" value="false">False</label>'+
				'</div>';
			}
				$('#quizQuestionsDiv').append(fldset);
		} else {
			alert("Please enter the question first for question no "+queCount);
		}
	};
	
	$('#queType').change(function(){
		$(this).closest('form.form-horizontal').find('fieldset').remove();
		addQuestion();
	});

	$('#exampleModal').on('show.bs.modal', function (event) {
		
	  var button = $(event.relatedTarget); // Button that triggered the modal
	  var from = $(button).find('td:first').text();
	  var msg = $(button).find('td:nth-child(2)').text();
	  var recipient = button.data('whatever'); // Extract info from data-* attributes
	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	  var modal = $(this);
	  //modal.find('.modal-title').text('New message to ' + recipient)
	  modal.find('#recipient-name').val(from);
	  modal.find('#message-text').val(msg);
	});
	
//	var count = 1;
//	function addFileUploadEvent(id){
//		$("#updateAtachment"+count).change(function (){
//			$('#attachmentsList').append('<div class="col-md-12"></div>');
//			$('#attachmentsList').find('div:last').append(this);
//			count++;
//			var input = '<input name="updateAtachment'+count+'" id="updateAtachment'+count+'" type="file" style="display:none;">';
//			$('#updateAtachmentDiv').find('span').append(input);
//			addFileUploadEvent('updateAtachment');
//			$('#updateAtachment'+(count-1)).unbind();
//		});
//	}
//	addFileUploadEvent('updateAtachment');
	
	//setInterval(checkForNotifications, 10000);
	
	/*		$(function() {
		$('#datePickerForScheduler').datetimepicker({
			pickTime: false,
			minDate: 1
		});
	});

	$(function() {
		$('#timePickerForScheduler').datetimepicker({
			pickDate : false,
			pick12HourFormat: true
		});
	});

	$(function () {
		$('#datePickerForEvent').datetimepicker({
			pickTime: false,
			minDate: 1
		});
	});

var dataTable = $('#example').dataTable();
	$("#ManageClassSearch").keyup(function() {
		dataTable.fnFilter(this.value);
	}); */
//	var dataTable=$('#example').DataTable( {
//	scrollX: 720
//	} );

//	$("#ManageClassSearch").keyup(function() {
//	dataTable.fnFilter($(this).val());
//	});

	$("#submit-post-btn").click(function(e){
		if(validPost()){
			var $div = $('<div />').appendTo('body');
			$div.addClass('modal-backdrop').css('opacity','0.5');
			var url = "submitPost.do";
			var classId = $('#parentOrStuendClassId').val();
			if($('#postClass option:selected').attr('id')){
				classId = $('#postClass option:selected').attr('id');
			}
			var json = { "post" : $('#updateComments').val(), "postClass" : classId,
					"type" : "update"};
			ajaxPost(url,json);
		}
	});
	
	
	$("#submit-event-btn").click(function(e){
		if(validEvent()){
			var $div = $('<div />').appendTo('body');
			$div.addClass('modal-backdrop').css('opacity','0.5');
			var url = "submitEvent.do";
			var classId = $('#parentOrStuendClassId').val();
			if($('#eventClass option:selected').attr('id')){
				classId = $('#eventClass option:selected').attr('id');
			}
			var json = { "eventTitle" : $('#inputTitle').val(), "eventDesc" : $('#inputDesc').val(), "date" : $('#dateEventTime').val(), "time": $('#timeEventTime').val(), "eventClass" : classId,"type" : "event"};
			ajaxPostWithoutReload(url,json,"Event posted successfullys");
		}
	});
	
	$("#submit-quiz-btn").click(function(e){
		function isValidQuizSet(){
			return true;
		}
		
		if(isValidQuizSet()){
			var $div = $('<div />').appendTo('body');
			$div.addClass('modal-backdrop').css('opacity','0.5');
			var url = 'submitQuiz.do';
			var questionSet = [];
			$('#quizQuestionsDiv').children('div.questionDiv').each(function(){
				var que = {};
				var queText = $(this).find('div.form-group:first').find('input').val();
				que['question'] = queText;
				var ansCount = 0;
				$(this).children('div.form-group').not(':first').each(function(){
					ansCount ++;
					que['answer'+ansCount] = $(this).find('input').val();
				});
				que['answerCount'] = ansCount;
				questionSet.push(que);
			});
			
			var queSetObj = {};
			queSetObj['questions'] = questionSet;
			var jsonStr = JSON.stringify(queSetObj);
			
			var json = {"quizType" : $('#queType').val(), "quizTitle" : $('#quizTitle').val(), "dueDate" : $('#dueDate').val(), "pointPerQue" : $('#pointPerQue').val(), "questionSet" : jsonStr};
			ajaxPostWithoutReload(url,json,"Quiz posted successfullys");
		}
	});
	
	  var files;
	  $("#upload-submit-btn").click(function(){
	         processFileUpload();
	 });
		  $('#document').change(function(){
			  console.log(' event fired'+event.target.files[0].name);
		      files=event.target.files;
		  });
	 function processFileUpload()
	  {
	      var oMyForm = new FormData();
	      oMyForm.append("file", files[0]);
	     $
	        .ajax({
	        	dataType : 'json',
	            url : "uploadDoc",
	            data : oMyForm,
	            type : "POST",
	            enctype: 'multipart/form-data',
	            processData: false, 
	            contentType:false,
	            success : function(data) {
	            $("#document-upload-modal").modal("hide");
	            },
	            error : function(result){
	            	$('#failure-popup-title').text("Error");
					$('#postFailureMessage').html(data.MESSAGE);
					$('#failure-post-popup').modal('show');
	            }
	        });
	  }
	 
	$("#submit-assignment-btn").click(function(e){
		if(validAssignment()){
			var $div = $('<div />').appendTo('body');
			$div.addClass('modal-backdrop').css('opacity','0.5');
			var url = "submitAssignment";
			var classId = $('#parentOrStuendClassId').val();
			if($('#assignmentClass option:selected').attr('id')){
				classId = $('#assignmentClass option:selected').attr('id');
			}
			var json = { "assignmentTitle" : $('#assignmentTitle').val(), "assignmentDesc" : $('#assignmentDesc').val(), "assignmentDate" : $('#assignmentDate').val(), "assignmentClass" : classId,"type" : "assignment"};
			ajaxPostWithoutReload(url,json,"Assignment posted successfully");
		}
	});
	
	$(".student-submit-assignment").click(function(e) {
		id = $(this).attr('id').split('_assignment')[0];
		$("#assignemntIdToSubmit").val(id);
		$("#submit-assignment").modal('show');
	});
	
	$("#assignment-submit-modal").click(function(e) {
		postId = $("#assignemntIdToSubmit").val();
		count = $("#"+postId+"_submittedCount").val();
		var json =  {"postId" : postId,"comment":$("#assignmentComments").val(),"submittedCount":count};
		 $.ajax({
	         url : 'submitOnlineAssignment',
	         data : json,//JSON.stringify($('#userSignUpForm').serializeArray()),
	         dataType: "json",
	         type: "POST",
			cache: false,
	         success : function(data) { 
	      	   if(data.status == 'Failure'){
	      		 $('#failure-popup-title').text("Error");
					$('#postFailureMessage').html(data.MESSAGE);
					$('#failure-post-popup').modal('show');
	      	   }
	      	   else{
//	      		 location.href = data.message;
	      		 $("#submit_online_div").html("<b>Submitted</b>")
	      	   }
	         }
	  });
	});
	
	$('#profilePic').click(function() {
		$('#photp-upload-modal').modal('show');
	});
	

	function ajaxPostWithoutReload(url,json,successMsg){
		$.ajax({
			type: "POST",
			cache: false,
			url: url,
			data: json,
			dataType: "json",
			success: function(data){
				$('.modal-backdrop').remove();
				if(data.STATUS=="SUCCESS"){
//					$('#postSuccessMessage').html(data.MESSAGE);
//					$('#success-post-popup').modal('show');
//					window.location = 'home.do'; 
					$('#failure-popup-title').text("Success");
					$('#postFailureMessage').html(successMsg);
					$('#failure-post-popup').modal('show');
					$('#inputTitle').val("");
					$('#inputDesc').val("");
					$('#dateEventTime').val("");
					$('#timeEventTime').val("");
					$('#eventScheduleDate').val("");
					$('#eventScheduleTime').val("");
					$('#scheduleDate').val("");
					$('#scheduleTime').val("");
					$('#updateComments').val("");
//					$('#eventClass option:selected').removeAttr('selected');
					$('#assignmentTitle').val("");
					$('#assignmentDesc').val("");
					$('#assignmentDate').val("");
				}
				else{
					$('#failure-popup-title').text("Error");
					$('#postFailureMessage').html(data.MESSAGE);
					$('#failure-post-popup').modal('show');
				}
			}
		});
	}
	
	function ajaxPost(url,json){
		$.ajax({
			type: "POST",
			cache: false,
			url: url,
			data: json,
			dataType: "json",
			success: function(data){
				$('.modal-backdrop').remove();
				if(data.STATUS=="SUCCESS"){
//					$('#postSuccessMessage').html(data.MESSAGE);
//					$('#success-post-popup').modal('show');
//					window.location = 'home.do';
					document.location = document.location.href + "?afterReload=true";
				}
				else{
					$('#postFailureMessage').html(data.MESSAGE);
					$('#failure-post-popup').modal('show');
				}
			}
		});
	}
	
	$( ".like_link" ).click(function(event) {
		var $div = $('<div />').appendTo('body');
		$div.addClass('modal-backdrop').css('opacity','0.5');
		var url = "addLike.do";
		postId = $(this).attr('id').split('_like')[0];
		likeCount = $('#'+postId+'_likeCount').text();
		var json = { "postId" : postId, "likeCount" : likeCount};
		$.ajax({
			type: "POST",
			cache: false,
			url: url,
			data: json,
			dataType: "json",
			success: function(data){
				$div.remove();
				if(data.STATUS=="SUCCESS"){
//					$('#postSuccessMessage').html(data.MESSAGE);
//					$('#success-post-popup').modal('show'); JSON.stringify(json)
					$('#'+postId+'_likeCount').text(parseInt(likeCount)+1);
				}
				else{
					$('#postFailureMessage').html(data.MESSAGE);
					$('#failure-post-popup').modal('show');
				}
			}
		});
	});
	
	$( ".comment_link" ).click(function(event) {
		postId = $(this).attr('id').split('_comment')[0];
		if($('#'+postId+'_commentDiv').hasClass('showing')){
		$('#'+postId+'_commentDiv').removeClass('showing');
		$('#'+postId+'_commentDiv').hide();
	}
	else{
		$('#'+postId+'_commentDiv').show();
		$('#'+postId+'_commentDiv').addClass('showing');
		$('#'+postId+'_commentText').focus();
	}
	});
	
	$( ".commentBox" ).keypress(function(event) {
		if ( event.which == 13 && $(this).val().trim()!='') {
			var $div = $('<div />').appendTo('body');
			$div.addClass('modal-backdrop').css('opacity','0.5');
			var url = "submitComment.do";
			postId = $(this).attr('id').split('_commentText')[0];
			commentCount = $('#'+postId+'_commentCount').text();
			var json = { "postId" : postId, "comment" : $(this).val(), "commentCount" : commentCount};
			$.ajax({
				type: "POST",
				cache: false,
				url: url,
				data: json,
				dataType: "json",
				success: function(data){
					$div.remove();
					if(data.STATUS=="SUCCESS"){
//						$('#postSuccessMessage').html(data.MESSAGE);
//						$('#success-post-popup').modal('show'); JSON.stringify(json)
						$('#'+postId+'_commentText').val('');
						$('#'+postId+'_commentCount').text(parseInt(commentCount)+1);
					}
					else{
						$('#postFailureMessage').html(data.MESSAGE);
						$('#failure-post-popup').modal('show');
					}
				}
			});
		}
	});
	
	$("select#messageClassName").on('change',function(){
	    var selectedClass = $(this).children(":selected").attr("id");
	    console.log("classId" +selectedClass);
	    $.ajax({
	        url: "getStudentsByClass", 
	        type: "GET",
	        data: { "classId" :parseInt(selectedClass)},
	        dataType: "json",
	        contentType: 'application/json',
	        async: false,
	        success: function(data) {
	        	//{"MESSAGE":[{"uid":3,"messageConversationses":null,"classSubjectTeachers":null,"postLikes":null,"password":"123","parentId":7,"messageUserses":null,
	        	//"username":"arun","postsesForCreatedBy":null,"role":"Student","gender":"M","userUploadses":null,"firstName":"Arun","postsesForUpdatedBy":null,
	        	//"commentsesForUpdatedBy":null,"lastName":"P","commentLikes":null,"classId":1,"status":1,"isLocked":false,"classeses":null,"email":"arun@gmail.com",
	        	//"profilePic":"default.jpg","schoolses":null,"messageses":null,"commentsesForCreatedBy":null},
	        	//{"uid":5,"messageConversationses":null,"classSubjectTeachers":null,"postLikes":null,"password":"123","parentId":8,"messageUserses":null,
	        	//"username":"Kuldeep","postsesForCreatedBy":null,"role":"Student","gender":"M","userUploadses":null,"firstName":"Kuldeep","postsesForUpdatedBy":null,
	        	//"commentsesForUpdatedBy":null,"lastName":"G","commentLikes":null,"classId":1,"status":1,"isLocked":false,"classeses":null,
	        	//"email":"kuldeep@yahoo.co.in","profilePic":"default.jpg","schoolses":null,"messageses":null,"commentsesForCreatedBy":null}],
	        	//"STATUS":"SUCCESS","TITLE":"SUCCESS"}
	        	if(data.STATUS == 'SUCCESS'){
	        		var totalStudents = Object.keys(data.MESSAGE).length;
	        		var listItems= "<option>- Select Student -</option>";
	        	    for ( var i = 0; i < totalStudents; i++)
	        	    {
	        	        console.log("ID: " + data.MESSAGE[i].uid + " Message " +data.MESSAGE[i].firstName);
	        	        listItems+= "<option id='" + data.MESSAGE[i].uid + "'>" + data.MESSAGE[i].firstName+" "+data.MESSAGE[i].lastName + "</option>";
	        	    }
	        	    $("select#messageStudent").html(listItems);
	        	}
	        	else{
	        	}
	        },
	        error: function(data){
	            //handle any error 
	        }
	    });
	});
	
	$("select#messageStudent").on('change',function(){
	    var selectedClass = $(this).children(":selected").attr("id");
	    console.log("studentId : " +selectedClass);
	    $.ajax({
	        url: "getParentByStudent", 
	        type: "GET",
	        data: { "studentId" :parseInt(selectedClass)},
	        dataType: "json",
	        contentType: 'application/json',
	        async: false,
	        success: function(data) {
	        	if(data.STATUS == 'SUCCESS'){
	        		var totalStudents = Object.keys(data.MESSAGE).length;
	        	    for ( var i = 0; i < totalStudents; i++)
	        	    {
	        	        console.log("ID: " + data.MESSAGE[i].uid + " Message " +data.MESSAGE[i].firstName);
	        	        $("#parentId").val(data.MESSAGE[i].uid);
		        	    $("#parentName").val(data.MESSAGE[i].firstName+" "+data.MESSAGE[i].lastName);
		        	   // $("#toEmail").html('<span class="label label-default">'+data.MESSAGE[i].firstName+' '+data.MESSAGE[i].lastName+' <span class="closeTo"></span></span>'+
		        	    //		'&nbsp;&nbsp;&nbsp;<span class="label label-default">'+ $("select#messageStudent").val()+' <span class="closeTo"></span></span>');
	        	    }
	        	}
	        	else{
	        	}
	        },
	        error: function(data){
	            //handle any error 
	        }
	    });
	});
	
	$("#sendMessage").click(function(e){
		var json = { "subject" : $('#messageSubject').val(), "message" : $('#messageText').val(), "studentId" : $('#messageStudent').children(":selected").attr("id"), "parentId" : $('#parentId').val()};
		$.ajax({
			url: "sendMessage", 
			type: "GET",
			data: json,
			dataType: "json",
			contentType: 'application/json',
			success: function(data) {
				if(data.STATUS == 'SUCCESS'){
					window.location = "messages";
				}
				else{
				}
			},
			error: function(data){
				//handle any error 
			}
		});
	});
//	$('.dashboard-button').click(function() {
//	$(this).css('background-color','#f47121');
//	});

//	$("#homeIcon").click(function(){
//	$(this).attr("src", function(index, attr){
//	return attr.replace("light_blue_img.jpg", "blue_img.jpg");
//	});
//	});

	$('#homeIcon').on('click', function() { 
		window.location = 'home.do'; 
	});

	$('.post_success_btn').on('click', function() { 
		window.location = 'home.do'; 
	});

	$('#updateComments').focus(function () {
		$(this).animate({ height: "5em" }, 500); 
	});
	$("#Manage_Class_Btn, #manageClassIcon").click(function(){
//		if(!$(this).hasClass( "dashboard-button-selected" )){
		$('#manage-class-popup').modal('show');
//		}
	});
	$("#manage_class_submit").click(function(){
		window.location='manageClass.do';
	});

	$("#schedule_post-btn").click(function(){
		if(validPost()){
			$('#schedule-post-popup').modal('show');
		}
	});
	
	
	$("#schedule_event-btn").click(function(){
		if(validEvent()){
			$('#schedule-event-popup').modal('show');
		}
	});
	
	$("#post_schedule_btn").click(function(e){
		if(validPost()){
			var $div = $('<div />').appendTo('body');
			$div.addClass('modal-backdrop').css('opacity','0.5');
			var url = "schedulePost.do";
			var classId = $('#parentOrStuendClassId').val();
			if($('#postClass option:selected').attr('id')){
				classId = $('#postClass option:selected').attr('id');
			}
			var json = { "post" : $('#updateComments').val(), "postClass" : classId,
					"type" : "update", "scheduleDate" : $('#scheduleDate').val(), 
					"scheduleTime" : $('#scheduleTime').val()};
			ajaxPostWithoutReload(url,json,"Post scheduled successfullys");
		}
	});
	
	$("#event_schedule_btn").click(function(e){
		if(validEvent()){
			var $div = $('<div />').appendTo('body');
			$div.addClass('modal-backdrop').css('opacity','0.5');
			var url = "scheduleEvent.do";
			var classId = $('#parentOrStuendClassId').val();
			if($('#eventClass option:selected').attr('id')){
				classId = $('#eventClass option:selected').attr('id');
			}
			var json = { "eventTitle" : $('#inputTitle').val(), "eventDesc" : $('#inputDesc').val(), "date" : $('#dateEventTime').val(), "time": $('#timeEventTime').val(), "eventClass" : classId,"type" : "event", "scheduleDate" : $('#eventScheduleDate').val(), "scheduleTime" : $('#eventScheduleTime').val()};
			ajaxPostWithoutReload(url,json,"Event scheduled successfullys");
		}
	});

	$("#manage_class_submit").click(function(){
		window.location='manageClass.do';
	});
	
	$( ".event-response" ).click(function(event) {
		var response = '';
		var eventId = '';
		if($(this).hasClass("yes")){
			response = '1';
			eventId = $(this).attr('id').split('_yes')[0];
		}
		else if($(this).hasClass("no")){
			response = '0';
			eventId = $(this).attr('id').split('_no')[0];
		}
		else{
			response = '2';
			eventId = $(this).attr('id').split('_maybe')[0];
		}
		var $div = $('<div />').appendTo('body');
		$div.addClass('modal-backdrop').css('opacity','0.5');
		var url = "eventResponse.do";
		var json = { "response" : response, "eventId" : eventId};
		ajaxPost(url,json);
	});
});

function hideSchedulerDiv(){
	$('#scheduleOptions').hide();
	$('#errorMessage').hide();
}
function validPost(){
	if($('#updateComments').val().length <= 0){
		$('#postFailureMessage').html("Enter text");
		//$('#postFailureMessage').val("Enter text");
		$('#failure-post-popup').modal('show');
		return false;
	}
	else if($('#postClass') && $('#postClass option:selected').attr('id') == '0'){
		$('#postFailureMessage').html("Select Class");
		$('#failure-post-popup').modal('show');
		return false;
	}
	return true;
}


function validEvent(){
	if($('#inputTitle').val().length<=0 || $('#inputDesc').val().length <= 0 || $('#dateEventTime').val().length <=0 || $('#timeEventTime').val().length <=0 ){
		$('#postFailureMessage').html("Enter all details");
		$('#failure-post-popup').modal('show');
		return false;
	}
	else if($('#eventClass') && $('#eventClass option:selected').attr('id') == '0'){
		$('#postFailureMessage').html("Select Class");
		$('#failure-post-popup').modal('show');
		return false;
	}
	return true;
}

function validAssignment(){
	if($('#assignmentTitle').val().length<=0 || $('#assignmentDesc').val().length <= 0 || $('#assignmentDate').val().length <=0 ){
		$('#postFailureMessage').html("Enter all details");
		$('#failure-post-popup').modal('show');
		return false;
	}
	else if($('#assignmentClass') && $('#assignmentClass option:selected').attr('id') == '0'){
		$('#postFailureMessage').html("Select Class");
		$('#failure-post-popup').modal('show');
		return false;
	}
	return true;
}

function checkForNotifications(){
    $.ajax({
        url: "checkForNotifications", 
        type: "GET",
        dataType: "json",
        contentType: 'application/json',
        success: function(data) {
        	//{"MESSAGE":"1","STATUS":"SUCCESS","TITLE":"SUCCESS"}
        	if(data.STATUS == 'SUCCESS'){
        		$('#notificationCount').text(data.MESSAGE);
        	   }
        	else{
        	}
        },
        error: function(data){
            //handle any error 
        }
    });
}


	
$(".badge.notice-board-badge.pointerCursor").click(function(e){
	postId = $(post).get(id);//$(this).attr('id').split('_commentText')[0];
	var json = { "postId" : postId};
//	var json = { "subject" : $('#messageSubject').val(), "message" : $('#messageText').val(), "studentId" : $('#messageStudent').children(":selected").attr("id"), "parentId" : $('#parentId').val()};
	$.ajax({
		url: "showComments.do", 
		type: "GET",
		data: json,
		dataType: "json",
		contentType: 'application/json',
		success: function(data) {
			data.text()
			if(data.STATUS == 'SUCCESS'){
				alert(data.MESSAGE);
			}
			else{
			}
		},
		error: function(data){
			//handle any error 
		}
	});
});