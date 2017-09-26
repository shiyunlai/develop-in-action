/**
 * 
 */
package org.syl.inaction.pattern.state.vote;

/**
 * 
 * 正常投票
 * @author megapro
 *
 */
public class NormalVoteState implements VoteState {

	/* (non-Javadoc)
	 * @see org.syl.inaction.pattern.state.vote.VoteState#vote(java.lang.String, java.lang.String, org.syl.inaction.pattern.state.vote.VoteManager)
	 */
	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		//正常投票，记录到投票记录中
        voteManager.getMapVote().put(user, voteItem);
        System.out.println("恭喜投票成功");
	}

}
