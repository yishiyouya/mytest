package imageBinary;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import encrytBase64.EncryptInfo;

public class RemoteImgUtil {
	public static void main(String[] args) {
		
	}
	
	public static void remoteIdCard() {
		// 密钥
        String pwd = "846acca7d02f6ba83460f0b626f37468";
       // eed976fc37abdda44f732f8d3f69c064
       // 846acca7d02f6ba83460f0b626f37468
        //ae1bbf5214414a3ef651e5a9714b840c 009001
        String miWen = "";
        // 明文加密得到的密文
        miWen = EncryptInfo.encodeResult(pwd, "");

        String request = "{" + "\"clientAuth\":\"admin\"," + "\"clientPsw\":\"admin\","
				+ "\"clientSender\":\"009004000000\"," + "\"reqBizInfo\":\"" + miWen + "\","
				+ "\"requestType\":\"updateUserInfo\"," + "\"serviceVersion\":\"V1.0.0\","
				+ "\"serviceUrl\":\"updateUserInfo\"" + "}";
		request = request.replace(" ", "");
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://10.28.37.87:3333/user/updateUserInfo");
		String result = "";
		try {
			StringEntity s = new StringEntity(request);
			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");// 发送json数据需要设置contentType
			post.setEntity(s);
			HttpResponse res = httpclient.execute(post);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result = EntityUtils.toString(res.getEntity());// 返回json格式：
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
