/**
 * 
 */
package org.syl.inaction.pattern.decorator.style;

/**
 * 
 * 装饰者角色
 * 
 * @author megapro
 *
 */
public class Decorator implements Component {

	private Component component;

	public Decorator(Component component) {
		this.component = component;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.syl.inaction.pattern.decorator.Component#operation()
	 */
	@Override
	public void operation() {
		component.operation();
	}

}
