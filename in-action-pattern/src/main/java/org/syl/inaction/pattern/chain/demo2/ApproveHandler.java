package org.syl.inaction.pattern.chain.demo2;

/**
 * 审批者抽象实现
 * @author megapro
 *
 */
public abstract class ApproveHandler {

	 /**
     * 持有下一个处理请求的对象
     */
    protected ApproveHandler successor = null;
    /**
     * 取值方法
     */
    public ApproveHandler getSuccessor() {
        return successor;
    }
    /**
     * 设置下一个处理请求的对象
     */
    public void setSuccessor(ApproveHandler successor) {
        this.successor = successor;
    }
    /**
     * 处理聚餐费用的申请
     * @param user    申请人
     * @param fee    申请的钱数
     * @return        成功或失败的具体通知
     */
    public abstract String handleFeeRequest(String user , double fee);
}
