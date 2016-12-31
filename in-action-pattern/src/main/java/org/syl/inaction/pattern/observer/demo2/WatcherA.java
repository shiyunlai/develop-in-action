/**
 * 
 */
package org.syl.inaction.pattern.observer.demo2;

import java.util.Observable;
import java.util.Observer;

/**
 * <pre>
 * 使用JAVA所提供的对观察者模式
 * 
 * 观察者对象A，实现 Observer 接口
 * </pre>
 * 
 * @author megapro
 *
 */
public class WatcherA implements Observer  {

	/**
	 * <pre>
	 * 构造函数
	 * 指定被被观察者
	 * </pre>
	 * @param o
	 */
	public WatcherA(Observable o){
        o.addObserver(this);//创建时，注册为 Observable对象的观察者
    }
	
	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("观察者A：状态发生改变：" + ((Watched)o).getData());
	}

}
