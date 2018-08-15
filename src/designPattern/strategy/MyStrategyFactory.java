package designPattern.strategy;

public class MyStrategyFactory {
	
	public static MyStrategy getStrategy(String strategyNa) throws Exception{
		String strategyClassName = StrategyInfo.valueOf(strategyNa).getClassName();
		return (MyStrategy)Class.forName(strategyClassName).newInstance();
	}
			
			
}
