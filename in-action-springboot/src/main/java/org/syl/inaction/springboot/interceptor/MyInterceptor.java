/**
 * 
 */
package org.syl.inaction.springboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 实践：拦截器使用
 * 
 * @author megapro
 *
 */
public class MyInterceptor implements HandlerInterceptor {
	
	Logger logger = LoggerFactory.getLogger(WebConfig.class) ;
	
	/*
	 * 预处理回调方法，若方法返回值为true，请求继续（调用下一个拦截器或处理器方法）；若方法返回值为false，请求处理流程中断，不会继续调用其他的拦截器或处理器方法，此时需要通过response产生响应；
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("here in MyInterceptor.preHandle()");
		return true;//继续
	}

	/*
	 * 后处理回调方法，实现处理器的后处理（但在渲染视图之前），此时可以通过ModelAndView对模型数据进行处理或对视图进行处理
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("here in MyInterceptor.postHandle()");
	}

	/*
	 * 整个请求处理完毕回调方法，即在视图渲染完毕时调用
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("here in MyInterceptor.afterCompletion()");
	}

}
