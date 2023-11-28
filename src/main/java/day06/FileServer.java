package day06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FileServer {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            // 포트를 리슨 상태로 변환해줌
            serverSocket = new ServerSocket(9999);

            // serverSocket.accept()는 클라이언트 쪽에서 new Socket이 실행되어야 한다.
            Socket cs = serverSocket.accept();

            OutputStream os = cs.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bow = new BufferedWriter(osw);

            Scanner sc = new Scanner(System.in);
            System.out.print("클라이언트에게 보낼 내용을 입력해주세요 : ");
            String message = sc.nextLine();

            bow.write(message + "\n");
            bow.flush();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
