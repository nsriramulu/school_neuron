package com.sn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sn.common.WebContextHolder;
import com.sn.entity.User;
import com.sn.service.UserService;

/**
 * The Class UserSelfServiceController is the major controller for self-service module.
 */
@Controller
//@RequestMapping(value = "/sn")
public class LoginController {
	
	@Autowired
	private MessageSource messages;
	@Autowired
	private UserService userService;
	
	/**
	 * Gets the messages from resource.
	 *
	 * @return the MessageSource messages
	 */
	public MessageSource getMessages() {
		return messages;
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(ModelMap model) {
		String view = "login";
		try{
			
		}
		catch(Exception e){
			view = "error";
		}
		return view;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		User user = WebContextHolder.get().getLoggedInUser();
		userService.updateLogoutTime(user);
		System.out.println("User id : "+user.getUid());
	    CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY);
	    SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
	    cookieClearingLogoutHandler.logout(request, response, null);
	    securityContextLogoutHandler.logout(request, response, null);
		return "login";
	}
	
	/**
	 * Session expired.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/sessionExpired", method = RequestMethod.GET)
	public String sessionexpirted(ModelMap model) {
		WebContextHolder.get().getSession().invalidate();
		return "login";
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
