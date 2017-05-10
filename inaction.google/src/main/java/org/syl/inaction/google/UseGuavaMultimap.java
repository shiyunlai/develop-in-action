/**
 * 
 */
package org.syl.inaction.google;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * 
 * 使用Goolge Guava的 Multimap对象
 * 
 * </br>参考学习： http://vipcowrie.iteye.com/blog/1522375
 * 
 * @author megapro
 *
 */
public class UseGuavaMultimap {

	/* -----------------------------
	 旧的写法
	 ----------------------------- */
	private static Map<String, List<String>> myClassListMap = new HashMap<String, List<String>>();

	public static void putMyObject(String key, String value) {
		List<String> myClassList = myClassListMap.get(key);
		if (myClassList == null) {
			myClassList = new ArrayList<String>();
			myClassListMap.put(key, myClassList);
		}
		myClassList.add(value);
	}

	/* -----------------------------
	 使用 guava 
	 ----------------------------- */
	private Multimap<String,Object> myMultimap = ArrayListMultimap.create();
	
	public static void testMultimap() {
		Multimap<String, String> myMultimap = ArrayListMultimap.create();

		// Adding some key/value
		myMultimap.put("Fruits", "Bannana");
		myMultimap.put("Fruits", "Apple");
		myMultimap.put("Fruits", "Pear");
		myMultimap.put("Vegetables", "Carrot");

		// Getting the size
		int size = myMultimap.size();
		System.out.println(size); // 4

		// Getting values
		Collection<String> fruits = myMultimap.get("Fruits");
		System.out.println(fruits); // [Bannana, Apple, Pear]

		Collection<String> vegetables = myMultimap.get("Vegetables");
		System.out.println(vegetables); // [Carrot]

		// Iterating over entire Mutlimap
		for (String value : myMultimap.values()) {
			System.out.println(value);
		}
		
		// Removing a single value
		myMultimap.remove("Fruits", "Pear");
		System.out.println(myMultimap.get("Fruits")); // [Bannana, Pear]

		// Remove all values for a key
		myMultimap.removeAll("Fruits");
		System.out.println(myMultimap.get("Fruits")); // [] (Empty Collection!)
	}
	
	public static void main(String[] args) {
		testMultimap() ; 
	}
	
}
