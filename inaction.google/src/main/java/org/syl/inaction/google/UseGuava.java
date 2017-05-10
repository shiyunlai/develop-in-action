/**
 * 
 */
package org.syl.inaction.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

//引入Guava的静态方法，让list、set创建更简便
//newXxx方法都是静态的，所以可以通过static import的方式更加简化
import static com.google.common.collect.Lists.newArrayList;  
import static com.google.common.collect.Sets.newHashSet; 

/**
 * @author megapro
 * 参考： http://vipcowrie.iteye.com/blog/1522375
 *
 */
public class UseGuava {
	
	Map<String,String> myMap1 = new HashMap<String,String>();  //old way  
	Multimap<String,String> myMap2 = ArrayListMultimap.create(); //guava way  
	
	List<String> myList1 = new ArrayList<String>(); //old way  
	List<String> myList2 = Lists.newArrayList(); //guava way  
	List<String> myList3 = newArrayList();  
	
	Set<String> mySet1 = new HashSet<String>(); //old way  
	Set<String> mySet2 = Sets.newHashSet(); //guava way  
	Set<String> mySet3 = newHashSet();  
	
	/*
	 * 只读集合 
	 * Guava为大多数的集合接口提供只读的实现，例如：ImmutableList，ImmutableSet和ImmutableMap等等。
	 */
	private static final Set<String> farmAnimals =ImmutableSet.of("Cow","Pig","Sheep");  

}
