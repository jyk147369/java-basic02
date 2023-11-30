package day07;

import java.io.*;
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
                Socket socket = serverSocket.accept();              // 서버소켓이 소켓을 받아 리턴하고 그 값을 클라이언트 소켓(socket)에 저장
                socketList.add(socket);                             // 소켓리스트에 클라이언트소켓을 추가
                Thread chatThread = new ChatServerThread(socket);   // ChatServerThread 클래스를 호출해서 ChatServerThread 생성자의 매개변수에 클라이언트소켓을 저장하여 객체를 생성
                                                                    // 그 객체를 스레드 클래스로 만든 변수에 저장
                chatThread.start();                                 // start()메소드로 스레드 실행 (ChatServerThread에 있는 run()메소드까지 다 실행됨)

                // 스레드 start()하면 run() 메소드 실행됨
                /*try {
                    InputStream is = socket.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader bir = new BufferedReader(isr);

                    // 무한 반복
                    while(true) {
                        String chat = bir.readLine();
                        // readLine : 글자를 읽을때 한줄씩 읽는 메소드
                        System.out.println(chat);
                        // 여기까지 받는 코드

                        // 받아서 연결된 전체 클라이언트한테 보냄
                        // 클라이언트 소켓 리스트만큼 반복
                        for (int i = 0; i < ChatServer.socketList.size(); i++) {
                            Socket client = ChatServer.socketList.get(i);
                            OutputStream os = client.getOutputStream();
                            OutputStreamWriter osw = new OutputStreamWriter(os);
                            BufferedWriter bw = new BufferedWriter(osw);
                            bw.write(chat + "\n");
                            bw.flush();
                        }*/
            }

            // 클라이언트 아이디 생성


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}