/**
 * 
 */
package org.syl.inaction.pattern.state.definition;

/**
 * 
 * 状态模式中的 环境角色
 * 
 * @author megapro
 *
 */
public class Context {

	private State state ; 
	
	/**
	 * 设置不同的状态
	 * @param state
	 */
	public void setState(State state) {
		this.state = state ; 
	}
	
	/**
	 * 随着状态的改变，dowork的行为也发生变化
	 * @param params
	 */
	public void dowork( String params ){
		
		this.state.handler(params);
	}
}
