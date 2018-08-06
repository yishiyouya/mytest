package encrytBase64;

import org.apache.commons.codec.binary.Base64;

//import org.apache.commons.codec.binary.Base64;

public class Base64Utils {
	
	//解码
	public static String decode(String decodeStr) {
		Base64 base64 = new Base64();
		byte[] decodeByte = null;
		String deRes = ""; 
		decodeByte = base64.decodeBase64(decodeStr.getBytes());
		deRes = new String(decodeByte);
        return deRes;
	}
	
	//编码
	public static String encode(String encodeStr) {
		Base64 base64 = new Base64();
		String enRes = "";
		byte[] encodeByte = null;
		encodeByte = base64.encodeBase64(encodeStr.getBytes());
		enRes = new String(encodeByte);
        return enRes;
	}
}
