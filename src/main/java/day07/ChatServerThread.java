package day07;

import com.sun.jdi.Value;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;


public class ChatServerThread extends Thread{
    Socket socket;

    // 스레드 생성자 만들기
    public ChatServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 여기서부터 받는 코드

        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bir = new BufferedReader(isr);

            // 무한 반복
            while(true) {
                String chat = bir.readLine();
                // readLine : 글자를 읽을때 한줄씩 읽는 메소드
                System.out.println(chat);
                // 여기까지 받는 코드

                // 클라이언트 소켓 리스트만큼 반복
                for (int i = 0; i < ChatServer.socketList.size(); i++) {
                    Socket client = ChatServer.socketList.get(i);
                    OutputStream os = client.getOutputStream();
                    OutputStreamWriter osw = new OutputStreamWriter(os);
                    BufferedWriter bw = new BufferedWriter(osw);
                    bw.write(chat + "\n");
                    bw.flush();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
