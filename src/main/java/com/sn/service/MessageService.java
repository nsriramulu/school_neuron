package com.sn.service;

import com.sn.entity.Message;
import com.sn.entity.MessageConversation;

public interface MessageService {

	String sendMessage(Message message, MessageConversation messageConversation);

}
