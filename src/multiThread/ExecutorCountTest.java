package multiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorCountTest {

	public static ConcurrentLinkedQueue<String> userAccounts = new ConcurrentLinkedQueue<String>();
	

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			// TODO Auto-generated method stub
			handleTrans();
			System.out.println("================");
		}
	}

	public static void handleTrans() {
		userAccounts.clear();
		for (int j = 0; j < 3; j++) {
			userAccounts.add(j+"");
		}
		CountDownLatch latch = new CountDownLatch(1);
		transfer t = new transfer(latch);
		ResList resList = new ResList(latch);
		t.start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resList.start();
		//System.out.println("========"+userAccounts);
		//resList.start();
	}
	
	static class transfer extends Thread{
		private CountDownLatch latch;
		ExecutorService exec = Executors.newFixedThreadPool(3);
		public transfer(CountDownLatch latch) {
			// TODO Auto-generated constructor stub
			this.latch = latch;
		}
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("transfer");
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
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//countDown - 1
			latch.countDown();
		}
	}
	
	static class ResList extends Thread{
		
		private CountDownLatch latch;

		public ResList(CountDownLatch latch) {
			// TODO Auto-generated constructor stub
			this.latch = latch;
		}
		public void run() {
			try {
				latch.await();
				List<String> resList = new ArrayList<String>();
				for (String string : userAccounts) {
					resList.add(string);
				}
				System.out.println("final:=" + resList.toString());
				System.out.println("ResList");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
