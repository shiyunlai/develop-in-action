/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic3.txengine;

/**
 * 
 * 交易引擎接口
 * 
 * @author megapro
 *
 */
public interface ITXEngine {
	
	/**
	 * 提交交易
	 * @param txRequest
	 * @return
	 */
	public TXOprResult commitTX(TXOprRequest txRequest) ;

	/**
	 * 重提交交易
	 * @param txRequest
	 * @return
	 */
	public TXOprResult agCommitTX(TXOprRequest txRequest) ;

	/**
	 * 关闭交易
	 * @param txRequest
	 * @return
	 */
	public TXOprResult closeTX(TXOprRequest txRequest) ;
	
}
