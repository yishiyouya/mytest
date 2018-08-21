package enumTest;

public enum EnumT{
	H("h"),
	E("e"),
	O("o");
	private String v;
	private EnumT(String v) {
		this.v = v;
	}
	public String getV() {
		return v;
	}
	
	public static String existV(String str) {
		for(EnumT eT : EnumT.values()) {
			if(eT.getV().equals(str)) {
				return str;
			}
		}
		return null;
	}
	
}
