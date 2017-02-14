/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic3.txengine;

import java.io.Serializable;

/**
 * 
 * 交易操作处理结果
 * 
 * @author megapro
 *
 */
public class TXOprResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 业务逻辑上，交易处理成功标识 true - 成功 false - 处理失败 
	 */
	private boolean bizSucc = true ;
	
	/**
	 * 交易处理响应码
	 * <br/> 默认 00000 为成功
	 */
	private String retCode = "00000" ; 
	
	/**
	 * 交易处理响应信息
	 */
	private String retMsg = "交易操作处理成功" ; 
	
	/**
	 * 交易处理响应数据
	 */
	private Object responseData = null ;

	public boolean isBizSucc() {
		return bizSucc;
	}

	public void setBizSucc(boolean bizSucc) {
		this.bizSucc = bizSucc;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getRetMsg() {
		return retMsg;
	}
	
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	
	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	} 
	
	public String toString() {
		StringBuffer sb = new StringBuffer() ; 
		sb.append("bizSucc = ").append(bizSucc).append(", ") ; 
		sb.append("retCode = ").append(retCode).append(", ") ; 
		sb.append("retMsg = ").append(retMsg) ; 
		return sb.toString() ; 
	}
}
