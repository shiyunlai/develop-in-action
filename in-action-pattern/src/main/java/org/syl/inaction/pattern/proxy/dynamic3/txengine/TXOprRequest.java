/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic3.txengine;

import java.io.Serializable;

/**
 * 
 * 交易操作请求
 * 
 * @author megapro
 *
 */
public class TXOprRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 交易代码
	 */
	private String txCode ;

	/**
	 * 交易操作功能码
	 */
	private String oprFunCode ;
	
	/**
	 * 交易操作请求数据
	 */
	private Object requestData ;

	public String getTxCode() {
		return txCode;
	}

	public void setTxCode(String txCode) {
		this.txCode = txCode;
	}

	public String getOprFunCode() {
		return oprFunCode;
	}

	public void setOprFunCode(String oprFunCode) {
		this.oprFunCode = oprFunCode;
	}

	public Object getRequestData() {
		return requestData;
	}

	public void setRequestData(Object requestData) {
		this.requestData = requestData;
	} 
	
	public String toString(){
		StringBuffer sb = new StringBuffer() ; 
		sb.append("txCode = ").append(txCode).append(", ") ; 
		sb.append("oprFunCode = ").append(oprFunCode) ; 
		return sb.toString() ; 
	}
}
