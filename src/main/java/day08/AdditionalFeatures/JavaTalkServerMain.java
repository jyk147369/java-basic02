package day08.AdditionalFeatures;

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

// 멀티 스레드를 이용해서 자바 콘솔을 이용한 카카오톡을 만든다.
// 회원가입, 로그인, 친구, 대화방, 저장 메모장 파일로
// 대화 내용 저장
public class JavaTalkServerMain {

    // 여러 이용자가 가능하도록 클라이언트 소켓들을 저장 할 수 있는 변수를 만든다.
    static Map<String,Socket> clientIdSocketMap = new HashMap<String,Socket>();

    public static void main(String[] args) {
        // 클라이언트가 포트를 이용해서 프로그램에 찾아올 수 있도록 임의로 포트 번호를 설정한다.
        int port = 7972;

        try {
            // 포트를 리슨 상태(연결할 수 있는 상태)로 만들기 위해 서버소켓 생성자를 이용해서 객체를 생성
            // 서버 클래스의 serverSocket 변수를 생성하고 서버소켓 생성자의 매개변수도 넣어서 저장한다.
            // 객체를 생성해주면 통로가 열린 상태 -> 클라이언트가 서버의 ip 주소와 저장한 포트번호로 연결할 수 있음
            ServerSocket serverSocket = new ServerSocket(port);
            // try-catch나 throw를 이용해서 예외설정

            System.out.println("서버가 준비중입니다.");
            System.out.println();


            while(true){
                // accept 메소드는 소켓객체를 반환해줌
                // 클라이언트로부터 연결을 기다림
                // 클라이언트 쪽에서 new Socket이 실행되어야 한다.
                // 서버는 클라이언트에게 따로 뭘 보낼건 없고 접속한 클라이언트가 주는 것을 잘 받는 스레드만 실행하면 됨
                // 클라이언트가 보낼때마다 클라이언트 소켓을 반환해서 저장해야한다.
                // 따라서 무한 반복으로 스레드를 실행한다.
                Socket cs = serverSocket.accept();              // 서버소켓이 소켓을 받아 리턴하고 그 값을 클라이언트 소켓(cs)에 저장

                // clientSocketList 객체를 이용한다고 하면 static 붙이라고 오류창 뜸.. 왜지
                // clientSocketList에 cs(클라이언트 소켓)을 넣는다. -> 여러 클라이언트를 받아야 클라이언트끼리 채팅할 수 있으니까

                InputStream is = cs.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader bir = new BufferedReader(isr);
                String id = bir.readLine();
                System.out.println(id+" 님이 입장하셨습니다");

                clientIdSocketMap.put(id,cs);                             // 소켓리스트에 클라이언트소켓을 추가

                System.out.println(cs + "클라이언트와 연결되었습니다.");
                System.out.println();

                // 클라이언트와 연결되면 클라이언트의 채팅을 순차적으로 여러번 받는 스레드를 실행시켜준다.
                Thread javaTalkServerThread = new JavaTalkServerThread(cs,id);   // JavaTalkServerThread 클래스를 호출해서 javaTalkServerThread 생성자의 매개변수에 클라이언트소켓을 저장하여 객체를 생성
                // 그 객체를 스레드 클래스로 만든 변수에 저장
                javaTalkServerThread.start();                                 // start()메소드로 스레드 실행 (JavaTalkServerThread에 있는 run()메소드까지 다 실행됨)
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
