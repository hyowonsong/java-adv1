package thread.start;

import static util.MyLogger.log;

// 중첩 클래스를 사용하여 Runnable 을 만들었다.
public class InnerRunnableMainV1 {

    public static void main(String[] args) {
        log("main() start");
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        log("main() end");
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log("run()");
        }
    }
}
