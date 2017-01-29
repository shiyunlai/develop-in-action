/**
 * 
 */
package org.syl.inaction.springboot.exceptionstatus;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <pre>
 * 异常：找不到对应的资源
 * 只要抛出该异常的controller方法，浏览器端都统一收到404错误
 * </pre>
 * @author megapro
 *
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="No such resouce") //404 NOT FOUND
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
