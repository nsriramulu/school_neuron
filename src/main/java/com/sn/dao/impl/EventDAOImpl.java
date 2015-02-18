package com.sn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sn.dao.EventDAO;
import com.sn.entity.EventResult;
import com.sn.utils.HibernateUtil;

@Component("eventDAO")
public class EventDAOImpl implements EventDAO{

	@Override
	@Transactional
	public String insertEventResult(EventResult eventResult) {
		String returnValue = "";
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction=null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(eventResult);
			updateResponseCount(eventResult, session);
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			returnValue = getEventResult(eventResult);
//			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return returnValue;
	}

	private void updateResponseCount(EventResult eventResult, Session session) {
		String columnName = "";
		switch(eventResult.getResponse()){
		case 1:
			columnName = "likeCount";
			break;
		case 0:
			columnName = "disLikeCount";
			break;
		case 2:
			columnName = "commentCount";
			break;
		}
		
		Query query = session.createQuery(" Update Post Set "+columnName+" = "+columnName+" + 1	Where id = :id");
		query.setParameter("id", eventResult.getEvent_id());
		query.executeUpdate();
	}
	
	@Override
	public String getEventResult(EventResult eventResult) {
		String returnValue = "";
		Session session = HibernateUtil.getOpenSession();
		try{
			Criteria criteria = session.createCriteria(EventResult.class);
			criteria.add(Restrictions.and(Restrictions.eq("event_id", eventResult.getEvent_id()),
					Restrictions.eq("userId", eventResult.getUserId())));
			List<EventResult> result = criteria.list();
			if(result != null && result.size()>0){
				eventResult = result.get(0);
				switch(eventResult.getResponse()){
				case 1:
					returnValue = "attending";
					break;
				case 0:
					returnValue = "not attending";
					break;
				case 2:
					returnValue = "may be attending";
					break;
				}
			}
		}
		catch(RuntimeException e){
			e.printStackTrace();
		}
		finally {
			if (session != null)
				session.close();
		}
		return returnValue;
	}
}
