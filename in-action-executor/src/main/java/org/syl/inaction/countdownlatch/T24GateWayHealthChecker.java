/**
 * 
 */
package org.syl.inaction.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 检查T24通道健康状况
 * @author megapro
 *
 */
public class T24GateWayHealthChecker extends AbstractHealthChecker {

	public T24GateWayHealthChecker( CountDownLatch latch) {
		super("检查T24通道健康状况", latch);
	}

	/* (non-Javadoc)
	 * @see org.shiyl.countdownlatch.AbstractHealthChecker#verifyService()
	 */
	@Override
	public void verifyService() {
		System.out.println("Checking " + this.getServiceName());
		try {
			Thread.sleep(5000);// 模拟健康检查过程耗时
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getServiceName() + " is UP");
	}

}
