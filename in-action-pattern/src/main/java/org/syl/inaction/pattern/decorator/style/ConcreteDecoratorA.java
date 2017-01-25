/**
 * 
 */
package org.syl.inaction.pattern.decorator.style;

/**
 * 
 * 
 * @author megapro
 *
 */
public class ConcreteDecoratorA extends Decorator {

	public ConcreteDecoratorA(Component component) {
		super(component);
	}

	@Override
	public void operation() {
		super.operation();
		// 写相关的业务代码
	}
}
