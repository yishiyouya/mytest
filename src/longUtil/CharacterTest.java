package longUtil;

import java.lang.*;

public class CharacterTest {
	public static void main(String[] args) {
		getDigit();
	}
	
	public static void getDigit() {
		char a = '1';
		int res = Character.digit(a, 10);
		System.out.println(res);
	}
}
