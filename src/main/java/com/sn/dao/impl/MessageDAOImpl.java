package com.sn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.sn.dao.MessageDAO;
import com.sn.entity.Message;
import com.sn.entity.MessageConversation;
import com.sn.entity.Post;
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

	@Override
	public List<Message> getMessages(Integer uid) {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction=null;
		List<Message> messages=null;
		try {
			transaction=session.beginTransaction();
			Criteria criteria = session.createCriteria(Message.class);
			//			Junction disjunction = Restrictions.disjunction(); 
			//	        for (Integer classId: classIds) {
			//	            disjunction = disjunction.add(Restrictions.eq("classId", classId));
			//	        }
			//	        criteria.add(disjunction);
			Criterion criterion = Restrictions.or(Restrictions.eq("users.uid", uid),Restrictions.eq("studentId", uid),Restrictions.eq("parentId", uid));
			
			criteria.add(criterion);
			criteria.addOrder(Order.desc("createdDate"));
			messages = 	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			transaction.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();

		}finally {
			if (session != null)
				session.close();
		}
		return messages;
	}
}
