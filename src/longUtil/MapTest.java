package longUtil;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hashTabTest();
	}
	
	public static void hashTabTest() {
		Map<String, String> ht = new Hashtable<>();
		ht.put(null, "hh");
		System.out.println(ht.toString());
	}
	
	public static void ifAbsent() {
		Map<String, String> map = new HashMap<>();
		map.put("a", "1");
		map.putIfAbsent("a", "2");
		for(Map.Entry<String, String> s : map.entrySet()) {
			System.out.println(s.getKey()+"\t"+s.getValue());
		}
	}
}
