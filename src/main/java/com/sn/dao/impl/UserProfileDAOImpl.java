package com.sn.dao.impl;

import org.springframework.stereotype.Repository;

import com.sn.dao.UserProfileDAO;

/**
 * Implements {@link UserProfileDAO}}
 * @see {@link UserProfileDAO} for more details
 * @author 424969
 *
 */
@Repository
public class UserProfileDAOImpl implements UserProfileDAO {
	
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
