package com.sn.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sn.dao.AssignmentDAO;
import com.sn.entity.StudentAssignment;
import com.sn.utils.HibernateUtil;

@Repository
public class AssignmentDAOImpl implements AssignmentDAO{
	
	@Override
	@Transactional
	public String insertStudentAssignment(StudentAssignment studentAssignment){
		String returnValue = "";
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction=null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(studentAssignment);
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
//			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return returnValue;
	}
}
