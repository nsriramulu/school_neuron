package com.sn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The Class UserSelfServiceController is the major controller for self-service module.
 */
@Controller
@RequestMapping(value = "/sn")
public class LoginController {
	
	@Autowired
	private MessageSource messages;
	
	/**
	 * Gets the messages from resource.
	 *
	 * @return the MessageSource messages
	 */
	public MessageSource getMessages() {
		return messages;
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getHomePage(ModelMap model) {
		String view = "login";
		try{
			
		}
		catch(Exception e){
			view = "error";
		}
		return view;
	}
}
