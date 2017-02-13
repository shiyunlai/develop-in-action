/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic;

/**
 * 
 * 实现：具体的某个主题
 * 
 * @author megapro
 *
 */
public class ConcreteSubject implements ISubject {

	/* (non-Javadoc)
	 * @see org.syl.inaction.pattern.proxy.dynamic.ISubject#doSomething(java.lang.String)
	 */
	@Override
	public String doSomething(String str) {
		
		System.out.println("ConcreteSubject 执行具体的业务逻辑处理:" + str);
		
		return "真实方法" ; 
	}

}
