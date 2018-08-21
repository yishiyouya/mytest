package enumTest;

public class TestEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		existEnum();
	}

	public static void existEnum() {
		String string = "y";
		String res = EnumT.existV(string);
		System.out.println(res);
	}
	
	public static void valueEnum() {
		for(EnumT eString : EnumT.values()) {
			System.out.println(eString);
		}
	}
	
}
