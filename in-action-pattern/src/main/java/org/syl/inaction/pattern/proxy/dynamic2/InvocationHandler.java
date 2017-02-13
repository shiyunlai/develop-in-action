/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic2;

import java.lang.reflect.Method;

/**
 * 代理加工接口和实现类：TimeHandler类实现了InvocationHandler接口，能够invoke（Object object，Method m）在object的m方法前后加上自己记录时间的逻辑，并不是代理类，只是提供了对被代理类的加工逻辑；
 * @author megapro
 *
 */
public interface InvocationHandler {
	 public void invoke(Object o,Method m);
}
