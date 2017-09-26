/**
 * 
 */
package org.syl.inaction.pattern.state;

import org.syl.inaction.pattern.state.vote.VoteManager;

/**
 * 
 * 演示状态模式的业务场景：投票控制逻辑
 * 
 * @author megapro
 *
 */
public class StatePatternVoteClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 模拟同一用户连续投票多次，从而查看不同的投票状态变化
		VoteManager vm = new VoteManager();
		for (int i = 0; i < 9; i++) {
			vm.vote("u1", "A");
		}
	}

}
