/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic3.bizadvice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.syl.inaction.pattern.proxy.dynamic3.bizcontorl.CheckBizCtlService;
import org.syl.inaction.pattern.proxy.dynamic3.txengine.ITXEngine;
import org.syl.inaction.pattern.proxy.dynamic3.txengine.TXOprRequest;
import org.syl.inaction.pattern.proxy.dynamic3.txengine.TXOprResult;

/**
 * <pre>
 * 交易引擎代理：交易操作时执行复核处理
 * 
 * </pre>
 * @author megapro
 *
 */
public class CheckInvocationHandler implements InvocationHandler{

	/** 被代理的交易引擎 */
	private ITXEngine txEngine = null ; 
	
	public CheckInvocationHandler(ITXEngine txEngine){
		
		this.txEngine = txEngine ; 
	}
	
	public ITXEngine getTxEngine() {
		return txEngine;
	}

	public void setTxEngine(ITXEngine txEngine) {
		this.txEngine = txEngine;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		TXOprResult r = new TXOprResult() ; 
		
		TXOprRequest txRequest = (TXOprRequest)args[0] 
				; 
		//先检查是否做复核处理
		if( CheckBizCtlService.isNeedCheck(txRequest) ) {
			r = CheckBizCtlService.doCheck(txRequest) ; 
		}
		//否则直接执行交易操作
		else{
			r = (TXOprResult) method.invoke(this.txEngine, args) ; 
		}
		
		//再检查是否要做授权处理
		return r;
	}
}
