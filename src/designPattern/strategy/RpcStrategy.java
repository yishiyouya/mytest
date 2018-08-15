package designPattern.strategy;

public class RpcStrategy implements MyStrategy{

	@Override
	public void getStrategy(String args) {
		// TODO Auto-generated method stub
		System.out.println("Rpc: "+args);
	}

	
}
