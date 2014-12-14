package com.sn.security;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.sn.dao.UserDAO;
import com.sn.entity.User;
import com.sn.vo.UserProfileVO;

/**
 * The Class CustomUserDetailsAuthenticationProvider will take care of user authentication.
 * This class will  invoke a service for authentication and based on its status it will redirect to respective page.
 * @author 419348
 */
@Component
public class CustomUserDetailsAuthenticationProvider extends
		AbstractUserDetailsAuthenticationProvider {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0,
			UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		// TODO Auto-generated method stub

	}

	/**Retrieves user from service layer and based on the status, redirect to respective page
	 * @param userName
	 * @param AuthenticationToken
	 * @return userDetails on successful authentication
	 */
	@Override
	protected UserDetails retrieveUser(String userName,
			UsernamePasswordAuthenticationToken authToken)
			throws AuthenticationException {
		String password = (String) authToken.getCredentials();
//		String tenantId=TenantKeyHelper.getTenantKey();
//		
//		if(StringUtils.isBlank(tenantId)){
//			throw new BadCredentialsException(messages.getMessage("invalid.url.errmsg", new Object[]{}, LocaleContextHolder.getLocale()));
//		}
		User user = userDAO.authenticateUser(userName, password);
		if (user == null){
			throw new BadCredentialsException(messages.getMessage("invalid.username.errmsg", new Object[]{}, LocaleContextHolder.getLocale()));
		}
		else{
			return new UserProfileVO(userName, password,
					true, 
					true,
					true,
					true,
					getAuthorities(user),
					false);
		} 
	}

	/**
	 * Gets the authorities or permissions for the user logging in.
	 *
	 * @param systemFeatures the system features
	 * @return the authorities
	 */
	private Set<GrantedAuthority> getAuthorities(User user) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

//		if (systemFeatures != null) {
//			Iterator<String> systemFeaturesIterator = systemFeatures.iterator();
//			while (systemFeaturesIterator.hasNext()) {
				String role = user.getRole();
				if (StringUtils.isNotEmpty(role)) {
					authorities.add(new SimpleGrantedAuthority(role));
				}
//			}
//		}

		return authorities;
	}
}
