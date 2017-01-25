/**
 * 
 */
package org.syl.inaction.pattern.decorator;

import org.syl.inaction.pattern.decorator.demo1.Bird;
import org.syl.inaction.pattern.decorator.demo1.Fish;
import org.syl.inaction.pattern.decorator.demo1.Monkey;
import org.syl.inaction.pattern.decorator.demo1.TheGreatestSage;

/**
 * 
 * 装饰者模式
 * 
 * @author megapro
 *
 */
public class DecoratorDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * 透明性的要求：变量申明为接口
		 * 装饰模式对客户端的透明性要求程序不要声明一个ConcreteComponent类型的变量，而应当声明一个Component类型的变量
		 * 用孙悟空的例子来说，必须永远把孙悟空的所有变化都当成孙悟空来对待，而如果把老孙变成的鱼儿当成鱼儿，而不是老孙，那就被老孙骗了，而这时不应当发生的。
		 */
		TheGreatestSage sage = new Monkey();
        TheGreatestSage bird = new Bird(sage);
        TheGreatestSage fish = new Fish(bird);
        
        bird.move(); 
        fish.move(); 
        
        System.out.println("==================");
        /*
         * 半透明的装饰模式
         * 半透明的装饰模式是介于装饰模式和适配器模式之间的。
         * 适配器模式的用意是改变所考虑的类的接口，也可以通过改写一个或几个方法，
         * 或增加新的方法来增强或改变所考虑的类的功能。
         * 大多数的装饰模式实际上是半透明的装饰模式，这样的装饰模式也称做半装饰、半适配器模式
         */
        Bird bird2 = new Bird(sage) ;
        bird2.fly(); 
        
        /*
         * 装饰模式的优点
         * （1）装饰模式与继承关系的目的都是要扩展对象的功能，但是装饰模式可以提供比继承更多的灵活性。
         * 装饰模式允许系统动态决定“贴上”一个需要的“装饰”，或者除掉一个不需要的“装饰”。
         * 继承关系则不同，继承关系是静态的，它在系统运行前就决定了。
         * 
         * （2）通过使用不同的具体装饰类以及这些装饰类的排列组合，设计师可以创造出很多不同行为的组合。
         * 
         * 缺点
         * 由于使用装饰模式，可以比使用继承关系需要较少数目的类。使用较少的类，当然使设计比较易于进行。
         * 但是，在另一方面，使用装饰模式会产生比使用继承关系更多的对象。
         * 更多的对象会使得查错变得困难，特别是这些对象看上去都很相像。
         * 
         */
	}

}
