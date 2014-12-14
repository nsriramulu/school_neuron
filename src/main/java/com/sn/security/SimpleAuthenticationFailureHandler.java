package com.sn.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.AuthenticationException;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 * The Class SimpleAuthenticationFailureHandler will be used to append tenant lookup key on authentication failure.
 * @author 419348
 */
public class SimpleAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	/**
	 * On Authentication Failure
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @param AuthenticationException
	 * 
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		String param=(String)request.getSession().getAttribute("tenantKey");
		String userName=(String)request.getSession().getAttribute("username");
		if(StringUtils.isNotBlank(userName)){
			setDefaultFailureUrl("/sn/login.do?id="+param+"&error=true&lang="+request.getSession().getAttribute("selectedLanguage")+"&userName="+request.getSession().getAttribute("username"));
		}else{
			setDefaultFailureUrl("/sn/login.do?id="+param+"&error=true&lang="+request.getSession().getAttribute("selectedLanguage"));
		}
		request.getSession().invalidate();
	  super.onAuthenticationFailure(request, response, exception);
	}

}
