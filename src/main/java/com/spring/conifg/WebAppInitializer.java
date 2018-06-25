package com.spring.conifg;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * tomcat启动时会自动加载WebAppInitializer，完成springMVC配置。
 * @author zgz
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	public WebAppInitializer() {
		System.out.println("=======================================WebAppInitializer create=============================================");
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

}
