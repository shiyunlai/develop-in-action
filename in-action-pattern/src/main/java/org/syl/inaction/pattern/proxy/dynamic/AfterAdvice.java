/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic;

import java.lang.reflect.Method;

/**
 * 
 * 方法执行后加强行为
 * 
 * @author megapro
 *
 */
public class AfterAdvice implements IAdvice {

	/* (non-Javadoc)
	 * @see org.syl.inaction.pattern.proxy.dynamic.IAdvice#exec(java.lang.reflect.Method)
	 */
	@Override
	public void exec(Method m) {
		System.out.println("执行<"+m.getName()+">后，做增强处理.....");
	}

}
