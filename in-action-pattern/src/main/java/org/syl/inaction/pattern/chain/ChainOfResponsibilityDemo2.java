/**
 * 
 */
package org.syl.inaction.pattern.chain;

import org.syl.inaction.pattern.chain.demo2.ApproveHandler;
import org.syl.inaction.pattern.chain.demo2.DeptManager;
import org.syl.inaction.pattern.chain.demo2.GeneralManager;
import org.syl.inaction.pattern.chain.demo2.ProjectManager;

/**
 * <pre>
 * 场景：
 * 申请聚餐费用的大致流程一般是：由申请人先填写申请单，然后交给领导审批，如果申请批准下来，
 * 领导会通知申请人审批通过，然后申请人去财务领取费用，如果没有批准下来，领导会通知申请人审批未通过，
 * 此事也就此作罢。
 * 
 * 不同级别的领导，对于审批的额度是不一样的，
 * 比如，项目经理只能审批500元以内的申请；部门经理能审批1000元以内的申请；而总经理可以审核任意额度的申请。
 * 
 * 可以使用责任链模式来实现上述功能：
 * 当某人提出聚餐费用申请的请求后，该请求会在 项目经理—〉部门经理—〉总经理 
 * 这样一条领导处理链上进行传递，发出请求的人并不知道谁会来处理他的请求，
 * 每个领导会根据自己的职责范围，来判断是处理请求还是把请求交给更高级别的领导，
 * 只要有领导处理了，传递就结束了。
 * 
 * </pre>
 * @author megapro
 *
 */
public class ChainOfResponsibilityDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 //先要组装责任链
        ApproveHandler gm = new GeneralManager();
        ApproveHandler dm = new DeptManager();
        ApproveHandler pm = new ProjectManager();
        
        //项目经理—〉部门经理—〉总经理 
        pm.setSuccessor(dm);
        dm.setSuccessor(gm);
        
        //开始测试
        String test1 = pm.handleFeeRequest("张三", 300);
        System.out.println("test1 = " + test1);
        String test2 = pm.handleFeeRequest("李四", 300);
        System.out.println("test2 = " + test2);
        System.out.println("---------------------------------------");
        
        String test3 = pm.handleFeeRequest("张三", 700);
        System.out.println("test3 = " + test3);
        String test4 = pm.handleFeeRequest("李四", 700);
        System.out.println("test4 = " + test4);
        System.out.println("---------------------------------------");
        
        String test5 = pm.handleFeeRequest("张三", 1500);
        System.out.println("test5 = " + test5);
        String test6 = pm.handleFeeRequest("李四", 1500);
        System.out.println("test6 = " + test6);
	}

}
