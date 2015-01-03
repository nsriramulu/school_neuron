package com.sn.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.sn.dao.LikeDAO;
import com.sn.entity.Like;
import com.sn.utils.HibernateUtil;
@Component("likeDAO")
public class LikeDAOImpl implements LikeDAO {
	public boolean addLike(Like like){
		Boolean isInserted = true;
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(like);
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
