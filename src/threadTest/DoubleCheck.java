package threadTest;

public class DoubleCheck {
	
	private static volatile DoubleCheck instance = null;
	
	public DoubleCheck getInstance() {
		
		if(instance == null) {
			synchronized(DoubleCheck.class) {
				instance = new DoubleCheck();
			}
		}
		
		return instance;
	}
	
	public static synchronized void method() {
         System.out.println("Hello World!");
     }
	
	public synchronized void method1() {
        System.out.println("1Hello World!");
    }
	
	public void method2() {
		synchronized(DoubleCheck.this) {
			System.out.println("2Hello World!");
		}
    }
}
