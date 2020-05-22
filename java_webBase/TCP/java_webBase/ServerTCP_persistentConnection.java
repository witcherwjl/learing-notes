package java_webBase;
// 待改
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class ServerTCP_persistentConnection {
	
    private static final int SERVER_PORT=2010;
 
    private static   Hashtable<String, Socket> ht = new Hashtable();
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        System.out.println("VNTCenter.main()===TCP SERVER==============");
        ServerSocket vntServer = null;
        try{
            vntServer= new ServerSocket(SERVER_PORT);

            System.out.println("Listening Port is "+vntServer.getLocalPort()+"...");
            while(true){
                Socket vntClient=vntServer.accept();
                System.out.println("have a client entering , the IP is "+vntClient.getInetAddress()+"...");
                System.out.println("have a client entering , the Port is "+vntClient.getPort()+"...");
                new GetGpsThreadFun(vntClient).start(); // 调用多线程
                ht.put(vntClient.getInetAddress().toString(),vntClient); // 保存到hashtable中
            }
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            vntServer.close();
        }
    }
}

class GetGpsThreadFun extends Thread{
    private Socket vntThreadClient;

    public GetGpsThreadFun(Socket vntThreadSocket){
        vntThreadClient=vntThreadSocket;
    }
    public void run(){
        try{
        	byte[] data = new byte[1024];
            while(true){
            	int len = vntThreadClient.getInputStream().read(data);
            	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            	
            	if (len > 0){
            		System.out.println(vntThreadClient.getInetAddress()+
            				":"+vntThreadClient.getPort()+":"+new String(data,0,len));
                  if("shutdown".equals(vntThreadClient)){
                      break;
                  }
            	}
            }
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}