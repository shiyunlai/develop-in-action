package org.syl.inaction.pattern;

import org.syl.inaction.pattern.builder.demo2.Builder;
import org.syl.inaction.pattern.builder.demo2.ConcreteBuilder;
import org.syl.inaction.pattern.builder.demo2.Director;
import org.syl.inaction.pattern.builder.demo2.Product;

public class BuilderPatternDemo2 {
	public static void main(String[] args) {
		Builder builder = new ConcreteBuilder();
		Director director = new Director(builder);
		director.construct();
		Product product = builder.retrieveResult();
		System.out.println(product.getPart1());
		System.out.println(product.getPart2());
	}
}
