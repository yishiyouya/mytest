package longUtil;


public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getName();
	}

	public static void getName() {
		String res = ImgTypeMap.getImgBinary(Integer.parseInt("02"));
		String res1 = ImgTypeMap.getImgBinary(4);
		int a = Integer.parseInt(res);
		int b = Integer.parseInt(res1);
		System.out.println(res);
	}
	
	public static String transImgType(){
		String imageType = "03";
		String preType = ImgTypeMap.getImgBinary(4);
		// TODO Auto-generated method stub
		String res = "";
		String imgType = ImgTypeMap.getImgBinary(Integer.parseInt(imageType));
		int len = imgType.length();
		for(int i = 0; i < len; i++) {
			res += (Integer.parseInt(String.valueOf(imgType.charAt(i)))+Integer.parseInt(String.valueOf((preType.charAt(i)))));
		}
		System.out.println(res);
		return res;
	}
}
