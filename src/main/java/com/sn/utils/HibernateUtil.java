package com.sn.utils;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sn.service.impl.TenantConnectionProvider;
public class HibernateUtil {
	
	public static SessionFactory getConfigStoreSessionFactory() {
		return TenantConnectionProvider.getSessionFactory();
	}
	
	public static SessionFactory getUmaasConfigStoreSessionFactory() {
		return TenantConnectionProvider.getSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
//		return TenantConnectionProvider.getConfigStoreSessionFactory();
		//For development purpose only
//		SessionFactory sessionFactory= null;
//		if(StringUtils.isBlank(ContextHolder.get())){
//			sessionFactory  = TenantConnectionProvider.getSessionFactory();
//		}
//		else{
//			sessionFactory  = TenantConnectionProvider.getSessionFactoryMap().get(ContextHolder.get());
//		}
		return TenantConnectionProvider.getSessionFactory();
	}
	
	public static void shutDownSessionFactory() {
		//TenantConnectionProvider.getSessionFactoryMap().get(ContextHolder.get()).close();
		TenantConnectionProvider.getSessionFactory().close();
	}
	
//	public static Map<String,TenantMaster> getAllTenantsMasterConfig(){
//		return TenantConnectionProvider.getAllTenantsMasterConfig();
//	}
//	
//	public static TenantMaster getTenantMasterByLookupKey(String tenantLookupKey){
//		return TenantConnectionProvider.getTenantMasterByLookupKey(tenantLookupKey);
//	}
//	
//	public static Logger getTenantLogger() {
//		return TenantLoggerProvider.getTenantLogger();
//	}
//	
	public static Session getOpenSession(){
		return  HibernateUtil.getSessionFactory().openSession();
	}
	
//	public static Session getAuditSession(){
//		Session session = null;
//		if(StringUtils.isNotBlank(ContextHolder.get())){
//			SessionFactory sessionFactory= null;
//			sessionFactory  = TenantConnectionProvider.getAuditSessionFactory(ContextHolder.get());
//			if(sessionFactory!=null){
//				session = sessionFactory.openSession();
//			}
//		}
//		return session;
//	}
//	
}