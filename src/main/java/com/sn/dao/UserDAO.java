package com.sn.dao;

import java.util.List;

import com.sn.entity.User;


public interface UserDAO {

	User authenticateUser(String userName,String password);
	boolean updateUser(User user);
	List<User> getStudentsByClass(Integer classId);
	List<User> getParentByStudent(Integer studentId);

}
