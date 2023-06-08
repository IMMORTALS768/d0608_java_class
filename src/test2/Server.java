package test2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8888);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        while (true){
            String msg = dis.readUTF();
            System.out.println("收到客户端消息为:"+msg);
            String reply = Select.SelectByInput(msg);
            dos.writeUTF(reply);
        }
    }
}
