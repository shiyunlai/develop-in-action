/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic2;

import java.lang.reflect.Method;

/**
 * @author megapro
 *
 */
public class TimeHandler implements InvocationHandler {

	/* (non-Javadoc)
	 * @see org.syl.inaction.pattern.proxy.dynamic2.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method)
	 */
	@Override
	public void invoke(Object o, Method m) {
		System.out.println("Time Before "+m.getName());
        try {
            m.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        System.out.println("Time After  "+m.getName());
	}

}
