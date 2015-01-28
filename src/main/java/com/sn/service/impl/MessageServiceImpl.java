package com.sn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sn.constants.ResponseStatus;
import com.sn.dao.MessageDAO;
import com.sn.entity.Message;
import com.sn.entity.MessageConversation;
import com.sn.service.MessageService;
import com.sn.utils.JSONUtils;

@Component("messageService")
public class MessageServiceImpl implements MessageService {
	
	@Autowired MessageDAO messageDAO;
	@Override
	public String sendMessage(Message message,
			MessageConversation messageConversation) {
		String response = "";
		try{
			if(messageDAO.insertMessage(message,messageConversation)){
				response = JSONUtils.getSuccessJSONResponse(ResponseStatus.SUCCESS.getCode());
			}
			else{
				response = JSONUtils.getErrorJSONRresponse(ResponseStatus.FAILURE.getCode());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return response;	
	}

}
