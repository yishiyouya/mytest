package encrytBase64;

import java.util.Properties;

public class AESDemo {

	public static void main(String[] args) {
        // 明文  
		String mingWen = "{\"loginType\":\"2\",\r\n" + 
				"	    \"resultFlag\":\"1\",\r\n" + 
				"	    \"userCode\":\"M1357806180796\",\r\n" + 
				"	    \"mobileNo\":\"18911138973\",\r\n" + 
				"	    \"emailAddress\":\"101402@qq.com\",\r\n" + 
				"	    \"certiNo\":\"110105201712140003\",\r\n" + 
				"	    \"userPsw\":\"343B1C4A3EA721B2D640FC8700DB0F36\",\r\n" + 
				"	    \"validateCode\":\"146770\",\r\n" +  
				"		\"loginTime\":\"2018-01-18 17:19:11\"}";
		/*String mingWen = "{\"loginType\":\"1\",\r\n" + 
				"	    \"resultFlag\":\"1\",\r\n" + 
				"	    \"userCode\":\"M150087661\",\r\n" + 
				"	    \"mobileNo\":\"13321170723\",\r\n" + 
				"	    \"emailAddress\":\"101402@qq.com\",\r\n" + 
				"	    \"certiNo\":\"110105201712140003\",\r\n" + 
				"	    \"userPsw\":\"2\",\r\n" + 
				"	    \"validateCode\":\"111111\",\r\n" +  
				"		\"loginTime\":\"2018-01-18 17:19:11\"}";*/
		// 密钥
		
		//String pwd = "3f04a29aa9ed89b907d5d3ee4be65690";//3002
		String pwd = "a5j44ec723bj95e0f7ju780tuid86140";//9013
		//String pwd = "9e4577f1ec4eb89d8645d83a1ce57cf8";//101
		//String pwd = "846acca7d02f6ba83460f0b626f37468";
		//String pwd = "846acca7d02f6ba83460f0b626f37468";//94
		//String pwd = "af5fba7966821f06f55118d3d9c531a5";//92
		//String pwd = "ae1bbf5214414a3ef651e5a9714b840c";//91
		// 明文加密得到的密文
		String miWen = EncryptInfo.encodeResult(pwd, mingWen);
		System.out.println(miWen);
		/*String miWen1 = AESUtils.encrypt(pwd, mingWen);
		System.out.println("a1====="+miWen1);
		String miWen2 = Base64Utils.encode(miWen1);
		System.out.println("a2====="+miWen2);
		String miWen = URLEncoder.encode(miWen2, "utf-8");
		System.out.println("a====="+miWen);
		// 输出密文
		// 打印密文解密得到的明文，并输出
		String deWen = URLDecoder.decode(miWen, "utf-8");
		System.out.println("0======"+deWen);
		String deWen1 = Base64Utils.decode(deWen);
		System.out.println("1======"+deWen1);
		String deWen2 = AESUtils.decrypt(pwd, deWen1);
		System.out.println("2======"+deWen2);*/
		//miWen = "REYzMTcyOTI1RUM5NUU4RkRDQkM0OTk5ODVGMTNBM0FERDQ0RkE2QjBBNjU1M0IzQkRGRjU1MkZCRDFGNjEwOTdCNDU1Qjc2QkEzNjI0MzQ3MTA2Q0I1RjE2QkYzMkQ4NjJCM0ExMjJBNjlDNEZEMTlDNTNDMkJERkE3QjkyQ0YyRDQ5MjIyQzAxQUU4MEQ4MzQyMEMxMzU3MzFFREM3RUMxMUM2MDlDRUIxNDJBMEZGQTFDMTM0NTUwRTA0RjA5MTA2RTRBMDM3MzRGRTE3NTAxQjMyQ0ZDNTJDQjYzNzc5MUFBQ0RDQjFCRDkwRDQ2RDZFM0FBODRCQTYwOEFCQzE0QTc2QjBCQUYzNDE4MjkyNzEzNTYzQzA4QzUxODg5M0YwNEIzM0REN0I3N0RDMTAyOENCQTNDRkNFOTE3OUVDRjlGNDhBMTkzNzFFOUEzMUQ4NzcwNzJFQjhGMUI3MDk2ODJEQkRBQ0ZDMEQ5QjU0NEZGRDBDOUFGQkIxMzExMEVFQjcyQ0EyQTZBNEFENzk2OTNBRjY1RERDNjM5ODg3ODk5MTNGRUQxMzVDQ0E3RkQxRUUxM0JGMjFDMDYxQTY2NzQyREI0Nzk3REFBOTRFMTdGRDgyQTVFQ0UwMERCNEU2MENDNjVBNzJCRDg4QjJGMjY4RjI3ODA3QTlENUQzM0ZBRkY5OUI5RUU0RDQ0OUY4RDc3MTE0RDYwMkFBMDREMzFERDEzRDY2NEVDMEY0MkMxMEY3NjdBMDRBOTU5NzM5N0RCQjY4ODI1N0I4MzVCQjU0N0Q1NEIwNzhERjUxMUZGREJFQzcwNEQxOEI0NTlEQUE2OTZBREY4RDE3Mjc5RDFBNTREOTkzOEI1MDRBRkNGRTQwNEY2MDEwMEFGMjlEOTJFMzhGNzg4QUI0REExRDQ3MUIxNkYyNTZDMDA4RkUyQTA1N0RGRkM2M0YyMjE5NDZDMjg0OENCNzRBMDg4QjZFMjQxM0Q2QzE2NUVEODg4OTFGRTE0MEMzMkMwNkQxNjhCOUU3MUM5Nzc2RkE1RjE4NjBFNkYxMkJDRUM0QjE1NUNFRTE2NzlEMUVFOUEwREQ3QzlBMTIzNjRGREQ5MzlFRjQ0M0Q1NjNDOEEwN0U2NDQ2OEMxNkY3NENDQzRGQjkyMTQyMjZFQTFDNkE0MDU5MkYyRjQxQzNGMDBEMkI5RDEwMEFCRDlFQzYwMDhCQkIwQjFENzY4QjkyRTFBRkY4NEM1MDFBMjNBRTJFQzAzOUU5NEVEQjk4MDEw";
		//miWen = "N0EyODVGREI5RUVDODgyQTRBNzhGQUVFMDY3NUY5QzgyQTM2MDg2QjkzMUUzOTc0NDdBMjZEN0Y2NzRDRENFRTBCQzlCMzZDOEMyMzZCNTAxNTMwQ0UwQjA1NDE0QjczRjEyMUI1NDhGQkJDQkYyMEY4MzIxQTFCQTk5OEY5RTUxMzU2NkMwNTcxMzIwQjk0MjM2N0U2N0EzMEQ4Rjg0NkQzQTE3MURFOTVFRDBCRDM0NjI5RDQwQzJCOUFBQzlFODZBRjk3OERFNUU3NDhFQTVENzRCRERBQzI4NkFBMkVEMzBDRUEzMjNERjJDNzZDQTM2NTA5NTBGQzZGRTk5MjgxMDJCMkE0N0IyM0Q0OTBFREVDNzBDNEQ4OTVGNDUxNzFCRDM2QzNGRUVFRDMxNzc5RkQ1RjczRUQ2RkM2QUQ=";
		miWen = "QzExRDIxQTQ2QzFGRjIwMUU2OTM0QTNGNDMyNTFFNEE0ODY5OTI3QUFCMEMyMjU3MjA3Q0E5RDhENEY4NDdCM0RDNjNFODUwRDlDNzY3NkFGMjFFNUQ5QTdBOURCRjAxQTNBMjcyQ0Y5MENERTVGNkNBRTNEQUREMUJBNTcxRTdFMUQzMDk1NEE4RTE5MjM1Mjk5MTJDRjk0Njk3Q0Q5MUU3NEFDRUQzODgwREUzOEQyMUFFNTI4NUNBQzFEMEQxOUNFQTgzNUYwMThERDQwQTMzMTFDQkZFNDA4NjFFMTY1QzlENDBBMUFGMTA4Mjc2RTA4NzM0OEVENzYxQ0E4OQ";
		//miWen = "QzExRDIxQTQ2QzFGRjIwMUU2OTM0QTNGNDMyNTFFNEE0ODY5OTI3QUFCMEMyMjU3MjA3Q0E5RDhENEY4NDdCM0RDNjNFODUwRDlDNzY3NkFGMjFFNUQ5QTdBOURCRjAxQTNBMjcyQ0Y5MENERTVGNkNBRTNEQUREMUJBNTcxRTdFMUQzMDk1NEE4RTE5MjM1Mjk5MTJDRjk0Njk3Q0Q5MUU3NEFDRUQzODgwREUzOEQyMUFFNTI4NUNBQzFEMEQxOUNFQTgzNUYwMThERDQwQTMzMTFDQkZFNDA4NjFFMTY1QzlENDBBMUFGMTA4Mjc2RTA4NzM0OEVENzYxQ0E4OQ==";
		System.out.println(EncryptInfo.decodeReqBizInfo(pwd, miWen));
		
		/*Properties pro = System.getProperties();
		System.out.println(pro.toString());
		System.out.println(System.getProperty("java.version"));*/
    }

}
