package longUtil;

public enum ImgTypeMap {
	
	IdCardPos("1000000000",1),
	IdCardRev("0100000000",2),
	BankCardPos("0010000000",3),
	HoldIdCardPos("0001000000",4),
	HoldCardRev("0000100000",5),
	SelfPicture("0000010000",6);
	
	private String imgBinary;
	private int index;
	
	private ImgTypeMap(String imgBinary, int index) {
		this.imgBinary = imgBinary;
		this.index = index;
	}
	
	public static String getImgBinary(int index) {
		for(ImgTypeMap itm : ImgTypeMap.values()) {
			if(itm.getIndex() == index) {
				return itm.imgBinary;
			}
		}
		return null;
	}
	
	public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
