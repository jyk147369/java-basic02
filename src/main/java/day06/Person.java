package day06;

public class Person {
    // 다형성을 연습하기 위한 간단한 예제
    // 부모 클래스

    String name;

    // 부모객체 메소드 eat();
    public void eat() {
        System.out.println(this.name + " 밥을 먹습니다.");
    }
}
