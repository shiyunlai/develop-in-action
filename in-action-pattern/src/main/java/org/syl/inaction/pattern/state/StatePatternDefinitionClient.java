/**
 * 
 */
package org.syl.inaction.pattern.state;

import org.syl.inaction.pattern.state.definition.Context;
import org.syl.inaction.pattern.state.definition.StateA;
import org.syl.inaction.pattern.state.definition.StateB;

/**
 * 状态模式定义的演示
 * @author megapro
 *
 */
public class StatePatternDefinitionClient {

	public static void main(String[] args) {
		Context c = new Context() ; 
		StateA  a = new StateA() ;
		
		// 设置context的状态为A，改变context的行为
		c.setState(a);
		c.dowork("设置context的状态为A，改变context的行为");
		
		StateB  b = new StateB() ;
		
		// 设置状态为B，改变context的行为
		c.setState(b);
		c.dowork("设置context的状态为B，改变context的行为");
	}
}
