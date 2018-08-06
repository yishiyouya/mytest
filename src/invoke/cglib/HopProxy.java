package invoke.cglib;

import net.sf.cglib.proxy.Enhancer;

public class HopProxy {
	
	public Object createProxy(Class supClass) {		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(supClass);
		enhancer.setCallback(new MyInter());
		return enhancer.create();
	}
	
	
}
