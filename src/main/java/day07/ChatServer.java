package day07;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// 멀티 스레드 서버
public class ChatServer {
    // 클라이언트 소켓들을 저장할 수 있는 변수
    static List<Socket> socketList = new ArrayList<Socket>();

    public static void main(String[] args) {
        int port = 9998;
        try {
            // 포트를 리슨 상태로
            ServerSocket serverSocket = new ServerSocket(port);

            // 무한 반복
            while (true) {
                Socket socket = serverSocket.accept();
                socketList.add(socket);
                Thread chatThread = new ChatServerThread(socket);
                chatThread.start();
            }

            // 클라이언트 아이디 생성


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}