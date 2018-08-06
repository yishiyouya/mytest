package designPattern.proxy;

public class TestProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Route route = new Route();
		Limit limit = new Limit(route);
		limit.route();
	}
	
}
