/**
 * 
 */
package org.syl.redis;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author megapro
 *
 */

@ContextConfiguration(locations = {"classpath*:data-source.xml"})  
public class TestRedisClusterUse extends AbstractJUnit4SpringContextTests{

	@Test
	public void testAddUser() {
		System.out.println("sadfsadf");
	}
	
}
