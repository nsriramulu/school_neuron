package com.sn.helper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.sn.common.WebContextHolder;



/**
 * The Class TenantKeyHelper to deal with tenant lookup key.
 */
public class TenantKeyHelper {
	
	/**
	 * Tenant key setter.
	 *
	 * @param response the response
	 */
	public static void tenantKeySetter(HttpServletResponse response){
		String tenantKey = WebContextHolder.get().getRequest().getParameter("id");
			if(StringUtils.isNotBlank(tenantKey)){
				WebContextHolder.get().getSession().setAttribute("tenantKey", tenantKey);
			}
			Cookie cookie = new Cookie("tenantKey", tenantKey);
			cookie.setHttpOnly(true);
			cookie.setSecure(true);
			response.addCookie(cookie);
	}
	
	/**
	 * Gets the tenant key.
	 *
	 * @return the tenant key
	 */
	public static String getTenantKey(){
		String key="";
		if(WebContextHolder.get().getSession().getAttribute("tenantKey")!=null){
			key = (String)WebContextHolder.get().getSession().getAttribute("tenantKey");
		}
		return key;
	}
}
