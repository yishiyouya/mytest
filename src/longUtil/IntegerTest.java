package longUtil;

import java.util.UUID;

public class IntegerTest {
	private static int i = 4;
	public static void main(String[] args) {
		getUUID();
	}
	
	public static void getUUID() {
		String uUString = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(uUString);
	}
	
	
	public static void leftMoveBit() {
		int COUNT_BITS = Integer.SIZE - 3;
		final Integer RUNNING    = -1 << COUNT_BITS;
	    final Integer SHUTDOWN   =  0 << COUNT_BITS;
	    final Integer STOP       =  1 << COUNT_BITS;
	    final Integer TIDYING    =  2 << COUNT_BITS;
	    final Integer TERMINATED =  3 << COUNT_BITS;
	    System.out.println(Integer.toBinaryString(RUNNING | 0));
	    System.out.format("%s \n%s \n%s \n%s \n%s", Integer.toBinaryString(RUNNING), 
	    		Integer.toBinaryString(SHUTDOWN), Integer.toBinaryString(STOP), 
	    				Integer.toBinaryString(TIDYING), Integer.toBinaryString(TERMINATED));
	}
	
	public static void negtiveInt() {
		int a = Integer.MAX_VALUE;
		int b = ++a;
		System.out.println(b);
	}
	
	public static void switchInt() {
		int res = 0;
		int i = 3;
		switch (i) {
			case 1:
				res = res + i*3;
			case 2:
				res = res + i*3;
			case 3:
				res = res + i*3;
			case 4:
				res = res + i*3;

		default:
			break;
		}
		System.out.println(res);
	}
	
	public static void equalOrNot() {
		Integer a = new Integer(1);
		Integer b = new Integer(1);
		Integer c = 1;
		Integer d = 1;
		boolean ea = a==b;
		boolean eb = a==c;
		boolean ec = c==d;
		
		System.out.format("%s, %s, %s", ea, eb, ec);
		
	}
	
	public static void calVal() {
		int i = 1;
		int j = 1;
		int re = i ^ j;
		int re1 = i & j;
		int re2 = i | j;
		System.out.println(re+" "+re1+" "+re2);
		
	}
	
	public static void changeVal() {
		IntegerTest it = new IntegerTest();
		it.i = 5;
		System.out.println(i);
	}
	
	public static void byteTrans() {
		byte b1 = 1;
		byte b2 = 2;
		Byte b3 = new Byte((byte) 128);
		System.out.println((int)b3);
		
	}
	
	public static void equl() {
		int i = 1;
		Integer j = new Integer(1);
		boolean a1 = i == j;
		boolean a2 = j.equals(i);
		System.out.println(a1);
		System.out.println(a2);
	}
	
	public static void bitMan() {
		int i = 4;
		int li = 0, ri = 0;
		int res = 0;
		li = 1<<i;
		ri = i>>1;
		res |= li;
		System.out.format("li:%d,ri:%d,res:%d",li, ri, res);
	}
	
}
