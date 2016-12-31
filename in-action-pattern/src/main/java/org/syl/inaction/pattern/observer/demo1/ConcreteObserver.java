/**
 * 
 */
package org.syl.inaction.pattern.observer.demo1;

/**
 * 具体观察者角色类
 * 
 * @author megapro
 *
 */
public class ConcreteObserver implements Observer {

	//观察者的状态
    private String observerState;
    
	/* (non-Javadoc)
	 * @see org.syl.inaction.pattern.observer.demo1.Observer#update(java.lang.String)
	 */
	@Override
	public void update(String state) {
		
		/*
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = state;
        System.out.println("状态为："+observerState);
	}

}
