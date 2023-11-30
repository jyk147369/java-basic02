package day07.AdditionalFeatures;

import day07.ChatServerThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiThreadServer {
    static Map<String, Socket> socketMap = new HashMap<String, Socket>();


    public static void main(String[] args) {
        /*int port = 9998;

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                Socket socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader bir = new BufferedReader(isr);
                String id = bir.readLine();
                System.out.println(id+" 님이 입장하셨습니다");

                socketMap.put(id, socket);

                Thread mpt = new ChatServerThread(id, socket);
                mpt.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
}
