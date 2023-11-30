package day06.Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FileServer {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            // 포트를 리슨 상태로 변환해줌
            serverSocket = new ServerSocket(8182);

            // serverSocket.accept()는 클라이언트 쪽에서 new Socket이 실행되어야 한다.
            System.out.println("서버가 준비중입니다.");
            Socket cs = serverSocket.accept();

            System.out.println("클라이언트와 연결이 완료되었습니다.");

            // 여기서부터 (글자를) 받는 코드
            // 클라이언트로부터 fileName 문자열을 받는다.
            System.out.println("클라이언트가 입력한 파일명을 읽습니다.");
            InputStream is = cs.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            // 성능을 좋게
            BufferedReader bir = new BufferedReader(isr);
            // readLine : 글자를 읽을때 한줄씩 읽는 메소드
            String fileName = bir.readLine();
            System.out.println("클라이언트가 입력한 파일명은 "+ fileName + "입니다.");
            // 여기까지 받는 코드

            // 여기서부터 보내는 코드
            System.out.println("클라이언트가 입력한 " + fileName + " 파일을 보냅니다.");
            OutputStream os = cs.getOutputStream();

            // 이건 글자를 보내는 코드
            /*OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bow = new BufferedWriter(osw);*/

            // byte단위로 파일을 기록 할때 사용하는 버퍼 스트림
            BufferedOutputStream bos = new BufferedOutputStream(os);

            // 파일을 읽어온다.
            System.out.println(fileName + " 파일을 읽어옵니다.");
            FileInputStream fis = new FileInputStream("c:\\test\\"+fileName);
            int data = 0;
            // 더이상 읽을 값이 없으면 -1을 리턴.
            while( (data = fis.read()) != -1) {
                bos.write(data);
            }
            System.out.println("파일 전송 완료!");
            // 여기까지 보내는 코드

            // 메소드 다 닫아준다.
            bos.close();
            bir.close();
            cs.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
