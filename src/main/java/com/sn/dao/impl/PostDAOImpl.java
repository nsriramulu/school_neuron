package com.sn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.sn.dao.PostDAO;
import com.sn.entity.Post;
import com.sn.utils.HibernateUtil;

@Component("postDAO")
public class PostDAOImpl implements PostDAO{

	@Override
	public boolean insertPost(Post post) {
		Boolean isInserted = true;
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(post);
			transaction.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			isInserted = false;
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
	public List<Post> getPostsByUserAndClass(Integer userId,List<Integer> classIds){
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction=null;
		List<Post> posts=null;
		try {
			transaction=session.beginTransaction();
			Criteria criteria = session.createCriteria(Post.class);
			//			Junction disjunction = Restrictions.disjunction(); 
			//	        for (Integer classId: classIds) {
			//	            disjunction = disjunction.add(Restrictions.eq("classId", classId));
			//	        }
			//	        criteria.add(disjunction);
			Criterion criterion= Restrictions.or(Restrictions.eq("usersByCreatedBy.uid", userId), 
					Restrictions.in("classId", classIds));
			criteria.add(criterion);
			criteria.addOrder(Order.desc("createdDate"));
			posts = 	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			transaction.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();

		}finally {
			if (session != null)
				session.close();
		}
		return posts;
	}

	@Override
	public List<Post> getPostsByClass(Integer classId) {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction=null;
		List<Post> posts=null;
		try {
			transaction=session.beginTransaction();
			Criteria criteria = session.createCriteria(Post.class)
					.add(Restrictions.not(Restrictions.eq("classId", classId)));
			posts = 	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			transaction.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}finally {
			if (session != null)
				session.close();
		}
		return posts;
	}

	@Override
	public boolean updatePost(Post post) {
		Boolean isUpdated = true;
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("update Post set commentCount = :commentCount" +
					" where id = :id");
			query.setParameter("commentCount", post.getCommentCount());
			query.setParameter("id", post.getId());
			query.executeUpdate();
			transaction.commit();
		} catch (RuntimeException e) {
			isUpdated = false;
			e.printStackTrace();
			isUpdated = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null)
				session.close();
		}
		return isUpdated;
	}
}

