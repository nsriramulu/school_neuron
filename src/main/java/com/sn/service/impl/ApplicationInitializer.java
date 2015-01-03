package com.sn.service.impl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ApplicationInitializer implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Init Connections.....");
		TenantConnectionProvider.init();
		//TenantLoggerProvider.init();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Close Connections.....");
//		TenantConnectionProvider.shutDownAllSessionFactory();
	}
}