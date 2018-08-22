package classabout;

public class ClassLoaderTest {
	
	public static void main(String[] args) {
		testClass();
	}
	
	public static void testClass() {
		
		ClassLoader cLoader = Thread.currentThread().getContextClassLoader();
		
		while(true) {
			System.out.println(cLoader.getClass().getName());
			cLoader = cLoader.getParent();
			if(cLoader == null) {
				break;
			}
		}
		
		ClassLoader systemLoader = cLoader.getSystemClassLoader();
		System.out.println(systemLoader.getClass().getName());
		
	}
	
}
