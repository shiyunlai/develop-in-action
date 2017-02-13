/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic2;

import java.util.Random;

/**
 * @author megapro
 *
 */
public class Tank implements IMoveable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.syl.inaction.pattern.proxy.dynamic2.IMoveable#move()
	 */
	@Override
	public void move() {
		System.out.println("Tank moving....");
		try {
			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
