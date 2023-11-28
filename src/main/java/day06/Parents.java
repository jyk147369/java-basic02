package day06;


// 아름다운 약속, 정해진 문법은 아님
// T : 타입
// K : 키
// E : 개체

public class Parents<T> {
    private T info;

    public Parents(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
