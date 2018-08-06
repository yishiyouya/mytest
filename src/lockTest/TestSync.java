package lockTest;

public class TestSync implements Runnable{
	private static int count;
	private Long id;
	
	public TestSync(Long id) {
		this.id = id;
		count = 0;
	}
	
	public static void main(String[] args){
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath().toString();
		System.out.println(path);
		synchronized(TestSync.class) {
			System.out.println("hh");
		}
		TestSync t1 = new TestSync(1l);
		TestSync t2 = new TestSync(2l);
		Thread th1 = new Thread(t1, "t1");
		Thread th2 = new Thread(t2, "t2");
		th1.start();
		th2.start();
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(this) {
			for (int i = 0; i < 5; i++) {
				try {
	               System.out.println(Thread.currentThread().getName() + ":" + (count++));
	               Thread.sleep(100);
	            } catch (InterruptedException e) {
	               e.printStackTrace();
	            }
			}
		}
	}
}
