package redisMuti;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import redis.clients.jedis.Jedis;

public class ThreadStr {
	public static int a = 1;
	
	public static void main(String[] args) {
		mutiThreadStr();
	}
	
	public static void mutiThreadStr() {
		final Jedis jedis = new Jedis("localhost", 6379);
		StrThread t1 = new StrThread(jedis);
		StrThread t2 = new StrThread(jedis);
		for (int i = 0; i < 10; i++) {
			t1.run();
			t2.run();
		}
	}
	
	public static void strThreadT() {
		for(int i = 0; i < 10; i++) {
			strThread();
		}
	}
	
	public static void strThread() {
		final Jedis jedis = new Jedis("localhost", 6379);
		ExecutorService exec = Executors.newFixedThreadPool(3);
		
		final int num = a++;
		Runnable task = null;
		task = new Runnable(){
			@Override
			public void run() {				
				jedis.set("ap", num+"");
			}
		};
		exec.execute(task);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exec.shutdownNow();
	}
	
}
