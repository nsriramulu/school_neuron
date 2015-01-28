package com.sn.controller;

import static com.sn.constants.ApplicationConstants.SELECTED_MENU;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
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
import com.sn.service.PostService;
import com.sn.vo.UserProfileVO;
/**
 * The Class UserSelfServiceController is the major controller for self-service module.
 */
@Controller
@RequestMapping(value = "/sn")
public class PollController {

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

	@RequestMapping(value = "/polls", method = RequestMethod.GET)
	public String getPollsPage(ModelMap model) {
		String view = "poll";
		try{
			model.put(SELECTED_MENU,"manageClass");
		}
		catch(Exception e){
			view = "error";
		}
		return view;
	}
}
