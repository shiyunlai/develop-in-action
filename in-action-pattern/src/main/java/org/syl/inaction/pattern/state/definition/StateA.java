/**
 * 
 */
package org.syl.inaction.pattern.state.definition;

/**
 * A状态
 * @author megapro
 *
 */
public class StateA implements State{

	@Override
	public void handler(String params) {
		System.out.println(" State A handler : "+params);
	}

}
