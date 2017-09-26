/**
 * 
 */
package org.syl.inaction.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * 监控检查项
 * 
 * @author megapro
 *
 */
public abstract class AbstractHealthChecker implements Runnable {

	/**
	 * 检查项数目
	 */
	private CountDownLatch _latch;
	/**
	 * 检查项名称
	 */
	private String _serviceName;
	/**
	 * 检查结果
	 */
	private boolean _serviceUp;

	// Get latch object in constructor so that after completing the task, thread
	// can countDown() the latch
	public AbstractHealthChecker(String serviceName, CountDownLatch latch) {
		super();
		this._latch = latch;
		this._serviceName = serviceName;
		this._serviceUp = false;
	}

	@Override
	public void run() {
		try {
			verifyService();
			_serviceUp = true;
		} catch (Throwable t) {
			t.printStackTrace(System.err);
			_serviceUp = false;
		} finally {
			if (_latch != null) {
				_latch.countDown();
			}
		}
	}

	public String getServiceName() {
		return _serviceName;
	}

	public boolean isServiceUp() {
		return _serviceUp;
	}

	/**
	 * 具体的监控检查处理过程
	 * This methos needs to be implemented by all specific service checker
	 */
	public abstract void verifyService();
}
