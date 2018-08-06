package multiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		executorMulti();
	}

	public static void executorMulti() {
		ExecutorService exec = Executors.newFixedThreadPool(3);
		final ConcurrentLinkedQueue<String> userAccounts = new ConcurrentLinkedQueue<String>();
		for (int j = 0; j < 10; j++) {
			userAccounts.add(j+"");
		}
		for (final String userCode : userAccounts) {
			Runnable task = null;
			try {
				task = new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(300);
							userAccounts.add(userCode);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getId()+"======"+userAccounts.toString());
					}
				};
			} catch (Exception e) {
				System.out.println("======"+userCode+": Runnable==========");
			}
			
			if (!exec.isShutdown()) {
				exec.execute(task);
			}
		}
		//¹Ø±Õexec
		exec.shutdown();
		Runnable task1 = null;
		if (exec.isShutdown()) {
			try {
				task1 = new Runnable() {
					@Override
					public void run() {
						//ConcurrentLinkedQueue ×ª list
						List<String> resList = new ArrayList<String>();
						for (String string : userAccounts) {
							resList.add(string);
						}
						System.out.println("final:=" + resList.toString());
					}
				};
			} catch (Exception e) {
				System.out.println("======: Runnable==========");
			} 
		}
		task1.run();
	}
	
	class transfer extends Thread{
		private CountDownLatch latch;
		public transfer(CountDownLatch latch) {
			this.latch = latch;
		}
		public void run() {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getId()+"======");
			latch.countDown();
		}
	}
}
