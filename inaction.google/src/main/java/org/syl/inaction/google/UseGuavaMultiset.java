/**
 * 
 */
package org.syl.inaction.google;

import java.util.HashMap;
import java.util.Map;

import org.syl.inaction.google.assist.MyClass;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;

/**
 * 
 * 使用Goolge Guava的 Multiset对象
 * 
 * <pre>
 * 
 * [List & Set]
 * 在JDK中，List和Set有一个基本的区别，就是List可以包含多个相同对象，且是有顺序的，
 * 而Set不能有重复，且不保证顺序（有些实现有顺序，例如LinkedHashSet和SortedSet等）
 * 
 * [Multiset]
 * 所以Multiset占据了List和Set之间的一个灰色地带：<strong>允许重复，但是不保证顺序。 </strong>
 * Multiset有一个有用的功能，就是跟踪每种对象的数量，所以你可以用来进行数字统计。 
 * 
 * </pre>
 * @author megapro
 *
 */
public class UseGuavaMultiset {

	/* ----------------------------
	 老的写法： 统计set中对象数量
	  ----------------------------*/
	Map<MyClass, Integer> objectCounts = new HashMap<MyClass, Integer>();

	public void incrementCount(MyClass obj) {
		Integer count = objectCounts.get(obj);
		if (count == null) {
			objectCounts.put(obj, 0);
		} else {
			objectCounts.put(obj, count++);
		}
	}

	public int getCount(MyClass obj) {
		Integer count = objectCounts.get(obj);
		if (count == null) {
			return 0;
		} else {
			return count;
		}
	}
	
	/* ----------------------------
	 借助Guava Multiset
	  ----------------------------*/
	static Multiset<MyClass> myMultiset = HashMultiset.create();  
	
	public static void useMultiset1(){
		
		MyClass myObject = new MyClass();  
		myMultiset.add(myObject); 
		myMultiset.add(myObject);  // add it a second time.  
		
		System.out.println(myMultiset.count(myObject)); // 2 
		showMultiset() ;
		
		myMultiset.remove(myObject);  
		System.out.println(myMultiset.count(myObject)); // 1  
		
		MyClass myObject2 = new MyClass(); 
		myMultiset.add(myObject2);
		System.out.println(myMultiset.count(myObject)); // 1  
		System.out.println(myMultiset.count(myObject2)); // 1  
	}
	
	public static void useMultiset2(){
		
		MyClass myObject = new MyClass();  
		myMultiset.add(myObject,5); // Add 5 copies of myObject  
		System.out.println(myMultiset.count(myObject)); // 5  
		myMultiset.remove(myObject,2); // remove 2 copies  
		System.out.println(myMultiset.count(myObject)); // 3  
	}
	
	public static void showMultiset(){
		
		System.out.println("-----> entrySet ");
		for( Entry<MyClass> e : myMultiset.entrySet()){
			System.out.println(e.getElement());
		}
		
		System.out.println("-----> elementSet ");
		for(MyClass m : myMultiset.elementSet() ){
			System.out.println(m);
		}
	}
	
	public static void main(String[] args) {
		useMultiset1() ; 
		useMultiset2() ; 
	}
	
}
