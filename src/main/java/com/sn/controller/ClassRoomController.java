package com.sn.controller;

import static com.sn.constants.ApplicationConstants.SELECTED_MENU;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sn.service.PostService;
/**
 * The Class UserSelfServiceController is the major controller for self-service module.
 */
@Controller
@RequestMapping(value = "/sn")
public class ClassRoomController {

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

	@RequestMapping(value = "/classRoom", method = RequestMethod.GET)
	public String getClassRoomPage(ModelMap model) {
		String view = "classRoom";
		try{
			model.put(SELECTED_MENU,"manageClass");
		}
		catch(Exception e){
			view = "error";
		}
		return view;
	}
}
