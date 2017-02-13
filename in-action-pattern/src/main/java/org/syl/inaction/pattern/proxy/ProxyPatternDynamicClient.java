/**
 * 
 */
package org.syl.inaction.pattern.proxy;

import java.lang.reflect.InvocationHandler;

import org.syl.inaction.pattern.proxy.dynamic.ConcreteSubject;
import org.syl.inaction.pattern.proxy.dynamic.DynamicProxy;
import org.syl.inaction.pattern.proxy.dynamic.ISubject;
import org.syl.inaction.pattern.proxy.dynamic.MyInvocationHandler;

/**
 * @author megapro
 *
 */
public class ProxyPatternDynamicClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		scene1() ; 
		scene2() ; 
	}
	
	// 第一种调用场景
	public static void scene1() {
		
		ISubject realSubject = new ConcreteSubject();
		
		InvocationHandler handler = new MyInvocationHandler(realSubject);
		ClassLoader classLoader = realSubject.getClass().getClassLoader();
		Class<?>[] interfaces = realSubject.getClass().getInterfaces();
		ISubject proxySubect = DynamicProxy.newProxyInstance(classLoader,interfaces, handler);
		
		proxySubect.doSomething("scene1: 动态代理AOP调用") ; 
	}
	
	// 第二种调用场景
	public static void scene2() {
		
		ISubject realSubject = new ConcreteSubject();
		
		ISubject proxySubject = DynamicProxy.createBAndAAdviceSubjectProxy(realSubject) ; 
		
		proxySubject.doSomething("scene2: 动态代理AOP调用") ; 
	}
}
