package longUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class OtherTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		imageFormatName();
	}

	public static void imageFormatName() {
		for(String fn : ImageIO.getReaderFormatNames()) {
			System.out.print(fn+"\t");
		}
		System.out.println();
		for(String fn : ImageIO.getReaderFileSuffixes()) {
			System.out.print(fn+"\t");
		}
		System.out.println();
		for(String fn : ImageIO.getReaderMIMETypes()) {
			System.out.print(fn+"\t");
		}
	}
	
	public static boolean proRun() {
		 String processName = "jconsole.exe";
		 BufferedReader br=null;   
         try{   
             Process proc=Runtime.getRuntime().exec("tasklist -fi " + '"' + "imagename eq " + processName +'"');   
             br=new BufferedReader(new InputStreamReader(proc.getInputStream()));   
             String line=null;   
             while((line=br.readLine())!=null){   
                 //�ж�ָ���Ľ����Ƿ�������   
                 if(line.contains(processName)){   
                	 System.out.println(line);
                     return true;   
                 }   
             }   
                 
             return false;   
         }catch(Exception e){   
             e.printStackTrace();   
            return false;   
         }finally{   
             if(br!=null){   
                 try{   
                     br.close();   
                 }catch(Exception ex){   
                 }   
             }   
                 
         } 
	}
}
