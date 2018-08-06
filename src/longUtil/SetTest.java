package longUtil;

import java.util.Set;


import java.util.HashSet;
import java.util.Iterator;
public class SetTest {
	public static void main(String[] args) {
		
		forRemove();
	}
	
	
	public static void forRemove() {
		Set<String> s = new HashSet<>();
		Set<String> sr = new HashSet<>();
		s.add("ab");
		s.add("acb");
		s.add("abc");
		s.add("abcc");
		for(Iterator<String> lue = s.iterator(); lue.hasNext(); ) {
			String tempUm = lue.next();
			if(tempUm.indexOf("ab") > -1) {
				sr.add(tempUm);
			}
		}
		s.removeAll(sr);
		for(Iterator<String> lue = s.iterator(); lue.hasNext(); ) {
			String tempUm = lue.next();
			System.out.println(tempUm);
		}
	}
	
	public static void interaSet() {
		Set<String> s = new HashSet<>();
		s.add(null);
		s.add("1");
		s.add("2");
		System.out.println(s.add("2"));
		Iterator<String> iterator = s.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		for(String str : s) {
			System.out.println(str);
		}
	}
}
