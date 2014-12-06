package com.sn.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


/**
 * The Class CustomUserDetailsAuthenticationProvider will take care of user authentication.
 * This class will  invoke a service for authentication and based on its status it will redirect to respective page.
 * @author 419348
 */
@Component
public class CustomUserDetailsAuthenticationProvider extends
		AbstractUserDetailsAuthenticationProvider {
	
	@Autowired
	private MessageSource messages;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0,
			UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		// TODO Auto-generated method stub

	}

	/**Retrieves user from service layer and based on the status, redirect to respective page
	 * @param userName
	 * @param AuthenticationToken
	 * @return userDetails on successful authntication
	 */
	@Override
	protected UserDetails retrieveUser(String userName,
			UsernamePasswordAuthenticationToken authToken)
			throws AuthenticationException {
				return null;
//		if(WebContextHolder.get().getSession().getAttribute("selectedLanguage")!=null){
//			LocaleContextHolder.setLocale(new Locale((String)WebContextHolder.get().getSession().getAttribute("selectedLanguage")));
//		}
//		String password = (String) authToken.getCredentials();
//		UserDetailsVO userNameAndPwdVO = new UserDetailsVO();
//		userNameAndPwdVO.setUserName(userName.trim());
//		userNameAndPwdVO.setPassword(password.trim());
//		String tenantId=TenantKeyHelper.getTenantKey();
//		
//		HashMap<String,Object> sessionMap = new HashMap<String,Object>();
//		HttpSession session = WebContextHolder.get().getSession();
//		 for (Enumeration e = session.getAttributeNames(); e.hasMoreElements(); ) {     
//			    String attribName = (String) e.nextElement();				    
//			    sessionMap.put(attribName, session.getAttribute(attribName));
//		 }
//		session.invalidate();
//		session = WebContextHolder.get().getRequest().getSession(true);
//		for(String key:sessionMap.keySet() ){
//			session.setAttribute(key, sessionMap.get(key));
//		}
//		
//		if(StringUtils.isBlank(tenantId)){
//			throw new BadCredentialsException(messages.getMessage("invalid.url.errmsg", new Object[]{}, LocaleContextHolder.getLocale()));
//		}
//		UserDetailsVO userDetails=(UserDetailsVO) ServiceProvider.serviceCall("login","com.cts.umaas.vo.UserDetailsVO","POST",userNameAndPwdVO);
//		if (userDetails == null)
//			throw new BadCredentialsException(messages.getMessage("invalid.username.errmsg", new Object[]{}, LocaleContextHolder.getLocale()));
//		
//		/*
//		 * if (userName.equals(userDetails.getUserName().trim()) &&
//		 * password.equals(userDetails.getPassword().trim())) {
//		 */
//
//		if (userDetails.isLoginSuccess()) {
//			return new UserProfileVO(userName, password,
//					userDetails.isEnabled(), userDetails.isAccountNonExpired(),
//					userDetails.isCredentialsNonExpired(),
//					userDetails.isAccountNonLocked(),
//					getAuthorities(userDetails.getSystemFeatures()),
//					userDetails.getLdapUser(),userDetails.isChangePasswordAfterFirstLogin());
//		} else {
//			WebContextHolder.get().getSession().setAttribute("username", userName);
//			String errorMsg = messages.getMessage("invalid.password.errmsg", new Object[]{}, LocaleContextHolder.getLocale());
//			if(userDetails.getLdapUser()==null){
//				errorMsg = messages.getMessage("invalid.username.errmsg", new Object[]{}, LocaleContextHolder.getLocale());
//			}
//			else if(StringUtils.equalsIgnoreCase(userDetails.getLdapUser().getUserProfileMap().get(UserAttributeNames.IS_LOCKED.getAttributeName()),"Y")){
//				return new UserProfileVO(userName, password,
//						true, true, true, false,
//						getAuthorities(userDetails.getSystemFeatures()),
//						userDetails.getLdapUser(),userDetails.isChangePasswordAfterFirstLogin());
//			}
//			throw new BadCredentialsException(errorMsg);
//		}

	}

	/**
	 * Gets the authorities or permissions for the user logging in.
	 *
	 * @param systemFeatures the system features
	 * @return the authorities
	 */
	private Set<GrantedAuthority> getAuthorities(Set<String> systemFeatures) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		if (systemFeatures != null) {
			Iterator<String> systemFeaturesIterator = systemFeatures.iterator();

			while (systemFeaturesIterator.hasNext()) {
				String featureName = systemFeaturesIterator.next();
				if (StringUtils.isNotEmpty(featureName)) {
					authorities.add(new SimpleGrantedAuthority(featureName));
				}
			}
		}

		return authorities;
	}
}
