package designPattern.proxy;

public class Limit implements Api{

	private Route route;
	
	public Limit(Route route) {
		// TODO Auto-generated method stub
		this.route = route;
	}
	
	
	@Override
	public void route() {
		// TODO Auto-generated method stub
		System.out.println("proxy route");
		route.route();
	}

}
