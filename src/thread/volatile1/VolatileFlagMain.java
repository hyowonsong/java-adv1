package thread.volatile1;

import static thread.start.MyLogger.log;
import static util.ThreadUtils.sleep;

// 메모리 가시성
public class VolatileFlagMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        t.start();

        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");
    }

    static class MyTask implements Runnable {
        // boolean runFlag = true;
        //volatile 을 추가해서 메인 메모리에 직접 접근한다.
        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
            // runFlag가 false로 변하면 탈출
            }
            log("task 종료");
        }
    }
}
