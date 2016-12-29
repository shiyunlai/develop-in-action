/**
 * 
 */
package org.syl.inaction.pattern.builder.demo2;

/**
 * 
 * 产品类Product (构造者输出的最终目标对象)
 * 
 * @author megapro
 *
 */
public class Product {
	/**
     * 定义一些关于产品的操作
     */
    private String part1;
    private String part2;
    public String getPart1() {
        return part1;
    }
    public void setPart1(String part1) {
        this.part1 = part1;
    }
    public String getPart2() {
        return part2;
    }
    public void setPart2(String part2) {
        this.part2 = part2;
    }
}
