/**
 * 
 */
package org.syl.inaction.pattern.decorator.demo1;

/**
 * 
 * 被装饰的对象：孙悟空
 * 
 * @author megapro
 *
 */
public class Monkey implements TheGreatestSage {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.syl.inaction.pattern.decorator.demo1.TheGreatestSage#move()
	 */
	@Override
	public void move() {
		System.out.println("Monkey Move");
	}

}
