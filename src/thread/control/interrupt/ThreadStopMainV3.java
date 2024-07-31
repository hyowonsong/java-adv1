package thread.control.interrupt;

import static thread.start.MyLogger.log;
import static util.ThreadUtils.sleep;

// MainV3로 while 문에서 인터럽트의 상태를 직접 확인하도록 코드를 변경해보자.
// 추가로 예제를 단순화하고 더 직접적인 이해를 돕기 위해 run( ) 의 반복문에서 sleep() 코드도 함께 제거하자.
public class ThreadStopMainV3 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();
        sleep(100); // 시간을 줄임
        log("작업 중단 지시 - thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            // `Thread.currentThread()` 로 이 코드를 실행하는 스레드를 조회할 수 있다.
            // `isInterrupted()` 를 사용하면 스레드가 인터럽트 상태인지 확인할 수 있다.
            while (!Thread.currentThread().isInterrupted()) { // 인터럽트 상태 변경X
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태2 = " +
                    Thread.currentThread().isInterrupted());

            try {
                log("자원 정리 시도");
                Thread.sleep(1000);
                log("자원 정리 완료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태3 = " +
                        Thread.currentThread().isInterrupted());
            }
            log("작업 종료");
        }
    }
}
