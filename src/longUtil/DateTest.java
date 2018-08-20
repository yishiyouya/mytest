package longUtil;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jdk8CurTimeStamp();
	}

	
	public static void jdk8CurTimeStamp() {
		LocalDateTime now = LocalDateTime.now();
		String curTimeStamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS"));
		Timestamp timestamp = Timestamp.valueOf(curTimeStamp);
		System.out.println(timestamp);
	}
	
	public static void dateForNoMonZero() {
		String date = "2018-02-02";
	      int index1 =date.indexOf("-");
	      int index2 =date.lastIndexOf("-");
	      int month;
	      int day;
	      int year=Integer.parseInt(date.substring(0,index1));
	      if(date.charAt(index1+1) == '0'){
	          month=Integer.parseInt(date.substring(index1+2,index1+3));
	      }else {
	          month=Integer.parseInt(date.substring(index1+1,index1+3));
	      }
	      if(date.charAt(index2+1) == '0'){
	          day=Integer.parseInt(date.substring(index2+2,index2+3));
	      }else{
	          day=Integer.parseInt(date.substring(index2+1,index2+3));
	      }
	      String date1=(year+"-"+month+"-"+day)+"";
	      System.out.println(date1);
	}
	
}
