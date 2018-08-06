package designPattern.builder;

public class CarBuilder extends MechineBuilder{
	
	@Override
	protected void buildCar() {
		System.out.println("car builder");
	}

	@Override
	public void needTime() {
		// TODO Auto-generated method stub
		System.out.println("build a car need 1 month");
	}
}
