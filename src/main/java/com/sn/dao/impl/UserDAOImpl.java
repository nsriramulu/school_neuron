package com.sn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import com.sn.dao.UserDAO;
import com.sn.entity.User;
import com.sn.utils.HibernateUtil;

@Component("usereDAO")
public class UserDAOImpl implements UserDAO {

	@Override
	public User authenticateUser(String userName, String password) {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		User user = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class)
					.add(Restrictions.eq("username", userName))
					.add(Restrictions.eq("password", password));
			List<User> userObj = 	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			if(userObj != null && !userObj.isEmpty()){
				user = (User) userObj.get(0);
			}
			transaction.commit();
		} finally {
			if (session != null)
				session.close();
		}
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		Boolean isUpdated = true;
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
		} catch (RuntimeException e) {
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
	public List<User> getStudentsByClass(Integer classId) {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		List<User> users = null;
		try {
			transaction = session.beginTransaction();
			 users = session.createCriteria(User.class).
					add(Restrictions.eq("classId", classId))
					.add(Restrictions.eq("role", "Student")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			/*ProjectionList projList = Projections.projectionList().
					add(Projections.property("firstName"))
					.add(Projections.property("lastName"))
					.add(Projections.property("gender"))
					.add(Projections.property("birthday"))
					.add(Projections.property("email"));*/
//			criteria.setProjection(projList);
//			users = 	criteria.setResultTransformer(Criteria.PROJECTION).list();
			transaction.commit();
		} finally {
			if (session != null)
				session.close();
		}
		return users;
	}

	@Override
	public List<User> getParentByStudent(Integer studentId) {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		List<User> users = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class)
					.add(Restrictions.eq("studentId", studentId))
					.add(Restrictions.eq("role", "Parent"));
			users = 	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			transaction.commit();
		} finally {
			if (session != null)
				session.close();
		}
		return users;
	}
	
		/* (non-Javadoc)
	 * @see com.cts.umaas.dao.UserProfileDAO#getRoleIdForGiveUserId(java.lang.Long)
	 */
//	@Override
//	public long getRoleIdForGiveUserId(Long loggedInUserId) {
//		Session session = UMaasUtil.getOpenSession();
//		Transaction transaction = null;
//		UserProfile user = null;
//		long roleId=0;
//		try {
//			transaction = session.beginTransaction();
//			user = (UserProfile) session.get(UserProfile.class, loggedInUserId);
//			if(user!=null){
//			Set<Role> roles=user.getRoles();
//			if(roles!=null&&!roles.isEmpty()){
//				
//				for(Role role:roles){
//					roleId=role.getRoleId();
//					break;
//				}
//				
//			}
//			}
//			transaction.commit();
//		} finally {
//			if (session != null)
//				session.close();
//		}
//
//		return roleId;
//	}
//	
//	/* (non-Javadoc)
//	 * @see com.cts.umaas.dao.UserProfileDAO#createUserProfile(java.lang.Long)
//	 */
//	@Override
//	public String createUser(Long userId) {
//		String status=null;
//		Session session = UMaasUtil.getOpenSession();
//		UserProfile userProfile = new UserProfile();
//		userProfile.setUserId(userId);
//		Set<Role> roles = new HashSet<Role>();
//		roles.add(new RoleDAOImpl().getDefaultRole());
//		userProfile.setRoles(roles);
//		Transaction transaction = null;
//		try {
//			transaction = session.beginTransaction();
//			session.saveOrUpdate(userProfile);
//			transaction.commit();
//		} catch (RuntimeException e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			throw e;
//		} finally {
//			if (session != null)
//				session.close();
//		}
//		return status;
//	}
	
}
