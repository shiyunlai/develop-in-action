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
 * 复核业务处理服务
 * 
 * @author megapro
 *
 */
public class CheckBizCtlService {

	private static List<String/*交易操作功能码*/> needCheckOprFunCode = new ArrayList<String>() ; 
	
	static {
		needCheckOprFunCode.add("agCommitTX") ; //只有再提交需要复核
	}

	public static boolean isNeedCheck(TXOprRequest txRequest) {
		if( needCheckOprFunCode.contains(txRequest.getOprFunCode())){
			return true ; //需要复核
		}
		return false;//无需复核
	}

	public static TXOprResult doCheck(TXOprRequest txRequest) {
		TXOprResult r = new TXOprResult() ; 
		r.setBizSucc(true);//业务处理成功
		r.setRetCode("88888");//交易操作需要授权
		r.setRetMsg("交易["+txRequest.getTxCode()+"]执行操作["+txRequest.getOprFunCode()+"]时需要复核处理！");
		r.setResponseData("这里模拟返回复核要求");
		return r;
	}
	
	
}
