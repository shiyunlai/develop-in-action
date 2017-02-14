/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic3.bizadvice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.syl.inaction.pattern.proxy.dynamic3.bizcontorl.OverrideBizCtlService;
import org.syl.inaction.pattern.proxy.dynamic3.txengine.ITXEngine;
import org.syl.inaction.pattern.proxy.dynamic3.txengine.TXOprRequest;
import org.syl.inaction.pattern.proxy.dynamic3.txengine.TXOprResult;

/**
 * 
 * 交易引擎代理：交易操作时执行授权处理
 * 
 * @author megapro
 *
 */
public class OverrideInvocationHandler implements InvocationHandler {
	
	/** 被代理的交易引擎 */
	private ITXEngine txEngine = null ; 
	
	public OverrideInvocationHandler(ITXEngine txEngine){
		
		this.txEngine = txEngine ; 
	}
	
	public ITXEngine getTxEngine() {
		return txEngine;
	}
	
	public void setTxEngine(ITXEngine txEngine) {
		this.txEngine = txEngine;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		/*
		 * 把授权业务控制 织入交易操作处理 
		 */
		TXOprResult r = null ; 
		TXOprRequest txRequest = (TXOprRequest)args[0] ; 
		if( OverrideBizCtlService.isNeedOverride(txRequest) ){
			r = OverrideBizCtlService.doOverride(txRequest) ; 
		}else{
			r = (TXOprResult) method.invoke(this.txEngine, args) ; 
		}
		
		return r;
	}

}
