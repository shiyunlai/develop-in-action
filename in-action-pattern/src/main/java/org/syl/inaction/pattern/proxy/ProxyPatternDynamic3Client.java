/**
 * 
 */
package org.syl.inaction.pattern.proxy;

import org.syl.inaction.pattern.proxy.dynamic3.txengine.ITXEngine;
import org.syl.inaction.pattern.proxy.dynamic3.txengine.TXEngineDefault;
import org.syl.inaction.pattern.proxy.dynamic3.txengine.TXOprRequest;
import org.syl.inaction.pattern.proxy.dynamic3.txengine.TXOprResult;


/**
 * 
 * @author megapro
 *
 */
public class ProxyPatternDynamic3Client {

	/**
	 * 模拟收到交易操作请求，执行响应的处理后，返沪处理响应给请求者
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 模拟得到交易引擎 
		ITXEngine realTXEngine = new TXEngineDefault();
		
		
		//TODO 根据参数配置获取对应的交易引擎代理
		
		ITXEngine proxyTXEngine = DynamicProxy.createOverrideTXEngineProxy(realTXEngine) ; //得到带有授权控制的交易引擎
		
		ITXEngine proxycAoTXEngine = DynamicProxy.createCheckTXEngineProxy(proxyTXEngine); //得到先复核再授权的交易引擎
		
		//
		TXOprRequest commitReq = mockCommitTXRequest() ;
		
		// 模拟服务端识别
		if( commitReq.getOprFunCode().equals( "commit" ) ){
			realTXEngine.commitTX(commitReq) ;
			proxyTXEngine.commitTX(commitReq) ;
		}
		
		
		TXOprResult res = proxyTXEngine.commitTX(commitReq) ;
		System.out.println("提交交易处理结果:"+res);
		
		//
		TXOprRequest agCommitReq = mockAgCommitTXRequest() ; 
		res = proxyTXEngine.agCommitTX(agCommitReq) ; 
		System.out.println("再提交交易处理结果:"+res);
		
		//
		TXOprRequest closeReq = mockCloseTXRequest() ; 
		res = proxyTXEngine.closeTX(closeReq) ;
		System.out.println("关闭交易处理结果:"+res);
		
		//
		res = proxycAoTXEngine.closeTX(agCommitReq) ;
		System.out.println("2222再提交交易处理结果:"+res);

		res = proxycAoTXEngine.closeTX(closeReq) ;
		System.out.println("2222关闭交易处理结果:"+res);
		
		
	}

	/**
	 * 模拟关闭交易操作请求
	 * @return
	 */
	private static TXOprRequest mockCloseTXRequest() {

		TXOprRequest req = new TXOprRequest() ; 
		req.setOprFunCode("closeTX"); 
		req.setTxCode("TX010808");
		req.setRequestData("关闭交易：我是一些交易数据");
		return req;
	}

	/**
	 * 模拟再提交交易操作请求
	 * @return
	 */
	private static TXOprRequest mockAgCommitTXRequest() {
		
		TXOprRequest req = new TXOprRequest() ; 
		req.setOprFunCode("agCommitTX"); 
		req.setTxCode("TX010808");
		req.setRequestData("再提交交易：我是一些交易数据");
		return req;
	}

	/**
	 * 模拟提交交易操作请求
	 * @return
	 */
	private static TXOprRequest mockCommitTXRequest() {
		
		TXOprRequest req = new TXOprRequest() ; 
		req.setOprFunCode("commitTX"); 
		req.setTxCode("TX010808");
		req.setRequestData("提交交易：我是一些交易数据");
		return req;
	}

}
