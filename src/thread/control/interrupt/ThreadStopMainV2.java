package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV2 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();
        sleep(4000);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            try {
                // while(ture) 부분은 체크하지 않고 있다.
                // 여기는 인터럽트가 발생해도 항상 true 이기 때문에 다음 코드로 넘어간다.
                // 그리고 sleep( )을 호출하고 나서야 인터럽트가 발생하는 것이다.
                // MainV3로 while 문에서 인터럽트의 상태를 직접 확인하도록 코드를 변경해보자.
                // 추가로 예제를 단순화하고 더 직접적인 이해를 돕기 위해 run( ) 의 반복문에서 sleep() 코드도 함께 제거하자.
                while (true) {
                    log("작업 중");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                log("work 스레드 인터럽트 상태2 = " +
                        Thread.currentThread().isInterrupted());
                log("interrupt message=" + e.getMessage());
                log("state=" + Thread.currentThread().getState());
            }
            log("자원 정리");
            log("작업 종료");
        }
    }

}
