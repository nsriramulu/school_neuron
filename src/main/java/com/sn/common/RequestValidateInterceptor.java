package com.sn.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sn.vo.UserProfileVO;

/**
 * The Class RequestValidateInterceptor is an extension of Spring HandlerInterceptorAdapter
 * used to protect from CSRF attacks
 */
public class RequestValidateInterceptor extends HandlerInterceptorAdapter{

	/** The pre-defined allowed referer list . */
	//	@Value("${allowed.referer}")
	//	private String allowedReferer;

	/** This method will get invoke before invoking MVC controller.
	 * @param javax.servlet.http.HttpServletRequest
	 * @param javax.servlet.http.HttpServletResponse
	 * @param java.lang.Object
	 * @return boolean
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean validSession=true;
		try{
			if(StringUtils.contains(request.getRequestURI(),"/sn/")){
				UserProfileVO userProfileVO = (UserProfileVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				if ( userProfileVO == null) {  
					validSession=false;
					response.sendRedirect("error");
				}
			}
			//			if(validSession){
			//				String referer  = request.getHeader("Referer");
			//				if(StringUtils.isNotBlank(referer) && StringUtils.isNotBlank(allowedReferer)){
			//					String[] allowedRefererArr = allowedReferer.split(",");
			//					boolean isAllowedReferer = false;
			//					for(int i=0;i<allowedRefererArr.length;i++){
			//						if(StringUtils.contains(referer,allowedRefererArr[i])){
			//							isAllowedReferer = true;
			//							break;
			//						}
			//					}
			//					if(!isAllowedReferer){
			//						WebContextHolder.get().getSession().invalidate();
			//					}
			//				}
			//			}
		}
		catch(Exception e){
			validSession=false;
			response.sendRedirect("error");
		}
		return validSession;
	}
}
