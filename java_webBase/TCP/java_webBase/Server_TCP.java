package java_webBase;
import java.net.*;
import java.io.*;

public class Server_TCP {
	String ipName = "127.0.0.1";
	
	public Server_TCP(InetAddress ip) {
		super();
	}
	
	public static void main(String[] args) {
		System.out.println("服务端：");
		Socket socket = null;
		int port = 6666;
		Socket server = null;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			byte[] recevie = new byte[1024];
			int revictemp;
			System.out.println("开始接收：");
			while(true) {
				// 接收客户端的连接
				// 每接收一个数据都会创建一个连接,当没有数据的接收的时候会阻塞
				socket = serverSocket.accept();
				System.out.println("地址是："+ socket.getRemoteSocketAddress());
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				while((revictemp = inputStream.read(recevie)) !=-1 ) {
					System.out.println(new String(recevie));
					outputStream.write("服务器接收到".getBytes());
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