/**
 * 
 */
package org.syl.inaction.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * 应用健康检查管理器
 * 
 * @author megapro
 *
 */
public class ApplicationHealthManager {

	// List of service checkers
	private static List<AbstractHealthChecker> _services;

	// This latch will be used to wait on
	private static CountDownLatch _latch;

	private ApplicationHealthManager() {
	}

	private final static ApplicationHealthManager INSTANCE = new ApplicationHealthManager();

	public static ApplicationHealthManager getInstance() {
		return INSTANCE;
	}

	public static boolean checkExternalServices() throws Exception {
		// Initialize the latch with number of service checkers
		_latch = new CountDownLatch(4);

		// All add checker in lists
		_services = new ArrayList<AbstractHealthChecker>();
		_services.add(new CacheHealthChecker(_latch));
		_services.add(new DataBaseHealthChecher(_latch));
		_services.add(new TWSChannelHealthChecker(_latch));
		_services.add(new T24GateWayHealthChecker(_latch));

		// Start service checkers using executor framework
		ExecutorService executor = Executors.newFixedThreadPool(_services.size());

		for (final AbstractHealthChecker v : _services) {
			executor.execute(v);
		}
		
		// Now wait till all services are checked
		_latch.await();
		
		executor.shutdown();
		
		// Services are file and now proceed startup
		for (final AbstractHealthChecker v : _services) {
			if (!v.isServiceUp()) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		boolean result = false;
		try {
			result = ApplicationHealthManager.checkExternalServices();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("External services validation completed !! Result was :: " + result);
	}
}
