/**
 * 
 */
package org.syl.inaction.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * 检查数据库健康状况
 * @author megapro
 *
 */
public class DataBaseHealthChecher extends AbstractHealthChecker {

	public DataBaseHealthChecher(CountDownLatch latch) {
		super("检查数据库健康状况", latch);
	}

	/* (non-Javadoc)
	 * @see org.shiyl.countdownlatch.AbstractHealthChecker#verifyService()
	 */
	@Override
	public void verifyService() {
		System.out.println("Checking " + this.getServiceName());
		try {
			Thread.sleep(10000);// 模拟健康检查过程耗时
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getServiceName() + " is UP");
	}

}
