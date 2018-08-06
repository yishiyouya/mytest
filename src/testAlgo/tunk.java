package testAlgo;


/**
 * @author zhenxin
 * 2018年5月10日
 */
public class tunk {
	public static final String LEFT = "L";
	public static final String GO = "M";
	public static final String RIGHT = "R";
	
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		cal();
		long e = System.currentTimeMillis();
		System.out.println(e - s);
	}
	
	public static void cal() {

		String head = "W";
		int x = 11;
		int y = 39;
		String ml = "MTMPRPMTMLMRPRMTPLMMTLMRRMP";
		for(int i = 0;i<ml.length();i++) {
			char h = ml.charAt(i);
			if(String.valueOf(h).equals(LEFT)) {
				if("W".equals(head)){
					head = "S";
				}else if("S".equals(head)){
					head = "E";
				}else if("E".equals(head)){
					head = "N";
				}else if("N".equals(head)){
					head = "W";
				}
			}else if(String.valueOf(h).equals(RIGHT)) {
				if("W".equals(head)){
					head = "N";
				}else if("N".equals(head)){
					head = "E";
				}else if("E".equals(head)){
					head = "S";
				}else if("S".equals(head)){
					head = "W";
				}
			}else if(String.valueOf(h).equals(GO)){
				if("W".equals(head)){
					x=x-1;
				}else if("N".equals(head)){
					y=y+1;
				}else if("E".equals(head)){
					x=x+1;
				}else if("S".equals(head)){
					y=y-1;
				}
			}
		}
		System.out.println(head+"("+x+","+y+")");
	}
}
