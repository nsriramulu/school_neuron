package com.sn.vo;

import java.util.Set;

import com.sn.entity.User;

public class UserDetailsVO {
	private String userName;
	private String password;
	private boolean enabled = true;
	private boolean accountNonExpired = true;
	private boolean credentialsNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean isLoginSuccess = false;
	private boolean changePasswordAfterFirstLogin=false;
	private User user;
	private Set<String> systemFeatures;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getSystemFeatures() {
		return systemFeatures;
	}

	public void setSystemFeatures(Set<String> systemFeatures) {
		this.systemFeatures = systemFeatures;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isLoginSuccess() {
		return isLoginSuccess;
	}

	public void setLoginSuccess(boolean isLoginSuccess) {
		this.isLoginSuccess = isLoginSuccess;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isChangePasswordAfterFirstLogin() {
		return changePasswordAfterFirstLogin;
	}

	public void setChangePasswordAfterFirstLogin(
			boolean changePasswordAfterFirstLogin) {
		this.changePasswordAfterFirstLogin = changePasswordAfterFirstLogin;
	}
	
	
}
