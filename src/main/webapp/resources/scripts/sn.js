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
			var json = { "post" : $('#updateText').val(), "postClass" : $('#postClass option:selected').attr('id'),
					"type" : "update"};
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
//						$('#success-post-popup').modal('show');
						window.location = 'home.do';
					}
					else{
						$('#postFailureMessage').html(data.MESSAGE);
						$('#failure-post-popup').modal('show');
					}
				}
			});
		}
	});

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

	$("#post_schedule_btn").click(function(e){
		if(validPost()){
			var $div = $('<div />').appendTo('body');
			$div.addClass('modal-backdrop').css('opacity','0.5');
			var url = "schedulePost.do";
			var json = { "post" : $('#updateText').val(), "postClass" : $('#postClass option:selected').attr('id'),
					"type" : "update", "date" : $('#datePickerForScheduler').find('input[type=text]').val(), 
					"time" : $('#timePickerForScheduler').find('input[type=text]').val()};
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
//						$('#success-post-popup').modal('show');
						window.location = 'home.do';
					}
					else{
						$('#postFailureMessage').html(data.MESSAGE);
						$('#failure-post-popup').modal('show');
					}
				}
			});
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