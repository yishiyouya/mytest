package longUtil;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTest {
	
	public static void main(String[] args) {
		fpathExist();
	}
	
	public static void fpathExist() {
		String fName = "E:\\DownLoad\\WeChat Files\\badfoxcc\\Files\\result.js";
		Path path = Paths.get(fName);
		if(path.toFile().exists()) {
			System.out.println("exists");
		}else {
			System.out.println("not exists");
		}
		
	}
	
	
	public static void fpExist() {
		String pat = "E:\\test\\note\\mengsanguo0.jpg";
		File f = new File(pat);
		boolean b = f.exists();
		System.out.println(b);
	}
}
