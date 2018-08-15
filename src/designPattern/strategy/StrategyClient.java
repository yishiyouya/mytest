package designPattern.strategy;

public class StrategyClient {

	public static void main(String[] args) {
		testStrategy();
	}
	
	public static void testStrategy() {
		try {
			String clientStra = "HttpStrategy";
			MyStrategy mStrategy = MyStrategyFactory.getStrategy(clientStra);
			mStrategy.getStrategy("hk");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
