$(document).ready(function(){

	$(function() {
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
	}); 
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
			var json = { "post" : $('#updateText').val(), "postClass" : $('#eventClass option:selected').attr('id'),
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
		ajaxPost(url,json);
	});
	
	$( ".comment_link" ).click(function(event) {
		postId = $(this).attr('id').split('_comment')[0];
		$('#'+postId+'_commentText').focus();
	});
	
	$( ".commentBox" ).keypress(function(event) {
		if ( event.which == 13 && $(this).val().trim()!='') {
			var $div = $('<div />').appendTo('body');
			$div.addClass('modal-backdrop').css('opacity','0.5');
			var url = "submitComment.do";
			postId = $(this).attr('id').split('_commentText')[0];
			commentCount = $('#'+postId+'_commentCount').text();
			var json = { "postId" : postId, "comment" : $(this).val(), "commentCount" : commentCount};
			ajaxPost(url,json);
		}
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

	$('#updateText').focus(function () {
		$(this).animate({ height: "7em" }, 500); 
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
			var json = { "post" : $('#updateText').val(), "postClass" : $('#postClass option:selected').attr('id'),
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
	if($('#updateText').val().length <= 0){
		$('#postFailureMessage').html("Enter text");
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