package com.sn.controller;

import static com.sn.constants.ApplicationConstants.SELECTED_MENU;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sn.entity.User;
import com.sn.service.UserService;
@Controller
@RequestMapping(value = "/sn")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/getStudentsByClass", method = RequestMethod.GET)
	public @ResponseBody String getStudentsByClass(ModelMap model,@RequestParam(value = "classId") Integer classId) {
		String response = "";
		try{
			response = userService.getStudentsByClass(classId);
		}
		catch(Exception e){
			response = "error";
		}
		return response;
	}
	
	@RequestMapping(value = "/getParentByStudent", method = RequestMethod.GET)
	public @ResponseBody String getParentByStudent(ModelMap model,@RequestParam(value = "studentId") Integer studentId) {
		String response = "";
		try{
			response = userService.getParentByStudent(studentId);
		}
		catch(Exception e){
			response = "error";
		}
		return response;
	}
	
	@RequestMapping(value = "/myClassRoom", method = RequestMethod.GET)
	public String myClassRoom(ModelMap model,@RequestParam("classId") Integer classId) {
		List<User> students = userService.getStudentsOfMyClass(classId);
		String view = "myClassRoom";
		try{
			model.put("students",students);
		}
		catch(Exception e){
			view = "error";
		}
		return view;
	}
}
