package com.augustconsulting.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.augustconsulting"})
public class SpringWebConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry reg){
		reg.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	 @Bean(name="messageSource") 
	 public MessageSource getMessageSource(){
		 ResourceBundleMessageSource messageSource = new
		 ResourceBundleMessageSource(); messageSource.setBasename("messages"); return
		 messageSource; 
	 }
	 
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setViewClass(JstlView.class);
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;
	}
	@Bean
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    resolver.setDefaultEncoding("utf-8");
	    resolver.setMaxUploadSize(50000000);
	    return resolver;
	}
	
	
}
