package threadTest;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		atomIntTest();
	}

	public static void atomIntTest() {
		// TODO Auto-generated method stub
		AtomicInteger aInt = new AtomicInteger();
		aInt.incrementAndGet();
		atomIntTestArgs(aInt);
		System.out.println(aInt.get());
	}
	
	public static void atomIntTestArgs(AtomicInteger aInt) {
		aInt.incrementAndGet();
	}
}
