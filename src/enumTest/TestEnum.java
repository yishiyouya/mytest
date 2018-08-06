package enumTest;

public class TestEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		valueEnum();
	}

	public static void valueEnum() {
		for(EnumT eString : EnumT.values()) {
			System.out.println(eString);
		}
	}
	
}
