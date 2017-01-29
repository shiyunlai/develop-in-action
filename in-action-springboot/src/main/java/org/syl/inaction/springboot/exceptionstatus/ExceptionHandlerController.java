/**
 * 
 */
package org.syl.inaction.springboot.exceptionstatus;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * <pre>
 * 全局异常处理
 * 
 * 最佳实践：
 * 不要在@Controller中自己进行异常处理逻辑。即使它只是一个Controller相关的特定异常，在@Controller中添加一个@ExceptionHandler方法处理。
 * 对于自定义的异常，可以考虑对其加上@ResponseStatus注解
 * 使用@ControllerAdvice处理通用异常（例如资源不存在、资源存在冲突等）
 * 
 * </pre>
 * @author megapro
 *
 */
@ControllerAdvice //全局异常处理
public class ExceptionHandlerController {
	
	public static final String DEFAULT_ERROR_VIEW = "error";
	Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class) ;
	
	/**
	 * controller方法抛出异常时，没有异常处理的，都会统一被此处处理
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		
		logger.info("===== here is ExceptionHandlerController.defaultErrorHandler()");
		
        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
            throw e;
        
        // Otherwise setup and send the user to a default error-view.
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
	
}
