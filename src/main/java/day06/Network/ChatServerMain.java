package day06.Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServerMain {
    public static void main(String[] args) {
        try {
            // 서버가 먼저 실행
            // 포트를 LISTEN 상태로 변경
            ServerSocket serverSocket = new ServerSocket(9876);
            // serverSocket.accept()는 클라이언트 쪽에서 new Socket()이 실행되어야 끝남
            // client로 부터 연결을 기다림
            Socket cs = serverSocket.accept();


            // 여기서부터 (글자를) 보내는 코드
            OutputStream os = cs.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bow = new BufferedWriter(osw);

            Scanner sc = new Scanner(System.in);
            System.out.print("클라이언트에게 보낼 내용을 입력해주세요 : ");
            String message = sc.nextLine();

            bow.write(message + "\n");
            bow.flush();
            // 여기까지 보내는 코드

            // 여기서부터 받는 코드
            InputStream is = cs.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bir = new BufferedReader(isr);
            String data = bir.readLine();
            // readLine : 글자를 읽을때 한줄씩 읽는 메소드
            System.out.println(data);
            // 여기까지 받는 코드 

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
