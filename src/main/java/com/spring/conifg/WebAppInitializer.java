package com.spring.conifg;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.web.Log4jServletContextListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * tomcat启动时会自动加载WebAppInitializer，完成springMVC配置。
 * @author zgz
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	private static final Logger logger = LogManager.getLogger(WebAppInitializer.class);
	
	public WebAppInitializer() {
		logger.info("=======================================WebAppInitializer create=============================================");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;// new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addListener(Log4jServletContextListener.class);
		
//		servletContext.addListener(WebSessionListener.class);
//		servletContext.setInitParameter("webAppRootKey", "spring4.root");
//		servletContext.setInitParameter("log4jConfigLocation", "classpath:log4j.properties");
//		servletContext.setInitParameter("log4jRefreshInterval", "10000");
		super.onStartup(servletContext);

	}

}
