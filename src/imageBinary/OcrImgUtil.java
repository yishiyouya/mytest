package imageBinary;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class OcrImgUtil {

    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();   
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();   
       
    public static void main(String[] args) {  
    	String jpgN = ""; 
    	String binStr = "";
    	jpgN = "F:\\File\\国寿电商\\task\\身份证统一管理\\ott141132.jpg";
    	jpgN = "F:\\File\\国寿电商\\task\\身份证统一管理\\yg172423.jpg";
    	jpgN = "F:\\File\\国寿电商\\task\\身份证统一管理\\ott141132.jpg";

    	binStr = getImageBinary(jpgN);
    	//ocr识别
    	callOcr(binStr);
    }   
    
    /**
     * 将图片转换为二进制
     * @return
     */
    static String getImageBinary(String fpath){   
        File f = new File(fpath);          
        BufferedImage bi;   
        try {   
            bi = ImageIO.read(f);   
            ByteArrayOutputStream baos = new ByteArrayOutputStream();   
            ImageIO.write(bi, "jpg", baos);   
            byte[] bytes = baos.toByteArray();   
            
            //文件头
            byte[] bytesCop = new byte[8];
            System.arraycopy(bytes, 0, bytesCop, 0, 8);
            
            String res = new String(Base64.encodeBase64(baos.toByteArray())); 
            res = new String(Base64.encodeBase64(bytes));
            //System.out.println(res);
            return res;   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
        return null;   
    }   
       
    
    
    public static void callOcr(String imgBina) {
		String url = "";
		url = "http://10.28.13.3:9090/exocr/recognize";//form
		Map<String, String> paramMap = new HashMap<String,String>();
		paramMap.put("username", "test");
		paramMap.put("password", "test");
		paramMap.put("recotype", "IdCard");
		paramMap.put("encoding", "UTF-8");
		paramMap.put("head_portrait", "0");
		paramMap.put("crop_image", "0");
		paramMap.put("b64", "1");
		//正面
		paramMap.put("image",imgBina);
		
		String result = localOcr(url, paramMap);
		JSONObject obj = JSONObject.parseObject(result);
		JSONObject objr = JSONObject.parseObject(obj.getString("Result"));
		IdCardBean it = new IdCardBean();
		it = JSONObject.parseObject(objr.toJSONString(), IdCardBean.class);
		System.out.println(objr);
	}
    
    public static String localOcr(String url, Map<String, String> paramMap) {
		String result = "";
		RequestConfig config = RequestConfig.DEFAULT;
		config.custom().setConnectTimeout(3000);
		config.custom().setSocketTimeout(6000);
		
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		httpClientBuilder.setDefaultRequestConfig(config);
		
		CloseableHttpClient httpClient = httpClientBuilder.build();
		
		HttpPost post = new HttpPost(url);
		
		try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			for (String key : paramMap.keySet()) {
                params.add(new BasicNameValuePair(key,  paramMap.get(key)));
            }
			UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, "UTF-8");
			post.setEntity(ent);
			HttpResponse res = httpClient.execute(post);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result = EntityUtils.toString(res.getEntity(), "UTF-8");// 返回json格式：
			}
			System.out.println(result);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}
}
