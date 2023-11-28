package day06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamMain {
    public static void main(String[] args) throws IOException {


        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("c:\\test\\pic1.jpg");
            // 오류 났을때 오류난 곳에 대고 alt+Enter 하면 수정방안을 제시해줌
            // 이 경우엔 1. throw 2. try-catch로 예외처리 하는 방식을 제시
            fileOutputStream = new FileOutputStream("c:\\test\\pic2.jpg");
            // pic1을 pic2로 복사

            byte[] bytes = fileInputStream.readAllBytes();

            for (int i = 0; i < bytes.length; i++) {
                fileOutputStream.write(bytes[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("error1: Can't find file");
        } catch (IOException e) {
            System.out.println("error2: Can't read");
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileInputStream.close();
            }
        }

    }
}
