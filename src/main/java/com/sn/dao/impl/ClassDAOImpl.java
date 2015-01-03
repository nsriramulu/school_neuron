package com.sn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.sn.dao.ClassDAO;
import com.sn.entity.ClassSubjectTeacher;
import com.sn.utils.HibernateUtil;

@Component("classDAO")
public class ClassDAOImpl implements ClassDAO {

	@Override
	public List<ClassSubjectTeacher> getClassesByUserId(Integer userId) {

		Session session = HibernateUtil.getOpenSession();
		Transaction transaction=null;
		List<ClassSubjectTeacher> classes = null;
		try {
			transaction=session.beginTransaction();
			Criteria criteria = session.createCriteria(ClassSubjectTeacher.class);
			Criterion criterion= Restrictions.eq("users.uid", userId);
			criteria.add(criterion);
			classes = 	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			transaction.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();

		}finally {
			if (session != null)
				session.close();
		}
		return classes;
	}

}
