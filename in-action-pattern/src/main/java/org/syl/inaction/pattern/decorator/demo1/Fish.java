/**
 * 
 */
package org.syl.inaction.pattern.decorator.demo1;

/**
 * 
 * 装饰类:Fish
 * 
 * @author megapro
 *
 */
public class Fish extends Change72 {

	public Fish(TheGreatestSage sage) {
		super(sage);
	}
	
	@Override
	public void move() {
		super.move(); 
		System.out.println("齐天大圣变成了一条Fish");
	}
	
	public void fishing(){
		System.out.println("鱼游了");
	}
}
