package com.sn.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.sn.dao.MessageDAO;
import com.sn.entity.Message;
import com.sn.entity.MessageConversation;
import com.sn.utils.HibernateUtil;
@Component("messageDAO")
public class MessageDAOImpl implements MessageDAO {

	@Override
	public boolean insertMessage(Message message,MessageConversation messageConversation) {
		boolean isInserted = false;
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(message);
			messageConversation.setMessages(message);
			session.saveOrUpdate(messageConversation);
			transaction.commit();
			isInserted = true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null)
				session.close();
		}
		return isInserted;
	}
	
	@Override
	public boolean insertMessageConversation(MessageConversation messageConversation) {
		boolean isInserted = false;
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(messageConversation);
			isInserted = true;
			transaction.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null)
				session.close();
		}
		return isInserted;
	}
}
