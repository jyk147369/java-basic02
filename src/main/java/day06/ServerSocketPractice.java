package day06;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketPractice {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5678);     // 서버의 포트는 5678로 정한다.
        while (true) {
            Socket client = serverSocket.accept();      // 클라이언트로부터 연결을 기다린다.

            // 클라이언트에게 전송할 수 있는 스트림 핸들러를 얻는다.
            PrintWriter printWriter = new PrintWriter(client.getOutputStream());

            // 문자열을 보낸다.
            printWriter.write("Hello");

            // 클라이언트 소켓을 닫는다.
            printWriter.close();
            client.close();
        }


    }
}
