package redisMuti;

import java.util.Map.Entry;

import redis.clients.jedis.Jedis;

public class StrThread implements Runnable{

	private Jedis jedis;
	private static int num = 0;
	
	public StrThread(Jedis jedis) {
		this.jedis = jedis;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		jedis.set("ap", ++num+"");
	}
}
