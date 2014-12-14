package com.sn.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserProfileVO extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean changePasswordAfterFirstLogin;

	public UserProfileVO(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,boolean changePasswordAfterFirstLogin) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
	    this.changePasswordAfterFirstLogin=changePasswordAfterFirstLogin; 

	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isChangePasswordAfterFirstLogin() {
		return changePasswordAfterFirstLogin;
	}

}
