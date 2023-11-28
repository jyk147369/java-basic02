package day06;

public class School {
    public static void main(String[] args) {
        // 부모 클래스와 자식클래스를 활용해서 다형성 이해하기

        // 업캐스팅
        // 자식 객체(Student)를 부모 타입(Person)의 변수에 저장 가능

        // 다형성을 배우기 전에는 객체를 생성할 때 객체와 변수가 같았다.
        // Person hgd = new Person();
        // 하지만 다형성에서는 생성하는 객체와 변수가 다르다.

        // 자식 객체를 부모 타입의 변수에 저장
        Person hgd = new Student();

        hgd.name = "홍길동";

        // 부모 타입의 변수에 객체를 저장했기 때문에 부모 클래스의 eat 메소드는 사용할 수 있다.
        hgd.eat();
        // 자식 클래스의 study 메소드는 사용할 수 없다.
        // hgd.study();

        // 다운캐스팅
        // 부모 객체를 자식 타입의 변수에 *형변환* 해서 저장
        //Student lkj = (Student) new Person();
        Person person = new Student();
        Student lkj = (Student) person;

        lkj.name = "임꺽정";

        // 자식 타입의 변수에 객체를 저장했기 때문에 자식 클래스의 study 메소드는 물론이고
        // 자식 클래스가 부모 클래스에게 상속받은 eat 메소드도 사용할 수 있다.
        // 하지만 자식 타입의 변수에 부모객체를 저장하는 것이기 때문에 형변환을 무조건 해줘야 함
        lkj.eat();
        lkj.study();

    }
}
