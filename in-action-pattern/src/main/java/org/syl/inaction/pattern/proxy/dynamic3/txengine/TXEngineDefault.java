/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic3.txengine;

/**
 * 交易引擎（默认实现）
 * @author megapro
 *
 */
public class TXEngineDefault implements ITXEngine {

	/* (non-Javadoc)
	 * @see org.syl.inaction.pattern.proxy.dynamic3.ITXEngine#commitTX(org.syl.inaction.pattern.proxy.dynamic3.TXOprRequest)
	 */
	@Override
	public TXOprResult commitTX(TXOprRequest txRequest) {
		
		System.out.println("\n\n"+TXEngineDefault.class.getName()+" commitTX is doing ...");
		System.out.println("提交交易： "+ txRequest);
		
		TXOprResult r = new TXOprResult() ; 
		r.setBizSucc(true);
		r.setRetCode("00000");
		
		System.out.println(TXEngineDefault.class.getName()+" commitTX is done ...");
		
		return r;
	}

	/* (non-Javadoc)
	 * @see org.syl.inaction.pattern.proxy.dynamic3.ITXEngine#cancelTX(org.syl.inaction.pattern.proxy.dynamic3.TXOprRequest)
	 */
	@Override
	public TXOprResult agCommitTX(TXOprRequest txRequest) {
		
		System.out.println("\n\n"+TXEngineDefault.class.getName()+" reCommitTX is doing ...");
		System.out.println("重提交交易： "+ txRequest);
		
		TXOprResult r = new TXOprResult() ; 
		r.setBizSucc(true);
		r.setRetCode("00000");
		
		System.out.println(TXEngineDefault.class.getName()+" reCommitTX is done ...");

		return r;
	}

	/* (non-Javadoc)
	 * @see org.syl.inaction.pattern.proxy.dynamic3.ITXEngine#closeTX(org.syl.inaction.pattern.proxy.dynamic3.TXOprRequest)
	 */
	@Override
	public TXOprResult closeTX(TXOprRequest txRequest) {

		System.out.println("\n\n"+TXEngineDefault.class.getName()+" closeTX is doing ...");
		System.out.println("关闭交易： "+ txRequest);
		
		TXOprResult r = new TXOprResult() ; 
		r.setBizSucc(true);
		r.setRetCode("00000");
		
		System.out.println(TXEngineDefault.class.getName()+" closeTX is done ...");
		
		return r;
	}

}
