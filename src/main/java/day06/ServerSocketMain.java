package day06;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketMain {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            // 포트를 리슨 상태로 변환해줌
            // 통로가 열린 상태
            // ServerSocket 서버
            // 서버를 먼저 실행
            Socket clientsocket = serverSocket.accept(); // accept은 소캣객체를 반환해줌
            // clientsocket 클라이언트

            System.out.println(clientsocket.getInetAddress() + " 접속함");

            InputStream clientInputStream = clientsocket.getInputStream();
            // 입력을 받겠다.

            int num = clientInputStream.read();
            System.out.println(num);
            // client가 write할때까지 기다림
            // 읽은 것을 num변수로 저장하고 출력

            OutputStream clientOutputStream = clientsocket.getOutputStream();
            clientOutputStream.write(200);



            serverSocket.close();
            clientsocket.close();

        } catch (IOException e) { // 입출력에 대한 예외처리가 꼭 필요함
            throw new RuntimeException(e);
        }
    }
}
