package multiThread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorsTest {
	public static void main(String[] args) {
		//Executor exec = Executors.newCachedThreadPool();
		Executor exec = Executors.newFixedThreadPool(100);

		
		Runnable task = new Runnable(){
			public void run(){
				//SendMessageUtil.sendMessage(mobile, code);
			}
		};
		exec.execute(task);
	}
}
