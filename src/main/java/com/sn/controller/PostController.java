package com.sn.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sn.common.WebContextHolder;
import com.sn.service.PostService;
import com.sn.vo.CommentsVO;


/**
 * The Class UserSelfServiceController is the major controller for self-service module.
 */
@Controller
@RequestMapping(value = "/sn")
public class PostController {
	
	@Autowired
	private MessageSource messages;
	
	@Autowired
	private PostService postService;
	
	public MessageSource getMessages() {
		return messages;
	}
	
	@Value("${profilePhotoRealPath}")
	private String porfilePhotoPath;
	
	@RequestMapping(value = "/submitPost", method = RequestMethod.POST)
	public @ResponseBody String submitPost(ModelMap model,@RequestParam(value = "post") String post,
			@RequestParam(value = "postClass") String postClass,
			@RequestParam(value = "type") String type) {
		return postService.submitUpdate(post, Integer.parseInt(postClass), type,"");
	}
	
	@RequestMapping(value = "/addLike", method = RequestMethod.POST)
	public @ResponseBody String addLike(ModelMap model,@RequestParam(value = "postId") Integer postId,
			@RequestParam(value = "likeCount") Integer likeCount) {
		return postService.addLike(postId, likeCount, WebContextHolder.get().getLoggedInUser().getUid());
	}
	
	@RequestMapping(value = "/submitComment", method = RequestMethod.POST)
	public @ResponseBody String submitComment(ModelMap model,@RequestParam(value = "postId") Integer postId,
			@RequestParam(value = "comment") String comment,
			@RequestParam(value = "commentCount") Integer commentCount) {//test git
		return postService.submitComment(postId, comment, commentCount, WebContextHolder.get().getLoggedInUser().getUid());
	}
	
	@RequestMapping(value = "/schedulePost", method = RequestMethod.POST)
	public @ResponseBody String schedulePost(ModelMap model,@RequestParam(value = "post") String post,
			@RequestParam(value = "postClass") String postClass,
			@RequestParam(value = "type") String type,
			@RequestParam(value = "scheduleDate") String date,
			@RequestParam(value = "scheduleTime") String time) {
		return postService.schedulePost(post, Integer.parseInt(postClass), type, date, time,"");
	}
	
	@RequestMapping(value = "/submitEvent", method = RequestMethod.POST)
	public @ResponseBody String submitEvent(ModelMap model,@RequestParam(value = "eventTitle") String title,
			@RequestParam(value = "eventDesc") String desc,
			@RequestParam(value = "date") String date,
			@RequestParam(value = "time") String time,
			@RequestParam(value = "eventClass") String postClass,
			@RequestParam(value = "type") String type) {
		return postService.submitEvent(title,desc,date,time, Integer.parseInt(postClass), type,"");
	}
//	"" : $('#inputTitle').val(), "" : $('#inputDesc').val(), "" : $('#dateEventTime').val(), "": $('#timeEventTime').val(), 
//	"" : $('#eventClass option:selected').attr('id'),"" : "event"
	@RequestMapping(value = "/scheduleEvent", method = RequestMethod.POST)
	public @ResponseBody String scheduleEvent(ModelMap model,@RequestParam(value = "eventTitle") String title,
			@RequestParam(value = "eventClass") String eventClass,
			@RequestParam(value = "eventDesc") String desc,
			@RequestParam(value = "type") String type,
			@RequestParam(value = "date") String date,
			@RequestParam(value = "time") String time,
			@RequestParam(value = "scheduleDate") String scheduleDate,
			@RequestParam(value = "scheduleTime") String scheduleTime) {
		return postService.scheduleEvent(title, Integer.parseInt(eventClass), type, date, desc,time,scheduleDate,scheduleTime,"");
	}
	
	@RequestMapping(value = "/submitQuiz", method = RequestMethod.POST)
	public @ResponseBody String submitQuiz(ModelMap model,@RequestParam(value = "quizType") String quizType,
			@RequestParam(value = "quizTitle") String quizTitle,
			@RequestParam(value = "dueDate") String dueDate,
			@RequestParam(value = "pointPerQue") String pointPerQue,
			@RequestParam(value = "questionSet") String questionSet) {
		return postService.submitQuiz(quizType,quizTitle,dueDate,pointPerQue, questionSet);
	}
	
	@RequestMapping(value = "/checkForNotifications", method = RequestMethod.GET)
	public @ResponseBody String checkForNotifications() {
		return postService.checkForNotifications();
	}
	
	@RequestMapping(value = "/showComments", method = RequestMethod.GET)
	public @ResponseBody List<CommentsVO> showComments(ModelAndView model,@RequestParam(value = "postId") Integer postId) {//test git
		List<CommentsVO> commentsVO=postService.showComments(postId);
		String view="postMain";
		model= new ModelAndView("postMain");
		/*for(CommentsVO vo:commentsVOs){
			System.out.println(vo.getComment());
			System.out.println(vo.getUsername());
		}*/
		model.addObject("comments", commentsVO);
		return commentsVO;
	}
	
	@RequestMapping(value = "uploadPhoto", method = RequestMethod.POST, headers={"content-type=multipart/form-data"})
	public String uploadPhoto(byte[] uploadData, @RequestParam("profile-photo") CommonsMultipartFile file,
			ModelMap modelMap){
		String pathContext = porfilePhotoPath+File.separator+"profile";//+File.separator+ TenantKeyHelper.getTenantKey();
		//ldapUser.getUserProfileMap().get(UserAttributeNames.ORGANIZATION.getAttributeName());
		File tenantDir = new File(pathContext);
		if (!tenantDir.exists()) {
			tenantDir.mkdir();
		}
		String  file_path = pathContext +File.separator+WebContextHolder.get().getLoggedInUser().getUid()+".jpg" ;
		 
		 if (!file.isEmpty()){
			 String name = file.getOriginalFilename();
			 int index = name.lastIndexOf(".");
			 String ext  = name.substring(index);
			 if(StringUtils.equalsIgnoreCase(ext, ".jpg")||StringUtils.equalsIgnoreCase(ext, ".jpeg")){
				 try{
					 File out = new File ( file_path );
					 byte[] bytes = file.getBytes();
					 BufferedOutputStream stream =	new BufferedOutputStream( new FileOutputStream( out ));
					 stream.write(bytes);
					 stream.close();
//					 ldapUser.getUserProfileMap().put(UserAttributeNames.JPEGPHOTO.getAttributeName(), file_path);
//					 Object object = ServiceProvider.serviceCall("uploadPhoto","java.lang.String", "POST", ldapUser);
//					 if (object != null) {
//						 responseMessage = (String) object;
//					 }
				 }
				 catch (Exception e){
//					 responseMessage = JSONUtils.getErrorJSONRresponse(e.getMessage());
					 e.printStackTrace();
				 }
			 }
//			 responseMessage = JSONUtils.getStringJSONResponse(ResponseStatus.SUCCESS.getCode(),messages.getMessage("photoUpload.Success", new Object[]{}, locale));	
		 }
//		modelMap.addAttribute("message",responseMessage);
		modelMap.addAttribute("selectedMenu", "profile");
//		WebContextHolder.get().getSession().setAttribute("isProfilePicUploaded",UserHelper.isProfilePhotoExists(file_path));
		return "redirect:home";
	}
	
	@RequestMapping(value = "uploadDoc12", method = RequestMethod.POST, headers={"content-type=multipart/form-data"})
	public String uploadDoc(byte[] uploadData, @RequestParam("datafile") CommonsMultipartFile file,
			ModelMap modelMap){
		String pathContext = porfilePhotoPath+File.separator+"docs";//+File.separator+ TenantKeyHelper.getTenantKey();
		//ldapUser.getUserProfileMap().get(UserAttributeNames.ORGANIZATION.getAttributeName());
		File tenantDir = new File(pathContext);
		if (!tenantDir.exists()) {
			tenantDir.mkdir();
		}
		 
		 if (!file.isEmpty()){
			 String name = file.getOriginalFilename();
			 int index = name.lastIndexOf(".");
			 String ext  = name.substring(index);
			 String  file_path = pathContext +File.separator+WebContextHolder.get().getLoggedInUser().getUid()+File.separator+name ;
//			 if(StringUtils.equalsIgnoreCase(ext, ".jpg")||StringUtils.equalsIgnoreCase(ext, ".jpeg")){
				 try{
					 File out = new File ( file_path );
					 byte[] bytes = file.getBytes();
					 BufferedOutputStream stream =	new BufferedOutputStream( new FileOutputStream( out ));
					 stream.write(bytes);
					 stream.close();
//					 ldapUser.getUserProfileMap().put(UserAttributeNames.JPEGPHOTO.getAttributeName(), file_path);
//					 Object object = ServiceProvider.serviceCall("uploadPhoto","java.lang.String", "POST", ldapUser);
//					 if (object != null) {
//						 responseMessage = (String) object;
//					 }
				 }
				 catch (Exception e){
//					 responseMessage = JSONUtils.getErrorJSONRresponse(e.getMessage());
					 e.printStackTrace();
				 }
//			 }
//			 responseMessage = JSONUtils.getStringJSONResponse(ResponseStatus.SUCCESS.getCode(),messages.getMessage("photoUpload.Success", new Object[]{}, locale));	
		 }
//		modelMap.addAttribute("message",responseMessage);
		modelMap.addAttribute("selectedMenu", "profile");
//		WebContextHolder.get().getSession().setAttribute("isProfilePicUploaded",UserHelper.isProfilePhotoExists(file_path));
		return "redirect:home";
	}
}
