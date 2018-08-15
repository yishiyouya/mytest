package designPattern.strategy;

public class HttpStrategy implements MyStrategy{

	@Override
	public void getStrategy(String args) {
		// TODO Auto-generated method stub
		System.out.println("Rpc: "+args);
	}

}
