package imageBinary;

import encrytBase64.EncryptInfo;

public class AESDemoImg {

	public static void main(String[] args) {
		encryImg("", 0);
    }

	public static void encryImg(String imgBin, int pr) {
		String mingWen = "";
		// imgUp 正
		if(pr == 0) {
			mingWen = "{\r\n" + 
					"		\"certiType\":\"01\",\r\n" + 
					"		\"certiNo\":\"232103199401180613\",\r\n" + 
					"		\"imageType\":\"03\",\r\n" + 
					"		\"reqType\":\"0\",\r\n" + 
					"		\"userName\":\"甄s鑫\",\r\n" + 
					"		\"gender\":\"1\",\r\n" + 
					"		\"birthDate\":\"1994-1-18\",\r\n" + 
					"		\"signDepart\":\"黑龙江省五常市山河镇铁路街112号\",\r\n" + 
					"		\"validDate\":\"20051008-20251008\",\r\n" + 
					//"		\"b64\":\"1\",\r\n" + 
					"		\"imageBinary\":\""+imgBin+"\"\r\n" +  
					"		}";
			mingWen = "{\r\n" + 
					"   \"certiType\" : \"01\",\r\n" + 
					"   \"certiNo\" : \"372922199004165720\",\r\n" + 
					"   \"imageType\" : \"01\",\r\n" + 
					"   \"userName\" : \"杨蕊\",\r\n" + 
					"   \"gender\" : \"2\",\r\n" + 
					"   \"birthDate\" : \"1990-04-16\",\r\n" + 
					"   \"signDepart\" : \"曹县公安局\",\r\n" + 
					"   \"validDate\" : \"20160520-20360520\",\r\n" + 
					"	\"imageBinary\":\""+imgBin+"\"\r\n" +  
					"}";
			/*mingWen = "{\r\n" + 
					"		\"certiType\":\"01\",\r\n" + 
					"		\"certiNo\":\"130224197712026835\",\r\n" + 
					"		\"imageType\":\"01\",\r\n" + 
					"		\"reqType\":\"0\",\r\n" + 
					"		\"userName\":\"王东\",\r\n" + 
					"		\"gender\":\"1\",\r\n" + 
					"		\"birthDate\":\"1977-12-02\",\r\n" + 
					"		\"signDepart\":\"上海市公安局徐汇分局\",\r\n" + 
					"		\"validDate\":\"20051008-20251008\",\r\n" + 
					//"		\"b64\":\"1\",\r\n" + 
					"		\"imageBinary\":\""+imgBin+"\"\r\n" +  
					"		}";*/
		}else if(pr == 1){
			// imgUp 反
			mingWen = "{\r\n" + 
				"		\"certiType\":\"01\",\r\n" + 
				"		\"certiNo\":\"130224197712026835\",\r\n" + 
				"		\"imageType\":\"02\",\r\n" + 
				"		\"reqType\":\"0\",\r\n" + 
				"		\"userName\":\"王东\",\r\n" + 
				"		\"gender\":\"1\",\r\n" + 
				"		\"birthDate\":\"1977-12-02\",\r\n" + 
				"		\"signDepart\":\"瞽县公安局\",\r\n" + 
				"		\"validDate\":\"20160520-20360520\",\r\n" + 
				"		\"imageBinary\":\""+imgBin+"\"\r\n" + 
				"		}";
		}else if(pr == 2){
			//imgDown
			/*mingWen = "{\r\n" + 
				"		\"certiType\":\"01\",\r\n" + 
				"		\"certiNo\":\"432103199401180613\",\r\n" + 
				"		\"imageType\":\"02\",\r\n" + 
				"		\"reqType\":\"0\"}";*/
		}
		
		// 密钥
		String pwd = "";
		/*
			pwd = "3f04a29aa9ed89b907d5d3ee4be65690";//3002
			pwd = "9e4577f1ec4eb89d8645d83a1ce57cf8";//101
			pwd = "846acca7d02f6ba83460f0b626f37468";
			pwd = "af5fba7966821f06f55118d3d9c531a5";//92
			pwd = "ae1bbf5214414a3ef651e5a9714b840c";//91
			pwd = "af5fba7966821f06f55118d3d9c531a5";//92
		*/
		
		pwd = "846acca7d02f6ba83460f0b626f37468";//94
		// 明文加密得到的密文
		String miWen = EncryptInfo.encodeResult(pwd, mingWen);
		System.out.println(miWen);
		
		miWen = "OENENTY1NzkzODBGNDVDQ0ZCRDk4OEVFRkNBQTQ2Rjk5ODBGNDY2NDIyQjI4RUY5NzQxMzA4RDE5MzNBNkEwRkUxQjgxOEIwMjQ0QkYwN0QzQkNDQ0JDRjc1Qzg4MkZDNzk2QTQ4ODZFRkMzOTQzRkU2OTA4NDZFMEE4MzEwNDAzM0Y0M0M1MzBEQkEzOThCQjlDNTEyNDY5MERFMDA2NDU1ODEwQjg0QUU4RjREOEIxMTU1Q0ZERTI5RkUwQjk1MTFEMTZEODZDRTY0Nzc5OTQyNDRBNjZDRUQ0NUJDRTVFMzdBNDkxM0U0Q0I1NjZDM0I4MDdCNkI2REJGQURCN0Q1RjVGMzQwRDU3RUY1Q0NGODlGMEJDQjU2OTU4QzUxNjJGNUUwOTgzQUFFMTk1Rjk3MjJEMTEzMTdEQUJERDBCMkNBREUwQzNBNjQwODFBNUMyRjc1Rjg1QURBRUU0MEU3MkFDMzYxRkU5RERDNkI0NjQ4RjBGNDA4OEYyOTFG";
		System.out.println(EncryptInfo.decodeReqBizInfo("", miWen));
		System.out.println(EncryptInfo.decodeReqBizInfo(pwd, miWen));
	}
}









