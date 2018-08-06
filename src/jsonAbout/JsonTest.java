package jsonAbout;

import com.alibaba.fastjson.JSONObject;

public class JsonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		commKey();
	}

/*	public static void commKey() {
		JSONObject jValue = new JSONObject();
		jValue.put("a", "1");
		String ov = jValue.getString("a")+1;
		jValue.put("a", "1");
	}
	*/
	public static void commKey() {
		JSONObject jValue = new JSONObject();
		jValue.put("a", "1");
		jValue.put("a", "2");
		String value = jValue.toJSONString();
		System.out.println(value);
	}
	
	public static void constrJson() {
		JSONObject jValue = new JSONObject();
		jValue.put("a", "1");
		jValue.put("b", "2");
		String value = jValue.toJSONString();
		System.out.println(value);
	}
	
}
