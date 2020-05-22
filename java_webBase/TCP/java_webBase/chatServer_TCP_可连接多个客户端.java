package java_webBase;
import java.net.*;
import java.io.*;


// !!! send������⣬����
/* ������������

���ö��̣߳���send��receive���ܷ��������߳��С�
send�����߳�
receive�����߳�.
ps:�����ټ�һ���߳���
*/
public class chatServer_TCP_�����Ӷ���ͻ��� extends Thread{
	Socket clientSocket;
	
	public chatServer_TCP_�����Ӷ���ͻ���(Socket clientSocket) {
		super();
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("����ˣ�");
		Socket socket = this.clientSocket;
		try {
			byte[] recevie = new byte[1024];
			int revictemp;
			System.out.println("��ʼ���գ�");
			while(true) {
				// ���տͻ��˵�����
				// ÿ����һ�����ݶ��ᴴ��һ������,��û�����ݵĽ��յ�ʱ�������
				System.out.println("��ַ�ǣ�"+ socket.getRemoteSocketAddress());
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
            	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            	
            	Send_one sendMessage = new Send_one(outputStream, br); // ����
            	System.out.println("��ʼ���룺\n");
            	sendMessage.start();
            	
				while((revictemp = inputStream.read(recevie)) !=-1 ) {
					System.out.println("�ͻ��˷��ͣ�"+new String(recevie));
					outputStream.write("���������յ�\n".getBytes());
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
		System.out.println("������port:");
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
		        new chatServer_TCP_�����Ӷ���ͻ���(client).start();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}



// �����߳�
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
	
	public void start() {
		// TODO Auto-generated method stub
         new Thread (this).start(); // �������߳�
         
	}
}