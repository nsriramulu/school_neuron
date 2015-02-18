package com.sn.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.springframework.core.io.ClassPathResource;

public class TenantConnectionProvider {
	private static Map<String,String> databaseDialectsMap = new HashMap<String,String>(); 
	private static Map<String,String> databaseDriversMap = new HashMap<String,String>(); 

	public static void setConfigproperty(Properties configproperty) {
		TenantConnectionProvider.configproperty = configproperty;
	}
	private static Properties configproperty =new Properties();
	private static SessionFactory sessionFactory;
	
	public TenantConnectionProvider() {}

	public static void init() {
//		loadDatabaseDialectsAndDrivers();
		loadSessionFactory();//config store for umaas super admin.
//		loadTenanMastersDTO();
//		loadAllTenantsSessionFactory();//Tenant Specific Data & Audit Store
	}

	//Added for config store database.
		private static void loadSessionFactory() {
			Properties prop=loadDBConenctionProps();
			Configuration configuration = new Configuration();
			configuration.setProperty(AvailableSettings.DIALECT,prop.getProperty("DIALECT"))
			.setProperty(AvailableSettings.DRIVER, prop.getProperty("DRIVER"))
			.setProperty(AvailableSettings.URL, prop.getProperty("URL"))//10.249.5.233
			.setProperty(AvailableSettings.USER, prop.getProperty("USER"))
			.setProperty(AvailableSettings.PASS, prop.getProperty("PASS")) 
			.setProperty("hibernate.connection.autoReconnect", "true")
			.setProperty("hibernate.connection.autoReconnectForPools", "true")
			.setProperty("hibernate.connection.is-connection-validation-required", "true")
//			.setProperty("org.hibernate.envers.default_schema", prop.getProperty("ENVERS_DEFAULT_SCHEMA"))
//			.setProperty("org.hibernate.envers.connection.url", prop.getProperty("ENVERS_CONNECTION_URL"))
//			.setProperty("org.hibernate.envers.connection.username", prop.getProperty("ENVERS_CONNECTION_USERNAME")) 
//			.setProperty("org.hibernate.envers.connection.password", prop.getProperty("ENVERS_CONNECTION_PASSWORD"))
			.configure();
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.configure().buildSessionFactory(serviceRegistry);
		}

//	private static void loadTenanMastersDTO() {
//		Set<TenantMaster> tenantMasters =new HashSet<TenantMaster> (new TenantMasterDAOImpl().getTenantsList());
//		for(TenantMaster tenantMaster : tenantMasters){
//			tenantMastersMap.put(tenantMaster.getTenantName(), tenantMaster);
//		}
//	}

//	private static void loadAllTenantsSessionFactory() {
//		Set<String> tenantLookupKeys = tenantMastersMap.keySet();
//		if(!CollectionUtils.isEmpty(tenantLookupKeys)){
//			System.out.println("~~~~~~ Number of Active Tenants : "+tenantLookupKeys.size()+"~~~~~~");
//			for(String tenantLookupKey : tenantLookupKeys){
//				TenantMaster tenantMaster = tenantMastersMap.get(tenantLookupKey);
//				addtTenantSessionFactory(tenantMaster);
//			}
//		}
//	}
//	
//	public static void addtTenantSessionFactory(TenantMaster tenantMaster) {
//		System.out.println("~~~~~~ Connecting "+tenantMaster.getTenantName()+" DB...  ~~~~~~");
//		Configuration configuration = new Configuration();
//		Configuration auditConfig = new Configuration();
//		configureTenantProperties(configuration,auditConfig,tenantMaster);
//		SessionFactory sessionFactory = null;
//		SessionFactory auditSessionFactory = null;
//		try{
//			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//			sessionFactory = configuration.configure().buildSessionFactory(serviceRegistry);
//			StandardServiceRegistry auditServiceRegistry = new StandardServiceRegistryBuilder().applySettings(auditConfig.getProperties()).build();
//			auditSessionFactory = auditConfig.configure().buildSessionFactory(auditServiceRegistry);
//		}
//		catch(JDBCConnectionException e){
//			e.printStackTrace();
//		}
//		finally{
//			sessionFactoryMap.put(tenantMaster.getTenantName(), sessionFactory);
//			auditSessionFactoryMap.put(tenantMaster.getTenantName(), auditSessionFactory);
//		}
//	}
//	
//	public static void closeTenantSessionFactory(TenantMaster tenantMaster) {
//		System.out.println("~~~~~~ Closing "+tenantMaster.getTenantName()+" DB...  ~~~~~~");
//			SessionFactory sessionFactory = sessionFactoryMap.get(tenantMaster.getTenantName());
//			if(sessionFactory !=null){
//				sessionFactory.close();
//			}
//			sessionFactoryMap.remove(tenantMaster.getTenantName());
//	}
//	
//	public static String parseURL(String str, char c) {
//	    int idx = str.lastIndexOf(c);
//	    String subStr = str.substring(0, idx);
//	    idx = subStr.lastIndexOf(c);
//	    String url = subStr.substring(0,idx);
//	    System.out.println("URL : "+url);
//	    return url ;
//	}
//	
//	private static void configureTenantProperties(Configuration configuration,Configuration auditConfig, TenantMaster tenantMaster) {
//		String identityStoreURL = tenantMaster.getIdentityStoreUrl();
//		String auditStoreURL = tenantMaster.getAuditStoreUrl();
//		System.out.println("Configuring "+tenantMaster.getTenantName()+" data store connection with url "+identityStoreURL);
//		configuration.setProperty(AvailableSettings.DIALECT, getDialect(identityStoreURL))
//		.setProperty(AvailableSettings.DRIVER, getDriver(identityStoreURL))
//		.setProperty(AvailableSettings.URL, identityStoreURL)
//		.setProperty(AvailableSettings.CONNECTION_PROVIDER,"org.hibernate.connection.C3P0ConnectionProvider")
//		.setProperty(AvailableSettings.POOL_SIZE,"5")
//		.setProperty(AvailableSettings.C3P0_IDLE_TEST_PERIOD,"600")
//		.setProperty(AvailableSettings.C3P0_MIN_SIZE,"3")
//		.setProperty(AvailableSettings.C3P0_MAX_SIZE,"20")
//		.setProperty(AvailableSettings.C3P0_TIMEOUT,"3600")
//		.setProperty(AvailableSettings.C3P0_MAX_STATEMENTS,"0")
//		;
//		configureAuditschma(configuration,auditConfig, auditStoreURL);
//		configuration.configure();
//		auditConfig.configure();
//	}
//
//	private static void configureAuditschma(Configuration configuration,
//			Configuration auditConfig, String auditStoreURL) {
//		if(!StringUtils.isEmpty(auditStoreURL)){
//			configuration.setProperty("org.hibernate.envers.connection.url", auditStoreURL);
//			int index1=auditStoreURL.lastIndexOf("/") ;
//			int index2=auditStoreURL.indexOf("?") ;
//			if(index1!=-1 && index2!=-1 ) {
//			 String auditDBschma=auditStoreURL.substring(index1+1,index2) ;
//			 System.out.println("auditDBschma is ---"+auditDBschma);
//			 configuration.setProperty("org.hibernate.envers.default_schema",auditDBschma ) ;
//			}
//			auditConfig.setProperty(AvailableSettings.DIALECT, getDialect(auditStoreURL))
//			.setProperty(AvailableSettings.DRIVER, getDriver(auditStoreURL))
//			.setProperty(AvailableSettings.URL, auditStoreURL)
//			.setProperty(AvailableSettings.CONNECTION_PROVIDER,"org.hibernate.connection.C3P0ConnectionProvider")
//			.setProperty(AvailableSettings.POOL_SIZE,"5")
//			.setProperty(AvailableSettings.C3P0_IDLE_TEST_PERIOD,"600")
//			.setProperty(AvailableSettings.C3P0_MIN_SIZE,"3")
//			.setProperty(AvailableSettings.C3P0_MAX_SIZE,"20")
//			.setProperty(AvailableSettings.C3P0_TIMEOUT,"3600")
//			.setProperty(AvailableSettings.C3P0_MAX_STATEMENTS,"0")
//			;
//		}
//	}
//
//
//	private static String getDialect(String url) {
//		String dialect = "";
//		String databaseProviderName = getDatabaseProviderName(url);
//		if(databaseDialectsMap.containsKey(databaseProviderName)){
//			dialect = databaseDialectsMap.get(databaseProviderName); 
//		}
//		System.out.println("Dialect "+dialect);
//		return dialect;
//	}
//
//	public static String getSchemaName(String url){
//		String schemaName = "";
//		String[] urlArr = StringUtils.replace(url, "\\", "/").split("/");
//		if(urlArr!=null){
//			schemaName = urlArr[urlArr.length-1];
//		}
//		return schemaName;
//	}
//
//	private static String getDatabaseProviderName(String url){
//		String databaseProviderName = "";
//		String[] urlArr = StringUtils.split(url,":");
//		if(urlArr!=null && urlArr.length>0){
//			databaseProviderName = urlArr[1];
//		}
//		System.out.println("databaseProviderName "+databaseProviderName);
//		return StringUtils.upperCase(databaseProviderName);
//	}
//
//	private static String getDriver(String url) {
//		String driver = "";
//		String databaseProviderName = getDatabaseProviderName(url);
//		if(databaseDriversMap.containsKey(databaseProviderName)){
//			driver = databaseDriversMap.get(databaseProviderName); 
//		}
//		System.out.println("driver "+driver);
//		return driver;
//	}
//
//	private static String getDBPassword(String identityStorURL) {
//		return parseByIndex(identityStorURL, 2);
//	}
//
//	private static String getDBUserName(String identityStorURL) {
//		return parseByIndex(identityStorURL, 1);
//	}
//
//	private static String parseByIndex(String identityStorURL, int index) {
//		String element = "";
//		String[] urlArr = StringUtils.replace(identityStorURL, "\\", "/").split("/");
//		if(urlArr!=null){
//			element = urlArr[urlArr.length-1].split(":")[index];
//		}
//		switch(index){
//		case 0:System.out.println("Schema : "+element);
//		break;
//		case 1:System.out.println("User : "+element);
//		break;
//		case 2:System.out.println("Password : "+element);
//		}
//		
//		return element;
//	}
//
//	private static void loadDatabaseDialectsAndDrivers() {
//		//Load Dialects
//		databaseDialectsMap.put("MYSQL", "org.hibernate.dialect.MySQLDialect");
//		databaseDialectsMap.put("DB2", "org.hibernate.dialect.DB2Dialect");
//		databaseDialectsMap.put("POSTGRESQL", "org.hibernate.dialect.PostgreSQLDialect");
//		databaseDialectsMap.put("ORACLE", "org.hibernate.dialect.OracleDialect");
//		databaseDialectsMap.put("SYBASE", "org.hibernate.dialect.SybaseDialect");
//		databaseDialectsMap.put("SQLSERVER", "org.hibernate.dialect.SQLServerDialect");
//		databaseDialectsMap.put("SAP", "org.hibernate.dialect.SAPDBDialect");
//		databaseDialectsMap.put("INFORMIX", "org.hibernate.dialect.InformixDialect");
//		databaseDialectsMap.put("HYPERSONICSQL", "org.hibernate.dialect.HSQLDialect");
//		databaseDialectsMap.put("INGRES", "org.hibernate.dialect.IngresDialect");
//		databaseDialectsMap.put("PROGRESS", "org.hibernate.dialect.ProgressDialect");
//		databaseDialectsMap.put("MCKOI", "org.hibernate.dialect.MckoiDialect");
//		databaseDialectsMap.put("INTERBASE", "org.hibernate.dialect.InterbaseDialect");
//		//Load Drivers
//		databaseDriversMap.put("MYSQL", "com.mysql.jdbc.Driver");
//	}

	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
//	public static Map<String,SessionFactory> getSessionFactoryMap(){
//		return sessionFactoryMap;
//	}
//	
//	public static SessionFactory getAuditSessionFactory(String tenantKey){
//		return auditSessionFactoryMap.get(tenantKey);
//	}
//
//	public static Map<String,TenantMaster> getAllTenantsMasterConfig(){
//		return tenantMastersMap;
//	}
//
//	public static TenantMaster getTenantMasterByLookupKey(String tenantLookupKey){
//		return tenantMastersMap.get("cts");
//	}
//
//	public static void shutDownAllSessionFactory() {
//		if(sessionFactoryMap!=null){
//			Set<String> keys = sessionFactoryMap.keySet();
//			for(String key : keys){
//				closeTenantSessionFactory(key);
//			}
//		}
//		if(auditSessionFactoryMap!=null){
//			Set<String> keys = auditSessionFactoryMap.keySet();
//			for(String key : keys){
//				closeTenantSessionFactory(key);
//			}
//		}
//	}
//	
//	private static void closeTenantSessionFactory(String key) {
//		SessionFactory sessionFactory = sessionFactoryMap.get(key);
//		sessionFactory.close();
//		sessionFactory = auditSessionFactoryMap.get(key);
//		sessionFactory.close();
//	}

	private static Properties loadDBConenctionProps(){
        try {
        String propFileName = "db_config.properties";
        ClassPathResource str =new ClassPathResource(propFileName) ;
        configproperty.load(str.getInputStream()) ;
        
        }
        catch(Exception e){
        	e.printStackTrace() ;
        }
		return configproperty ;
	}
	
	public static Properties getConfigproperty() {
		return configproperty;
	}
	
}
