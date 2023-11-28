package day06;

import java.io.*;
import java.util.Scanner;

public class StreamMain2 {
    public static void main(String[] args) throws IOException {
        // 한글 오류 남
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("c:\\test\\abc.txt");
            fileOutputStream = new FileOutputStream("c:\\test\\abc2.txt");
            // abc.txt 파일을 abc2.txt 파일 만들어서 복사

            int data = 0;   // 한 글자씩 읽어온다.

            while( (data = fileInputStream.read()) != -1) {     // 읽어올 값이 없으면 -1을 반환하여, while문을 나온다.
                System.out.print((char)data);       // 숫자를 문자로 변환해서 출력한다.
            }

        } catch (FileNotFoundException e) {
            System.out.println("error1");
        } catch (IOException e) {
            System.out.println("error2");
        } finally {
            if(fileInputStream != null) {
                fileInputStream.close();    // *FileInputStream을 닫아준다* (중요함)
            }
            if(fileOutputStream != null) {
                fileInputStream.close();
            }
        }
    }
}
