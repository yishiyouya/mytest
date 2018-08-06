package invoke.cglib;

public class CglibTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hop hp = new Hop();
		HopProxy hpro = new HopProxy();
		Hop cgHop = (Hop)hpro.createProxy(hp.getClass());
		cgHop.begin();
	}

}
