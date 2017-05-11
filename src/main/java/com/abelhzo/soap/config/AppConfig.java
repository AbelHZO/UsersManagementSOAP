package com.abelhzo.soap.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.abelhzo.soap.repositorys"},
					   entityManagerFactoryRef = "entityManagerFactory",
					   transactionManagerRef = "transactionManager")
@ComponentScan(basePackages = {"com.abelhzo.soap.bo", 
							   "com.abelhzo.soap.dao",
							   "com.abelhzo.soap.messages",
							   "com.abelhzo.soap.aspects"})
public class AppConfig {

	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource() {
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		DataSource dataSource = dsLookup.getDataSource(environment.getProperty("jndi.name.abelhzo", "java:/HZOOracleDS"));
		return dataSource;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(false);
		vendorAdapter.setShowSql(true);
		vendorAdapter.setDatabase(Database.ORACLE);
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.abelhzo.jpa");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		
		return factory.getObject();
	}
	
	@Bean
	public AbstractPlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}
	
}

/**
 * Para configurar el datasorce en el servidor wildfly 10.0.0.Final, son los siguientes pasos:
 * 1.- Crear los modulos en los sig directorios:
 * MYSQL: ${home}/wildfly-10.0.0.Final/modules/system/layers/base/com/mysql/main
 * ORACLE: ${home}/wildfly-10.0.0.Final/modules/system/layers/base/com/oracle/main
 * 
 * 2.-Copiar los drives correspondientes al directorio main:
 * MYSQL: mysql-connector-java-5.1.6
 * ORACLE: ojdbc-14.jar
 * 
 * 3.- Crear los archivos module.xml correspondientes:
 * 
 *	<?xml version="1.0" encoding="UTF-8"?>
 *	<module xmlns="urn:jboss:module:1.3" name="com.mysql">
 *	    <resources>
 *	        <resource-root path="mysql-connector-java-5.1.6.jar"/>
 *	    </resources>
 *	    <dependencies>
 *	        <module name="javax.api"/>
 *	        <module name="javax.transaction.api"/>
 *	        <module name="javax.servlet.api" optional="true"/>
 *	    </dependencies>
 *	</module>
 * 
 * 
 *	<?xml version="1.0" encoding="UTF-8"?>
 *	<module xmlns="urn:jboss:module:1.3" name="com.oracle">
 *	    <resources>
 *	        <resource-root path="ojdbc-14.jar"/>
 *	    </resources>
 *	    <dependencies>
 *	        <module name="javax.api"/>
 *	        <module name="javax.transaction.api"/>
 *	        <module name="javax.servlet.api" optional="true"/>
 *	    </dependencies>
 *	</module> 
 * 
 * 
 * 4.- Registrar las entradas en el archivo standalone.xml o standalone-full.xml 
 * 	   según el que este corriendo:
 * 
 * 	Dentro de los tags <drivers></drivers> colocar:
 * 
 * <driver name="mysql" module="com.mysql">
 *  	<driver-class>com.mysql.jdbc.Driver</driver-class>
 * </driver>	
 * 
 * 
 * <driver name="oracle" module="com.oracle">
 *  	<driver-class>oracle.jdbc.driver.OracleDriver</driver-class>
 * </driver>
 * 
 * 5.- Entrar a la consola del wildfly: 
 * Configuration: Subsystems > Datasources > Non-XA > Add
 * 
 * 6.- Colocar el name del attribute y el jdni name, seleccionar detected driver y tendra que aparecer mysql,
 * 	   después colocar los datos de la base de datos: url, usuario, password.
 * 
 *  Terminar con un test y finish.
 */
