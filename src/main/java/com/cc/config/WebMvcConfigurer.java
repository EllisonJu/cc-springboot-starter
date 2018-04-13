package com.cc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.cc.controller.interceptor.OneInterceptor;
import com.cc.controller.interceptor.TwoInterceptor;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器按照顺序执行
		 */
		registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");
		registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
													 .addPathPatterns("/one/**");
		
		super.addInterceptors(registry);
	}

}
