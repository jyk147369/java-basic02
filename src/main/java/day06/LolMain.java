package day06;

import java.util.*;

public class LolMain {

    public static void main(String[] args) {
        Champion champion = new Champion(
                "가렌",
                72,
                100,
                580,
                60,
                1,
                0,
                0,
                0,
                new String[6]
        );

        // 생성하는 객체의 클래스이름과 객체를 저장하는 변수의 타입을 다르게 설정
        // 자식 객체를 부모 타입의 변수에 저장 가능 (업 캐스팅)
        // 부모 객체를 자식 타입의 변수에 저장 불가능 (다운 캐스팅)
        // 단, 다운 캐스팅할 때 형변환을 직접 해주면 가능

        // 업캐스팅
        Champion tristana1 =  new Tristana(
                "트리스타나",
                60,
                180,
                600,
                39,
                1,
                0,
                0,
                0,
                new String[6]);

        // tristana1에는 Champion 객체가 저장된 것이지 Tristana가 저장된 게 아님
        // 따라서 Tristana객체에 있는 jump() 메소드를 사용할 수 없음
        // tristana1.jump();


        // 다운 캐스팅
        Tristana tristana2 =  (Tristana)(new Champion(
                "트리스타나",
                60,
                180,
                600,
                39,
                1,
                0,
                0,
                0,
                new String[6]));

        tristana2.jump();


        // 다형성 활용
        // 기존 방식
        List arrayList = new Stack();

        ListCounter.sizeOf(arrayList);

        // 다형성 활용
        List list = new ArrayList();

        // 형태가 다양하다-> 다형성
        // 생성하는 객체의 클래스 이름과 객체를 저장하는 변수의 타입을 다르게 설정


        // 제네릭 및 다형성 활용
        List<Champion> championList = new ArrayList<Champion>();
        championList.add(champion); // Champion champion = new Champion()
        championList.add(tristana1); // Champion champion = new Tristana()
        championList.add(tristana2); // Tristana tristana2 =  (Tristana)(new Champion())



        Map<String, Champion> map = new HashMap<String, Champion>();
        map.put("블루팀", champion);
        map.put("레드팀", tristana1);


    }
}
