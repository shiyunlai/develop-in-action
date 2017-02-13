/**
 * 
 */
package org.syl.inaction.pattern.proxy;

import org.syl.inaction.pattern.proxy.dynamic2.IMoveable;
import org.syl.inaction.pattern.proxy.dynamic2.InvocationHandler;
import org.syl.inaction.pattern.proxy.dynamic2.Proxy;
import org.syl.inaction.pattern.proxy.dynamic2.Tank;
import org.syl.inaction.pattern.proxy.dynamic2.TimeHandler;

/**
 * @author megapro
 *
 */
public class ProxyPatternDynamic2Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IMoveable m = new Tank(); 
		InvocationHandler h = new TimeHandler();
        try {
            IMoveable moveableProxy = (IMoveable) Proxy.newInstance(IMoveable.class, h);
            moveableProxy.move();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
