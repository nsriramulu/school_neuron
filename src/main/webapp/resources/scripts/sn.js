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
//	    scrollX: 720
//	} );
//	
//	$("#ManageClassSearch").keyup(function() {
//		   dataTable.fnFilter($(this).val());
//		});
	
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
//							$('#postSuccessMessage').html(data.MESSAGE);
//							$('#success-post-popup').modal('show');
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
	
	
	$( ".commentBox" ).keypress(function() {
		var $div = $('<div />').appendTo('body');
		$div.addClass('modal-backdrop').css('opacity','0.5');
		postId = $(this).attr('id');
		commentCount = document.getElementById(postId+"_comment").value;
		var json = { "postId" : postId, "comment" : $('comment'), "commentCount" : commentCount};
		$.ajax({
			type: "POST",
			cache: false,
			url: "submitComment.do",
			data: json,
			dataType: "json",
			success: function(data){
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
	});
	
//	$('.dashboard-button').click(function() {
//	    $(this).css('background-color','#f47121');
//	});
//	
//	$("#homeIcon").click(function(){
//		$(this).attr("src", function(index, attr){
//			return attr.replace("light_blue_img.jpg", "blue_img.jpg");
//		});
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