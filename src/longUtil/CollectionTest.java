package longUtil;

import java.util.HashMap;
import java.util.Map;

public class CollectionTest {
	public static void main(String[] args) {
		hashMapT();
	}
	
	public static void hashMapT() {
		Map<String, String> hm = new HashMap();
		hm.put(null, "a");
		hm.put(null, "b");
		hm.put("1", null);
		hm.put("1", null);
		System.out.println(hm);
	}
}
