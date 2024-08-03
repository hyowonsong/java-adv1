package thread.control.test;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinTest2Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyTask(), "t1");
        Thread t2 = new Thread(new MyTask(), "t2");
        Thread t3 = new Thread(new MyTask(), "t3");

        // 한번에 스레드 실행하고 한번에 join 해서 실행 시간을 줄인다.
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("모든 스레드 실행 완료");
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                log(i);
                sleep(1000);
            }
        }
    }
}
