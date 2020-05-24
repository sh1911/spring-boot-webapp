package com.alien.bloodhelper.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class FreeMarkerFactoryConfig implements WebMvcConfigurer {
	
	
	@Primary
	@Bean
	public  FreeMarkerConfigurationFactoryBean freemarkerbean()
	{
		FreeMarkerConfigurationFactoryBean bean=new FreeMarkerConfigurationFactoryBean();
		bean.setTemplateLoaderPath("classpath:/templates");
		return bean;
	}

}
