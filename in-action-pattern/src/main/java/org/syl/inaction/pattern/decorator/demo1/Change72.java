/**
 * 
 */
package org.syl.inaction.pattern.decorator.demo1;

/**
 * 
 * 齐天大圣的72变
 * 
 * @author megapro
 *
 */
public class Change72 implements TheGreatestSage {

	private TheGreatestSage sage;
	
	public Change72(TheGreatestSage sage){
        this.sage = sage;
    }
	
	/* (non-Javadoc)
	 * @see org.syl.inaction.pattern.decorator.demo1.TheGreatestSage#move()
	 */
	@Override
	public void move() {
		sage.move(); 
	}

}
