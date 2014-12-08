package com.sn.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.sn.dao.CommentDAO;
import com.sn.entity.Comment;
import com.sn.utils.HibernateUtil;
@Component("commentDAO")
public class CommentDAOImpl implements CommentDAO {
	public boolean insertComment(Comment comment){
		Boolean isInserted = true;
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(comment);
			transaction.commit();
		} catch (RuntimeException e) {
			isInserted = false;
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
