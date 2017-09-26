/**
 * 
 */
package org.syl.inaction.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * 检查缓存健康状况
 * 
 * @author megapro
 *
 */
public class CacheHealthChecker extends AbstractHealthChecker {

	public CacheHealthChecker(CountDownLatch latch) {
		super("检查缓存健康状况", latch);
	}

	@Override
	public void verifyService() {
		System.out.println("Checking " + this.getServiceName());
		try {
			Thread.sleep(7000);// 模拟健康检查过程耗时
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getServiceName() + " is UP");
	}

}
