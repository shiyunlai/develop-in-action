/**
 * 
 */
package org.syl.inaction.pattern.observer;

import java.util.Observer;

import org.syl.inaction.pattern.observer.demo2.Watched;
import org.syl.inaction.pattern.observer.demo2.WatcherA;
import org.syl.inaction.pattern.observer.demo2.WatcherB;

/**
 * <pre>
 * 使用JAVA对观察者模式的支持
 * 被观察者（Watched）对象继承自java.util.Observable类；
 * 观察者（Watcher）对象实现了java.util.Observer接口；
 * </pre>
 * 
 * @author megapro
 *
 */
public class ObserverPatternDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//创建被观察者对象
        Watched watched = new Watched();
        
        //创建观察者对象，并将被观察者对象登记
        Observer watchera = new WatcherA(watched);
        Observer watcherb = new WatcherB(watched);
        
        //给被观察者状态赋值
        watched.setData("start");
        watched.setData("run");
        watched.setData("stop");
	}

}
