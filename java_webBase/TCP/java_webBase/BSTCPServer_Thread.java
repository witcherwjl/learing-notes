package java_webBase;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;

public class BSTCPServer_Thread {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            System.out.println("start\n");

            Socket socket = server.accept();
            new Thread(new Web(socket)).start();
        }
    }
    static class Web implements Runnable{
        private Socket socket;

        public Web(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = br.readLine();
                String[] arr = line.split(" ");
                String htmlpath = arr[1].substring(1);
                System.out.println("htmlpath:" + htmlpath);

                FileInputStream fis = new FileInputStream(htmlpath);
                OutputStream os = socket.getOutputStream();
                byte[] bytes = new  byte[1024];
                int len=0;
                os.write("HTTP/1/1 200 OK\r\n".getBytes());
                os.write("Content-Type:test/html\r\n".getBytes());
                os.write("\r\n".getBytes());

                while ((len = fis.read(bytes))!=-1){
                    System.out.println(len);
                    os.write(bytes,0,len);
                }
                fis.close();
                os.close();
                br.close();
                socket.close();
            }catch(Exception e) {

            }
        }


    }
}
