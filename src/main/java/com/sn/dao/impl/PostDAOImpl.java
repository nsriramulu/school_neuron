package com.sn.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
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
import com.sn.vo.CommentsVO;

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
			Criterion criterion= Restrictions.and(Restrictions.eqOrIsNull("isScheduled", false), Restrictions.or(Restrictions.eq("usersByCreatedBy.uid", userId), 
					Restrictions.in("classId", classIds)));
			
			criteria.add(criterion);
			criteria.addOrder(Order.desc("postDate"));
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
	public boolean updateCommentCount(Post post) {
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
	
	@Override
	public boolean updateLikeCount(Post post) {
		Boolean isUpdated = true;
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("update Post set likeCount = :likeCount" +
					" where id = :id");
			query.setParameter("likeCount", post.getLikeCount());
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

	@Override
	public List<Post> getScheduledPosts() {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction=null;
		List<Post> posts=null;
		try {
			transaction=session.beginTransaction();
			Criteria criteria = session.createCriteria(Post.class);
			Criterion criterion= Restrictions.eq("isScheduled", true);
			criteria.add(criterion);
			criteria.addOrder(Order.desc("createdDate"));
			posts = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
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
	public boolean updateIsScheduled(Post post) {
		Boolean isUpdated = true;
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("update Post set isScheduled = :isScheduled" +
					" where id = :id");
			query.setParameter("isScheduled", post.getIsScheduled());
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

	@Override
	public List<Post> getPostsForNotification(Integer uid,
			List<Integer> classIds, Calendar calendar) {

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
			Criterion criterion= Restrictions.and(Restrictions.eqOrIsNull("isScheduled", false), Restrictions.or(Restrictions.eq("usersByCreatedBy.uid", uid), 
					Restrictions.in("classId", classIds)),Restrictions.between("postDate", calendar,calendar.getInstance()));
			
			criteria.add(criterion);
			criteria.addOrder(Order.desc("postDate"));
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
	public List<Post> getAllPosts() {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction=null;
		List<Post> posts=null;
		try {
			transaction=session.beginTransaction();
			Criteria criteria = session.createCriteria(Post.class);
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
	public List<Post> getEventsByUserAndClass(Integer userId,
			List<Integer> classIds) {
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
			Criterion criterion= Restrictions.and(
										Restrictions.eqOrIsNull("isScheduled", false), 
										Restrictions.or(
												Restrictions.eq("usersByCreatedBy.uid", userId), 
												Restrictions.in("classId", classIds)
										),
										Restrictions.isNotNull("eventTitle")
										);
			
			criteria.add(criterion);
			criteria.addOrder(Order.desc("postDate"));
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
	public List<CommentsVO> getAllComments(Integer postId) {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction=null;
//		CommentsVO commentsVO=new CommentsVO();
		List<CommentsVO> comments=new ArrayList<CommentsVO>();
		try {
			/*transaction=session.beginTransaction();
			Criteria criteria = session.createCriteria(postId);
			comments = 	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			Query query = session.createQuery("select a.comment,b.username from Comment a,User b where a.usersByCreatedBy=b.uid and a.postId="+postId);
			comments=(List<CommentsVO>)query.list();
			Iterator iterator=comments.iterator();
			while (iterator.hasNext()) {
				List<Object> voValues= (List<Object>) iterator.next();
				Object voValues= (Object) iterator.next();
					CommentsVO vo=new CommentsVO();
					vo.setComments(voValues.get(0));
					vo.setUserName(voValues.get(1));
			}
			commentsVO.setComments(comments.get(0).getComments());
			commentsVO.setUserName(comments.get(1).getUserName());
			Iterator<CommentsVO> iterator=comments.iterator();
			while (iterator.hasNext()) {
				
			}
			transaction.commit();*/
		List<Object[]> vos = session.createQuery(
			       "select a.comment,b.username from Comment a,User b where a.usersByCreatedBy=b.uid and a.postId=?")
			       .setInteger(0, postId)
			       .list();
			  for(Object[] values : vos){
			   CommentsVO commentsVO = new CommentsVO();
			   commentsVO.setComment((String)values[0]);
			   commentsVO.setUsername((String)values[1]);
			   comments.add(commentsVO);
			   System.out.println("Comment : "+commentsVO.getComment()+" user : "+commentsVO.getUsername());
			  }
			  
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}finally {
			if (session != null)
				session.close();
		}
		return comments;
	}
}

