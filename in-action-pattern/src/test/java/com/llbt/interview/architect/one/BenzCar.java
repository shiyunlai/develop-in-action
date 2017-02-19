/**
 * 
 */
package com.llbt.interview.architect.one;

/**
 * 模拟奔驰汽车
 */
public class BenzCar {
	
	String BRAND = "奔驰" ; 
	Driver driver ;
	
	public BenzCar( Driver driver){
		System.out.println(driver.driverName + " 准备试驾 "+BRAND);
		this.driver = driver ;
	}
	
	/**
	 * 启动汽车
	 */
	public void start() {
		System.out.println(this.driver.driverName +"：汽车启动了");
	}

	/**
	 * 放开手刹
	 */
	public void releaseHandBrake() {
		System.out.println(this.driver.driverName +"：放开了手刹");
	}

	/**
	 * 踩离合、挂档
	 */
	public void upClutchAndShiftGear() {
		System.out.println(this.driver.driverName +"：踩离合、挂档");
	}
	
	/**
	 * 放离合、给油
	 */
	public void downClutchAndAddAccelerator() {
		System.out.println(this.driver.driverName +"：放离合、给油");
	}

	/**
	 * 前进
	 */
	public void goForword() {
		System.out.println(this.driver.driverName +"：前进");
	}
}
