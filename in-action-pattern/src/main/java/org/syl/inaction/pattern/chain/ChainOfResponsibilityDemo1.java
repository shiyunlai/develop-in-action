/**
 * 
 */
package org.syl.inaction.pattern.chain;

import org.syl.inaction.pattern.chain.demo1.ConcreteHandler;
import org.syl.inaction.pattern.chain.demo1.Handler;

/**
 * 本示例的传递逻辑非常简单：只要有下家，就传给下家处理；如果没有下家，就自行处理。
 * 
 * @author megapro
 *
 */
public class ChainOfResponsibilityDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//组装责任链
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        Handler handler3 = new ConcreteHandler();
        
        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);
        
        //提交请求
        handler1.handleRequest();

	}

}
