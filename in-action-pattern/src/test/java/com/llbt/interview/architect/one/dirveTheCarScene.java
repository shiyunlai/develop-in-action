package com.llbt.interview.architect.one;

/**
 * 模拟小明试驾各种汽车的场景
 */
public class dirveTheCarScene {

	public static void main(String[] args) {
		
		System.out.println("========== 模拟小明试驾奔驰汽车");
		Driver xiaoMingDriver = new Driver("小明") ; 
		BenzCar benzCar = new BenzCar(xiaoMingDriver) ; 
		xiaoMingDriver.DriveBenz(benzCar);

		System.out.println("========== 模拟小明试驾宝马汽车");
		BMWCar bmwCar = new BMWCar(xiaoMingDriver) ; 
		xiaoMingDriver.DriveBMW(bmwCar);
	}
}
