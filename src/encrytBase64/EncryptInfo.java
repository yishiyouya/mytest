package encrytBase64;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncryptInfo {
	
	/**
	 * 1、解密reqBizInfo
	 * @param requestInfo
	 * @return
	 * @throws Exception
	 */
	public static String decodeReqBizInfo(String KeyValue, String reqBizInfo){
		String baseDecodeReq = "";
		String aesDecodeReq = "";
		String urlDecodeReq = "";
		try {
			//base64解码
			baseDecodeReq = Base64Utils.decode(reqBizInfo);
			//baseDecodeReq = new String(Base64Old.decode(reqBizInfo));
			//根据密钥进行AES解密
			aesDecodeReq = AESUtils.decrypt(KeyValue, baseDecodeReq);
			//对请求报文进行URLDecode解码
			urlDecodeReq = URLDecoder.decode(aesDecodeReq, "utf-8");
			//返回解密后的reqBizInfo报文
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urlDecodeReq;
	}
	
	/**
	 * 2、加密result的方�?
	 * @param result
	 * @return
	 * @throws Exception
	 */
	public static String encodeResult(String keyValue, String result){
		String urlEcodeRes = "";
		String aesEncodeRes = "";
		String encodeRes = "";
		try {
			//对加密后的应答报文进行encode编码
			urlEcodeRes = URLEncoder.encode(result, "utf-8");
			//对传入的应答报文进行AES加密
			aesEncodeRes = AESUtils.encrypt(keyValue, urlEcodeRes);
			//base64进行编码
			encodeRes = Base64Utils.encode(aesEncodeRes);
			//encodeRes = Base64Old.encode(aesEncodeRes.getBytes());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回应答报文
		return encodeRes;
	}
}
