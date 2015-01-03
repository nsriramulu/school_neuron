package com.sn.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sn.quartz.JobScheduler;
@Component
public class ApplicationInitializer {
	@Autowired
	JobScheduler jobScheduler;
	
	private static Boolean isInitialized = false;
	
	@PostConstruct
	public void contextInitialized() {
		synchronized (isInitialized) {
			if(!isInitialized){
				System.out.println("Init Connections.....");
				TenantConnectionProvider.init();
				jobScheduler.init();
				isInitialized = true;
			}
		}
	}

	//	@Override
	//	public void contextDestroyed(ServletContextEvent arg0) {
	//		System.out.println("Close Connections.....");
	////		TenantConnectionProvider.shutDownAllSessionFactory();
	//	}
}