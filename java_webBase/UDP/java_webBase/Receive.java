package java_webBase;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive {
	public static void main(String[] args) {
		try {
			// �׽��֣�ָ��port
			DatagramSocket ds = new DatagramSocket(6666);
			byte[] buf = new byte[1024];
			
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			try {
				System.out.println("��ʼ����");
				ds.receive(dp);
				System.out.println(dp.getPort());
				System.out.println(dp.getAddress());
				byte[] b = dp.getData();
				System.out.println(new String(b, 0, b.length));
				ds.close();
				System.out.println("��������");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
