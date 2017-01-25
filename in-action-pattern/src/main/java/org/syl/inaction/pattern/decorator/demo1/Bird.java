/**
 * 
 */
package org.syl.inaction.pattern.decorator.demo1;

/**
 * 装饰类:Bird
 * @author megapro
 *
 */
public class Bird extends Change72 {

	public Bird(TheGreatestSage sage) {
		super(sage);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void move() {
		super.move(); 
		System.out.println("齐天大圣变成了一只飞鸟");
	}

	public void fly(){
		System.out.println("鸟儿飞了");
	}
}
