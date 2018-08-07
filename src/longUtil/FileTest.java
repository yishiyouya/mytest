package longUtil;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.pactera.sms.foundbase.util.GsdsCommonTool;

public class FileTest {
	
	public static void main(String[] args) {
		fpathExist();
	}
	
	public static String fileCreTime(String fullFileName) {
		Path path = Paths.get(fullFileName);  
		String fileCreTime = "";
		try {
			if(path.toFile().exists()) {
				BasicFileAttributeView basicview = Files.getFileAttributeView(path, BasicFileAttributeView.class,LinkOption.NOFOLLOW_LINKS );
				BasicFileAttributes attr;
				attr = basicview.readAttributes();
				Date createDate = new Date(attr.creationTime().toMillis());
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = formatter.format(createDate);
				Timestamp time = Timestamp.valueOf(dateString);
				fileCreTime = time.toString();
			}
			fileCreTime = fileCreTime.replaceAll(":", "").replaceAll(" ", "_");
			fileCreTime = fileCreTime.substring(0, fileCreTime.length() - 2);
		} catch (Exception e) {
			System.out.println(GsdsCommonTool.getStackInfo(e));
		}
        return fileCreTime;
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
