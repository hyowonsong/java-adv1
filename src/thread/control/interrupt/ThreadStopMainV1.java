package thread.control.interrupt;

import static thread.start.MyLogger.log;
import static util.ThreadUtils.sleep;

// 이 방식은 main 스레드가 runFlag 를 false 로 변경해도, work 스레드는
// sleep(3000) 을 통해 3초간 잠들어 있다. 3초간의 잠이 깬 다음에
// while(runFlag) 코드를 실행해야, runFlag 를 확인하고 작업을 중단할 수 있다.
// 인터럽트를 사용하면 WAITING, TIME_WAITING 같은 대기 상태의 스레드를 직접 깨워서
// 작동하는 RUNNABLE 상태로 만들 수 있다.
public class ThreadStopMainV1 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();
        sleep(4000);
        log("작업 중단 지시 runFlag=false");
        task.runFlag = false;
    }

    static class MyTask implements Runnable {
        volatile boolean runFlag = true;
        @Override
        public void run() {
            while (runFlag) {
                log("작업 중");
                sleep(3000);
            }
            log("자원 정리");
            log("작업 종료");
        }
    }
}
