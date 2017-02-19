/**
 * 
 */
package com.llbt.interview.architect.one;

/**
 * 模拟“司机”
 */
public class Driver {

	/** 司机名称 */
	public String driverName = null ;
	
	public Driver( String driverName ) {
		this.driverName = driverName ;
	}
	
	/**
	 * 模拟司机开奔驰车
	 * @param bmwCar
	 */
	public void DriveBenz(BenzCar benzCar) {
		
		// 启动汽车
		benzCar.start();

		// 放手刹
		benzCar.releaseHandBrake();

		// 踩离合、挂档
		benzCar.upClutchAndShiftGear();

		// 放离合、给油
		benzCar.downClutchAndAddAccelerator();

		// 汽车前进
		benzCar.goForword();
	}
	
	/**
	 * 模拟司机开宝马车
	 * @param bmwCar
	 */
	public void DriveBMW( BMWCar bmwCar){
		
		//启动汽车
		bmwCar.start() ;
		
		//放手刹
		bmwCar.releaseHandBrake() ;
		
		//踩离合、挂档
		bmwCar.upClutchAndShiftGear() ;
		
		//放离合、给油
		bmwCar.downClutchAndAddAccelerator() ;
		
		//汽车前进
		bmwCar.goForword() ;
	}
}
