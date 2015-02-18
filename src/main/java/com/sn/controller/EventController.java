package com.sn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.sn.common.WebContextHolder;
import com.sn.constants.ApplicationConstants;
import com.sn.entity.ClassSubjectTeacher;
import com.sn.entity.Post;
import com.sn.entity.User;
import com.sn.service.PostService;
import com.sn.vo.UserProfileVO;
/**
 * The Class UserSelfServiceController is the major controller for self-service module.
 */
@Controller
@RequestMapping(value = "/sn")
public class EventController {

	@Autowired
	private MessageSource messages;
	@Autowired
	private PostService postService;
	/**
	 * Gets the messages from resource.
	 *
	 * @return the MessageSource messages
	 */
	public MessageSource getMessages() {
		return messages;
	}

	@Value("${profilePhotoRealPath}")
	private String porfilePhotoPath;

	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public String getEventsPage(ModelMap model,HttpSession session) {
		String view = "event";
		try{
			List<Integer> classIds = new ArrayList<Integer>();
			UserProfileVO userProfile = WebContextHolder.get().getLoggedInUserProfile();
			User user = userProfile.getUser();
			List<ClassSubjectTeacher> classSubjectTeachers = userProfile.getClasses();
			if(classSubjectTeachers!=null){
				for(ClassSubjectTeacher classObj : userProfile.getClasses()){
					classIds.add(classObj.getClassesByClassId().getId());
				}
			}
			List<Post> posts = null;
			if(StringUtils.equalsIgnoreCase(ApplicationConstants.TEACHER_ROLE,user.getRole())){
				session.setAttribute("classSubjectTeachers", classSubjectTeachers);//getUniqueClasses(classSubjectTeachers)
				posts = postService.getPostsForTeacher(WebContextHolder.get().getLoggedInUser().getUid(), classIds,ApplicationConstants.POSTS_FOR_EVENT_PAGE);
			}
			else if(StringUtils.equalsIgnoreCase(ApplicationConstants.PARENT_ROLE,user.getRole()) || StringUtils.equalsIgnoreCase(ApplicationConstants.STUDENT_ROLE,user.getRole())){
				posts = postService.getPostsForStudentOrParent(user.getClassId());
			}
			else if(StringUtils.equalsIgnoreCase(ApplicationConstants.PRINCIPAL_ROLE,user.getRole())){
				posts = postService.getPostsForPrincipal();
			}
			model.put("posts", posts);
		}
		catch(Exception e){
			view = "error";
		}
		return view;
	}
	
	@RequestMapping(value = "/eventResponse", method = RequestMethod.POST)
	public @ResponseBody String respondToEvent(ModelMap model,@RequestParam(value = "response") Integer response,
			@RequestParam(value = "eventId") Integer eventId) {
		return postService.respondToEvent(response, eventId, WebContextHolder.get().getLoggedInUser().getUid());
	}
}
