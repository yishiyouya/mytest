package designPattern.builder;

public abstract class MechineBuilder {
	protected void buildCar() {
		System.out.println("mechine builder");
	}
	
	public abstract void needTime();
}
