package longUtil;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.chrono.ThaiBuddhistChronology;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.pactera.sms.foundbase.util.SecurityUtil;

import sun.misc.BASE64Encoder;
import com.pactera.sms.foundbase.util.SecurityUtil;
public class StringTest {

	public static void main(String[] args) {
		strHash();
	}
	
	
	public static void strHash() {
		String a = "ABCDEa123abc";
		String b = "ABCDFB123abc";
		Set<String> set = new HashSet<>();
		set.add(a);
		set.add(b);
		System.out.println(a.hashCode()+"\n"+b.hashCode()+"\n"+set.toString());
	}
	
	public static void md5Test() {
		String str = "014448544544545";
		String s = "";
		try {
			s = SecurityUtil.encodeBasedMd5Same(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s);
	}
	
	public static void internTest() {
		String str = "hhaabbcc";
		String s = new String("hhaabbcc");
		System.out.println(s.intern() == str);
	}
	
	public static void burnEle() {
		String str = "hh";
		int k = 0;
		while(k < 10) {
			for(int i = 0; i < 1*1024*1024; i++) {
				str += str;
			}
			str = null;
			k++;
			System.out.println(k);
		}
	}
	
	public static String bytesToHexFun3(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        for(byte b : bytes) { // 使用String的format方法进行转换
            buf.append(String.format("%02x", new Integer(b & 0xff)));
        }

        return buf.toString();
    }

	
	public static void addBinar() {
		String res = "";
		String preType = "1000000000";
		String imgType = "1000000000";
		int len = imgType.length();
		for(int i = 0; i < len; i++) {
			res += (Integer.parseInt(String.valueOf(imgType.charAt(i))) & 
					Integer.parseInt(String.valueOf(preType.charAt(i))));
		}
		System.out.println(res);
	}
	
	public static void compBinar() {
		String imageType = "0000010000";
		String res = "1000100000";
		int len = res.length();
		for(int i = 0; i < len; i++) {
			System.out.println(String.valueOf(imageType.charAt(i))+"\t"+String.valueOf(res.charAt(i)));
			if("1".equals(String.valueOf(imageType.charAt(i)))) {
				if("1".equals(String.valueOf(res.charAt(i)))) {
					continue;
				}else {
					res = "";
					break;
				}
			}
		}
		System.out.println(res+"=======");
	}
	
	public static void repalceSepa() {
		String str = "AEjdWr9QADySkjHLIE/Ziw==";
		String res = "";
		res = str.replaceAll("\\\\", "1").replaceAll("/", "2");
		System.out.println(res);

	}
	
	public static void sysFileUrl() {
		String res = "";
		try {
			String certiType = "01";
			String certiNo = "27893833456789";
			String imgType = "01";
			res = "";
			String path = "";
			String line = File.separator;
			if("\\".equals(line)){
				path = "D:\\testSvn";
			}
			/*
			 * Linux下
			 * /authimgs
			 */
			if("/".equals(line)){
				path = "/authimgs";
			}
			StringBuilder sPath = new StringBuilder(path);
			sPath.append(line).append(certiType).append(line);
			
			File fileDir = new File(sPath.toString());
			if(!fileDir.exists()) {
				fileDir.mkdirs();
			}
			
			//文件名
			StringBuilder sFile = new StringBuilder();
			sFile.append(certiType).append(imgType).append(certiNo);
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64 = new BASE64Encoder();
			String fileName = base64.encode(md5.digest(sFile.toString().getBytes("utf-8")));
			sPath.append(fileName).append(".jpg");
			res = sPath.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(res);
	}
	
	public static String curImgUrl() {
		String str = "afdfdfdf";
		String res = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64 = new BASE64Encoder();
			res = base64.encode(md5.digest(str.getBytes("utf-8")));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(res.equals("IMKs1eEjkJo5UtCpS7q3YA=="));
		return null;
	}
	
	public static void objIdStr() {
		StringBuilder sBuilder = new StringBuilder();
		Random ran = new Random();
		sBuilder.append(System.currentTimeMillis()).append(ran.nextInt(100));
		System.out.println(sBuilder.toString());
	}
	
	public static void objNullStr() {
		Object a = null;
		//String b = a.toString();
		String c = String.valueOf(a);
		//System.out.println("**"+b+"**");
		System.out.println("**"+c.equals("null")+"**");
	}
	
	public static void subIndex() {
		String a = "abcdef";
		String res = a.substring(0, a.length()-1);
		System.out.println(res);
	}
	
	public static void strChar() {
		String str = "abc";
		boolean cont = str.contains(str.charAt(0)+"");
		System.out.println(cont);
	}
	
	public static void arrAction() {
//		int[] ia = {1,2,3,4};
//		baseArr(ia);
		Integer[] ia = {1,2,3,4};
		objArr(ia);
		System.out.println(ia[0]);
	}
	
	public static void objArr(Integer[] ia) {
		ia[0] = 0;
	}
	
	public static void baseArr(int[] ia) {
		ia[0] = 0;
	}
	
	public static void sbInsert() {
		StringBuilder sb = new StringBuilder();
		sb.insert(0, 'a');
		sb.insert(0, 'b');
		System.out.println(sb.toString());
	}
	
	public static void subTest() {
		String s = "abab";
		String str = s + s;
        String res = str.substring(1, str.length() - 1);
        res.contains(s);
        System.out.println(res.contains(s)+"\t"+res);
	}
	
	public static void charIndex() {
		String str = "abc";
		char a = Character.highSurrogate(5);
		System.out.println(a);
	}
	
	public static void intLead() {
		int a = Integer.numberOfLeadingZeros(32);
		System.out.println(a);
	}
	
	public static void ifEle() {
		int n = 2;
		if(n != 3) {			
			System.out.println((++n)/2 + " " );
		}else if(n == 3) {
			System.out.println("hh");
		}
	}
	
	public static void move() {
		int n = 2;
		int m = 2;
		n <<= 1;
		
		System.out.println((++n)/2 + " " );
	}
	
	public static void delNuml() {
		int n = 2;
		while(n > 0) {
			System.out.println(n);
			n--;
		}
		//if(--n == 1) System.out.println(n);
	}
	
	 public static int maximumSwap(int num) {
	        char[] digits = Integer.toString(num).toCharArray();
	        
	        int[] buckets = new int[10];
	        for (int i = 0; i < digits.length; i++) {
	            buckets[digits[i] - '0'] = i;
	        }
	        
	        for (int i = 0; i < digits.length; i++) {
	            for (int k = 9; k > digits[i] - '0'; k--) {
	                if (buckets[k] > i) {
	                    char tmp = digits[i];
	                    digits[i] = digits[buckets[k]];
	                    digits[buckets[k]] = tmp;
	        	        System.err.println(Integer.valueOf(new String(digits)));
	                    return Integer.valueOf(new String(digits));
	                }
	            }
	        }
	        return num;
	    }
	 
	public static void constructArray(int n, int k) {
        /*int[] arr = new int[n];
        int i = 0, small = 1, large = n;        
        while(i<k){ 
            arr[i++] = small++;
            if(i<k) arr[i++] = large--;
        }        
        if(k%2 == 0){ // k==2 ==> 1, 6, 5,4,3,2
            while(i<arr.length) arr[i++] = large--;
        } else { // k==3 ==> 1,6,2,3,4,5
            while(i<arr.length) arr[i++] = small++;
        }*/
        
        int[] arr = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++)
            arr[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : l++;
            
        for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j]+",");
		}
    }
	
	public static void arrTest() {
		int[] res = new int[2];
		int i = 0,start = 1;
		res[i++] = start++;
		System.err.println(i);
		for (int j = 0; j < res.length; j++) {
			System.out.println(res[j]);
		}
	}
	
	public static void printExce() {
		try {
			int i = 1/0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println(e.toString());
			System.out.println(getExceStr(e));
		}
	}
	
	public static String getExceStr(Exception e) {
		try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return "\r\n" + sw.toString() + "\r\n";
        } catch (Exception e2) {
            return "ErrorInfoFromException";
        } finally {
        	String exde = e.toString()+"\n"+Arrays.asList(e.getStackTrace()).toString().replaceAll(",",",\n");
        	return exde;
        }
	}
	
	public static void testForLoop() {
		for(int i = 0; i < 5; i++) {
			if(i == 3) {
				i += 1;
			}
			System.out.println(i);
		}
	}
	
	public static void repTest() {
		String preS = "&&";
		String enS = "QzlGM0Q3RTc3NjVCRTkwNjEwMTQ4RjlGMjEzQUMwNUMwQzE0RTE3ODQ2Q0YxNjUxMjYwMTRGQUFE\r\nODlCMTY3NTc4RDE4RTA3OUJEM0UzMEJCNzU1RkFFMDMwOThFRjg1NDZFMkQ4MDFFN0JDQjRGRjBF\r\nNUM3RUQ0ODk5QzJERkU3OTRDNjM1MjIwQTdCOUJCNEQ2Q0FFRkFBQzRFNUEwNUNBQTExQzY2RjAx\r\nRThGQzlBMkI5QzhCREI5OTEyRTk5Qzk1RjJDRDhDNTE2REM3MkM2QjRGMTBGOTUwRDQxMjRGNTRC\r\nQURENEU4QTQ1M0FEQ0Q4OTMxQzM0MkYzRDEyQjgxQTgwMDZEMjQxMjgzRTc4QURCRUY1OUI4Q0JG\r\nRDUyNDdDN0YzMzAxMEFENUU4NzlFQjYwMjdCOTQzNEM0M0ZDQjY5OTlDMzhERDVFMjU2QjFGMzMw\r\nQjdEMTNGNzc2ODNFNUExQTM2NjBFMzE1NTdDMjM5MjE5MDBEOTAxNjUxOUQxNTJEOTE2MjVGMUZF\r\nNzQ0NjI1RjMxNDg4OTk0QTk=\r\n";
		String aftS = "&&";
		String var = "";
		enS = enS.replaceAll("\r\n", "");
		var = preS + "\"" + enS +"\"" + aftS;
		System.out.println(var);
		var = var.replaceAll("\"" + enS +"\"", "^^");
		System.out.println(var);
		
		System.out.println("======");
		System.out.println("\\\r\\\n");
		System.out.println("======");
	}
	
	public static void longTest() {
		String s1 = "12999999";
		String s2 = "1a999999";
		Long g1 = Long.valueOf(s1); 
		//Long g2 = Long.valueOf(s2);
		Long g3 = Long.parseLong(s1); 
		//Long g4 = Long.parseLong(s2);
		System.out.println(g1+" "+" "+g3+" "+" ");
	}
	
	public static void testWhile() {
		int i  = 10;
		while(i > 3) {
			if(i == 3 ) {
				break;
			}
			i--;
			System.out.println(i);
		}
		System.out.println("hh:" + i);
	}
	
	public static void finalInt() {
		int i = 0;
		for (int j = 0; j < 10; j++) {
			i += j;
		}
		System.out.println(i);
	}
}
