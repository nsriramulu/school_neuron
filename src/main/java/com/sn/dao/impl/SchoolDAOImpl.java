package com.sn.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.sn.dao.SchoolDAO;
import com.sn.entity.ClassSubjectTeacher;
import com.sn.entity.School;
import com.sn.utils.HibernateUtil;

@Component("schoolDAO")
public class SchoolDAOImpl implements SchoolDAO {

	@Override
	public School getSchoolByCode(String code) {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction=null;
		School school = null;
		try {
			transaction=session.beginTransaction();
			Criteria criteria = session.createCriteria(School.class);
			Criterion criterion= Restrictions.eq("code", code);
			criteria.add(criterion);
			Object object = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).uniqueResult();
			transaction.commit();
			if(object!=null){
				school = (School) object;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();

		}finally {
			if (session != null)
				session.close();
		}
		return school;
	}

}
