package com.spring.conifg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {

	private static final Logger logger = LogManager.getLogger(SecurityWebInitializer.class);
	
	public SecurityWebInitializer() {
		super(new Class<?>[] {SecurityConfig.class});
		logger.info("==============SecurityWebInitializer.class=======create=============");
	}
}
