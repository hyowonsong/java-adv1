package thread.start;

// 앞서 만든 HelloTread 스레드 객체를 생성하고 start() 메서드를 호출
// start() 메서드는 스레드를 실행하는 아주 특별한 메서드
public class HelloThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 전");
        // start() 를 호출해야 HelloThread 스레드가 run() 메서드를 실행한다.
        // HelloThread 스레드 객체를 생성한 다음 start() 메서드를 호출하면
        // 자바는 스레드를 위한 별도의 스택 공간을 할당한다.
        // 여기서 main 스레드가 run() 메서드를 실행하는게 아니라 Thread-0 스레드가 run() 메서드를 실행
        // main 스레드는 단지 start() 메서드를 통해 Thread-0 스레드에게 실행을 지시할 뿐
        // 스레드 간 실행 순서는 보장하지 않는다. 이것이 멀티스레드이다.
        helloThread.start();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 후");
        System.out.println(Thread.currentThread().getName() + ": main() end");
    }
}
