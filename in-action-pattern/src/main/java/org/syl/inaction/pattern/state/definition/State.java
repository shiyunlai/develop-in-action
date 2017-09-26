package org.syl.inaction.pattern.state.definition;

/**
 * 状态接口
 * @author megapro
 *
 */
public interface State {

	/**
	 * 不同状态对应的处理行为
	 * @param params
	 */
	public void handler( String params ) ; 
}
