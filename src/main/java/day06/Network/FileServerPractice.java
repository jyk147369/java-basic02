package day06.Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FileServerPractice {
    public static void main(String[] args) throws IOException {
        // 서버 먼저 실행해야함
        // 포트를 리슨 상태로 변경
        ServerSocket serverSocket = new ServerSocket(8182);
        // serverSocket.accept()는 클라이언트 쪽에서 new Socket()이 실행되어야 끝남
        // client로 부터 연결을 기다림
        Socket cs = serverSocket.accept();


    }
}
