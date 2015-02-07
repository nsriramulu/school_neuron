package com.sn.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.sn.dao.LikeDAO;
import com.sn.entity.Like;
import com.sn.utils.HibernateUtil;
@Component("likeDAO")
public class LikeDAOImpl implements LikeDAO {
	public boolean addLike(Like likes){
		Boolean isInserted = true;
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(likes);
			
//			Query query=session.createQuery("SELECT Likes.postId, Post.usersByCreatedBy, Likes.usersByCreatedBy FROM Likes INNER JOIN Post ON Likes.usersByCreatedBy=Post.usersByCreatedBy");
			/*query.setParameter("post_id", postId);
			query.setParameter("created_by", uid);*/
			/*query.executeUpdate();
			List<Object[]> groupList = query.list();
	        for(Object[] arr : groupList){
	            System.out.println(Arrays.toString(arr));
	        }*/
			/*for(Iterator it=query.iterate();it.hasNext();)  
			  {  
				like = (Like)it.next();  
			   System.out.println("User Name: " + like.getPostId());  
			   System.out.println("User Id: " + like.getUsersByCreatedBy());  
			  } */
			/*@SuppressWarnings("unchecked")
			List<Object[]> groupList = query.list();
	        for(Object[] arr : groupList){
	            System.out.println(Arrays.toString(arr));
	        }*/
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
