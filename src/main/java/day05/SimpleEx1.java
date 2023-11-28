package day05;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class SimpleEx1 {
    public static void main(String[] args) {

        String jsonText = "{\"판매자정보\":{\"이름\":\"남도일\",\"지역\":\"서울\"},\"판매품목\":['사과','배','딸기']}";
        System.out.println(jsonText);
        System.out.println();

        // json 형태의 문자열을 JSONObject 생성자로 전달 -> map 형식으로 변경
        JSONObject map1 = new JSONObject(jsonText);
        // 출력해보면
        System.out.println(map1);       // {"판매품목":["사과","배","딸기"],"판매자정보":{"지역":"서울","이름":"남도일"}}
        System.out.println();           // 따옴표의 기능을 사라지게 하는 \는 사라지고 맵 형태로 출력된 것을 확인할 수 있다.

        // 다음 맵 map2
        // 다음 맵이 될 문자열을 map1에서 추출
        String mapStr1 = map1.get("판매자정보").toString();
        System.out.println(map1.get("판매자정보").toString());
        System.out.println();

        JSONObject map2 = new JSONObject(mapStr1);
        System.out.println(map2);
        System.out.println();

        // JSONArray list1 = new JSONArray(jsonText);
        // jsonText 문자열을 리스트 생성자로 전달하면
        // System.out.println(list1);
        // 오류남 -> 시작이 리스트 형태가 아니기 때문에. 리스트형태 '[]'만 뽑아서 생성자로 전달해야 한다.
        // 따라서 jsonText 문자열에서 리스트형태만 추출해야 한다.

        String listStr1 = map1.get("판매품목").toString();
        // 문자열 listStr1은 map1에서 "판매품목"key와 대응되는 문자열을 get한다.
        // 출력해보면
        System.out.println(listStr1);   // ["사과","배","딸기"]
        System.out.println();           // 리스트의 형태만 출력된 것을 확인할 수 있다.

        // 이제 listStr1 문자열을 리스트 생성자로 전달하면 오류안남
        JSONArray list1 = new JSONArray(listStr1);
        System.out.println(list1);      // ["사과","배","딸기"]
        System.out.println();           // listStr1과 출력결과가 같지만 list1은 리스트임


        // 이를 이용해서 주어진 jsonText에서 상품의 판매품목을 출력해보자.
        System.out.print("판매품목은 ");
        for (int i = 0; i < list1.length(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println("입니다.");     // 판매품목은 사과 배 딸기 입니다.
        System.out.println();

        // 판매품목에 수박을 추가
        list1.put("수박");                // add가 아니고 put인 이유 : JSONArray 생성자 메소드라서 main에서 리스트 값 추가하는 add가 아니다..?
        System.out.print("판매품목은 ");
        for (int i = 0; i < list1.length(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println("입니다.");     // 판매품목은 사과 배 딸기 수박 입니다.
        System.out.println();

        // map1에 "판매기간:2023년 11월 24일까지"를 추가해보자
        map1.accumulate("판매기간", "2023년 11월 24일까지");
        System.out.println(map1);
        System.out.println();

        Iterator i = map1.keys();

        // hasNext() : next()했을때 데이터가 있다 없다를 반환
        while (i.hasNext()){
            // 옆에 데이터가 있으면 true, 없으면 false
            String key = i.next().toString();
            System.out.println("<"+key+">");
        }


    }


}
