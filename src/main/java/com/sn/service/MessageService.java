package com.sn.service;

import java.util.List;

import com.sn.entity.Message;
import com.sn.entity.MessageConversation;

public interface MessageService {

	String sendMessage(Message message, MessageConversation messageConversation);

	List<Message> getMessages(Integer uid);


}
