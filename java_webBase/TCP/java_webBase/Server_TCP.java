package java_webBase;
import java.net.*;
import java.io.*;

public class Server_TCP {
	String ipName = "127.0.0.1";
	
	public Server_TCP(InetAddress ip) {
		super();
	}
	
	public static void main(String[] args) {
		System.out.println("����ˣ�");
		Socket socket = null;
		int port = 6666;
		Socket server = null;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			byte[] recevie = new byte[1024];
			int revictemp;
			System.out.println("��ʼ���գ�");
			while(true) {
				// ���տͻ��˵�����
				// ÿ����һ�����ݶ��ᴴ��һ������,��û�����ݵĽ��յ�ʱ�������
				socket = serverSocket.accept();
				System.out.println("��ַ�ǣ�"+ socket.getRemoteSocketAddress());
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				while((revictemp = inputStream.read(recevie)) !=-1 ) {
					System.out.println(new String(recevie));
					outputStream.write("���������յ�".getBytes());
				}
				outputStream.flush();
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		InetAddress ip = InetAddress.getByName(ip);

		
	}
}