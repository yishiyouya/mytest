package redisMuti;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class AtomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ajm = {"10.28.37.86", "6380", "123456"};
		String[] ajs = {"10.28.37.87", "6381", "123456"};
		Jedis jm = getJedisPool(ajm).getResource();
		Jedis js = getJedisPool(ajs).getResource();
		String ck = "ATest_atom";
		jm.set(ck, "0");
		jMt j1 = new jMt(jm, js, ck);
		jMt j2 = new jMt(jm, jm, ck);
		/*Thread t1 = new Thread(j1);
		//Thread t2 = new Thread(j2);
		t1.start();
		//t2.start();
		jm.close();
		js.close();*/
		for(int i = 0; i < 10; i++) {
			Thread t1 = new Thread(j1);
			Thread t2 = new Thread(j2);
			t1.run();
			t2.run();
		}
		jm.close();
		js.close();
		
	}
	
	public static void incrKey() {
		String[] ajm = {"10.28.37.86", "6380", "123456"};
		String[] ajs = {"10.28.37.87", "6381", "123456"};
		Jedis jm = getConn(ajm);
		Jedis js = getConn(ajs);
		int i = 0;
		String ck = "ATest_atom";
		jm.set(ck, "0");
		while(i < 100) {
			//jm.incr(ck);
			jm.set(ck, Integer.valueOf(jm.get(ck))+1+"");
			if(!jm.get(ck).equals(js.get(ck))) {
				System.out.println("master:"+jm.get(ck)+"\t slave:"+js.get(ck));
			}
			i++;
		}
		
	}
	
	public static JedisPool getJedisPool(String... info){
        //1.设置连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //设置池中最大连接数
        config.setMaxTotal(50);
        //设置空闲时池中保有的最大连接数
        config.setMaxIdle(10);
        //2.设置连接池对象
        JedisPool pool = new JedisPool(config,info[0],Integer.valueOf(info[1]),30000,info[2]);
        //3.从池中获取连接对象
        Jedis jedis = pool.getResource();
        //4.连接归还池中
        jedis.close();
        return pool;

    }
	
	
	//"10.28.37.86"  6380 "123456"
	public static Jedis getConn(String[] args) {
		Jedis jMaster = new Jedis(args[0], Integer.valueOf(args[1]));
		jMaster.auth(args[2]);
		return jMaster;
	}

	
}
class jMt implements Runnable{
	private Jedis jedisM;
	private Jedis jedisS;
	private String key;
	
	public jMt(Jedis jedisM, Jedis jedisS, String key){
		this.jedisM = jedisM;
		this.jedisS = jedisS;
		this.key = key;
	}
	
	@Override
	public void run() {
		//jedisM.set(key, Integer.valueOf(jedisS.get(key))+1+"");
		jedisM.incr(key);
		System.out.println(jedisM.get(key)+"\t "+jedisM.getClient().getHost());
	}
	
}