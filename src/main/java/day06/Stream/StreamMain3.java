package day06.Stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StreamMain3 {
    public static void main(String[] args) throws IOException {
        // 한글 오류 안남
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("c:\\test\\abc.txt");
            fileWriter = new FileWriter("c:\\test\\abc2.txt");

            int data = 0;

            while( (data = fileReader.read()) != -1) {
                System.out.print((char)data);
            }

        } catch (FileNotFoundException e) {
            System.out.println("error1");
        } catch (IOException e) {
            System.out.println("error2");
        } finally {
            if(fileReader != null) {
                fileReader.close();
            }
            if(fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}
