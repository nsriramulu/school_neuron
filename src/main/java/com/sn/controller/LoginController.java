package com.sn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sn.common.WebContextHolder;

/**
 * The Class UserSelfServiceController is the major controller for self-service module.
 */
@Controller
//@RequestMapping(value = "/sn")
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
	
	/**
	 * Sessionexpirted.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/sessionExpired", method = RequestMethod.GET)
	public String sessionexpirted(ModelMap model) {
		WebContextHolder.get().getSession().invalidate();
		return "session-expired";
	}
	
	/**
	 * Display error page.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "error", method = RequestMethod.GET)
	public String displayErrorPage(ModelMap model) {
		return "error";
	}
}
