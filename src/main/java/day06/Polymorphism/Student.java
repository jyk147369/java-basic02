package day06.Polymorphism;

public class Student extends Person{
    // 다형성을 연습하기 위한 간단한 예제
    // 자식 클래스
    // 부모 클래스를 상속받음

    // 자식 객체 메소드 study
    public void study() {
        System.out.println(this.name + " 공부를 합니다.");
    }
}
