package com.sn.controller;

import static com.sn.constants.ApplicationConstants.SELECTED_MENU;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sn.common.WebContextHolder;
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
public class HomeController {

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

	/** The porfile photo upload path from props file. */
	@Value("${profilePhotoRealPath}")
	private String porfilePhotoPath;


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(ModelMap model,HttpSession session) {
		String view = "home";
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
			session.setAttribute("school", userProfile.getSchool());
			session.setAttribute("user", user);
			List<Post> posts = null;
			if(StringUtils.equalsIgnoreCase("Teacher",user.getRole())){
				session.setAttribute("classSubjectTeachers", classSubjectTeachers);//getUniqueClasses(classSubjectTeachers)
				posts = postService.getPostsForTeacher(WebContextHolder.get().getLoggedInUser().getUid(), classIds);
			}
			else if(StringUtils.equalsIgnoreCase("Parent",user.getRole()) || StringUtils.equalsIgnoreCase("Student",user.getRole())){
				posts = postService.getPostsForStudentOrParent(user.getClassId());
			}
			else if(StringUtils.equalsIgnoreCase("Principal",user.getRole())){
				posts = postService.getPostsForPrincipal();
			}
			session.setAttribute("classSubjectTeachers", classSubjectTeachers);//getUniqueClasses(classSubjectTeachers)
			model.put("posts", posts);
		}
		catch(Exception e){
			view = "error";
		}
		return view;
	}

	private List<ClassSubjectTeacher> getUniqueClasses(List<ClassSubjectTeacher> classSubjectTeachers) {
		List<ClassSubjectTeacher> tempClassSubjectTeachers = null;
		for(ClassSubjectTeacher classSubjectTeacher : classSubjectTeachers){
			if(CollectionUtils.isNotEmpty(tempClassSubjectTeachers)){
				for(ClassSubjectTeacher tempClassSubjectTeacher : tempClassSubjectTeachers){
					if(classSubjectTeacher.getClassesByClassId().getId().intValue() != tempClassSubjectTeacher.getClassesByClassId().getId().intValue()){
						tempClassSubjectTeachers.add(classSubjectTeacher);
						break;
					}
				}
			}
			else{
				tempClassSubjectTeachers = new ArrayList<ClassSubjectTeacher>();
				tempClassSubjectTeachers.add(classSubjectTeacher);
			}
		}
		return tempClassSubjectTeachers;
	}

	@RequestMapping(value = "/manageClass", method = RequestMethod.GET)
	public String getManageClassPage(ModelMap model) {
		String view = "manageClass";
		try{
			model.put(SELECTED_MENU,"manageClass");
		}
		catch(Exception e){
			view = "error";
		}
		return view;
	}
}
