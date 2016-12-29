/**
 * 
 */
package org.syl.inaction.pattern.builder.demo2;

/**
 * 
 * 抽象建造者类Builder（构造者接口）
 * 
 * @author megapro
 *
 */
public interface Builder {
	
	public void buildPart1();

	public void buildPart2();

	public Product retrieveResult();
}
