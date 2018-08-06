package googleTest;

import com.google.common.util.concurrent.RateLimiter;

public class GuavaBucketTest {
	
	
	public static void main(String[] args) {
		
		tokenBucket();
	}
	
	public static void tokenBucket() {
		RateLimiter limiter = RateLimiter.create(5);
		System.out.println(limiter.acquire());
		System.out.println(limiter.acquire());
		System.out.println(limiter.acquire());
		System.out.println(limiter.acquire());
		System.out.println(limiter.acquire());
		System.out.println(limiter.acquire());
		
	}
	
}
