/**
 * 
 */
package org.syl.inaction.pattern.observer.demo2;

import java.util.Observable;

/**
 * <pre>
 * 使用JAVA所提供的对观察者模式
 * 
 * 被观察者对象，集成 Observable 接口
 * </pre>
 * 
 * @author megapro
 *
 */
public class Watched extends Observable {

	private String data = "";

	public String getData() {
		return data;
	}

	public void setData(String data) {

		if (!this.data.equals(data)) {
			this.data = data;
			setChanged();
		}
		notifyObservers();
	}
}
