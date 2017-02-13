/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


/**
 * 
 * 对ISubject的动态代理
 * 
 * @author megapro
 *
 */
public class DynamicProxy{
	
	/**
	 * 为interfaces创建具备handler处理能力的动态代理类(创建过程)
	 * @param classLoader 一个ClassLoader对象，定义了由哪个ClassLoader对象，来对生产的代理进行加载。
	 * @param interfaces 一个Interfaces数组，表示我将要给我所代理的对象提供一组什么样的接口，如果提供一组接口给它，那么该代理对象就宣称实现了该接口，从而可以调用接口中的方法。即，查找出真是主题类的所实现的所有的接口。
	 * @param handler 一个InvocationHandler对象，表示当我这个动态代理对象在调用方法时，会关联到该InvocationHandler对象,该InvocationHandler与主题类有着关联。
	 * @return
	 */
    public static <T> T newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces, InvocationHandler handler){
        @SuppressWarnings("unchecked")
        T t = (T) Proxy.newProxyInstance(classLoader, interfaces, handler);
        return t;
    }
    
    /**
     * 创建具备前后增强能力的ISubject动态代理对象
     * 对newProxyInstance的进一步封装，返回特定意义的动态代理对象
     * @param subject
     * @return 
     */
	public static <T> T createBAndAAdviceSubjectProxy(ISubject subject) {

		ClassLoader classLoader = subject.getClass().getClassLoader();
		Class<?>[] interfaces = subject.getClass().getInterfaces();
		
		//特定意义的代理过程
		InvocationHandler handler = new MyInvocationHandler(subject);
		
		T t = newProxyInstance(classLoader, interfaces, handler);
		return t;
	}

}
