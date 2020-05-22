package java_webBase;
import java.net.*;
import java.io.*;


// !!! send会出问题，待改
/* 聊天器服务器

利用多线程，将send和receive功能放入两个线程中。
send在子线程
receive在主线程.
ps:懒得再加一个线程了
*/
public class chatServer_TCP_可连接多个客户端 extends Thread{
	Socket clientSocket;
	
	public chatServer_TCP_可连接多个客户端(Socket clientSocket) {
		super();
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("服务端：");
		Socket socket = this.clientSocket;
		try {
			byte[] recevie = new byte[1024];
			int revictemp;
			System.out.println("开始接收：");
			while(true) {
				// 接收客户端的连接
				// 每接收一个数据都会创建一个连接,当没有数据的接收的时候会阻塞
				System.out.println("地址是："+ socket.getRemoteSocketAddress());
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
            	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            	
            	Send_one sendMessage = new Send_one(outputStream, br); // 发送
            	System.out.println("开始输入：\n");
            	sendMessage.start();
            	
				while((revictemp = inputStream.read(recevie)) !=-1 ) {
					System.out.println("客户端发送："+new String(recevie));
					outputStream.write("服务器接收到\n".getBytes());
				}
				inputStream.close();
				outputStream.flush();
				socket.close();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		InetAddress ip = InetAddress.getByName(ip);

		
	}
	
	public static void main(String[] args) {
		System.out.println("请输入port:");
		BufferedReader in_port = new BufferedReader(new InputStreamReader(System.in));
		String portNow;
		Integer Port = null;
		try {
			if(!(portNow = in_port.readLine()).equals("q")) {
				Port = Integer.parseInt(portNow);
			}
			in_port.close();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(Port);
		ServerSocket tcpServer;
		try {
			tcpServer = new ServerSocket(Port);
			while(true) {
				Socket client = tcpServer.accept();
		        new chatServer_TCP_可连接多个客户端(client).start();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}



// 发送线程
class Send_one implements Runnable{
	OutputStream output = null;
	BufferedReader br = null;
	
	public Send_one(OutputStream output, BufferedReader br) {
		super();
		this.output = output;
		this.br = br;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String s = null;
		try {
			do{
	    		System.out.println("等待输入:");
	    		this.output.write("服务器返回:".getBytes());
				this.output.write((s+"\n").getBytes());
	    	}while(!(s = this.br.readLine()).equals("q") );
			System.out.println("输入结束");
			this.br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		// TODO Auto-generated method stub
         new Thread (this).start(); // 定义新线程
         
	}
}