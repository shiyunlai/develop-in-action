/**
 * 
 */
package org.syl.inaction.pattern.observer.demo1;

/**
 * 
 * 抽象观察者角色类
 * 
 * @author megapro
 *
 */
public interface Observer {
	
	/**
     * 更新接口
     * @param state    更新的状态
     */
    public void update(String state);
}
