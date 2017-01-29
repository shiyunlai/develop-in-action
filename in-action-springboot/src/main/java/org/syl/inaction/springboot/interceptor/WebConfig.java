/**
 * 
 */
package org.syl.inaction.springboot.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置Interceptor
 * 
 * @author megapro
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	Logger logger = LoggerFactory.getLogger(WebConfig.class) ;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		logger.info("====== here in WebConfig.addInterceptors() 开始注册自定义interceptor");
		registry.addInterceptor(new MyInterceptor());
	}
}
