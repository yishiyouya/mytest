package invoke;

public class AopTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicProxyTest dTest = new DynamicProxyTest();
		Hop hp = new Hop();
		((GostKing)dTest.bind(hp)).begin();
	}

}
