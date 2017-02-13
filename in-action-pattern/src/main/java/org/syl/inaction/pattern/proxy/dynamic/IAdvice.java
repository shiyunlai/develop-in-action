/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic;

import java.lang.reflect.Method;

/**
 * 
 * 接口：加强逻辑接口
 * 
 * @author megapro
 *
 */
public interface IAdvice {

	/**
	 * 增强逻辑
	 * <br/>在被代理的方法执行前，从而达到扩展功能
	 */
	public void exec(Method m) ; 
}
