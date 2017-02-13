/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 
 * 对被代理类的加工逻辑<br/>
 * 在被执行方法的前、后进行增强处理（IAdvice）
 * 
 * @author megapro
 *
 */
public class MyInvocationHandler implements InvocationHandler {

	// 被代理的对象
	private ISubject realSubject;

	// 通过MyInvocationHandler的构造方法将被代理对象传递过来。
	public MyInvocationHandler(ISubject realSubject) {
		this.realSubject = realSubject;
	}

	// 执行被代理类的方法。
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		// 在执行方法前，执行前置通知。
		IAdvice beforeAdvice = new BeforeAdvice();
		beforeAdvice.exec(method);
		
		Object result = method.invoke(this.realSubject, args);
		
		// 在执行方法后，执行后置通知。
		IAdvice afterAdvice = new AfterAdvice();
		afterAdvice.exec(method);
		
		// 前置通知，和后置通知，都是要看具体实际的业务需求来进行添加。
		return result;
	}

}
