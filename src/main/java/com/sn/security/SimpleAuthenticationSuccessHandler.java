package com.sn.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.sn.vo.UserProfileVO;

/**
 * The Class SimpleAuthenticationHandler will be used to identify the redirection page on authentication success.
 */
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	 /** 
	  * On Authentication Success - will identify the redirection page based on user password reset flag
	  * @param HttpServletRequest
	  * @param HttpServletResponse
	  * @param Authentication
	 */
	@Override
     public void onAuthenticationSuccess(HttpServletRequest request,
        HttpServletResponse response, Authentication auth) throws IOException, ServletException {
//		 String sessiontimeout=100+"";//neeed to be configure
//			int timeout;
//			if(sessiontimeout!=null){
//			 timeout=Integer.valueOf(sessiontimeout)*60;
//			 request.getSession().setMaxInactiveInterval(timeout);
//			}
		 UserProfileVO userProfile=(UserProfileVO)auth.getPrincipal();
    	request.getSession().setAttribute("userProfile", userProfile);
//    	String isPWDRest = userProfile.getLdapUser().getUserProfileMap().get(UserAttributeNames.IS_PWD_RESET.getAttributeName());
//    	if (userProfile.isChangePasswordAfterFirstLogin() && !ApplicationConstants.YES.equalsIgnoreCase(isPWDRest)) {
//        	redirectStrategy.sendRedirect(request, response, "/sn/changePassword");
//        } else {
        	redirectStrategy.sendRedirect(request, response, "/sn/home");
//        }
    }

//   public void proceed(HttpServletRequest request, 
//        HttpServletResponse response, Authentication auth) throws IOException, ServletException {
//        target.onAuthenticationSuccess(request, response, auth);
//    }


}
