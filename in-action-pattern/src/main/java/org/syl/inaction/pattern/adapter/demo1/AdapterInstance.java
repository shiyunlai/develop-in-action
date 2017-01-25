/**
 * 
 */
package org.syl.inaction.pattern.adapter.demo1;

/**
 * @author megapro
 *
 */
public class AdapterInstance implements Target{

	Adaptee adaptee  ; 
	
	public AdapterInstance( Adaptee adaptee ){
		this.adaptee = adaptee ; 
	}
	
	/**
     * 源类Adaptee有方法sampleOperation1
     * 因此适配器类直接委派即可
     */
	@Override
	public void sampleOperation1() {
		
		this.adaptee.sampleOperation1();
	}

	/**
     * 源类Adaptee没有方法sampleOperation2
     * 因此由适配器类需要补充此方法
     */
	@Override
	public void sampleOperation2() {
		// TODO Auto-generated method stub
	}

}
