package longUtil;

import java.util.Hashtable;
import java.util.Map;

public class TableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		putTest(1);
	}

	public static <K> K putTest(K k) {
		System.out.println(k.hashCode());
		String a = "a";
		String b = "1";
		String c = "2";
		String d = "3";
		Map<String, String> ht = new Hashtable<>();
		
		ht.put(a, b);
		ht.put(a, c);
		
		for(Map.Entry<String, String> tEntry : ht.entrySet()) {
			System.out.println(tEntry.getKey()+"\t"+tEntry.getValue());
		}
		return null;
	}
}
