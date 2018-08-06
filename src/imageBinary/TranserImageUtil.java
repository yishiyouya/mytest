package imageBinary;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 图片与二进制之间的相互转换
 * @author chenqk
 * 2014年6月9日09:50:13
 */
public class TranserImageUtil {
    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();   
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();   
       
    public static void main(String[] args) {  
    	String jpgN = ""; 
    	String binStr = "";
    	String pngP = "F:\\File\\国寿电商\\task\\身份证统一管理\\idcard4431.png";
    	String bankN = "F:\\File\\国寿电商\\task\\身份证统一管理\\bankCard1.png";
    	jpgN = "F:\\File\\国寿电商\\task\\身份证统一管理\\idcardzx.jpg";
    	jpgN = "F:\\File\\国寿电商\\task\\身份证统一管理\\xuanye.jpg";
    	jpgN = "F:\\File\\国寿电商\\task\\身份证统一管理\\ot141132.jpg";
    	jpgN = "F:\\File\\国寿电商\\task\\身份证统一管理\\zmgq45841.jpg";

    	//binStr = getImageBinary(pngP);
    	//binStr = getImageBinary(bankN);
    	binStr = getImageBinary(jpgN);
    	//ocr识别
    	//HttpClientApache.callOcr(binStr);
    	AESDemoImg.encryImg(binStr, 0);//0 正面 1反面 2下载
    	//System.out.println(binStr);
        //base64StringToImage(binStr);   
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
            System.out.println(bytesToHexFun3(bytesCop));
            
            String res = new String(Base64.encodeBase64(baos.toByteArray())); 
            res = new String(Base64.encodeBase64(bytes));
            //System.out.println(res);
            return res;   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
        return null;   
    }   
       
    /**
     * 将二进制转换为图片
     * @param base64String 二进制数据
     */
    static void base64StringToImage(String base64String){   
        try {   
            byte[] bytes1 = decoder.decodeBuffer(base64String);   
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);   
            BufferedImage bi1 = ImageIO.read(bais);   
            File w2 = new File("F:\\File\\国寿电商\\task\\身份证统一管理\\idcard443_bak.jpg");//可以是jpg,png,gif格式   
            ImageIO.write(bi1, "png", w2);//不管输出什么格式图片，此处不需改动   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    } 
    
    /**
     * 二进制转16进制
     * @param bytes
     * @return
     */
    public static String bytesToHexFun3(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        for(int i = 0, len = bytes.length; i < len; i++) { // 使用String的format方法进行转换
            buf.append(String.format("%02x", new Integer(bytes[i] & 0xff)));
        }

        return buf.toString();
    }
}


/* ImageIO.write(bi, "gif", baos);   
ImageIO.write(bi, "jpg", baos);   
ImageIO.write(bi, "bmp", baos);   
ImageIO.write(bi, "wbmp", baos);   
ImageIO.write(bi, "jpeg", baos);   */


/*ImageIO.write(bi1, "gif", w2);   
ImageIO.write(bi1, "jpg", w2);   
ImageIO.write(bi1, "bmp", w2);   
ImageIO.write(bi1, "wbmp", w2);   
ImageIO.write(bi1, "jpeg", w2);   */