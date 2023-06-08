package test2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1",8888);
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        Scanner sc = new Scanner(System.in);
        while (true){
            dos.writeUTF(sc.nextLine());
            System.out.println("收到服务器消息为:"+dis.readUTF());
        }
    }
}
