package java_webBase;

// 待改

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.*;


public class ClientTCP_persistentConnection {

	public static void main(String[] args) {
		String ip = "127.0.0.1";
		int port = 8080;
		Socket socket;
		try {
			socket = new Socket(ip, port);
			System.out.println("创建一个连接");
			
			 // 2 获取回馈服务器的输入流
			InputStream inputStream=socket.getInputStream(); 
			
			// 3 将要传输的数据数据写入到输出流中，传输给目的主机
	        OutputStream outputStream=socket.getOutputStream(); 
	        
	        //向socket中写入数据
        	 outputStream.write("this is a word".getBytes());  // 4 传输数据到目的主机
             int totalByrecive=0;  //到目前为止接收到的数据
             byte[] readBuff=new byte[1024];
             int lastReadByte;  //最后接收的字节
             System.out.println("从服务器中接收的数据：");
             int receiveMsgSize;
             // 5.从回馈服务器中获取数据，
             while ((receiveMsgSize=inputStream.read(readBuff))!=-1){   
                 System.out.println("从服务器获取的数据" +new String(readBuff));
             }
           
             socket.close();  //关闭
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
	}
}
