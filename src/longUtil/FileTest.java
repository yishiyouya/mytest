package longUtil;

import java.io.File;

public class FileTest {
	
	public static void main(String[] args) {
		fpExist();
	}
	
	public static void fpExist() {
		String pat = "E:\\test\\note\\mengsanguo0.jpg";
		File f = new File(pat);
		boolean b = f.exists();
		System.out.println(b);
	}
}
