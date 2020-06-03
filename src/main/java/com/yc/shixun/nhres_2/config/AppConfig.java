package com.yc.shixun.nhres_2.config;



import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 约定重于配置 整个应用的配置信息
 * 
 * @author 张影 QQ:1069595532 WX:zycqzrx1
 * @date Jun 2, 2020
 */
@Configuration // 这个类是一个配置信息
@ComponentScan(basePackages = "com.yc") // 组件类的位置,自动扫描,自动加载，自动装配
@EnableTransactionManagement     //启用基于注解的事务管理  
public class AppConfig {

	private Logger log = Logger.getLogger(AppConfig.class); // 日志

	@Bean // 由spring 自动调用这个代码，并创建 datasource , 交由spring托管
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/nhres");
		dataSource.setUsername("root");
		dataSource.setPassword("a");
		log.info("创建数据源" + dataSource + "成功");
		return dataSource;   
	}
	
	@Bean
	public    DataSourceTransactionManager  tx(  DriverManagerDataSource ds    ){
		log.info(   "创建事务管理器,"+  ds );
		DataSourceTransactionManager dtm=new DataSourceTransactionManager();   // jdbc 事务管理器
		dtm.setDataSource(   ds );
		return dtm;
	}
	

}


