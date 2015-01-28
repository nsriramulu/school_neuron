package com.sn.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sn.constants.ResponseStatus;
import com.sn.dao.UserDAO;
import com.sn.entity.User;
import com.sn.service.UserService;
import com.sn.utils.JSONUtils;


@Component("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	
	public String updateLogoutTime(User user){
		String response = "";
		boolean isSuccess = false;
		try{
			user.setLastLogOutTime(Calendar.getInstance());
			isSuccess = userDAO.updateUser(user);
		}
		catch(Exception e){
			e.printStackTrace();
			isSuccess = false;
		}
		if(isSuccess){
			//EmailUtils.sendEmail()
			response = JSONUtils.getSuccessJSONResponse(ResponseStatus.SUCCESS.getCode());
		}
		else{
			response = JSONUtils.getErrorJSONRresponse(ResponseStatus.FAILURE.getCode());
		}
		return response;	
	}

	@Override
	public String getStudentsByClass(Integer classId) {
		String response = "";
		List<User> students = null;
		try{
			students = userDAO.getStudentsByClass(classId);
		}
		catch(Exception e){
			e.printStackTrace();
			response = JSONUtils.getErrorJSONRresponse(ResponseStatus.FAILURE.getCode());
		}
		if(students!=null){
			response = JSONUtils.getSuccessJSONArrayResponse(students);
			
		}
		else{
			response = JSONUtils.getErrorJSONRresponse(ResponseStatus.FAILURE.getCode());
		}
		return response;	
	}
	
	@Override
	public List<User> getStudentsOfMyClass(Integer classId) {
		List<User> students = null;
		try{
			students = userDAO.getStudentsByClass(classId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return students;	
	}
	
	@Override
	public String getParentByStudent(Integer studentId) {
		String response = "";
		List<User> students = null;
		try{
			students = userDAO.getParentByStudent(studentId);
		}
		catch(Exception e){
			e.printStackTrace();
			response = JSONUtils.getErrorJSONRresponse(ResponseStatus.FAILURE.getCode());
		}
		if(students!=null){
			response = JSONUtils.getSuccessJSONArrayResponse(students);
			
		}
		else{
			response = JSONUtils.getErrorJSONRresponse(ResponseStatus.FAILURE.getCode());
		}
		return response;	
	}
}
