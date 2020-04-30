package com.estacio.shipMe.config;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.stereotype.Component;

@Component
public class Environment {

	public String getEnvironment() {
		try {
			Object jndiAppEnviroment = new InitialContext().lookup("environment");
			return jndiAppEnviroment.toString().trim();
		} catch (NamingException e) {
			e.printStackTrace();
			return "";
		}
	}

}
