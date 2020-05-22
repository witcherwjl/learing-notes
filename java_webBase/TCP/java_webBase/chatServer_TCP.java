package java_webBase;
import java.net.*;
import java.io.*;

/* ��������������������

���ö��̣߳���send��receive���ܷ��������߳��С�
send�����߳�
receive�����߳�.
ps:�����ټ�һ���߳���
*/
public class chatServer_TCP extends Thread{
	int port;
	public chatServer_TCP(int port) {
		super();
		this.port = port;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("����ˣ�");
		Socket socket = null;
		Socket server = null;
		try {
			ServerSocket serverSocket = new ServerSocket(this.port);
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
            	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            	
            	Send sendMessage = new Send(outputStream, br); // ����
            	System.out.println("��ʼ���룺\n");
            	sendMessage.start();
            	
				while((revictemp = inputStream.read(recevie)) !=-1 ) {
					System.out.println("�ͻ��˷��ͣ�"+new String(recevie));
					outputStream.write("���������յ�\n".getBytes());
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
	
	public static void main(String[] args) {
		System.out.println("������port:");
		BufferedReader in_port = new BufferedReader(new InputStreamReader(System.in));
		String portNow;
		try {
			if(!(portNow = in_port.readLine()).equals("q")) {
				Integer Port = Integer.parseInt(portNow);
				System.out.println(Port);
				chatServer_TCP tcpServer = new chatServer_TCP(Port);
				tcpServer.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

// �����߳�
class Send extends Thread{
	OutputStream output = null;
	BufferedReader br = null;
	
	public Send(OutputStream output, BufferedReader br) {
		super();
		this.output = output;
		this.br = br;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		String s = null;
		try {
			do{
	    		System.out.println("�ȴ�����:");
	    		this.output.write("����������:".getBytes());
				this.output.write((s+"\n").getBytes());
	    	}while(!(s = this.br.readLine()).equals("q") );
			System.out.println("�������");
			this.br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
	}
}