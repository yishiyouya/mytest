package threadTest;

public class VolatileTest {
	
	public static volatile  int i;
	
	public static void main(String[] args) {
		inc(i);
	}
	
	public static void inc(int i) {
		i++;
	}
	
}
