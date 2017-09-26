/**
 * 
 */
package org.syl.inaction.pattern.state.definition;

/**
 * B状态
 * @author megapro
 *
 */
public class StateB implements State {

	/* (non-Javadoc)
	 * @see org.syl.inaction.pattern.state.definition.State#handler(java.lang.String)
	 */
	@Override
	public void handler(String params) {
		System.out.println(" State B handler : "+params);
	}

}
