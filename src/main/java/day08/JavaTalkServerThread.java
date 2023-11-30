package day08;

import java.io.*;
import java.net.Socket;

// 스레드 사용해야 되니까 Thread를 상속받는다.
// JavaTalkServerThread클래스와 생성자는 JavaTalkServerMain에서 사용된다.
public class JavaTalkServerThread extends Thread{
    Socket socket;

    // 스레드 생성자 만들기
    public JavaTalkServerThread(Socket socket) {
        // 이 소켓 변수에 accept해서 return한 클라이언트소켓을 저장할거임
        this.socket = socket;
    }

    @Override
    public void run() {

        // 여기서부터 받는 코드
        InputStream is = null;
        try {
            // 소켓이 주는 것을 받을거임
            is = socket.getInputStream();
            // 받은 것을 읽을거임
            InputStreamReader isr = new InputStreamReader(is);
            // 읽은 것을 버퍼로 다시 성능좋게 읽을거임
            BufferedReader bir = new BufferedReader(isr);

            // 한 줄씩 읽은 것을 talk 변수에 스트링으로 저장할거임
            // 무한 반복 -> 무한반복 안하면 한줄만 보내고 끝남
            // readLine : 글자를 읽을때 한줄씩 읽는 메소드
            while(true) {
                String talk = bir.readLine();
                // talk을 출력할거임
                System.out.println(socket + "이 입력한 채팅 : " + talk);
                // 여기까지 받는 코드

                // 받아서 연결된 전체 클라이언트한테 보냄
                // 클라이언트 소켓 리스트만큼 반복
                for (int i = 0; i < JavaTalkServerMain.clientSocketList.size(); i++) {
                    Socket client = JavaTalkServerMain.clientSocketList.get(i);
                    // 클라이언트소켓에게 보낼거임
                    OutputStream os = client.getOutputStream();
                    // 보낸 것을 쓸거임
                    OutputStreamWriter osw = new OutputStreamWriter(os);
                    // 보낸 것을 성능 좋게 쓸거임
                    BufferedWriter bw = new BufferedWriter(osw);
                    // talk을 출력한다
                    bw.write(talk + "\n");
                    bw.flush();
                    System.out.println();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
