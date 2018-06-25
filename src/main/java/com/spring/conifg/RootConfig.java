package com.spring.conifg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//import com.spring.mvc.ScanFlag;

@Configuration
@ComponentScan(//basePackageClasses={ScanFlag.class},
	excludeFilters={
		@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)	
	}
)
public class RootConfig {
	
	public RootConfig() {
		System.out.println("==========================RootConfig create============================");
	}

}
