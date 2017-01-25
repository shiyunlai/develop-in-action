/**
 * 
 */
package org.syl.inaction.pattern.adapter.demo1;

/**
 * <pre>
 * 类适配器
 * 
 * 适配器角色Adapter扩展了Adaptee,同时又实现了目标(Target)接口。
 * 由于Adaptee没有提供sampleOperation2()方法，
 * 而目标接口又要求这个方法，因此适配器角色Adapter实现了这个方法。
 * 
 * </pre>
 * 
 * @author megapro
 *
 */
public class AdapterClass extends Adaptee implements Target {

	/**
	 * 由于源类Adaptee没有方法sampleOperation2() 因此适配器补充上这个方法
	 */
	@Override
	public void sampleOperation2() {
		// 写相关的代码
	}
}
