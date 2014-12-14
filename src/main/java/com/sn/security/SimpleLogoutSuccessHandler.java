package com.sn.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

/**
 * The Class SimpleLogoutSuccessHandler will be used to handle user logout.
 */
public class SimpleLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler{
	
	/**On Successful logout, will destroy the session and redirect to login page.
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @param Authentication
	 */
	@Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
		String param=(String)(request.getSession().getAttribute("tenantKey"));
		if(param==null){
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie:cookies){
				if("tenantKey".equals(cookie.getName())){
					param=cookie.getValue();
					
				}
			}
		}
		request.getSession().invalidate();
		setDefaultTargetUrl("/login.do?id="+param);
		Cookie cookie = new Cookie("JSESSIONID", null); cookie.setPath(request.getContextPath() + "/"); 
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		cookie.setMaxAge(0); 
		response.addCookie(cookie);
        super.onLogoutSuccess(request, response, authentication); 
	}

}
