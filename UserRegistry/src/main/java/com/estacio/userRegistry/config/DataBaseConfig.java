package com.estacio.userRegistry.config;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.stereotype.Component;

@Component
public class DataBaseConfig {

	// Hibernate Config
	private String hbDialect;
	private String hbDefaultSchema;
	private String hbHbm2ddl;
	private String hbShowSql;
	private String hbFormatSql;

	// JDBC Config
	private String jdbcDriverClassName;
	private String jdbcUrl;
	private String jdbcSchema;
	private String jdbcUserName;
	private String jdbcPassword;

	public String getHbDialect() {
		try {
			Object jndiAppEnviroment = new InitialContext().lookup("userRegistry.hibernateDialect");
			hbDialect = jndiAppEnviroment.toString().trim();
			return hbDialect;
		} catch (NamingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getHbDefaultSchema() {
		try {
			Object jndiAppEnviroment = new InitialContext().lookup("userRegistry.hibernateDefaultSchema");
			hbDefaultSchema = jndiAppEnviroment.toString().trim();
			return hbDefaultSchema;
		} catch (NamingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getHbHbm2ddl() {
		try {
			Object jndiAppEnviroment = new InitialContext().lookup("userRegistry.hibernateHbm2ddlAuto");
			hbHbm2ddl = jndiAppEnviroment.toString().trim();
			return hbHbm2ddl;
		} catch (NamingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getHbShowSql() {
		try {
			Object jndiAppEnviroment = new InitialContext().lookup("userRegistry.hibernateShowSql");
			hbShowSql = jndiAppEnviroment.toString().trim();
			return hbShowSql;
		} catch (NamingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getHbFormatSql() {
		try {
			Object jndiAppEnviroment = new InitialContext().lookup("userRegistry.hibernateFormatSql");
			hbFormatSql = jndiAppEnviroment.toString().trim();
			return hbFormatSql;
		} catch (NamingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getJdbcDriverClassName() {
		try {
			Object jndiAppEnviroment = new InitialContext().lookup("jdbcDriverClassName");
			jdbcDriverClassName = jndiAppEnviroment.toString().trim();
			return jdbcDriverClassName;
		} catch (NamingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getJdbcUrl() {
		try {
			Object jndiAppEnviroment = new InitialContext().lookup("userRegistry.jdbcUrl");
			jdbcUrl = jndiAppEnviroment.toString().trim();
			return jdbcUrl;
		} catch (NamingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getJdbcSchema() {
		try {
			Object jndiAppEnviroment = new InitialContext().lookup("userRegistry.jdbcSchema");
			jdbcSchema = jndiAppEnviroment.toString().trim();
			return jdbcSchema;
		} catch (NamingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getJdbcUserName() {
		try {
			Object jndiAppEnviroment = new InitialContext().lookup("userRegistry.jdbcUsername");
			jdbcUserName = jndiAppEnviroment.toString().trim();
			return jdbcUserName;
		} catch (NamingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getJdbcPassword() {
		try {
			Object jndiAppEnviroment = new InitialContext().lookup("userRegistry.jdbcPassword");
			jdbcPassword = jndiAppEnviroment.toString().trim();
			return jdbcPassword;
		} catch (NamingException e) {
			e.printStackTrace();
			return "";
		}
	}

}
