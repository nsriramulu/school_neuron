package com.sn.service;

import java.util.List;

import com.sn.entity.User;



public interface UserService {
	String updateLogoutTime(User user);

	String getStudentsByClass(Integer classId);

	String getParentByStudent(Integer studentId);

	List<User> getStudentsOfMyClass(Integer classId);
}
