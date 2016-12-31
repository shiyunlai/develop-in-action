/**
 * 
 */
package org.syl.inaction.pattern.observer.demo2;

import java.util.Observable;
import java.util.Observer;

/**
 * @author megapro
 *
 */
public class WatcherB implements Observer {

	public WatcherB(Observable o){
        o.addObserver(this);
    }
	
	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("观察者B：状态发生改变：" + ((Watched)o).getData());
	}
}
