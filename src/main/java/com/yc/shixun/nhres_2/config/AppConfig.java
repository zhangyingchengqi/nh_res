package com.yc.shixun.nhres_2.config;



import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 约定重于配置 整个应用的配置信息
 * 
 * @author 张影 QQ:1069595532 WX:zycqzrx1
 * @date Jun 2, 2020
 */
@Configuration // 这个类是一个配置信息
@ComponentScan(basePackages = "com.yc") // 组件类的位置,自动扫描,自动加载，自动装配
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

}


