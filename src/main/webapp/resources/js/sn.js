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
	
	var count = 1;
	function addFileUploadEvent(id){
		$("#updateAtachment"+count).change(function (){
			$('#attachmentsList').append('<div class="col-md-12"></div>');
			$('#attachmentsList').find('div:last').append(this);
			count++;
			var input = '<input name="updateAtachment'+count+'" id="updateAtachment'+count+'" type="file">';
			$('#updateAtachmentDiv').find('span').append(input);
			addFileUploadEvent('updateAtachment');
			$('#updateAtachment'+(count-1)).unbind();
		});
	}
	addFileUploadEvent('updateAtachment');
	
	setInterval(checkForNotifications, 10000);
	
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
			var json = { "post" : $('#updateComments').val(), "postClass" : $('#postClass option:selected').attr('id'),
					"type" : "update"};
			ajaxPost(url,json);
		}
	});
	
	
	$("#submit-event-btn").click(function(e){
		if(validEvent()){
			var $div = $('<div />').appendTo('body');
			$div.addClass('modal-backdrop').css('opacity','0.5');
			var url = "submitEvent.do";
			var json = { "eventTitle" : $('#event_title').val(), "eventDesc" : $('#event_desc').val(), "date" : $('#datePickerForEvent').find('input[type=text]').val(), "eventClass" : $('#eventClass option:selected').attr('id'),"type" : "event"};
			ajaxPost(url,json);
		}
	});
	
	
	function ajaxPost(url,json){
		$.ajax({
			type: "POST",
			cache: false,
			url: url,
			data: json,
			dataType: "json",
			success: function(data){
				var $div = $('<div />').appendTo('body');
				$div.remove();
				if(data.STATUS=="SUCCESS"){
//					$('#postSuccessMessage').html(data.MESSAGE);
//					$('#success-post-popup').modal('show');
					window.location = 'home.do';
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
			$('#schedule-options-popup').modal('show');
		}
	});
	
	
	$("#schedule_event-btn").click(function(){
		if(validEvent()){
			$('#schedule-options-popup').modal('show');
		}
	});
	
	$("#post_schedule_btn").click(function(e){
		if(validPost()){
			var $div = $('<div />').appendTo('body');
			$div.addClass('modal-backdrop').css('opacity','0.5');
			var url = "schedulePost.do";
			var json = { "post" : $('#updateComments').val(), "postClass" : $('#postClass option:selected').attr('id'),
					"type" : "update", "date" : $('#datePickerForScheduler').find('input[type=text]').val(), 
					"time" : $('#timePickerForScheduler').find('input[type=text]').val()};
			ajaxPost(url,json);
		}
	});

	$("#manage_class_submit").click(function(){
		window.location='manageClass.do';
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
	else if($('#postClass option:selected').attr('id') == '0'){
		$('#postFailureMessage').html("Select Class");
		$('#failure-post-popup').modal('show');
		return false;
	}
	return true;
}


function validEvent(){
	if($('#event_title').val().length<=0 || $('#event_desc').val().length <= 0 || $('#datePickerForEvent').find('input[type=text]').val().length <=0){
		$('#postFailureMessage').html("Enter all details");
		$('#failure-post-popup').modal('show');
		return false;
	}
	else if($('#eventClass option:selected').attr('id') == '0'){
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