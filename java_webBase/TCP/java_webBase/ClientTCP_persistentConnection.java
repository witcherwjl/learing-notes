package java_webBase;

// ����

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
			System.out.println("����һ������");
			
			 // 2 ��ȡ������������������
			InputStream inputStream=socket.getInputStream(); 
			
			// 3 ��Ҫ�������������д�뵽������У������Ŀ������
	        OutputStream outputStream=socket.getOutputStream(); 
	        
	        //��socket��д������
        	 outputStream.write("this is a word".getBytes());  // 4 �������ݵ�Ŀ������
             int totalByrecive=0;  //��ĿǰΪֹ���յ�������
             byte[] readBuff=new byte[1024];
             int lastReadByte;  //�����յ��ֽ�
             System.out.println("�ӷ������н��յ����ݣ�");
             int receiveMsgSize;
             // 5.�ӻ����������л�ȡ���ݣ�
             while ((receiveMsgSize=inputStream.read(readBuff))!=-1){   
                 System.out.println("�ӷ�������ȡ������" +new String(readBuff));
             }
           
             socket.close();  //�ر�
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
	}
}
