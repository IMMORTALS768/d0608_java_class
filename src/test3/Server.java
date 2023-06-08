package test3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            Socket s = ss.accept();
            new SendThread(s).start();
            new ReceiveThread(s).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
