/**
 * 
 */
package org.syl.inaction.pattern.adapter.demo1;

/**
 * 
 * 客户端期待的接口
 * 
 * @author megapro
 *
 */
public interface Target {

	/**
	 * 这是源类Adaptee也有的方法
	 */
	public void sampleOperation1();

	/**
	 * 这是源类Adapteee没有的方法
	 */
	public void sampleOperation2();
}
