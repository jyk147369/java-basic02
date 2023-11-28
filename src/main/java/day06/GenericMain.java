package day06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericMain {
    public static void main(String[] args) {
        Parents<String> parentsString = new Parents<String>("제네릭");

        Parents<Character> parentsChar = new Parents<Character>('c');

        Parents<Integer> parentsInt = new Parents<Integer>(100);

        // 제네릭을 안쓴 리스트
        List integerList1 = new ArrayList();
        integerList1.add("글자");
        integerList1.add(100);

        List<Integer> integerList2 = new ArrayList<Integer>();
        // 제네릭으로 타입을 Integer로 설정해서 글자는 저장 못함
        //integerList2.add("글자");
        integerList2.add(100);

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(0, "값1");



    }
}
