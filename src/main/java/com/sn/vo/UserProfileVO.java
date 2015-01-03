package com.sn.vo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.sn.entity.ClassSubjectTeacher;
import com.sn.entity.School;

public class UserProfileVO extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean changePasswordAfterFirstLogin;
	private School school;
	private com.sn.entity.User user;
	private List<ClassSubjectTeacher> classes;
	
	public UserProfileVO(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,School school, com.sn.entity.User user, List<ClassSubjectTeacher> classes, boolean changePasswordAfterFirstLogin) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		this.school = school;
		this.user =user;
		this.classes = classes;
	    this.changePasswordAfterFirstLogin=changePasswordAfterFirstLogin; 
	}

	public School getSchool() {
		return school;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isChangePasswordAfterFirstLogin() {
		return changePasswordAfterFirstLogin;
	}


	public com.sn.entity.User getUser() {
		return user;
	}

	public List<ClassSubjectTeacher> getClasses() {
		return classes;
	}
}
