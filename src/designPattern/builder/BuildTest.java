package designPattern.builder;

public class BuildTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tChildMe();
	}
	
	public static void tChildMe() {
		MechineBuilder mb = new CarBuilder();
		mb.buildCar();
	}

}
