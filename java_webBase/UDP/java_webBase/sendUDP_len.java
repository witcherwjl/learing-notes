package java_webBase;
//�����Ӵ���
import java.net.*;
import java.io.*;
public class sendUDP_len {
//    public static void main(String[] args) throws IOException {
//        DatagramSocket ds = null;
//        try {
//            ds = new DatagramSocket();
//            byte[] buf = "Hello World!".getBytes();
//            InetAddress address = InetAddress.getByName("127.0.0.1");
//            DatagramPacket dp = new DatagramPacket(buf,buf.length,address,10086);
//            ds.send(dp);
//        } catch (SocketException e) {
//            e.printStackTrace();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } finally {
//            if(ds!=null)
//                ds.close();
//        }
//    }
	public static void main(String[] args) {
		
		try {
			// ����UDP�׽���,��ָ��port
			DatagramSocket ds = new DatagramSocket();
			// ������������
			byte[] buf = "HHHHH".getBytes();
			// ������ַ
			InetAddress address = InetAddress.getByName("127.0.0.1");
			// ���ݰ�����
			DatagramPacket dp = new DatagramPacket(buf, buf.length, address, 6666);
			ds.send(dp);
			ds.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
