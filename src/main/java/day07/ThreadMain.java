package day07;


// 여러 스레드를 이용해서 동시에 여러 작업을 수행
// 장점 : 작업 속도가 빨라진다. 비동기 작업이 가능
// 단점 : 컨텍스트 스위치가 많이 일어나면 오히려 작업속도가 느려질 수 있다. 동기화가 어려워짐. 스레드 세이프하지 않을 수 있다.
public class ThreadMain {

    public static void main(String[] args) {
        // 스레드 객체 생성
        Thread thread01 = new Thread01(); // 다형성 이용

        // start() 메소드로 스레드 시작, 시작시키면 스레드에 있는 run() 메소드가 실행됨
        thread01.start();

        Thread02 runnable02 = new Thread02(); // 다형성 이용
        Thread thread02 = new Thread(runnable02);
        thread02.start();

        for(int i=0; i<10000; i++) {
            System.out.println("메인 스레드에서 실행 : " + i);

            // 메인에서 끝나지 않았는데 서로 섞이면서 실행
            // 스레드가 아니라면 한 클래스 작업 끝나고 그 다음에 이어서 작업 다시 시작
        }
    }
}
