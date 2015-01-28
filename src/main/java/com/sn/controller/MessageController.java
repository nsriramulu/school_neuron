package com.sn.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sn.common.WebContextHolder;
import com.sn.entity.Message;
import com.sn.entity.MessageConversation;
import com.sn.service.MessageService;
/**
 * The Class UserSelfServiceController is the major controller for self-service module.
 */
@Controller
@RequestMapping(value = "/sn")
public class MessageController {

	@Autowired
	private MessageSource messages;
	@Autowired
	private MessageService messageService;
	/**
	 * Gets the messages from resource.
	 *
	 * @return the MessageSource messages
	 */
	public MessageSource getMessages() {
		return messages;
	}

	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public String getMessagesPage(ModelMap model) {
		String view = "message";
		try{
		}
		catch(Exception e){
			view = "error";
		}
		return view;
	}

	@RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
	public @ResponseBody String sendMessage(ModelMap model,@RequestParam(value = "subject") String subject,
			@RequestParam(value = "message") String messageText,
			@RequestParam(value = "studentId") Integer studentId,
			@RequestParam(value = "parentId") Integer parentId){
		Message message = new Message();
		message.setSubject(subject);
		message.setParentId(parentId);
		message.setStudentId(studentId);
		message.setUsers(WebContextHolder.get().getLoggedInUserProfile().getUser());
		message.setCreatedDate(Calendar.getInstance());
		MessageConversation messageConversation = new MessageConversation();
		messageConversation.setMessage(messageText);
		messageConversation.setCreatedDate(Calendar.getInstance());
		messageConversation.setUsers(WebContextHolder.get().getLoggedInUserProfile().getUser());
		return messageService.sendMessage(message,messageConversation);
	}
}
