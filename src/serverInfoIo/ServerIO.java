package serverInfoIo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ServerIO {
	public static void main(String[] args) {
		asynchronousFileWrite();
	}
	
	//AsynchronousFileChannel  write
	public static void asynchronousFileWrite() {
		String content = "aysn write\n";
		Path path = Paths.get("warn.log");
		try {
			AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			buffer = ByteBuffer.wrap(content.getBytes("utf-8"));
			Future<Integer> future = channel.write(buffer, channel.size());
			channel.force(true);
			while (!future.isDone()) {
				System.out.println("Do others...");
			}
			System.out.println(" content : " + new String(buffer.array()));
			buffer.clear();
			channel.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//AsynchronousFileChannel  read
	public static void asynchronousFileIO() {
		Path path = Paths.get("warn.log");
		try {
			AsynchronousFileChannel channel = AsynchronousFileChannel.open(path);
			ByteBuffer buffer = ByteBuffer.allocate(1000);
			Future<Integer> future = channel.read(buffer, 0);

			while (!future.isDone()) {
				System.out.println("Do others...");
			}
			Integer number = future.get();
			System.out.println("Read " + number + " content : " + new String(buffer.array()));
			channel.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//0、获取当前服务器真实IP
	public static InetAddress getCurrentIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) networkInterfaces.nextElement();
                Enumeration<InetAddress> nias = ni.getInetAddresses();
                while (nias.hasMoreElements()) {
                    InetAddress ia = (InetAddress) nias.nextElement();
                    if (!ia.isLinkLocalAddress() && !ia.isLoopbackAddress() && ia instanceof Inet4Address) {
                    	System.out.println(ia.toString());
                        return ia;
                    }
                }
            }
        } catch (SocketException e) {
        }
        return null;
    }
	
	//1、追加文件信息
	public static void appendFile() throws IOException {
		String warnInfo = "Oh! help! help!\n";
		File par = new File("./");
		String path0 = Thread.currentThread().getContextClassLoader().getResource("").toString()+"warnLog";
		String path = par.getCanonicalPath()+File.separatorChar+"warnLog";
		System.out.println(path0.substring(path0.indexOf("/")+1, path0.length())+"\t"+path);
		File fileDir = new File(path);
		if(!fileDir.exists()) {
			fileDir.mkdir();
		}
		File file = new File(path+File.separatorChar+"warn.log");
		System.out.println(file.getAbsolutePath());
		FileOutputStream fos = null;
		FileChannel fChannel = null;
		ByteBuffer send = null;
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			fos = new FileOutputStream(file, true);
			fChannel = fos.getChannel();
			fChannel.position(fChannel.size());
			send = ByteBuffer.wrap(warnInfo.getBytes("utf-8"));
			fChannel.write(send);
			fChannel.force(true);
			send.clear();
			fChannel.close();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
