package com.sn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sn.constants.ApplicationConstants;
import com.sn.entity.Post;
import com.sn.entity.User;
import com.sn.service.PostService;

import static com.sn.constants.ApplicationConstants.*;
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
	public String getHomePage(ModelMap model) {
		String view = "home";
		try{
			List<Integer> classIds = new ArrayList<Integer>();
			classIds.add(1);
			classIds.add(2);
			classIds.add(3);
			classIds.add(4);
			classIds.add(5);
			List<Post> posts = postService.getPostsForTeacher(1, classIds);
			model.put("posts", posts);
		}
		catch(Exception e){
			view = "error";
		}
		return view;
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
