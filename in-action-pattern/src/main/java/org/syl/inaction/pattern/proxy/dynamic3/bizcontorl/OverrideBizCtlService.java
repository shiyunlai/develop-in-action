/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic3.bizcontorl;

import java.util.ArrayList;
import java.util.List;

import org.syl.inaction.pattern.proxy.dynamic3.txengine.TXOprRequest;
import org.syl.inaction.pattern.proxy.dynamic3.txengine.TXOprResult;

/**
 * 
 * 授权业务处理服务
 * 
 * @author megapro
 *
 */
public class OverrideBizCtlService {
	
	private static List<String/*交易操作功能码*/> needOverrideOprFunCode = new ArrayList<String>() ; 
	
	static {
		needOverrideOprFunCode.add("commitTX") ; 
		needOverrideOprFunCode.add("agCommitTX") ; 
	}
	
	/**
	 * 判断当前交易操作是否需要授权处理
	 * @param request 交易操作请求
	 * @return
	 */
	public static boolean isNeedOverride(TXOprRequest request) {
		
		/*
		 * 模拟需要授权的交易操作：
		 * 提交交易
		 * 重提交交易
		 * 不需要授权的交易操作：
		 * 关闭交易
		 */
		//TODO 实际中，此处可使用交易的授权控制参数进行检查
		if( needOverrideOprFunCode.contains(request.getOprFunCode())){
			return true ; //需要授权
		}
		
		return false;//无需授权
	}

	/**
	 * 当前交易操作执行授权处理
	 * 
	 * @param request 交易操作请求
	 * @return
	 */
	public static TXOprResult doOverride(TXOprRequest request) {
		
		//TODO 1、回复前端 overriderequirement
		//TODO 2、调用授权服务
		
		TXOprResult r = new TXOprResult() ; 
		r.setBizSucc(true);//业务处理成功
		r.setRetCode("99999");//交易操作需要授权
		r.setRetMsg("交易["+request.getTxCode()+"]执行操作["+request.getOprFunCode()+"]时需要授权处理！");
		r.setResponseData("这里模拟返回授权要求");
		return r;
	}
}
