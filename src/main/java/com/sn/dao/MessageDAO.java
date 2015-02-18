package com.sn.dao;

import java.util.List;

import com.sn.entity.Message;
import com.sn.entity.MessageConversation;

public interface MessageDAO {
	boolean insertMessage(Message message, MessageConversation messageConversation);
	boolean insertMessageConversation(MessageConversation messageConversation);
	List<Message> getMessages(Integer uid);
}
