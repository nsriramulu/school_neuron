package com.sn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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
