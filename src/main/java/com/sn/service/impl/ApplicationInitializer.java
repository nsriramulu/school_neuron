package com.sn.service.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sn.quartz.JobScheduler;
@Component
public class ApplicationInitializer {
	@Autowired
	JobScheduler jobScheduler;
	
	private static Boolean isInitialized = false;
	
	@Value("${docTempPath}")
	private String docTempPath;
	
	@PostConstruct
	public void contextInitialized() {
		synchronized (isInitialized) {
			if(!isInitialized){
				System.out.println("Init Connections.....");
				System.out.println("Deleting temp folder....");
				try {
					FileUtils.deleteDirectory(new File(docTempPath));
					System.out.println("Deleted temp folder !!!");
				} catch (IOException e) {
					System.out.println("Error in deleting temp folder !!!!");
					e.printStackTrace();
				}
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