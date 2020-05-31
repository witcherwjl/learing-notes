package java_webBase;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BSTCPServer_1 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        Socket socket = server.accept();
        // 输入流
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();
        String[] arr = line.split(" ");
        String htmlpath = arr[1].substring(1);
        System.out.println("htmlpath:"+htmlpath);

        FileInputStream fis = new FileInputStream(htmlpath);
        OutputStream os  = socket.getOutputStream();

        os.write("HTTP/1/1 200 OK\r\n".getBytes());
        os.write("Content-Type:test/html\r\n".getBytes());
        os.write("\r\n".getBytes());
        fis.close();
        os.close();
        is.close();
    }
}
