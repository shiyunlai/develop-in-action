/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic;

import java.lang.reflect.Method;

/**
 * 
 * 方法执行前加强行为
 * 
 * @author megapro
 *
 */
public class BeforeAdvice implements IAdvice {

	@Override
	public void exec(Method m) {
		System.out.println("执行<"+m.getName()+">前，做增强处理.....");
	}

}
